/*
 */

/*
 * InvoiceUI.java
 *
 * Created on 12-Apr-2011, 12:36:51
 */
package invoicingsystem;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.biz.app.ui.util.MessageBoxes;
import org.biz.invoicesystem.master.ui.CustomerPopUp;
import org.biz.invoicesystem.master.ui.ItemPopUp;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.inventory.InventoryJournal;
import org.biz.invoicesystem.entity.inventory.InventoryJournalLine;
import org.biz.invoicesystem.entity.master.Customer;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.entity.transactions.SalesInvoice;
import org.biz.invoicesystem.entity.transactions.SalesInvoiceLineItem;
import org.biz.invoicesystem.service.master.CustomerService;
import org.biz.invoicesystem.service.transactions.SalesInvoiceService;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author mjawath
 */
public class SalesInvoiceUI extends TabPanelUI {

//
    CustomerService cs;
    List<Customer> customers;
    ItemService itemService;
    SalesInvoice invoice;
    SalesInvoiceService invoiceService;
    List<Item> items;
    /** Creates new form InvoiceUI */
    ItemPopUp dialog;
    CustomerPopUp cusdialog;
    SalesInvoiceLineItem curlineItem;
    EntityService es;
    int rownum = 15575;
    Item selectedItem;
    Customer selectedCustomer;

    public SalesInvoiceUI() {

        initComponents();
        curlineItem = new SalesInvoiceLineItem();
//                   dialog.setUndecorated(true);

        titem.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                dialog.setVisible(false);
            }
        });
        init();
    }

    @Override
    public void init() {
        events();
        cs = new CustomerService();
        es = EntityService.getEntityService();
        itemService = new ItemService();
        invoiceService = new SalesInvoiceService();
        invoice = new SalesInvoice();
        invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
        items = new ArrayList<Item>();
        items = itemService.getDao().getAll();

        dialog = new ItemPopUp(titem, items) {

            @Override
            public void action() {
                selectedItem = (Item)dialog.getSelectedItem();
            }

            @Override
            public void deleteAction() {
                /*
                 *
                 *
                 *  SalesInvoiceUI.this.remove();
                 *
                 */
            }
        };

        dialog.setSecTable(cxTable1);
        customers = cs.getDao().getAll();



    }

    @Override
    public void events() {
        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                if (cxTable1.getSelectedRow() > -1) {
                    Object ob = TableUtil.getSelectedValue(cxTable1, 0);
                    if (ob != null) {
                        for (SalesInvoiceLineItem sl : invoice.getLineItems()) {
                            if (ob.equals(sl.getId())) {

                                uiEty.objToUi(titem, sl.getItem().getId());
                                uiEty.objToUi(tqty, sl.getQty());
                                uiEty.objToUi(tamount, sl.getLineAmount());
                                uiEty.objToUi(tprice, sl.getPrice());
                                //put to uom combo box

                                uiEty.objToUi(tdescription, sl.getDescription());
                                Item selectedItem = sl.getItem();
                                return;
                            }
                        }
                        uiEty.objToUi(titem, "");
                        uiEty.objToUi(tdescription, "");
                        uiEty.objToUi(tqty, "");
                        uiEty.objToUi(tamount, "");
                        uiEty.objToUi(tprice, "");


                    }
                }
            }
        });

//        dialog.setFocusableWindowState(false);
//        cusdialog.setFocusableWindowState(false);

        titem.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
