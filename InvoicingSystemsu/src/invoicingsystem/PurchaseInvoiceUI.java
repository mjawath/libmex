/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.biz.invoicesystem.master.ui.ItemPopUp;
import org.biz.invoicesystem.master.ui.SupplierPopUp;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.inventory.InventoryJournal;
import org.biz.invoicesystem.entity.inventory.InventoryJournalLine;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.entity.transactions.PurchaseInvoice;
import org.biz.invoicesystem.entity.transactions.PurchaseInvoiceLineItem;
import org.biz.invoicesystem.entity.master.Supplier;
import org.biz.invoicesystem.service.master.ItemService;
import org.biz.invoicesystem.service.transactions.PurchaseInvoiceService;
import org.biz.invoicesystem.service.master.SupplierService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author mjawath
 */
public class PurchaseInvoiceUI extends TabPanelUI {

//
    SupplierService cs;
    List<Supplier> customers;
    ItemService itemService;
    PurchaseInvoice invoice;
    PurchaseInvoiceService invoiceService;
    List<Item> items;
    /** Creates new form InvoiceUI */
    ItemPopUp dialog;
    SupplierPopUp cusdialog;
    Item selectedItem;
    PurchaseInvoiceLineItem curlineItem;
    EntityService es;
    int rownum = 15575;

