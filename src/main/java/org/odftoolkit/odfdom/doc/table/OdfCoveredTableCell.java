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

package org.odftoolkit.odfdom.doc.table;

import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.element.table.TableCoveredTableCellElement;
import org.odftoolkit.odfdom.type.PositiveInteger;

/**
 * Convenient functionalty for the parent ODF OpenDocument element
 *
 */
public class OdfCoveredTableCell extends TableCoveredTableCellElement
{

	PositiveInteger m_nRowSpan;
	PositiveInteger m_nColSpan;
    boolean m_bAutoGen = false;

    /** Creates a new instance of this class
     * @param ownerDoc
     */
    public OdfCoveredTableCell(OdfFileDom ownerDoc) {
        super(ownerDoc);
        m_nRowSpan = new PositiveInteger(1);
        m_nColSpan = new PositiveInteger(1);
    }

    public int getColumnIndex() {
        return OdfTableCellBaseImpl.getColumnIndex((OdfTableCellBase) this);
    }

    public OdfTableColumn getTableColumn() {
        return getTableColumn(this);
    }

    static public OdfTableColumn getTableColumn(OdfCoveredTableCell _aBase) {
        return _aBase.getTable().getTableColumn(_aBase.getColumnIndex());
    }

    public OdfTableRow getTableRow() {
        return getAncestorAs(OdfTableRow.class);
    }

    public OdfTable getTable() {
        return OdfTableCellBaseImpl.getTable((OdfTableCellBase) this);
    }

    public PositiveInteger getNumberColumnsSpanned() {
        return m_nColSpan;
    }

    public void setNumberColumnsSpanned(PositiveInteger n) {
        m_nColSpan = n;
    }

    public PositiveInteger getNumberRowsSpanned() {
        return m_nRowSpan;
    }

    public void setNumberRowsSpanned(PositiveInteger n) {
        m_nRowSpan = n;
    }

    public boolean isAutoGenerated() {
        return m_bAutoGen;
    }

    public void setAutoGenerated() {
        m_bAutoGen = true;
    }

}