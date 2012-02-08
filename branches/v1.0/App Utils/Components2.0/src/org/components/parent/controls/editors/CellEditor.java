/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author nnjj
 */
public abstract  class CellEditor extends  AbstractCellEditor
        implements TableCellEditor {
    public void getEditingValue(){
    
    }
    public abstract  JComponent getComponent();
}