//                if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) && e.isControlDown()) {
//                  int x=cxTable1.getSelectedRow();
//                    TableUtil.selectNextRow(cxTable1, e);
//                    Object val = TableUtil.getSelectedValue(cxTable1, 0);
//                    if (val != null) {
//                        titem.setText(val.toString());
//                        titem.setCaretPosition(titem.getText().length());
//                        titem.selectAll();
//                    }
//                }
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    tqty.requestFocus();
//                    return;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_DELETE && e.isControlDown()) {
//                    System.out.println(e);
//                    remove();
//                }
            }
        });

    }

    private void remove() {
        Object rowid = TableUtil.rowID(cxTable1);
        if (rowid != null) {
            //new row new
            for (Iterator<SalesInvoiceLineItem> it = invoice.getLineItems().iterator(); it.hasNext();) {
                SalesInvoiceLineItem si = it.next();
                if (si.getId().equals(rowid)) {
                    it.remove();
                    break;
                }
            }
            addToTable(invoice.getLineItems());
        }

    }

    public InventoryJournal updateInventory(SalesInvoice grn) {
        InventoryJournal ij = new InventoryJournal();
        String key = es.getKey();
        ij.setId(key);
        ij.setDocumentType(SalesInvoice.class.getSimpleName());
        ij.setRefCode(grn.getId());
        ij.setModifiedDate(new Date());
        ij.setLines(new ArrayList<InventoryJournalLine>());
        int x = 0;
        for (SalesInvoiceLineItem gl : grn.getLineItems()) {
            InventoryJournalLine ijl = new InventoryJournalLine();
            ijl.setDescription(gl.getDescription());
            ijl.setItem(gl.getItem());
            ijl.setQty(-gl.getQty());    // + becas we add to inventory
            ijl.setUom(gl.getUom());
            ij.getLines().add(ijl);
            ijl.setId(key + "-" + x++);

        }

        return ij;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titem = new org.components.controls.CTextField();
        tdescription = new org.components.controls.CTextField();
        cButton1 = new org.components.controls.CButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        jButton1 = new javax.swing.JButton();
        cLabel1 = new org.components.controls.CLabel();
        tqty = new org.components.controls.CTextField();
        tamount = new org.components.controls.CTextField();
        tprice = new org.components.controls.CTextField();
        cLabel3 = new org.components.controls.CLabel();
        cLabel4 = new org.components.controls.CLabel();
        cLabel6 = new org.components.controls.CLabel();
        cLabel7 = new org.components.controls.CLabel();
        cButton3 = new org.components.controls.CButton();
        cButton5 = new org.components.controls.CButton();
        cButton2 = new org.components.controls.CButton();
        cButton4 = new org.components.controls.CButton();

        setLayout(null);
        add(titem);
        titem.setBounds(30, 50, 154, 25);

        tdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdescriptionActionPerformed(evt);
            }
        });
        add(tdescription);
        tdescription.setBounds(190, 50, 190, 25);

        cButton1.setText("Add");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });
        add(cButton1);
        cButton1.setBounds(840, 50, 60, 20);

        cxTable1.setForeground(new java.awt.Color(0, 0, 255));
        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Item", "Description", "Qty", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cxTable1.setSelectionBackground(new java.awt.Color(246, 201, 122));
        cxTable1.setSelectionForeground(new java.awt.Color(153, 0, 0));
        cxTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(cxTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 920, 200);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(420, 330, 60, 23);

        cLabel1.setText("Item");
        add(cLabel1);
        cLabel1.setBounds(60, 30, 38, 20);
        add(tqty);
        tqty.setBounds(384, 50, 150, 25);
        add(tamount);
        tamount.setBounds(650, 50, 173, 25);
        add(tprice);
        tprice.setBounds(540, 50, 100, 25);

        cLabel3.setText("Desc");
        add(cLabel3);
        cLabel3.setBounds(210, 30, 104, 20);

        cLabel4.setText("Qty");
        add(cLabel4);
        cLabel4.setBounds(390, 30, 40, 20);

        cLabel6.setText("price");
        add(cLabel6);
        cLabel6.setBounds(560, 20, 50, 20);

        cLabel7.setText("amount");
        add(cLabel7);
        cLabel7.setBounds(670, 20, 80, 20);

        cButton3.setText("Clear");
        cButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton3ActionPerformed(evt);
            }
        });
        add(cButton3);
        cButton3.setBounds(550, 330, 70, 23);

        cButton5.setText("Delete");
        cButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton5ActionPerformed(evt);
            }
        });
        add(cButton5);
        cButton5.setBounds(480, 330, 70, 23);

        cButton2.setText("New");
        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });
        add(cButton2);
        cButton2.setBounds(620, 330, 70, 23);

        cButton4.setText("Copy");
        cButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton4ActionPerformed(evt);
            }
        });
        add(cButton4);
        cButton4.setBounds(690, 330, 57, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (invoice.getId() != null) {
            invoice.setCustomer(selectedCustomer);
            String key = invoice.getId();
            invoice.setId(key);
            invoice.setSaveddate(new Date());
            setLineID(key);
            InventoryJournal ij = updateInventory(invoice);

            invoiceService.getDao().updateEV(invoice, ij);
            invoice = new SalesInvoice();
            invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());
            TableUtil.cleardata(cxTable1);
            TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
            return;
        }
        //find customer in the database        
        invoice.setCustomer(selectedCustomer);
        String key = es.getKey();
        invoice.setId(key);
        invoice.setSaveddate(new Date());
        setLineID(key);
        InventoryJournal ij = updateInventory(invoice);
        invoiceService.getDao().save(invoice, ij);
        invoice = new SalesInvoice();
        invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());
        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
