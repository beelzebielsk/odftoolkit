/************************************************************************
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 *
 * Use is subject to license terms.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0. You can also
 * obtain a copy of the License at http://odftoolkit.org/docs/license.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ************************************************************************/
package org.odftoolkit.odfdom.doc.number;

import org.odftoolkit.odfdom.doc.number.OdfNumberStyle;
import org.odftoolkit.odfdom.doc.number.OdfNumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.odftoolkit.odfdom.doc.style.OdfStyleMap;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.w3c.dom.Node;

/**
 *
 * @author J David Eisenberg
 */
public class OdfNumberStyleTest {

	OdfSpreadsheetDocument doc;
	OdfFileDom dom;

    public OdfNumberStyleTest() {
    }

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

    @Before
    public void setUp() {
        try
        {
            doc = OdfSpreadsheetDocument.newSpreadsheetDocument();
			dom = doc.getContentDom();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @After
    public void tearDown() {
    }

	/**
	 * Test of buildFromFormat method, of class OdfNumberStyle.
	 */
	@Test
	public void testBuildFromFormat() {
		int n;
		String[] formatTest = {
			"##",
			"#0",
			"#00",
			"#,###",
			"#,##0",
			"#,##0.00",
			"before:##0",
			"##0:after",
			"before:##0:after"
		};

		/*
		 * Expected elements.
         * t -- <number:text> with following text
         * n -- <number:number> with minimum digits, decimal places,
         *      and grouping (T or F)
		 */
		String[][] expected = {
			{ "n00F" }, // ##
			{ "n10F"}, // #0
			{ "n20F" }, // #00
			{ "n00T" }, // #,###
			{ "n10T" }, // #,##0
			{ "n12T" }, // #,##0.00
			{ "tbefore:", "n10F" },
			{ "n10F", "t:after" },
			{ "tbefore:", "n10F", "t:after"},
		};
		System.out.println("buildFromFormat");
		OdfNumberStyle instance = null;
		char expectedType;
        String expectedValue;
		Node node;

		for (int i = 0; i < formatTest.length; i++)
		{
			System.out.println("Number format: " + formatTest[i]);
			instance = new OdfNumberStyle(dom,
				formatTest[i], "fstyle");
			Assert.assertNotNull(instance);

			node = instance.getFirstChild();

			for (int j = 0; j < expected[i].length; j++)
			{
				expectedType = expected[i][j].charAt(0);
				expectedValue = expected[i][j].substring(1);
				switch (expectedType)
				{
					case 't':
						checkNumberText("text", expectedValue, node);
						break;
					case 'n':
						checkNumberFormat(expectedValue, node);
						break;
				}
				node = node.getNextSibling();
			}
		}
	}

	/**
	 * Check that the node is a <code>&lt;number:elementName&gt;</code> node
	 * with the expected text content.
     * @param elementName the local name of the expected element
	 * @param expected expected text content
	 * @param node the Node to be examined
	 */
	private void checkNumberText(String elementName, String expected, Node node)
	{
		Node childNode;
		// Check for <number:text> with expected content
		Assert.assertNotNull(node);
		Assert.assertEquals(Node.ELEMENT_NODE, node.getNodeType());
		Assert.assertEquals(OdfNamespaceNames.NUMBER.getNamespaceUri(),
			node.getNamespaceURI());
		Assert.assertEquals(elementName, node.getLocalName());
		childNode = node.getFirstChild();
		Assert.assertEquals(Node.TEXT_NODE, childNode.getNodeType());
		Assert.assertEquals(expected, childNode.getNodeValue());
	}
	/**
	 * Check to see that the node is <code>&lt;number:number&gt;</code> and
	 * meets the expected specifications.
	 *
	 * The expected specifications is a string of three characters:
	 * min # of digits, # of decimal places, grouped (T/F)
	 * @param expected expected specification for <code>&lt;number:number&gt;</code>
	 * @param node the node to be validated
	 */
	private void checkNumberFormat(String expected, Node node)
	{
		int nDigits = Integer.parseInt(expected.substring(0,1));
		int nDecimals = Integer.parseInt(expected.substring(1,2));
		boolean grouped = (expected.charAt(2) == 'T');
		boolean nodeGrouped;
		OdfNumber number;

		Assert.assertTrue("node is OdfNumber", node instanceof OdfNumber);
		number = (OdfNumber) node;

		// check number of digits and decimals
		Assert.assertEquals(nDigits, (long) number.getNumberMinIntegerDigitsAttribute());

		if (nDecimals > 0)
		{
			Assert.assertEquals(nDecimals, (long)number.getNumberDecimalPlacesAttribute());
		}

		// check if grouping is set properly
		nodeGrouped = (number.getNumberGroupingAttribute() == null) ? false :
			number.getNumberGroupingAttribute().booleanValue();
		Assert.assertTrue("Grouping", grouped == nodeGrouped);
	}

	/**
	 * Test of setMapPositive method, of class OdfNumberNumberStyle.
	 */
	@Test
	public void testSetMapPositive() {
		Node node;
		OdfStyleMap mapNode;

		System.out.println("setMapPositive");
		String mapName = "positiveMap";
		OdfNumberStyle instance = new OdfNumberStyle(dom,
				"#0", "fstyle");
		instance.setMapPositive(mapName);
		node = instance.getLastChild();
		Assert.assertNotNull(node);
		Assert.assertTrue(node instanceof OdfStyleMap);
		mapNode = (OdfStyleMap) node;
		Assert.assertEquals("value()>0", mapNode.getStyleConditionAttribute());
		Assert.assertEquals(mapName, mapNode.getStyleApplyStyleNameAttribute());
	}

	/**
	 * Test of setMapNegative method, of class OdfNumberNumberStyle.
	 */
	@Test
	public void testSetMapNegative() {
		Node node;
		OdfStyleMap mapNode;

		System.out.println("setMapNegative");
		String mapName = "negativeMap";
		OdfNumberStyle instance = new OdfNumberStyle(dom,
				"#0", "fstyle");
		instance.setMapNegative(mapName);
		node = instance.getLastChild();
		Assert.assertNotNull(node);
		Assert.assertTrue(node instanceof OdfStyleMap);
		mapNode = (OdfStyleMap) node;
		Assert.assertEquals("value()<0", mapNode.getStyleConditionAttribute());
		Assert.assertEquals(mapName, mapNode.getStyleApplyStyleNameAttribute());
	}

}