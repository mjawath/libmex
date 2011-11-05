
/*
 * ContactsUI.java
 *
 * Created on 22-Apr-2011, 22:27:15
 */
package org.biz.invoicesystem.master.ui;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.swing.JPanel;
import org.biz.app.ui.util.TableUtil;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.contacts.Address;
import org.biz.invoicesystem.entity.contacts.ContactDetail;
import org.biz.invoicesystem.entity.contacts.Email;
import org.biz.invoicesystem.entity.contacts.Fax;
import org.biz.invoicesystem.entity.contacts.Phone;
import org.biz.invoicesystem.entity.contacts.SocialWebsite;
import org.biz.invoicesystem.entity.contacts.Website;
import org.biz.invoicesystem.service.contacts.ContactsDetailService;
import org.biz.invoicesystem.service.contacts.PhoneService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author mjawath
 */
public class ContactsUI extends TabPanelUI {

    ContactDetail contactDetail;
    ContactsDetailService detailService;
    EntityService es;

    /** Creates new form ContactsUI */
    public ContactsUI() {
        initComponents();
//        init();
    }

    @Override
    public void init() {
        es = EntityService.getEntityService();
        detailService = new ContactsDetailService();
        contactDetail = new ContactDetail();
        contactDetail.setAddresses(new ArrayList<Address>());
        contactDetail.setEmails(new ArrayList<Email>());
        contactDetail.setFaxs(new ArrayList<Fax>());
        contactDetail.setPhones(new ArrayList<Phone>());
        contactDetail.setWebsites(new ArrayList<Website>());
        contactDetail.setSocialWebsites(new ArrayList<SocialWebsite>());
        contactDetail.setId(353l);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});

        tphone.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent(cxTable1, e);
                    Object val = TableUtil.getSelectedValue(cxTable1, 1);
                    if (val != null) {
                        tphone.setText(val.toString());

                        tphone.setCaretPosition(tphone.getText().length());
                        tphone.selectAll();
                    }
                }

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    cTextField1.requestFocus();
                    return;
                }
                if (e.getKeyCode() == KeyEvent.VK_DELETE && e.isControlDown()) {
                    System.out.println(e);
                    remove();
                }
            }
        });
        cTextField1.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    addd();
                    tphone.requestFocus();
                }
            }
        });
    }

    private void remove() {
        Object rowid = TableUtil.rowID(cxTable1);
        if (rowid != null) {
            //new row new
            for (Iterator<Phone> it = contactDetail.getPhones().iterator(); it.hasNext();) {
                Phone phone = it.next();
                if (phone.getId().equals(rowid)) {
                   it.remove();
                   break;
                }
            }
            TableUtil.cleardata(cxTable1);
                for (Phone ph : contactDetail.getPhones()) {
                    TableUtil.addrow(cxTable1, new Object[]{ph.getId(), ph.getNumber()});
                }
                TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});

       
        }
            
    }

    private void addd() {
        Phone ph = new Phone();
        ph.setId(es.getKey());
        ph.setNumber(tphone.getText());
        //if it is not new row  then return row id value
        Object rowid = TableUtil.rowID(cxTable1);
        if (rowid == null) {
            //new row new
            contactDetail.getPhones().add(ph);
        } else {
            //replace row update
            for (ListIterator<Phone> it = contactDetail.getPhones().listIterator(); it.hasNext();) {
                Phone phone = it.next();
                if (phone.getId().equals(rowid)) {
                    it.set(ph);
                    break;
                }
            }
        }
        TableUtil.cleardata(cxTable1);
        for (Phone phone : contactDetail.getPhones()) {
            TableUtil.addrow(cxTable1, new Object[]{phone.getId(), phone.getNumber()});
        }
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cButton1 = new org.components.controls.CButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        tphone = new org.components.controls.CTextField();
        tphone1 = new org.components.controls.CTextField();
        cButton2 = new org.components.controls.CButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cxTable2 = new org.components.controls.CxTable();
        cButton3 = new org.components.controls.CButton();
        cButton4 = new org.components.controls.CButton();
        cButton5 = new org.components.controls.CButton();
        cButton6 = new org.components.controls.CButton();
        cTextField1 = new org.components.controls.CTextField();

        setLayout(null);

        cButton1.setText("Add");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });
        add(cButton1);
        cButton1.setBounds(220, 20, 67, 23);

        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cxTable1.setSelectionBackground(new java.awt.Color(167, 217, 247));
        jScrollPane1.setViewportView(cxTable1);
        cxTable1.getColumnModel().getColumn(0).setResizable(false);
        cxTable1.getColumnModel().getColumn(1).setResizable(false);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 42, 200, 234);
        add(tphone);
        tphone.setBounds(10, 11, 161, 25);
        add(tphone1);
        tphone1.setBounds(300, 20, 161, 25);

        cButton2.setText("Add");
        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });
        add(cButton2);
        cButton2.setBounds(470, 20, 67, 23);

        cxTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Fax"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cxTable2);
        cxTable2.getColumnModel().getColumn(0).setResizable(false);

        add(jScrollPane2);
        jScrollPane2.setBounds(300, 50, 161, 234);

        cButton3.setText("Default");
        cButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton3ActionPerformed(evt);
            }
        });
        add(cButton3);
        cButton3.setBounds(220, 50, 67, 23);

        cButton4.setText("Default");
        cButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton4ActionPerformed(evt);
            }
        });
        add(cButton4);
        cButton4.setBounds(470, 50, 67, 23);

        cButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton5ActionPerformed(evt);
            }
        });
        add(cButton5);
        cButton5.setBounds(550, 20, 65, 23);

        cButton6.setText("Remove");
        cButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton6ActionPerformed(evt);
            }
        });
        add(cButton6);
        cButton6.setBounds(220, 80, 70, 23);
        add(cTextField1);
        cTextField1.setBounds(180, 10, 40, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed

        if (cxTable1.getSelectedRow() > -1 && cxTable1.getRowCount() == (cxTable1.getSelectedRow() + 1)) {
            //add new row
        } else {
            //replace row
        }

        //get id value of column  this is the new column id MMX##$^^^
        if (TableUtil.isSelectedRowNewRow(cxTable1)) {
            //new row
        } else {
            //replace row
        }
        addd();


    }//GEN-LAST:event_cButton1ActionPerformed

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cButton2ActionPerformed

    private void cButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cButton3ActionPerformed

    private void cButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cButton4ActionPerformed

    private void cButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton5ActionPerformed

        detailService.getDao().update(contactDetail);
    }//GEN-LAST:event_cButton5ActionPerformed

    private void cButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton6ActionPerformed
    }//GEN-LAST:event_cButton6ActionPerformed

    @Override
    public String getTabName() {
        return "Contacts ";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CButton cButton4;
    private org.components.controls.CButton cButton5;
    private org.components.controls.CButton cButton6;
    private org.components.controls.CTextField cTextField1;
    private org.components.controls.CxTable cxTable1;
    private org.components.controls.CxTable cxTable2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.components.controls.CTextField tphone;
    private org.components.controls.CTextField tphone1;
    // End of variables declaration//GEN-END:variables
}