//         *
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed

        try {
            String id = titem.getText();
            // Item item = itemService.getDao().getByPropertySR("id",id ); //get item from db

            curlineItem.setId("" + ++rownum);//set row number here 
            curlineItem.setItem(selectedItem);
            curlineItem.setQty(uiEty.tcToLong(tqty));
            curlineItem.setDescription(uiEty.tcToStr(tdescription));
            curlineItem.setLineAmount(uiEty.tcToDouble(tamount));
            curlineItem.setPrice(uiEty.tcToDouble(tprice));
        } catch (Exception e) {
            MessageBoxes.errormsg(getRootPane(), "There was an error..", "unexpected error");
            e.printStackTrace();
            return;
        }
        Object rowid = TableUtil.rowID(cxTable1);
        if (rowid == null) {
            invoice.getLineItems().add(curlineItem);
        } else {
            for (ListIterator<SalesInvoiceLineItem> it = invoice.getLineItems().listIterator(); it.hasNext();) {
                SalesInvoiceLineItem sil = it.next();
                if (rowid.equals(sil.getId())) {
                    it.set(curlineItem);
                    break;
                }
            }
        }
        addToTable(invoice.getLineItems());
        curlineItem = new SalesInvoiceLineItem();
//            cxTable1.scrollRectToVisible(cxTable1.getCellRect(cxTable1.getRowCount(), 0, true));        // TODO add your handling code here:
        titem.requestFocus();




    }//GEN-LAST:event_cButton1ActionPerformed

    private void tdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdescriptionActionPerformed
    }//GEN-LAST:event_tdescriptionActionPerformed

    private void cButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton5ActionPerformed


        invoiceService.getDao().delete(invoice.getId());
        invoice = new SalesInvoice();
        invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());

        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
        // TODO add your handling code here:
    }//GEN-LAST:event_cButton5ActionPerformed

    private void cButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton3ActionPerformed
        invoice = new SalesInvoice();
        invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());

        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});



    }//GEN-LAST:event_cButton3ActionPerformed

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed
        invoice = new SalesInvoice();
        invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());

        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});        // TODO add your handling code here:
    }//GEN-LAST:event_cButton2ActionPerformed

    private void cButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton4ActionPerformed

        invoice.setId(null);
        
        
    }//GEN-LAST:event_cButton4ActionPerformed

    public void setLineID(String key) {
        int x = 0;
        for (SalesInvoiceLineItem li : invoice.getLineItems()) {
            li.setId(key + "-" + x++);
        }
    }

    @Override
    public void setobj(Object obj) {
        invoice = (SalesInvoice) obj;
        System.out.println(invoice.getId());
        selectedCustomer = invoice.getCustomer();
        addToTable(invoice.getLineItems());
    }

    @Override
    public void updateEntityUI() {
        items = itemService.getDao().getAll();
        dialog.populateTable(items);



    }

    public void setInvoice() {
    }

    public void addToTable(List<SalesInvoiceLineItem> items) {
        TableUtil.cleardata(cxTable1);
        if (items == null || items.isEmpty()) {
            return;
        }
        for (SalesInvoiceLineItem salesInvoiceLineItem : items) {
            addToTable(salesInvoiceLineItem);
        }

        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    public void addToTable(SalesInvoiceLineItem item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getItem().getId(), item.getDescription(), item.getQty(), item.getPrice(), item.getLineAmount()
                });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CButton cButton4;
    private org.components.controls.CButton cButton5;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.components.controls.CTextField tamount;
    private org.components.controls.CTextField tdescription;
    private org.components.controls.CTextField titem;
    private org.components.controls.CTextField tprice;
    private org.components.controls.CTextField tqty;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
        return "Invoice UI";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
}
