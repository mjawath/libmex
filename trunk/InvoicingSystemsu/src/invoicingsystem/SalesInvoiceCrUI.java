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
import org.biz.invoicesystem.master.ui.CustomerPopUp;
import org.biz.invoicesystem.master.ui.ItemPopUp;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
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
public class SalesInvoiceCrUI extends TabPanelUI {

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

    public SalesInvoiceCrUI() {

        initComponents();
        curlineItem = new SalesInvoiceLineItem();
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
            }

            @Override
            public void deleteAction() {
                SalesInvoiceCrUI.this.remove();
            }
        };
        dialog.setSecTable(cxTable1);
        customers = cs.getDao().getAll();
        System.out.println(customers.size());
        cusdialog = new CustomerPopUp(tcustomer, customers);


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
//                                uiEty.objToUi(tunit, sl.getUom().getSimbol());
                                //put to uom combo box
                                uiEty.objToUi(tdescription, sl.getDescription());
                     

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titem = new org.components.controls.CTextField();
        tdescription = new org.components.controls.CTextField();
        cButton1 = new org.components.controls.CButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        jButton1 = new javax.swing.JButton();
        tcustomer = new org.components.controls.CTextField();
        cLabel1 = new org.components.controls.CLabel();
        cLabel2 = new org.components.controls.CLabel();
        tqty = new org.components.controls.CTextField();
        tamount = new org.components.controls.CTextField();
        tprice = new org.components.controls.CTextField();
        cLabel3 = new org.components.controls.CLabel();
        cLabel4 = new org.components.controls.CLabel();
        cLabel5 = new org.components.controls.CLabel();
        cLabel6 = new org.components.controls.CLabel();
        cLabel7 = new org.components.controls.CLabel();
        cTextField1 = new org.components.controls.CTextField();
        cLabel8 = new org.components.controls.CLabel();

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
        cButton1.setBounds(920, 90, 51, 23);

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
        jScrollPane1.setBounds(10, 136, 1155, 350);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(400, 40, 57, 23);
        add(tcustomer);
        tcustomer.setBounds(70, 40, 154, 25);

        cLabel1.setText("Item");
        add(cLabel1);
        cLabel1.setBounds(80, 70, 38, 25);

        cLabel2.setText("Customer :");
        add(cLabel2);
        cLabel2.setBounds(93, 11, 79, 25);
        add(tqty);
        tqty.setBounds(400, 90, 154, 25);
        add(tamount);
        tamount.setBounds(740, 90, 173, 25);
        add(tprice);
        tprice.setBounds(650, 90, 70, 25);

        cLabel3.setText("Desc");
        add(cLabel3);
        cLabel3.setBounds(230, 70, 104, 20);

        cLabel4.setText("Qty");
        add(cLabel4);
        cLabel4.setBounds(410, 65, 40, 20);

        cLabel5.setText("unit");
        add(cLabel5);
        cLabel5.setBounds(570, 60, 50, 25);

        cLabel6.setText("price");
        add(cLabel6);
        cLabel6.setBounds(650, 60, 50, 25);

        cLabel7.setText("amount");
        add(cLabel7);
        cLabel7.setBounds(740, 65, 104, 20);
        add(cTextField1);
        cTextField1.setBounds(570, 90, 60, 25);

        cLabel8.setText("address");
        add(cLabel8);
        cLabel8.setBounds(210, 10, 104, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String key = es.getKey();
        invoice.setId(key);
        invoiceService.getDao().save(invoice);
        invoice = new SalesInvoice();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed

        try {
            String id = titem.getText();
            // Item item = itemService.getDao().getByPropertySR("id",id ); //get item from db
            Item item = new Item();
            item.setId(id);
            curlineItem.setId("" + ++rownum);//set row number here 
            curlineItem.setItem(item);
            curlineItem.setQty(uiEty.tcToLong(tqty));
            curlineItem.setDescription(uiEty.tcToStr(tdescription));
            curlineItem.setLineAmount(uiEty.tcToDouble(tamount));
            curlineItem.setPrice(uiEty.tcToDouble(tprice));



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

            titem.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_cButton1ActionPerformed

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
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CLabel cLabel8;
    private org.components.controls.CTextField cTextField1;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.components.controls.CTextField tamount;
    private org.components.controls.CTextField tcustomer;
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
