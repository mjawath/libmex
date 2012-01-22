/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import org.biz.app.ui.util.ComponentFactory;
import org.biz.app.ui.util.TableUtil;

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
        boolean b = false;
        if (isCellValid()) {           
                 b = super.stopCellEditing();
        }
        return b;
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
                int selcol = tbl.getSelectedColumn();
                int selrow = tbl.getSelectedRow();
                int colcount = tbl.getColumnCount();
                int rowcount = tbl.getRowCount();

                boolean ab = action();//Action will return true if it need new row or 
                if (((rowcount-1 )==selrow) && ab) {              //false normal selection           
                    TableUtil.addrow(tbl, new Object[]{});                    
                    tbl.changeSelection(selrow+1, 1, false, false);
                } else {
                    
                if (((rowcount-1 )> selrow) && ab){
                    System.out.println("ee");
                tbl.changeSelection(selrow+1, 1, false, false);
                return;
                }
                selcol = (colcount - 1) == selcol ? selcol : ++selcol;
                tbl.changeSelection(selrow, selcol, false, false);
                }
            }
        });

    }

    public boolean action() {
        return false;

    }

    public boolean isCellValid() {
        return true;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {

        if (!isSelected) {
            JLabel jl = new JLabel();
//            if (value == null) {
//                jl.setText("");
//            } else {
//                jl.setText(value.toString());
//            }
            return jl;
        }
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
