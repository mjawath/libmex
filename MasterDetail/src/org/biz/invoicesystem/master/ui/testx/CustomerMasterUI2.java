/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * cust.java
 *
 * Created on Nov 18, 2011, 11:54:02 PM
 */
package org.biz.invoicesystem.master.ui.testx;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.biz.invoicesystem.entity.master.Customer;
import org.biz.invoicesystem.service.master.CustomerService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author Administrator
 */
public class CustomerMasterUI2 extends TabPanelUI  {

    
     private CustomerService cService;
  
  List<Customer> customers;
  
  Customer customer;

    @Override
    public void init() {
  
        try {
           
   cService=new CustomerService();
   customers=new ArrayList<Customer>();
   customer=new Customer();
   
   
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }
    /** Creates new form cust */
    public CustomerMasterUI2() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cLabel6 = new org.components.controls.CLabel();
        cComboBox1 = new org.components.controls.CComboBox();
        cLabel7 = new org.components.controls.CLabel();
        cLabel2 = new org.components.controls.CLabel();
        cLabel8 = new org.components.controls.CLabel();
        cLabel1 = new org.components.controls.CLabel();
        cLabel4 = new org.components.controls.CLabel();
        cTextField2 = new org.components.controls.CTextField();
        cTextField1 = new org.components.controls.CTextField();
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
        cLabel11 = new org.components.controls.CLabel();
        cTextField9 = new org.components.controls.CTextField();

        cLabel6.setText("Address");

        cComboBox1.setEditable(true);

        cLabel7.setText("City");

        cLabel2.setText("Custmer Id");

        cLabel8.setText("Phone");

        cLabel1.setText("Custmer Type");

        cLabel4.setText("Custmer Name ");

        cTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField2ActionPerformed(evt);
            }
        });

        cTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField1ActionPerformed(evt);
            }
        });

        cLabel3.setText("Title");

        cComboBox2.setEditable(true);

        cLabel5.setText("DOB");

        cButton1.setText("Close");

        cButton3.setText("Save");
        cButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton3ActionPerformed(evt);
            }
        });

        cButton4.setText("Clear");

        cButton5.setText("Delete");

        cTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField3ActionPerformed(evt);
            }
        });

        cTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField4ActionPerformed(evt);
            }
        });

        cTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField5ActionPerformed(evt);
            }
        });

        cTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField6ActionPerformed(evt);
            }
        });

        cLabel9.setText("Mobile");

        cTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField7ActionPerformed(evt);
            }
        });

        cLabel10.setText("Email");

        cTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField8ActionPerformed(evt);
            }
        });

        cLabel11.setText("S.Rep");

        cTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTextField9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(cButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(cLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(163, 163, 163)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cLabel10, 0, 0, Short.MAX_VALUE)
                                    .addComponent(cLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cLabel11, 0, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(549, 549, 549))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField2ActionPerformed

    private void cTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cTextField1ActionPerformed

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

    private void cTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cTextField9ActionPerformed

    
      /**
     * @param cService the cService to set
     */
    public void setcService(CustomerService cService) {
        this.cService = cService;
    }

    @Override
    public String getTabName() {
        return "Customer Form";
    }

    @Override
    public JPanel getJPanel() {
    
        return this;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CButton cButton4;
    private org.components.controls.CButton cButton5;
    private org.components.controls.CComboBox cComboBox1;
    private org.components.controls.CComboBox cComboBox2;
    private org.components.controls.CDatePicker cDatePicker1;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel10;
    private org.components.controls.CLabel cLabel11;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CLabel cLabel8;
    private org.components.controls.CLabel cLabel9;
    private org.components.controls.CTextField cTextField1;
    private org.components.controls.CTextField cTextField2;
    private org.components.controls.CTextField cTextField3;
    private org.components.controls.CTextField cTextField4;
    private org.components.controls.CTextField cTextField5;
    private org.components.controls.CTextField cTextField6;
    private org.components.controls.CTextField cTextField7;
    private org.components.controls.CTextField cTextField8;
    private org.components.controls.CTextField cTextField9;
    // End of variables declaration//GEN-END:variables
}
