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

/*
 * This file is automatically generated.
 * Don't edit manually.
 */    

package org.odftoolkit.odfdom.dom.element.chart;

import org.odftoolkit.odfdom.dom.OdfName;
import org.odftoolkit.odfdom.dom.OdfNamespace;
import org.odftoolkit.odfdom.doc.OdfFileDom;
import org.odftoolkit.odfdom.dom.element.OdfElement;
import org.odftoolkit.odfdom.dom.type.OdfBoolean;
import org.odftoolkit.odfdom.dom.type.OdfStyleName;


/**
 * ODF DOM Element implementation for element "<chart:equation>".
 */
public abstract class OdfEquationElement extends OdfElement
{        
    /**
	 * 
	 */
	private static final long serialVersionUID = -6499938895800872781L;
	public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.CHART, "equation" );

    public OdfEquationElement( OdfFileDom _aOwnerDoc )
    {
        super( _aOwnerDoc, ELEMENT_NAME );
    }

    @Override
	public OdfName getOdfName()
    {
        return ELEMENT_NAME;
    }


    /**
     * Get value of attribute "chart:automatic-content".
     */
    public Boolean getAutomaticContent()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.CHART, "automatic-content" ) );
        return OdfBoolean.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "chart:automatic-content".
     */
    public void setAutomaticContent( Boolean _aAutomaticContent )
    {                    
        String aStringVal = OdfBoolean.toString( _aAutomaticContent );
        setOdfAttribute( OdfName.get( OdfNamespace.CHART, "automatic-content" ), aStringVal );
    }

    /**
     * Get value of attribute "chart:display-r-square".
     */
    public Boolean getDisplayRSquare()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.CHART, "display-r-square" ) );
        return OdfBoolean.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "chart:display-r-square".
     */
    public void setDisplayRSquare( Boolean _aDisplayRSquare )
    {                    
        String aStringVal = OdfBoolean.toString( _aDisplayRSquare );
        setOdfAttribute( OdfName.get( OdfNamespace.CHART, "display-r-square" ), aStringVal );
    }

    /**
     * Get value of attribute "chart:display-equation".
     */
    public Boolean getDisplayEquation()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.CHART, "display-equation" ) );
        return OdfBoolean.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "chart:display-equation".
     */
    public void setDisplayEquation( Boolean _aDisplayEquation )
    {                    
        String aStringVal = OdfBoolean.toString( _aDisplayEquation );
        setOdfAttribute( OdfName.get( OdfNamespace.CHART, "display-equation" ), aStringVal );
    }

    /**
     * Get value of attribute "svg:x".
     */
    public String getX()
    {
        return getOdfAttribute( OdfName.get( OdfNamespace.SVG, "x" ) );
    }

    /**
     * Set value of attribute "svg:x".
     */
    public void setX( String _aX )
    {
        setOdfAttribute( OdfName.get( OdfNamespace.SVG, "x" ), _aX );
    }

    /**
     * Get value of attribute "svg:y".
     */
    public String getY()
    {
        return getOdfAttribute( OdfName.get( OdfNamespace.SVG, "y" ) );
    }

    /**
     * Set value of attribute "svg:y".
     */
    public void setY( String _aY )
    {
        setOdfAttribute( OdfName.get( OdfNamespace.SVG, "y" ), _aY );
    }

    /**
     * Get value of attribute "chart:style-name".
     */
    public String getStyleName()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.CHART, "style-name" ) );
        return OdfStyleName.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "chart:style-name".
     */
    public void setStyleName( String _aStyleName )
    {                    
        String aStringVal = OdfStyleName.toString( _aStyleName );
        setOdfAttribute( OdfName.get( OdfNamespace.CHART, "style-name" ), aStringVal );
    }

}
