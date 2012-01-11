
/*
 * InvoiceMasterUi.java
 *
 * Created on Dec 2, 2011, 10:27:21 AM
 */
package invoicingsystem;

import com.components.custom.PagedPopUpPanel;
import com.components.custom.TableEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.biz.app.ui.util.uiEty;
import org.biz.invoicesystem.entity.master.Customer;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.entity.transactions.SalesInvoice;
import org.biz.invoicesystem.entity.transactions.SalesInvoiceLineItem;
import org.biz.invoicesystem.service.master.CustomerService;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

/*
 * @2011/12/08 zumri -  GUI creation  of invoice
 * @2011/12/09 jawath-  creation  of invoice logic 
 * @2011/12/12 jawath-  table editing popup poanel  
 * @2011/12/15 jawath-  table editing cell ediotr
 * @2011/12/18 jawath-  table editing cell ediotr document listner
 */
public class InvoiceMasterUi extends TabPanelUI {

    SalesInvoice invoice;
    List<SalesInvoiceLineItem> lineItems;

    /** Creates new form InvoiceMasterUi */
    public InvoiceMasterUi() {
        initComponents();

        init();
    }
    TableEditor ed;

    @Override
    public void init() {
//        System.out.println("yyyyyy");


        invoice = new SalesInvoice();
        lineItems = new ArrayList<SalesInvoiceLineItem>();
        invoice.setLineItems(lineItems);
        itemService = new ItemService();
        listItem = itemService.getDao().getAll();
        ed = new TableEditor();
        TableEditor tb = new TableEditor();
        popUpComponent = new PagedPopUpPanel(tblInvoice, ed) {

            @Override
            public Object[] data(Object item) {
                Item it = (Item) item;
                return new Object[]{it.getId(), it.getCode(), it.getDescription()};
            }
        };
        tblInvoice.getColumnModel().getColumn(0).setCellEditor(tb);
        tblInvoice.getColumnModel().getColumn(1).setCellEditor(ed);
        tblInvoice.getColumnModel().getColumn(3).setCellEditor(new DoubleCellEditor());
        ComboBoxCellEditor com = new ComboBoxCellEditor();


        JComboBox jc = new JComboBox();
        jc.setEditable(true);
        jc.setModel(new DefaultComboBoxModel(new Object[]{"150", "250", "3650"}));
        jc.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("fkkkkkkkkkkk");
            }
        });
        tblInvoice.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(jc));
        tblInvoice.getColumnModel().getColumn(5).setCellEditor(new DoubleCellEditor());
        de = new DoubleCellEditor() {
            @Override
            public boolean isValide() {
                if (de.getComponent().getText().equals("2.0")) {
                    
                    
                    
                    System.out.println("  8--88--8  ");
                    return true;
                }
                return false;
            }
        };
        tblInvoice.getColumnModel().getColumn(6).setCellEditor(de);
        de.getComponent().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("action performed.........");
            }
        });
//        cxTable2.getColumnModel().getColumn(2).setCellEditor(new editor(popUpComponent, tblInvoice));
//        dialog = new ItemPopUp(cTextField1, lineItems)
        /*     KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        KeyStroke ob = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        //         tblInvoice.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),ob);
        ActionListener ac = tblInvoice.getActionForKeyStroke(ob);
        tblInvoice.registerKeyboardAction(ac,enter,JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);*/

        custService = new CustomerService();
        listCust = custService.getDao().getAll();
