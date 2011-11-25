/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InvoiceTestUI.java
 *
 * Created on Nov 24, 2011, 7:57:59 PM
 */
package invoicingsystem;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import org.components.windows.TabPanelUI;

/**
 *
 * @author user
 */
public class InvoiceTestUI extends TabPanelUI {

    /** Creates new form InvoiceTestUI */
    public InvoiceTestUI() {
        initComponents();
        cxTable1.setSurrendersFocusOnKeystroke(true);
        cxTable1.getColumn(0).setCellEditor(new MyTableCellEditor() );
        cxTable1.getColumn(1).setCellEditor(new MyTableCellEditor() );
        cxTable1.getColumn(2).setCellEditor(new MyTableCellEditor() );
        cxTable1.getColumn(3).setCellEditor(new MyTableCellEditor() );
        cxTable1.getColumn(3).setCellEditor(new TableCellEditor(){

            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public Object getCellEditorValue() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean isCellEditable(EventObject anEvent) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean shouldSelectCell(EventObject anEvent) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean stopCellEditing() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void cancelCellEditing() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void addCellEditorListener(CellEditorListener l) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void removeCellEditorListener(CellEditorListener l) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        } );
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();

        setLayout(null);

        jScrollPane1.setViewportView(cxTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 30, 660, 460);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
        return "* Invocise Test *";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
}
 class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {
    // This is the component that will handle the editing of the cell value
    JComponent component = new JTextField();

    public MyTableCellEditor() {
    super();
    component.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("WTF "+e.getKeyChar()); 
                
            }    
    });
    }

    
    // This method is called when a cell value is edited by the user.
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)

        if (isSelected) {
            // cell (and perhaps other cells) are selected
        }

        // Configure the component with the specified value
        ((JTextField)component).setText((String)value);

        // Return the configured component
        return component;
    }

    // This method is called when editing is completed.
    // It must return the new value to be stored in the cell.
    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }
}