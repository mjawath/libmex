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

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import org.components.windows.TabPanelUI;

/**
 *
 * @author user
 */
public class InvoiceTestUI2 extends TabPanelUI {

    /** Creates new form InvoiceTestUI */
    public InvoiceTestUI2() {
        initComponents();
        cxTable1.putClientProperty("JTable.autoStartsEdit", Boolean.TRUE);
            
           jd= new jd();
           jd.getRootPane().setOpaque(false);
           AWTUtilities.setWindowOpacity(jd, 0.8f);
           jd.setUndecorated(true);
                
                jd.setSize(700,100);
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
                System.out.println("pressed " + e);
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
//        cxTable1.getColumn(0).setCellEditor(new MyTableCellEditor());
//        cxTable1.getColumn(1).setCellEditor(new MyTableCellEditor());
//        cxTable1.getColumn(2).setCellEditor(new MyTableCellEditor());
//        cxTable1.getColumn(3).setCellEditor(new MyTableC/ellEditor());

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
   
                int x = (int) cxTable1.getLocationOnScreen().x;
                int y = (int) cxTable1.getLocationOnScreen().y;
                int sr = cxTable1.getSelectedRow();
                int hight= (sr+1)*cxTable1.getRowHeight();
                jd.setLocation(x,y+hight);
                jd.setFocusable(false);
                jd.setVisible(true);
                
            }
        });
        cxTable1.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
        jd.setVisible(false);
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
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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

