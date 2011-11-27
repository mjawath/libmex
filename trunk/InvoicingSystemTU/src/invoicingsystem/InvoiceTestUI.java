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

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
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
        cxTable1.putClientProperty("JTable.autoStartsEdit", Boolean.TRUE);



        cxTable1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println("pressed " + e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println("typed " + e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("released " + e);

            }
        });
        cxTable1.setSurrendersFocusOnKeystroke(true);
        cxTable1.getColumn(0).setCellEditor(new MyTableCellEditor());
        cxTable1.getColumn(1).setCellEditor(new MyTableCellEditor());
        cxTable1.getColumn(2).setCellEditor(new MyTableCellEditor());
        cxTable1.getColumn(3).setCellEditor(new MyTableCellEditor());
        /*   cxTable1.getColumn(3).setCellEditor(new TableCellEditor(){
        
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
        } );*/
        cxTable1.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),
                "doSomething");
        cxTable1.getActionMap().put("doSomething",
                new AbstractAction() {

                    public void actionPerformed(ActionEvent e) {
                        System.out.println(" time " + System.currentTimeMillis());
                    }
                });

        cxTable1.setDefaultRenderer(String.class, new CustomRenderer());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        cTextField1 = new org.components.controls.CTextField();

        setLayout(null);

        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "asdfs", "wehgewq", "rewhwj", "erjrew", "uyty", "iuyy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cxTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 660, 400);

        cTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField1ActionPerformed(evt);
            }
        });
        add(cTextField1);
        cTextField1.setBounds(40, 40, 130, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void cTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField1ActionPerformed

        cxTable1.requestFocus();
    }//GEN-LAST:event_cTextField1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CTextField cTextField1;
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

    JComponent component = new JTextField() {

        @Override
        protected void processKeyEvent(KeyEvent e) {
                    System.out.println("eeeeeeeeee"+e);

            super.processKeyEvent(e);
        }

        

        

    };

    public MyTableCellEditor() {
        super();
        component.setBackground(Color.orange);
        component.addKeyListener(new KeyAdapter() {

            
            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println("ccccccccr pressed ----------------\n" + e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("action concumed ");
                    stopCellEditing();
                    return;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println("ccccccctyped " + e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                System.out.println("ccccccccckey rtel;ased " + e);
            }
        });
        component.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
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
        ((JTextField) component).setText((String) value);

        // Return the configured component
        return component;
    }

    // This method is called when editing is completed.
    // It must return the new value to be stored in the cell.
    public Object getCellEditorValue() {
        return ((JTextField) component).getText();
    }
}

class CustomRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (isSelected && hasFocus) {
            c.setBackground(Color.red);
        }


        // Formatting
        return c;
    }
}
