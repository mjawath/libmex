/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import com.components.custom.PagedPopUpPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import org.biz.app.ui.util.TableUtil;

/**
 *
 * @author nnjj
 */
public class TablePopUpCellEditor extends AbstractCellEditor
        implements TableCellEditor {

    private JTable tbl;
    PagedPopUpPanel popUpComponent;
    JTextField component;

    // This method is called when a cell value is edited by the user.
    public TablePopUpCellEditor(PagedPopUpPanel popUpComponent, JTable tbl) {
        this.popUpComponent = popUpComponent;
        init(tbl);

    }

    @Override
    public boolean stopCellEditing() {
        boolean b = false;
        if (isCellValid()) {
            
            b = super.stopCellEditing();
            
        }
        return b;
    }

    public boolean isCellValid() {
        return true;
    }

    public TablePopUpCellEditor(JTable jt) {
        init(jt);


    }

    public boolean validateCell() {

        return true;
    }

    private void init(JTable jt) {
        //specify

        tbl = jt;
        component = new JTextField();

        component.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                stopCellEditing();

                int selcol = tbl.getSelectedColumn();
                int selrow = tbl.getSelectedRow();
                int colcount = tbl.getColumnCount();
                int rowcount = tbl.getRowCount();

                boolean ab = action();//Action will return true if it need new row or 
                if (((rowcount - 1) == selrow) && ab) {              //false normal selection           
                    TableUtil.addrow(tbl, new Object[]{});
                    tbl.changeSelection(selrow + 1, 1, false, false);
                } else {
                    selcol = (colcount - 1) == selcol ? selcol : ++selcol;
                    tbl.changeSelection(selrow, selcol, false, false);
                }
            }
        });

    }

    public boolean action() {
        return false;

    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)
        if (!isSelected) {
            return null;
        }
        // Configure the component with the specified value
        if (value != null) {
            ((JTextField) component).setText("" + value);
            ((JTextField) component).selectAll();

        }
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
        return tbl;
    }

    /**
     * @param masterTbl the masterTbl to set
     */
    public void setMasterTbl(JTable masterTbl) {
        this.tbl = masterTbl;
    }
}