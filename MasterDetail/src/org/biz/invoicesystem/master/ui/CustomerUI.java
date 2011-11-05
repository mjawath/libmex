/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomerUI.java
 *
 * Created on 13-Apr-2011, 16:15:14
 */
package org.biz.invoicesystem.master.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.Customer;
import org.biz.invoicesystem.service.master.CustomerService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author mjawath
 */
public class CustomerUI extends TabPanelUI {

    Customer customer;
    CustomerService service;
    EntityService es;
    Customer selectedCustomer;

    /** Creates new form CustomerUI */
    public CustomerUI() {
        initComponents();
        init();
    }

    @Override
    public void init() {
        customer = new Customer();
        service = new CustomerService();
        es=EntityService.getEntityService();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cButton2 = new org.components.controls.CButton();
        tcode = new org.components.controls.CTextField();
        cButton1 = new org.components.controls.CButton();
        cLabel1 = new org.components.controls.CLabel();
        cLabel2 = new org.components.controls.CLabel();
        tname = new org.components.controls.CTextField();

        cButton2.setText("Fill table");
        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });

        cButton1.setText("Save");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });

        cLabel1.setText("Customer Code :");

        cLabel2.setText("Name :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcode, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(301, 301, 301)
                                .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(413, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    List<Customer> cs = new ArrayList<Customer>();
    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed

    }//GEN-LAST:event_cButton2ActionPerformed

    
    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed
        uiety(customer);
        customer.setId(es.getKey());
        service.getDao().save(customer);
        customer = new Customer();
        etyui(customer);
    }//GEN-LAST:event_cButton1ActionPerformed

    public void uiety(Customer customer) {
        customer.setName(uiEty.tcToStr(tname) );
        customer.setCode(uiEty.tcToStr(tcode) );

    }

    public void etyui(Customer customer) {
         uiEty.objToUi(tcode, customer.getCode());
         uiEty.objToUi(tname, customer.getName());
    }

    @Override
    public String getTabName() {
        return "Customer ";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CTextField tcode;
    private org.components.controls.CTextField tname;
    // End of variables declaration//GEN-END:variables
}
