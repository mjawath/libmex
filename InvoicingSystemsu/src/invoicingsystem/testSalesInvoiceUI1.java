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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
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
import org.biz.invoicesystem.entity.master.UOM;
import org.biz.invoicesystem.service.master.CustomerService;
import org.biz.invoicesystem.service.transactions.SalesInvoiceService;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;
import org.dao.util.JPAUtil;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 *
 * @author mjawath
 */
public class testSalesInvoiceUI1 extends TabPanelUI {

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

    public testSalesInvoiceUI1() {

        initComponents();
        curlineItem = new SalesInvoiceLineItem();
//                   dialog.setUndecorated(true);
        titem.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        cxTable1.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("-----------gained");
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("----------lost");
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
        tdescription.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                new SwingWorker(){

                    @Override
                    protected Object doInBackground() throws Exception {
                    long t1 = System.currentTimeMillis();
                        // task is a Runnable which encapsulates the unit of work
                        List<SalesInvoice> invoices = new ArrayList<SalesInvoice>();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date date = null;
                        try {
                            date = format.parse("2011-06-21 20:12:33");
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        Date date2 = null;
                        try {
                            date2 = format.parse("2011-06-21 20:17:04");
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }

                        EntityManager em = JPAUtil.getEntityManager();
                        Query query = em.createQuery("select c from SalesInvoice c where c.saveddate "
                                + "between ?1 and ?2");
                        query.setParameter(1, date, TemporalType.TIMESTAMP);
                        query.setParameter(2, date2, TemporalType.TIMESTAMP);
                       query.setHint(QueryHints.REFRESH, HintValues.TRUE);
                        invoices = query.getResultList();

               //        Query query = em.createQuery("select c from SalesInvoice c where c.customer.name like '%"+tdescription.getText()+"%'"
                 //                 +"");
                           // Query query = em.createQuery("select c from SalesInvoice c ");
                           // Query query = em.createNativeQuery("select * from SalesInvoice  ",SalesInvoice.class);

                           invoices = query.getResultList();
                        long t2 = System.currentTimeMillis();
                        int x = 0;
                        double d = (t2 - t1);
                        d = d / 1000;
                        System.out.println("My task took " + d + " seconds to execute. " + invoices.size());
                        em.clear();
                        em.close();
                        return invoices;
                    }

                    @Override
                    protected void done() {
                        try {
                             long t1 = System.currentTimeMillis();
                            List<SalesInvoice> invoices = (List<SalesInvoice>) get();
                                  System.out.println("My task took " + "" + " seconds to execute. " + invoices.size());
                                  addToTablex(invoices);
                                   long t2 = System.currentTimeMillis();
                        int x = 0;
                        double d = (t2 - t1);
                        d = d / 1000;
                        System.out.println("My task took " + d + " seconds to execute. " + invoices.size());
                        } catch (InterruptedException ex) {
                           ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }


                    }


                }.execute();
                System.gc();
               /* long t1 = System.currentTimeMillis();
                int x=0;
                for (int i = 0; i < 15000; i++) {
                        x+=i;
                                    System.out.println("x "+x);
                                    if (x>200 ) {

                        System.out.println("x somauch vorry   "+x+250);
                    }
                }
                System.out.println("x "+x);
                      long t2 = System.currentTimeMillis();

                        double d = (t2 - t1);
                        d = d / 1000;
                        System.out.println("My task took " + d + " seconds to execute. " );
*/
            }
        });
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
        
        Item item = new Item();
        double d = Math.random();
        Integer intd = (int) Math.round(d * 10);
        String key = es.getKey();

        item.setId(key);
        item.setCode(key+d);
        item.setDescription(es.getKeyStr());
        item.setName(es.getKeyStr());
        


        dialog.setSecTable(cxTable1);
        customers = cs.getDao().getAll();
        System.out.println(customers.size());

        cusdialog = new CustomerPopUp(tcustomer, customers) {

            @Override
            public void action() {
                selectedCustomer =(Customer) cusdialog.getSelectedItem();
            }
        };


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
        jScrollPane2 = new javax.swing.JScrollPane();
        cxTable2 = new org.components.controls.CxTable();

        setLayout(null);
        add(titem);
        titem.setBounds(50, 180, 154, 25);

        tdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdescriptionActionPerformed(evt);
            }
        });
        add(tdescription);
        tdescription.setBounds(220, 180, 173, 25);

        cButton1.setText("Add");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });
        add(cButton1);
        cButton1.setBounds(920, 180, 51, 23);

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
        jScrollPane1.setBounds(10, 220, 950, 40);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(430, 30, 57, 23);
        add(tcustomer);
        tcustomer.setBounds(50, 130, 154, 25);

        cLabel1.setText("Item");
        add(cLabel1);
        cLabel1.setBounds(80, 160, 38, 25);

        cLabel2.setText("Customer :");
        add(cLabel2);
        cLabel2.setBounds(70, 100, 90, 20);
        add(tqty);
        tqty.setBounds(400, 180, 154, 25);
        add(tamount);
        tamount.setBounds(740, 180, 173, 25);
        add(tprice);
        tprice.setBounds(650, 180, 70, 25);

        cLabel3.setText("Desc");
        add(cLabel3);
        cLabel3.setBounds(230, 160, 104, 20);

        cLabel4.setText("Qty");
        add(cLabel4);
        cLabel4.setBounds(410, 150, 40, 20);

        cLabel5.setText("unit");
        add(cLabel5);
        cLabel5.setBounds(570, 150, 50, 25);

        cLabel6.setText("price");
        add(cLabel6);
        cLabel6.setBounds(650, 150, 50, 25);

        cLabel7.setText("amount");
        add(cLabel7);
        cLabel7.setBounds(740, 150, 104, 20);

        cxTable2.setForeground(new java.awt.Color(0, 0, 255));
        cxTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        cxTable2.setSelectionBackground(new java.awt.Color(246, 201, 122));
        cxTable2.setSelectionForeground(new java.awt.Color(153, 0, 0));
        cxTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(cxTable2);

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 270, 950, 310);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*

        //find customer in the database
        
        
        invoice.setCustomer(selectedCustomer);
        String key = es.getKey();
        invoice.setId(key);
        setLineID(key);
        invoiceService.getDao().save(invoice);
        invoice = new SalesInvoice();
        invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());
        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
         *
         */
        long t1 = System.currentTimeMillis();
        // task is a Runnable which encapsulates the unit of work
        List<SalesInvoice> invoices = new ArrayList<SalesInvoice>();
        /*
        for (int i = 1; i < 15000; i++) {
        try {
        double d = Math.random();
        Integer intd = (int) Math.round(d * 10);
        String key = es.getKey();
        SalesInvoice invoice = new SalesInvoice();

        System.out.println("key " + key);
        invoice.setEditeddate(new Date());
        invoice.setSaveddate(new Date());
        Customer customer = new Customer();
        customer.setId(intd + "");
        invoice.setLineItems(new ArrayList<SalesInvoiceLineItem>());
        invoice.setCustomer(customer);
        for (int i2 = 0; i2 < 6; i2++) {
        SalesInvoiceLineItem invoiceLineItem = new SalesInvoiceLineItem();
        invoiceLineItem.setDescription(key);
        invoiceLineItem.setId(key + i2);
        Item item = new Item();
        item.setId(intd + "");
        invoiceLineItem.setItem(item);
        invoiceLineItem.setLineAmount(d);
        invoiceLineItem.setPrice(d);
        invoiceLineItem.setQty((long) intd);
        invoice.getLineItems().add(invoiceLineItem);
        }
        Thread.sleep(10);
        invoices.add(invoice);
        int x = i % 1000;
        if (x == 0) {
        invoiceService.getDao().saveList(invoices);
        System.out.println("saved " + i);
        invoices.clear();
        }
        } catch (InterruptedException ex) {
        ex.printStackTrace();
        }

        }
        long t2 = System.currentTimeMillis();
        System.out.println("My task took " + ((double) (t2 - t1) / 1000) + " seconds to execute.");*/

