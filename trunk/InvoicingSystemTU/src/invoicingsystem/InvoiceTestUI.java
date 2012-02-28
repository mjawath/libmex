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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellEditor;
import org.components.parent.controls.editors.CustomRenderer;
import org.components.windows.TabPanelUI;

/**
 *
 * @author user
 */
public class InvoiceTestUI extends TabPanelUI {

    DetailPanel panel;

    /** Creates new form InvoiceTestUI */
    public InvoiceTestUI() {
        initComponents();

        panel = new DetailPanel();
        cxTable1.putClientProperty("JTable.autoStartsEdit", Boolean.TRUE);



        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(10, 310));
        layeredPane.setBackground(Color.red);
        layeredPane.setBorder(BorderFactory.createTitledBorder(
                "Move the Mouse to Move Duke"));
        layeredPane.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("e " + e);
            }
        });
        add(layeredPane);

        cxTable1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("jtable pressed " + e);
                int sc = cxTable1.getSelectedColumn();
                int sr = cxTable1.getSelectedRow();
                if (sr > -1) {
                    System.out.println("sdffsfsafsafsadf");
                    TableCellEditor tc = cxTable1.getCellEditor(sr, sc);
                    Component c = tc.getTableCellEditorComponent(cxTable1, tc.getCellEditorValue(), true, sr, sc);
                    if (c instanceof JTextField) {
                        JTextField cc = (JTextField) c;
                        cc.setCaretPosition(0);
                    }
                }
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

        cxTable1.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),
                "doSomething");
        cxTable1.getActionMap().put("doSomething",
                new AbstractAction() {

                    public void actionPerformed(ActionEvent e) {
                        System.out.println(" time " + System.currentTimeMillis());
                    }
                });

        cxTable1.setDefaultRenderer(String.class, new CustomRenderer());
        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
            }
        });
        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
            }
        });
        cxTable1.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
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
        jScrollPane1.setBounds(10, 200, 660, 310);

        cTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField1ActionPerformed(evt);
            }
        });
        add(cTextField1);
        cTextField1.setBounds(40, 40, 130, 25);
    }// </editor-fold>//GEN-END:initComponents
    JDialog jd = null;
    private void cTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField1ActionPerformed

        cxTable1.requestFocus();
        cxTable1.editCellAt(0, 0);
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

class MyTableCellEditor extends DefaultCellEditor {
    
    JTextField jtf=new JTextField();
    
    public MyTableCellEditor() {
        super(new JTextField());
        
        
  
    }
   
    
}



class jd extends JDialog {

    public jd() {
        setFocusableWindowState(false);
    }
}

