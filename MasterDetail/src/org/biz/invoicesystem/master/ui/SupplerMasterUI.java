/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SupplerMasterUI.java
 *
 * Created on Nov 19, 2011, 12:13:25 AM
 */
package org.biz.invoicesystem.master.ui;

import javax.swing.JPanel;
import org.components.windows.TabPanelUI;

/**
 *
 * @author Administrator
 */
public class SupplerMasterUI extends TabPanelUI {

    /** Creates new form SupplerMasterUI */
    public SupplerMasterUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cLabel6 = new org.components.controls.CLabel();
        cComboBox1 = new org.components.controls.CComboBox();
        cLabel7 = new org.components.controls.CLabel();
        cLabel2 = new org.components.controls.CLabel();
        cLabel8 = new org.components.controls.CLabel();
        cLabel4 = new org.components.controls.CLabel();
        cTextField2 = new org.components.controls.CTextField();
        cLabel3 = new org.components.controls.CLabel();
        cComboBox2 = new org.components.controls.CComboBox();
        cDatePicker1 = new org.components.controls.CDatePicker();
        cLabel5 = new org.components.controls.CLabel();
        cButton1 = new org.components.controls.CButton();
        cButton3 = new org.components.controls.CButton();
        cButton4 = new org.components.controls.CButton();
        cButton5 = new org.components.controls.CButton();
        cTextField3 = new org.components.controls.CTextField();
        cTextField4 = new org.components.controls.CTextField();
        cTextField5 = new org.components.controls.CTextField();
        cTextField6 = new org.components.controls.CTextField();
        cLabel9 = new org.components.controls.CLabel();
        cTextField7 = new org.components.controls.CTextField();
        cLabel10 = new org.components.controls.CLabel();
        cTextField8 = new org.components.controls.CTextField();
        cLabel12 = new org.components.controls.CLabel();
        cTextField10 = new org.components.controls.CTextField();
        cLabel13 = new org.components.controls.CLabel();
        cComboBox4 = new org.components.controls.CComboBox();
        cTextField11 = new org.components.controls.CTextField();
        cLabel14 = new org.components.controls.CLabel();

        setLayout(null);

        cLabel6.setText("Address");
        add(cLabel6);
        cLabel6.setBounds(360, 80, 63, 25);

        cComboBox1.setEditable(true);
        add(cComboBox1);
        cComboBox1.setBounds(140, 160, 160, 23);

        cLabel7.setText("City");
        add(cLabel7);
        cLabel7.setBounds(360, 150, 31, 25);

        cLabel2.setText("Supplier Id");
        add(cLabel2);
        cLabel2.setBounds(10, 10, 239, 25);

        cLabel8.setText("Phone");
        add(cLabel8);
        cLabel8.setBounds(360, 190, 48, 25);

        cLabel4.setText("Name ");
        add(cLabel4);
        cLabel4.setBounds(330, 10, 119, 25);

        cTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField2ActionPerformed(evt);
            }
        });
        add(cTextField2);
        cTextField2.setBounds(330, 40, 275, 25);

        cLabel3.setText("Title");
        add(cLabel3);
        cLabel3.setBounds(260, 10, 40, 25);

        cComboBox2.setEditable(true);
        add(cComboBox2);
        cComboBox2.setBounds(260, 40, 63, 23);
        add(cDatePicker1);
        cDatePicker1.setBounds(610, 40, 110, 22);

        cLabel5.setText("DOB");
        add(cLabel5);
        cLabel5.setBounds(610, 10, 110, 25);

        cButton1.setText("Close");
        add(cButton1);
        cButton1.setBounds(220, 210, 59, 40);

        cButton3.setText("Save");
        cButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton3ActionPerformed(evt);
            }
        });
        add(cButton3);
        cButton3.setBounds(40, 210, 57, 40);

        cButton4.setText("Clear");
        add(cButton4);
        cButton4.setBounds(100, 210, 57, 40);

        cButton5.setText("Delete");
        add(cButton5);
        cButton5.setBounds(160, 210, 63, 40);

        cTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField3ActionPerformed(evt);
            }
        });
        add(cTextField3);
        cTextField3.setBounds(430, 80, 284, 25);

        cTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField4ActionPerformed(evt);
            }
        });
        add(cTextField4);
        cTextField4.setBounds(430, 120, 284, 25);

        cTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField5ActionPerformed(evt);
            }
        });
        add(cTextField5);
        cTextField5.setBounds(430, 150, 284, 25);

        cTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField6ActionPerformed(evt);
            }
        });
        add(cTextField6);
        cTextField6.setBounds(430, 190, 284, 25);

        cLabel9.setText("Mobile");
        add(cLabel9);
        cLabel9.setBounds(360, 230, 48, 25);

        cTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField7ActionPerformed(evt);
            }
        });
        add(cTextField7);
        cTextField7.setBounds(430, 230, 284, 25);

        cLabel10.setText("Email");
        add(cLabel10);
        cLabel10.setBounds(360, 260, 48, 25);

        cTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField8ActionPerformed(evt);
            }
        });
        add(cTextField8);
        cTextField8.setBounds(430, 260, 284, 25);

        cLabel12.setText("Company Name");
        add(cLabel12);
        cLabel12.setBounds(20, 90, 119, 25);

        cTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField10ActionPerformed(evt);
            }
        });
        add(cTextField10);
        cTextField10.setBounds(139, 90, 190, 25);

        cLabel13.setText("Type");
        add(cLabel13);
        cLabel13.setBounds(20, 160, 119, 25);

        cComboBox4.setEditable(true);
        add(cComboBox4);
        cComboBox4.setBounds(140, 130, 160, 23);

        cTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField11ActionPerformed(evt);
            }
        });
        add(cTextField11);
        cTextField11.setBounds(10, 40, 239, 25);

        cLabel14.setText("Religion");
        add(cLabel14);
        cLabel14.setBounds(20, 130, 119, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void cTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField2ActionPerformed

    private void cButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton3ActionPerformed
        
        //        if (selectedItem != null) {
        //            Item item = itemService.getDao().deatach(selectedItem, selectedItem.getId());
        //            uiToEty(item);
        //            //            item.setProduct(selectedProd);
        //            itemService.getDao().update(item);
        //            items = itemService.getDao().getAll();
        //            addToTable(items);
        //            return;
        //        }
        
        //        uiToEty(item)?;
        //        item.setProduct(selectedProd);
        
        //        Object [] ss= new Object[]{new Item(),new Customer()};
        //        ipu.populateTable(items);
}//GEN-LAST:event_cButton3ActionPerformed

    private void cTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField3ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField3ActionPerformed

    private void cTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField4ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField4ActionPerformed

    private void cTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField5ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField5ActionPerformed

    private void cTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField6ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField6ActionPerformed

    private void cTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField7ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField7ActionPerformed

    private void cTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField8ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField8ActionPerformed

    private void cTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField10ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField10ActionPerformed

    private void cTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cTextField11ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CButton cButton4;
    private org.components.controls.CButton cButton5;
    private org.components.controls.CComboBox cComboBox1;
    private org.components.controls.CComboBox cComboBox2;
    private org.components.controls.CComboBox cComboBox4;
    private org.components.controls.CDatePicker cDatePicker1;
    private org.components.controls.CLabel cLabel10;
    private org.components.controls.CLabel cLabel12;
    private org.components.controls.CLabel cLabel13;
    private org.components.controls.CLabel cLabel14;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CLabel cLabel8;
    private org.components.controls.CLabel cLabel9;
    private org.components.controls.CTextField cTextField10;
    private org.components.controls.CTextField cTextField11;
    private org.components.controls.CTextField cTextField2;
    private org.components.controls.CTextField cTextField3;
    private org.components.controls.CTextField cTextField4;
    private org.components.controls.CTextField cTextField5;
    private org.components.controls.CTextField cTextField6;
    private org.components.controls.CTextField cTextField7;
    private org.components.controls.CTextField cTextField8;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
       return "Suppler Master";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
}
