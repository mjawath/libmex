/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicingsystem;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author nnjj
 */
class TableEditor extends AbstractCellEditor
        implements TableCellEditor {

    private JTable masterTbl;
    DetailPopUpPanel popUpComponent;
    JTextField component;
    
    // This method is called when a cell value is edited by the user.

    public TableEditor(DetailPopUpPanel popUpComponent, JTable tbl) {
        this.popUpComponent = popUpComponent;
        this.masterTbl = tbl;
        init();

    }

    @Override
    public boolean stopCellEditing() {
//        if (component.getText().equals("abcd") || component.getText().equals("")) {
      
            int selcol=masterTbl.getSelectedColumn();
            int selrow=masterTbl.getSelectedRow();
//            TableColumn tc= masterTbl.getColumnModel().getColumn(selcol); 
                 boolean b = super.stopCellEditing();
                 masterTbl.changeSelection(selrow, selcol+1, true, true);
            return b;
//        }
//
//        return false;
    }

    public TableEditor() {
        init();

    }

    private void init() {


        component = new JTextField();
        
        /* component.addKeyListener(new KeyAdapter() {
        
        @Override
        public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
        System.out.println("dfd");
        //                    if (component.getText().equals("a")) {
        ////                        e.consume();
        stopCellEditing();
        //                        masterTbl.changeSelection(masterTbl.getSelectedRow(), masterTbl.getSelectedColumn()+2, true, true);
        //                        return;
        //                    }
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        System.out.println(" pressed up button ");
        //                    e.consume();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        System.out.println(" pressed down button ");
        //                    e.consume();
        }
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
        }
        }
        });
        component.addFocusListener(new FocusAdapter() {
        
        @Override
        public void focusGained(FocusEvent e) {
        System.out.println(e);
        }
        
        @Override
        public void focusLost(FocusEvent e) {
        System.out.println("lost " + e);
        }
        });
        
         */
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)

        if (isSelected) {
            // cell (and perhaps other cells) are selected
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
