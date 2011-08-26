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

package org.odftoolkit.odfdom.dom.element.style;

import org.odftoolkit.odfdom.dom.OdfName;
import org.odftoolkit.odfdom.dom.OdfNamespace;
import org.odftoolkit.odfdom.doc.OdfFileDom;
import org.odftoolkit.odfdom.dom.element.OdfElement;
import org.odftoolkit.odfdom.dom.type.OdfPercent;
import org.odftoolkit.odfdom.dom.type.style.OdfLineStyleType;
import org.odftoolkit.odfdom.dom.type.style.OdfAdjustmentType;


/**
 * ODF DOM Element implementation for element "<style:footnote-sep>".
 */
public abstract class OdfFootnoteSepElement extends OdfElement
{        
    /**
	 * 
	 */
	private static final long serialVersionUID = 2838085152293769817L;
	public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.STYLE, "footnote-sep" );

    public OdfFootnoteSepElement( OdfFileDom _aOwnerDoc )
    {
        super( _aOwnerDoc, ELEMENT_NAME );
    }

    @Override
	public OdfName getOdfName()
    {
        return ELEMENT_NAME;
    }


    /**
     * Get value of attribute "style:width".
     */
    public String getWidth()
    {
        return getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "width" ) );
    }

    /**
     * Set value of attribute "style:width".
     */
    public void setWidth( String _aWidth )
    {
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "width" ), _aWidth );
    }

    /**
     * Get value of attribute "style:rel-width".
     */
    public Double getRelWidth()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "rel-width" ) );
        return OdfPercent.valueOf( aStringVal);
    }

    /**
     * Set value of attribute "style:rel-width".
     */
    public void setRelWidth( Double _aRelWidth )
    {                    
        String aStringVal = OdfPercent.toString( _aRelWidth );
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "rel-width" ), aStringVal );
    }

    /**
     * Get value of attribute "style:color".
     */
    public String getColor()
    {
        return getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "color" ) );
    }

    /**
     * Set value of attribute "style:color".
     */
    public void setColor( String _aColor )
    {
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "color" ), _aColor );
    }

    /**
     * Get value of attribute "style:line-style".
     */
    public OdfLineStyleType getLineStyle()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "line-style" ) );
        return OdfLineStyleType.enumValueOf( aStringVal);
    }

    /**
     * Set value of attribute "style:line-style".
     */
    public void setLineStyle( OdfLineStyleType _aLineStyle )
    {                    
        String aStringVal = OdfLineStyleType.toString( _aLineStyle );
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "line-style" ), aStringVal );
    }

    /**
     * Get value of attribute "style:adjustment".
     */
    public OdfAdjustmentType getAdjustment()
    {                    
        String aStringVal = getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "adjustment" ) );
        return OdfAdjustmentType.enumValueOf( aStringVal);
    }

    /**
     * Set value of attribute "style:adjustment".
     */
    public void setAdjustment( OdfAdjustmentType _aAdjustment )
    {                    
        String aStringVal = OdfAdjustmentType.toString( _aAdjustment );
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "adjustment" ), aStringVal );
    }

    /**
     * Get value of attribute "style:distance-before-sep".
     */
    public String getDistanceBeforeSep()
    {
        return getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "distance-before-sep" ) );
    }

    /**
     * Set value of attribute "style:distance-before-sep".
     */
    public void setDistanceBeforeSep( String _aDistanceBeforeSep )
    {
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "distance-before-sep" ), _aDistanceBeforeSep );
    }

    /**
     * Get value of attribute "style:distance-after-sep".
     */
    public String getDistanceAfterSep()
    {
        return getOdfAttribute( OdfName.get( OdfNamespace.STYLE, "distance-after-sep" ) );
    }

    /**
     * Set value of attribute "style:distance-after-sep".
     */
    public void setDistanceAfterSep( String _aDistanceAfterSep )
    {
        setOdfAttribute( OdfName.get( OdfNamespace.STYLE, "distance-after-sep" ), _aDistanceAfterSep );
    }

}
