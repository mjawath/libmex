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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.components.windows.TabPanelUI;

/**
 *
 * @author user
 */
public class InvoiceTestUI3 extends TabPanelUI {
     DetailPopUpPanel detailPopUpPanel;
    /** Creates new form InvoiceTestUI */
    public InvoiceTestUI3() {
        initComponents();
//       detailPopUpPanel=new DetailPopUpPanel(cxTable1,new JTextField() ) {
//
//         
//        };
       
       cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
           

                detailPopUpPanel.showPopUp();
            }
        });
       
       cxTable1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
       
                System.out.println("  "+e);
            }       
       });
    }
    
    
    void initPopup(){
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cPanel1 = new org.components.containers.CPanel();
        cButton1 = new org.components.controls.CButton();
        cTextField2 = new org.components.controls.CTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        cTextField1 = new org.components.controls.CTextField();
        cButton2 = new org.components.controls.CButton();

        setLayout(null);

        cPanel1.setLayout(null);

        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });
        cPanel1.add(cButton1);
        cButton1.setBounds(80, 50, 65, 23);

        cTextField2.setText("cTextField2");
        cPanel1.add(cTextField2);
        cTextField2.setBounds(20, 10, 110, 25);

        add(cPanel1);
        cPanel1.setBounds(20, 350, 640, 90);

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
                true, false, false, false, false, false
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
        jScrollPane1.setBounds(10, 110, 660, 200);

        cTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField1ActionPerformed(evt);
            }
        });
        cTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cTextField1KeyReleased(evt);
            }
        });
        add(cTextField1);
        cTextField1.setBounds(40, 40, 130, 25);

        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });
        add(cButton2);
        cButton2.setBounds(150, 460, 65, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void cTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField1ActionPerformed
    }//GEN-LAST:event_cTextField1ActionPerformed

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed



    }//GEN-LAST:event_cButton2ActionPerformed

    private void cTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cTextField1KeyReleased
    }//GEN-LAST:event_cTextField1KeyReleased

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.containers.CPanel cPanel1;
    private org.components.controls.CTextField cTextField1;
    private org.components.controls.CTextField cTextField2;
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
