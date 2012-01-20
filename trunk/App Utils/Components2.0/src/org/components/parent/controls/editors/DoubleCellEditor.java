/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.EventObject;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import org.biz.app.ui.util.ComponentFactory;

/**
 *
 * @author nnjj
 */
public class DoubleCellEditor extends AbstractCellEditor
        implements TableCellEditor {

    JTextField component;
    JTable tbl;
    // This method is called when a cell value is edited by the user.

    @Override
    public boolean stopCellEditing() {
//        if (component.getText().equals("abcd") || component.getText().equals("")) {

//            TableColumn tc= masterTbl.getColumnModel().getColumn(selcol); 

        boolean b = false;
        if (isValide()) {
            b = super.stopCellEditing();
//            getTbl().changeSelection(selrow, selcol + 1, true, true);
        }
        return b;
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return super.isCellEditable(e);

    }

    public DoubleCellEditor(JTable jt) {
        init(jt);

    }

    public JTable getTbl() {
        return tbl;
    }

    public void setTbl(JTable tbl) {
        this.tbl = tbl;
    }

    private void init(JTable jt) {
        //specify

        tbl = jt;
        component = new JTextField();
        ComponentFactory.createDoubleTextField(component);
        component.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                stopCellEditing();
            }
        });
        addCellEditorListener(new CellEditorListener() {

            @Override
            public void editingStopped(ChangeEvent e) {
                boolean b = false;
//        if (isCellValid()) {
                int selcol = tbl.getSelectedColumn();
                int selrow = tbl.getSelectedRow();
                System.out.println("editing stped sel col   "+selcol);
//            b = super.stopCellEditing();
                tbl.changeSelection(selrow, selcol + 1, true, true);

//        }/
//        return b;
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        });
    }

    public boolean isValide() {
        return true;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
      
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)
        System.out.println("vlaue " + value);
        // Configure the component with the specified value
        ((JTextField) component).setText("" + value);
        ((JTextField) component).selectAll();

        // Return the configured component
        return component;
    }

    // This method is called when editing is completed.
    // It must return the new value to be stored in the cell.
    public Object getCellEditorValue() {
        String s = ((JTextField) component).getText();
        if (!"".equals(s)) {
            Double dd = new Double((s));
            return dd;
        }
        return null;
    }

    public JTextField getComponent() {
        return component;
    }
}