    public PurchaseInvoiceUI() {

        initComponents();
        curlineItem = new PurchaseInvoiceLineItem();
//                   dialog.setUndecorated(true);
        titem.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

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
        cs = new SupplierService();
        es = EntityService.getEntityService();
        itemService = new ItemService();
        invoiceService = new PurchaseInvoiceService();
        invoice = new PurchaseInvoice();
        invoice.setLineItems(new ArrayList<PurchaseInvoiceLineItem>());
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
                PurchaseInvoiceUI.this.remove();
            }
        };
        dialog.setSecTable(cxTable1);
        customers = cs.getDao().getAll();
        System.out.println(customers.size());
        cusdialog = new SupplierPopUp(tsupp, customers);


        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                if (cxTable1.getSelectedRow() > -1) {
                    Object ob = TableUtil.getSelectedValue(cxTable1, 0);
                    if (ob != null) {
                        for (PurchaseInvoiceLineItem sl : invoice.getLineItems()) {
                            if (ob.equals(sl.getId())) {

                                uiEty.objToUi(titem, sl.getItem().getId());
                                uiEty.objToUi(tqty, sl.getQty());
                                uiEty.objToUi(tamount, sl.getLineAmount());
                                uiEty.objToUi(tprice, sl.getPrice());
                                uiEty.objToUi(tdescription, sl.getDescription());

                            }
                        }
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
            for (Iterator<PurchaseInvoiceLineItem> it = invoice.getLineItems().iterator(); it.hasNext();) {
                PurchaseInvoiceLineItem si = it.next();
                if (si.getId().equals(rowid)) {
                    it.remove();
                    break;
                }
            }
            addToTable(invoice.getLineItems());
        }

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
        tsupp = new org.components.controls.CTextField();
        cLabel1 = new org.components.controls.CLabel();
        cLabel2 = new org.components.controls.CLabel();
        tqty = new org.components.controls.CTextField();
        tamount = new org.components.controls.CTextField();
        tprice = new org.components.controls.CTextField();
        cLabel3 = new org.components.controls.CLabel();
        cLabel4 = new org.components.controls.CLabel();
        cLabel6 = new org.components.controls.CLabel();
        cLabel7 = new org.components.controls.CLabel();

        setLayout(null);
        add(titem);
        titem.setBounds(50, 90, 154, 25);
        add(tdescription);
        tdescription.setBounds(220, 90, 173, 25);

        cButton1.setText("Add");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });
        add(cButton1);
        cButton1.setBounds(850, 90, 51, 23);

        cxTable1.setForeground(new java.awt.Color(0, 0, 255));
        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Item", "Description", "Qty", "Unit", "Price", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane1.setBounds(40, 140, 1050, 260);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(310, 420, 57, 23);
        add(tsupp);
        tsupp.setBounds(50, 40, 154, 25);

        cLabel1.setText("Item");
        add(cLabel1);
        cLabel1.setBounds(80, 70, 50, 20);

        cLabel2.setText("Supplier :");
        add(cLabel2);
        cLabel2.setBounds(70, 10, 79, 20);
        add(tqty);
        tqty.setBounds(400, 90, 154, 25);
        add(tamount);
        tamount.setBounds(670, 90, 173, 25);
        add(tprice);
        tprice.setBounds(570, 90, 70, 25);

        cLabel3.setText("Desc");
        add(cLabel3);
        cLabel3.setBounds(230, 70, 104, 20);

        cLabel4.setText("Qty");
        add(cLabel4);
        cLabel4.setBounds(410, 65, 50, 20);

        cLabel6.setText("price");
        add(cLabel6);
        cLabel6.setBounds(570, 70, 50, 20);

        cLabel7.setText("amount");
        add(cLabel7);
        cLabel7.setBounds(700, 70, 104, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String key = es.getKey();
        invoice.setId(key);
        setLineID(key);
        InventoryJournal ij = updateInventory(invoice);
        invoiceService.getDao().save(invoice, ij);
        invoice = new PurchaseInvoice();
        invoice.setLineItems(new ArrayList<PurchaseInvoiceLineItem>());
        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
        //invoiceService.getDao().save(invoice);
        //invoice = new PurchaseInvoice();

    }//GEN-LAST:event_jButton1ActionPerformed
    public void setLineID(String key) {
        int x = 0;
        for (PurchaseInvoiceLineItem li : invoice.getLineItems()) {
            li.setId(key + "-" + x++);
        }
    }

    public InventoryJournal updateInventory(PurchaseInvoice pi) {
        InventoryJournal ij = new InventoryJournal();
        String key = es.getKey();
        ij.setId(key);
        ij.setLines(new ArrayList<InventoryJournalLine>());
        int x = 0;
        for (PurchaseInvoiceLineItem gl : pi.getLineItems()) {
            InventoryJournalLine ijl = new InventoryJournalLine();
            ijl.setDescription(gl.getDescription());
            ijl.setItem(gl.getItem());
            ijl.setQty(gl.getQty());    // + becas we add to inventory
            ijl.setUom(gl.getUom());
            ij.getLines().add(ijl);
            ijl.setId(key + "-" + x++);
        }

        return ij;
    }
    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed

        try {
            String id = titem.getText();
            // Item item = itemService.getDao().getByPropertySR("id",id ); //get item from db
            Item item = new Item();
            item.setId(id);
            curlineItem.setId("" + ++rownum);//set row number here 
            curlineItem.setItem(selectedItem);
            curlineItem.setQty(uiEty.tcToLong(tqty));
            curlineItem.setDescription(uiEty.tcToStr(tdescription));
            curlineItem.setLineAmount(uiEty.tcToDouble(tamount));
            curlineItem.setPrice(uiEty.tcToDouble(tprice));

            Object rowid = TableUtil.rowID(cxTable1);
            if (rowid == null) {
                invoice.getLineItems().add(curlineItem);
            } else {
                for (ListIterator<PurchaseInvoiceLineItem> it = invoice.getLineItems().listIterator(); it.hasNext();) {
                    PurchaseInvoiceLineItem sil = it.next();
                    if (rowid.equals(sil.getId())) {
                        it.set(curlineItem);
                        break;
                    }
                }
            }
            addToTable(invoice.getLineItems());
            curlineItem = new PurchaseInvoiceLineItem();

            titem.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_cButton1ActionPerformed

    public void addToTable(List<PurchaseInvoiceLineItem> items) {
        TableUtil.cleardata(cxTable1);
        if (items == null || items.isEmpty()) {
            return;
        }
        for (PurchaseInvoiceLineItem salesInvoiceLineItem : items) {
            addToTable(salesInvoiceLineItem);
        }

        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    public void addToTable(PurchaseInvoiceLineItem item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getItem().getName(), item.getDescription(), item.getQty(), item.getPrice(), item.getLineAmount()
                });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel2;
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
    private org.components.controls.CTextField tsupp;
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
