/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.components.custom;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author nnjj
 */
public class TableEditor extends AbstractCellEditor
        implements TableCellEditor {

    private JTable masterTbl;
    PagedPopUpPanel popUpComponent;
    JTextField component;

    // This method is called when a cell value is edited by the user.
    public TableEditor(PagedPopUpPanel popUpComponent, JTable tbl) {
        this.popUpComponent = popUpComponent;
        init(tbl);

    }

    @Override
    public boolean stopCellEditing() {
//        if (component.getText().equals("abcd") || component.getText().equals("")) {
//      if(validateCell()){
//            int selcol=masterTbl.getSelectedColumn();
//            int selrow=masterTbl.getSelectedRow();
//            TableColumn tc= masterTbl.getColumnModel().getColumn(selcol); 
//                 boolean b = super.stopCellEditing();
//                 masterTbl.changeSelection(selrow, selcol+1, true, true);
//            return b;
//        }
//
//        return false;
//    }
//      return false; 
        boolean b = false;
        if (isValide()) {
            System.out.println("===============");
            int selcol = masterTbl.getSelectedColumn();
            int selrow = masterTbl.getSelectedRow();            
            b = super.stopCellEditing();
            selcol+=1;
            masterTbl.changeSelection(selrow, selcol, true, true);
//      masterTbl.getColumnModel().getColumn(selcol). 
        }
        return b;
    }

    public boolean isValide() {
        return true;
    }

    
    public TableEditor(JTable jt) {
        init(jt);
        

    }

    public boolean validateCell() {

        return true;
    }

    private void init(JTable jt) {


        component = new JTextField();
        masterTbl=jt;
        
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)
if(!isSelected){
return null;
}
     

        // Configure the component with the specified value
        ((JTextField) component).setText((String) value);

        // Return the configured component
        return component;
    }

    // This method is called when editing is completed.
    // It must return the new value to be stored in the cell.
    public Object getCellEditorValue() {
        return ((JTextField) component).getText();
    }

    public JTextField getComponent() {
        return component;
    }

    /**
     * @return the masterTbl
     */
    public JTable getMasterTbl() {
        return masterTbl;
    }

    /**
     * @param masterTbl the masterTbl to set
     */
    public void setMasterTbl(JTable masterTbl) {
        this.masterTbl = masterTbl;
    }
}