//                //ADD this list to popup


        cuspop = new PagedPopUpPanel(tcus) {

            @Override
            public Object[] data(Object item) {
                Customer customer = (Customer) item;
                return new Object[]{customer.getId(), customer.getCode(), customer.getCustomerName()};
            }

            @Override
            public void search(String qry) {
                //filter 
               
            }
            
            
        };

        cuspop.setObjectToTable(listCust);
        custService = new CustomerService();
        popUpComponent.setObjectToTable(listItem);
     
        

    }
    DoubleCellEditor de;
    PagedPopUpPanel cuspop;
    CustomerService custService;
    ItemService itemService;
    List<Customer> listCust;
    List<Item> listItem;
    SalesInvoiceLineItem invoiceLineItem;
    Item currentItem;

    public void lineItem() {
//        SalesInvoiceLineItem lineItem = rowToEty(SalesInvoiceLineItem lineItem);
//        Item item = new Item();
//        lineItem.setItem(item);
//        lineItem.setDescription("");
//        lineItem.setLineAmount(55.0);
//        lineItem.setPrice(Long.MIN_VALUE);
    }

    public SalesInvoiceLineItem rowToEty() {
        SalesInvoiceLineItem lineItem = new SalesInvoiceLineItem();
        Item item = new Item();
        lineItem.setItem(currentItem);
        lineItem.setDescription(uiEty.colToStrE(cxTable2, 2));
        lineItem.setPrice(uiEty.colToDbl(cxTable2, 4));
        lineItem.setLineAmount(uiEty.colToDbl(cxTable2, 5));
        return lineItem;
    }

    public boolean validateRow() {
        int r = tblInvoice.getSelectedRow();
        if (r == -1) {
            return true;
        }
        try {
            System.out.println("0000000000000000000000000000");
            SalesInvoiceLineItem lineItem = rowToEty();
            if (lineItem.getPrice() == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cPanel1 = new org.components.containers.CPanel();
        cLabel5 = new org.components.controls.CLabel();
        cLabel7 = new org.components.controls.CLabel();
        cLabel8 = new org.components.controls.CLabel();
        cLabel9 = new org.components.controls.CLabel();
        cLabel10 = new org.components.controls.CLabel();
        cTextField1 = new org.components.controls.CTextField();
        cTextField4 = new org.components.controls.CTextField();
        cTextField5 = new org.components.controls.CTextField();
        cTextField6 = new org.components.controls.CTextField();
        cTextField11 = new org.components.controls.CTextField();
        cLabel15 = new org.components.controls.CLabel();
        cComboBox1 = new org.components.controls.CComboBox();
        cLabel2 = new org.components.controls.CLabel();
        cComboBox2 = new org.components.controls.CComboBox();
        cTextField2 = new org.components.controls.CTextField();
        cPanel2 = new org.components.containers.CPanel();
        cLabel3 = new org.components.controls.CLabel();
        tcus = new org.components.controls.CTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        cTextArea2 = new org.components.controls.CTextArea();
        cCheckBox2 = new org.components.controls.CCheckBox();
        cDatePicker1 = new org.components.controls.CDatePicker();
        cPanel4 = new org.components.containers.CPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        cxTable2 = new org.components.controls.CxTable();
        cLabel4 = new org.components.controls.CLabel();
        cPanel3 = new org.components.containers.CPanel();
        cLabel6 = new org.components.controls.CLabel();
        cLabel11 = new org.components.controls.CLabel();
        cLabel12 = new org.components.controls.CLabel();
        cLabel13 = new org.components.controls.CLabel();
        cTextField9 = new org.components.controls.CTextField();
        cTextField10 = new org.components.controls.CTextField();
        cPanel5 = new org.components.containers.CPanel();
        cLabel16 = new org.components.controls.CLabel();
        cLabel17 = new org.components.controls.CLabel();
        cLabel18 = new org.components.controls.CLabel();
        cLabel19 = new org.components.controls.CLabel();
        cLabel20 = new org.components.controls.CLabel();
        cTextField12 = new org.components.controls.CTextField();
        cTextField13 = new org.components.controls.CTextField();
        cTextField14 = new org.components.controls.CTextField();
        cTextField15 = new org.components.controls.CTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoice = new org.components.controls.CxTable();

        setLayout(null);

        cPanel1.setLayout(null);

        cLabel5.setText("Salesman");
        cLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel1.add(cLabel5);
        cLabel5.setBounds(800, 70, 60, 25);

        cLabel7.setText("Total");
        cLabel7.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel1.add(cLabel7);
        cLabel7.setBounds(10, 10, 70, 20);

        cLabel8.setText("Tax");
        cLabel8.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel1.add(cLabel8);
        cLabel8.setBounds(10, 40, 70, 20);

        cLabel9.setText("Discount");
        cLabel9.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel1.add(cLabel9);
        cLabel9.setBounds(10, 60, 70, 20);

        cLabel10.setText("Final Total");
        cLabel10.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel1.add(cLabel10);
        cLabel10.setBounds(10, 90, 70, 20);

        cTextField1.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel1.add(cTextField1);
        cTextField1.setBounds(90, 90, 150, 20);

        cTextField4.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel1.add(cTextField4);
        cTextField4.setBounds(90, 10, 150, 20);

        cTextField5.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel1.add(cTextField5);
        cTextField5.setBounds(90, 40, 150, 20);

        cTextField6.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel1.add(cTextField6);
        cTextField6.setBounds(90, 60, 150, 20);

        cTextField11.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel1.add(cTextField11);
        cTextField11.setBounds(90, 120, 150, 20);

        cLabel15.setText("Recieved");
        cLabel15.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel1.add(cLabel15);
        cLabel15.setBounds(10, 120, 70, 20);

        add(cPanel1);
        cPanel1.setBounds(680, 360, 260, 160);
        add(cComboBox1);
        cComboBox1.setBounds(830, 70, 110, 23);

        cLabel2.setText("Salesman");
        cLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        add(cLabel2);
        cLabel2.setBounds(780, 70, 60, 25);

        cComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Invoice", "Quotation", "Credit Note", "Consignment Out" }));
        add(cComboBox2);
        cComboBox2.setBounds(680, 10, 150, 23);

        cTextField2.setText("Inv No manually");
        add(cTextField2);
        cTextField2.setBounds(830, 10, 110, 25);

        cPanel2.setLayout(null);

        cLabel3.setText("Customer");
        cLabel3.setFont(new java.awt.Font("Tahoma", 1, 10));
        cPanel2.add(cLabel3);
        cLabel3.setBounds(10, 0, 60, 20);
        cPanel2.add(tcus);
        tcus.setBounds(60, 0, 150, 20);

        cTextArea2.setColumns(20);
        cTextArea2.setRows(10);
        jScrollPane3.setViewportView(cTextArea2);

        cPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(10, 30, 230, 60);

        cCheckBox2.setText("Type");
        cPanel2.add(cCheckBox2);
        cCheckBox2.setBounds(10, 90, 140, 23);

        add(cPanel2);
        cPanel2.setBounds(0, 11, 240, 110);
        add(cDatePicker1);
        cDatePicker1.setBounds(830, 40, 110, 22);

        cPanel4.setLayout(null);

        cxTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "Price Range"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(cxTable2);

        cPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(10, 10, 210, 100);

        add(cPanel4);
        cPanel4.setBounds(10, 380, 230, 120);

        cLabel4.setText("Date");
        cLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        add(cLabel4);
        cLabel4.setBounds(780, 40, 60, 25);

        cPanel3.setLayout(null);

        cLabel6.setText("Salesman");
        cLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel3.add(cLabel6);
        cLabel6.setBounds(800, 70, 60, 25);

        cLabel11.setText("Last Invoice");
        cLabel11.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel3.add(cLabel11);
        cLabel11.setBounds(60, 0, 70, 20);

        cLabel12.setText("Invoice Date");
        cLabel12.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel3.add(cLabel12);
        cLabel12.setBounds(10, 20, 70, 20);

        cLabel13.setText("Invoice Total");
        cLabel13.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel3.add(cLabel13);
        cLabel13.setBounds(10, 60, 70, 20);

        cTextField9.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel3.add(cTextField9);
        cTextField9.setBounds(10, 40, 150, 20);

        cTextField10.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel3.add(cTextField10);
        cTextField10.setBounds(10, 80, 150, 20);

        add(cPanel3);
        cPanel3.setBounds(490, 10, 180, 110);

        cPanel5.setLayout(null);

        cLabel16.setText("Salesman");
        cLabel16.setFont(new java.awt.Font("Tahoma", 0, 12));
        cPanel5.add(cLabel16);
        cLabel16.setBounds(800, 70, 60, 25);

        cLabel17.setText("Credit Limit");
        cLabel17.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cLabel17);
        cLabel17.setBounds(10, 10, 70, 20);

        cLabel18.setText("Total Dues");
        cLabel18.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cLabel18);
        cLabel18.setBounds(10, 40, 70, 20);

        cLabel19.setText("PD Chqs");
        cLabel19.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cLabel19);
        cLabel19.setBounds(10, 60, 70, 20);

        cLabel20.setText("Bounced Chqs");
        cLabel20.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cLabel20);
        cLabel20.setBounds(10, 80, 70, 20);

        cTextField12.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cTextField12);
        cTextField12.setBounds(90, 80, 150, 20);

        cTextField13.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cTextField13);
        cTextField13.setBounds(90, 10, 150, 20);

        cTextField14.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cTextField14);
        cTextField14.setBounds(90, 40, 150, 20);

        cTextField15.setFont(new java.awt.Font("Tahoma", 0, 10));
        cPanel5.add(cTextField15);
        cTextField15.setBounds(90, 60, 150, 20);

        add(cPanel5);
        cPanel5.setBounds(240, 10, 250, 110);

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Item Code", "Item Description", "Qty", "Unit", "Price", "LineAmount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblInvoice.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblInvoice);
        tblInvoice.getColumnModel().getColumn(0).setResizable(false);
        tblInvoice.getColumnModel().getColumn(1).setResizable(false);
        tblInvoice.getColumnModel().getColumn(2).setResizable(false);
        tblInvoice.getColumnModel().getColumn(3).setResizable(false);
        tblInvoice.getColumnModel().getColumn(4).setResizable(false);
        tblInvoice.getColumnModel().getColumn(5).setResizable(false);
        tblInvoice.getColumnModel().getColumn(6).setResizable(false);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 930, 200);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CCheckBox cCheckBox2;
    private org.components.controls.CComboBox cComboBox1;
    private org.components.controls.CComboBox cComboBox2;
    private org.components.controls.CDatePicker cDatePicker1;
    private org.components.controls.CLabel cLabel10;
    private org.components.controls.CLabel cLabel11;
    private org.components.controls.CLabel cLabel12;
    private org.components.controls.CLabel cLabel13;
    private org.components.controls.CLabel cLabel15;
    private org.components.controls.CLabel cLabel16;
    private org.components.controls.CLabel cLabel17;
    private org.components.controls.CLabel cLabel18;
    private org.components.controls.CLabel cLabel19;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel20;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CLabel cLabel8;
    private org.components.controls.CLabel cLabel9;
    private org.components.containers.CPanel cPanel1;
    private org.components.containers.CPanel cPanel2;
    private org.components.containers.CPanel cPanel3;
    private org.components.containers.CPanel cPanel4;
    private org.components.containers.CPanel cPanel5;
    private org.components.controls.CTextArea cTextArea2;
    private org.components.controls.CTextField cTextField1;
    private org.components.controls.CTextField cTextField10;
    private org.components.controls.CTextField cTextField11;
    private org.components.controls.CTextField cTextField12;
    private org.components.controls.CTextField cTextField13;
    private org.components.controls.CTextField cTextField14;
    private org.components.controls.CTextField cTextField15;
    private org.components.controls.CTextField cTextField2;
    private org.components.controls.CTextField cTextField4;
    private org.components.controls.CTextField cTextField5;
    private org.components.controls.CTextField cTextField6;
    private org.components.controls.CTextField cTextField9;
    private org.components.controls.CxTable cxTable2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.components.controls.CxTable tblInvoice;
    private org.components.controls.CTextField tcus;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateEntityUI() {
    }

    @Override
    public String getTabName() {
        return "Invoice Master";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
    PagedPopUpPanel popUpComponent;
}