//        for (SalesInvoice salesInvoice : invoices) {
//            System.out.println(x++  + "--" +salesInvoice.getId());
//        }
//
//
//        long t3 = System.currentTimeMillis();
//        System.out.println( "count --"+x + " "+((double) (t3 - t2) / 1000) + " seconds to execute.");
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

            UOM uom = selectedItem.getUnitOne();
            curlineItem.setUom(uom);

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

    private void tdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdescriptionActionPerformed

    }//GEN-LAST:event_tdescriptionActionPerformed

    public void setLineID(String key) {
        int x = 0;
        for (SalesInvoiceLineItem li : invoice.getLineItems()) {
            li.setId(key + "-" + x++);
        }
    }
    public void addToTablex(List<SalesInvoice> tt) {
        TableUtil.cleardata(cxTable2);
        if (tt == null || tt.isEmpty()) {
          
            return;
        }
        for (SalesInvoice salesInvoice : tt) {
            addToTable(salesInvoice);
        }


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
    public void addToTable(SalesInvoice item) {
        TableUtil.addrow(cxTable2, new Object[]{item.getId(), item.getEditeddate()});

    }
    public void addToTable(SalesInvoiceLineItem item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getItem().getId(), item.getDescription(), item.getQty(), item.getUom().getSimbol(), item.getPrice(), item.getLineAmount()
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
    private org.components.controls.CxTable cxTable1;
    private org.components.controls.CxTable cxTable2;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
