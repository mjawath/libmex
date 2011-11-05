/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GrnUI.java
 *
 * Created on May 28, 2011, 5:58:04 AM
 */
package invoicingsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.EntityManager;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.biz.invoicesystem.master.ui.ItemPopUp;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.inventory.GDN;
import org.biz.invoicesystem.entity.inventory.GDNLine;
import org.biz.invoicesystem.entity.inventory.GRN;
import org.biz.invoicesystem.entity.inventory.GRNLine;
import org.biz.invoicesystem.entity.inventory.InventoryJournal;
import org.biz.invoicesystem.entity.inventory.InventoryJournalLine;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.service.inventory.GDNService;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;
import org.dao.util.JPAUtil;

/**
 *
 * @author Administrator
 */
public class GDNUI extends TabPanelUI {

    GDN gdn;
    List<Item> items;
    ItemService itemService;
    GDNService gdnService;
    EntityService es;
    ItemPopUp dialog;
    Item selectedItem;
    GDNLine curlineItem;
  int rownum = 15575;
    /** Creates new form GrnUI */
    public GDNUI() {
        initComponents();
        init();
    }

    @Override
    public void init() {
        itemService = new ItemService();
        gdnService = new GDNService();
        items = itemService.getDao().getAll();
        es = EntityService.getEntityService();
        itemService = new ItemService();
        gdn = new GDN();
        items = new ArrayList<Item>();
        items = itemService.getDao().getAll();




        gdn.setLines(new ArrayList<GDNLine>());
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
        
   
        dialog = new ItemPopUp(titem, items) {

            @Override
            public void action() {
                selectedItem = dialog.getSelectedItem();


            }

            @Override
            public void deleteAction() {
                GDNUI.this.remove();
            }
        };
        dialog.setSecTable(cxTable1);





        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                if (cxTable1.getSelectedRow() > -1) {
                    Object ob = TableUtil.getSelectedValue(cxTable1, 0);
                    if (ob != null) {
                        for (GDNLine sl : gdn.getLines()) {
                            if (ob.equals(sl.getId())) {

                                uiEty.objToUi(titem, sl.getItem().getId());
                                uiEty.objToUi(tqty, sl.getQty());
//                                uiEty.objToUi(tunit, sl.getUom().getSimbol());
                                return;
                            }
                        }
                        uiEty.objToUi(titem, "");
                        uiEty.objToUi(tqty, "");
                        uiEty.objToUi(tunit, "");

                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titem = new org.components.controls.CTextField();
        cLabel1 = new org.components.controls.CLabel();
        tqty = new org.components.controls.CTextField();
        cLabel4 = new org.components.controls.CLabel();
        tunit = new org.components.controls.CLabel();
        cButton1 = new org.components.controls.CButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        cButton3 = new org.components.controls.CButton();
        cButton2 = new org.components.controls.CButton();
        cLabel6 = new org.components.controls.CLabel();
        cLabel7 = new org.components.controls.CLabel();

        setLayout(null);
        add(titem);
        titem.setBounds(10, 41, 160, 25);

        cLabel1.setText("Item");
        add(cLabel1);
        cLabel1.setBounds(38, 16, 38, 25);
        add(tqty);
        tqty.setBounds(270, 40, 154, 25);

        cLabel4.setText("Qty");
        add(cLabel4);
        cLabel4.setBounds(280, 20, 40, 20);

        tunit.setBackground(new java.awt.Color(204, 255, 204));
        tunit.setText("");
        tunit.setOpaque(true);
        add(tunit);
        tunit.setBounds(450, 40, 80, 25);

        cButton1.setText("Add");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });
        add(cButton1);
        cButton1.setBounds(540, 40, 51, 23);

        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Item", "Descrption", "Qty", "UOM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cxTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(cxTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 77, 830, 261);

        cButton3.setText("Clear");
        cButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton3ActionPerformed(evt);
            }
        });
        add(cButton3);
        cButton3.setBounds(357, 349, 57, 23);

        cButton2.setText("Save");
        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });
        add(cButton2);
        cButton2.setBounds(290, 349, 57, 23);

        cLabel6.setText("");
        add(cLabel6);
        cLabel6.setBounds(180, 40, 80, 30);

        cLabel7.setText("unit");
        add(cLabel7);
        cLabel7.setBounds(450, 20, 80, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed

        try {
            String id = titem.getText();
            Item item = itemService.getDao().getByPropertySR("id", id); //get item from db
//            Item item = new Item();
            //item.setId(selectedItem);
            curlineItem = new GDNLine();
            curlineItem.setId("" + ++rownum);//set row number here
            curlineItem.setItem(selectedItem);
            
            curlineItem.setQty(uiEty.tcToLong(tqty));

            Object rowid = TableUtil.rowID(cxTable1);
            if (rowid == null) {
                gdn.getLines().add(curlineItem);
            } else {
                for (ListIterator<GDNLine> it = gdn.getLines().listIterator(); it.hasNext();) {
                    GDNLine sil = it.next();
                    if (rowid.equals(sil.getId())) {
                        it.set(curlineItem);
                        break;
                    }
                }
            }
            addToTable(gdn.getLines());
            curlineItem = new GDNLine();

            titem.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
       

    }//GEN-LAST:event_cButton1ActionPerformed

    private void cButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton3ActionPerformed

        gdn = new GDN();
        gdn.setLines(new ArrayList<GDNLine>());
        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }//GEN-LAST:event_cButton3ActionPerformed

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed

        gdn.setId(es.getKey());
        gdnService.getDao().save(gdn);
        gdn = new GDN();
        gdn.setLines(new ArrayList<GDNLine>());
        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
}//GEN-LAST:event_cButton2ActionPerformed


    public InventoryJournal updateInventory(GRN grn){
        InventoryJournal ij= new InventoryJournal();
        ij.setLines(new ArrayList<InventoryJournalLine>());

        for (GRNLine gl : grn.getLines()) {
        InventoryJournalLine ijl = new InventoryJournalLine();
        ijl.setDescription(gl.getDescription());
        ijl.setItem(gl.getItem());
        ijl.setQty(-gl.getQty());    // - becas we add to inventory
        ijl.setUom(gl.getUom());
        ij.getLines().add(ijl);
        }
        return  ij;
    }

    
    private void updateInventorySummery(Date date1){
    //get all  InventoryJournal InventoryJournalLine for running month
      // get the last month InventoryMonthlySummery
        //sum the  totel item and put that to hashmap of item/uom/-----InventoryMonthlySummery

    }


    private void remove() {
        Object rowid = TableUtil.rowID(cxTable1);
        if (rowid != null) {
            //new row new
            for (Iterator<GDNLine> it = gdn.getLines().iterator(); it.hasNext();) {
                GDNLine si = it.next();
                if (si.getId().equals(rowid)) {
                    it.remove();
                    break;
                }
            }
            addToTable(gdn.getLines());
        }

    }

    public void addToTable(List<GDNLine> items) {
        TableUtil.cleardata(cxTable1);
        if (items == null || items.isEmpty()) {
            return;
        }
        for (GDNLine salesInvoiceLineItem : items) {
            addToTable(salesInvoiceLineItem);
        }

        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    public void addToTable(GDNLine item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getItem().getId(), item.getDescription(), item.getQty(),  item.getPrice(), item.getLineAmount()
                });
    }
    public static void main(String[] args) {

        EntityManager em= JPAUtil.getEntityManager();
em.getTransaction().begin();
em.persist(new GDN());
em.getTransaction().commit();

    }

    @Override
    public String getTabName() {
        return " GRN ";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.components.controls.CTextField titem;
    private org.components.controls.CTextField tqty;
    private org.components.controls.CLabel tunit;
    // End of variables declaration//GEN-END:variables
}
