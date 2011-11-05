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
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import org.biz.invoicesystem.master.ui.ItemPopUp;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.inventory.GRN;
import org.biz.invoicesystem.entity.inventory.GRNLine;
import org.biz.invoicesystem.entity.inventory.InventoryJournal;
import org.biz.invoicesystem.entity.inventory.InventoryJournalLine;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.master.ui.UOMPopUp;
import org.biz.invoicesystem.service.inventory.GRNService;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author Administrator
 */
public class GRNUI extends TabPanelUI {

    GRN grn;
    List<GRN> lists;
    ItemPopUp dialog;
    UOMPopUp uompopup;
    List<Item> items;
    ItemService itemService;
    GRNService service;
    GRNLine curlineItem;
    /** Creates new form InvoiceUI */
    List<GRNLine> lines;
    EntityService es;
    int rownum = 15575;
    Item selectedItem;

    /** Creates new form GrnUI */
    public GRNUI() {
        initComponents();
        init();
    }

    @Override
    public void init() {
        es = EntityService.getEntityService();
        service = new GRNService();
        itemService = new ItemService();
        grn = new GRN();
        items = new ArrayList<Item>();
        items = itemService.getDao().getAll();

        grn.setLines(new ArrayList<GRNLine>());
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
        items = new ArrayList<Item>();
        items = itemService.getDao().getAll();
        dialog = new ItemPopUp(titem, items) {

            @Override
            public void searchItem(String text, int... indice) {
                super.searchItem(text, indice);
            }

            
            @Override
            public void action() {
                selectedItem = (Item)dialog.getSelectedItem();
            }

            @Override
            public void deleteAction() {
                GRNUI.this.remove();
            }
        };
        dialog.setSecTable(cxTable1);
        
        uompopup = new UOMPopUp((JTextComponent)tuom.getEditor(), items){
        
        };


        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                if (cxTable1.getSelectedRow() > -1) {
                    Object ob = TableUtil.getSelectedValue(cxTable1, 0);
                    if (ob != null) {
                        for (GRNLine sl : grn.getLines()) {
                            if (ob.equals(sl.getId())) {
                                uiEty.objToUi(titem, sl.getItem().getId());
                                uiEty.objToUi(tqty, sl.getQty());
                                //put to uom combo box                                
                                return;
                            }
                        }
                        uiEty.objToUi(titem, "");
                        uiEty.objToUi(tqty, "");

                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cButton1 = new org.components.controls.CButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        titem = new org.components.controls.CTextField();
        cLabel1 = new org.components.controls.CLabel();
        tqty = new org.components.controls.CTextField();
        cLabel4 = new org.components.controls.CLabel();
        cLabel5 = new org.components.controls.CLabel();
        cButton2 = new org.components.controls.CButton();
        cButton3 = new org.components.controls.CButton();
        tuom = new org.components.controls.CComboBox();

        setLayout(null);

        cButton1.setText("Save");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });
        add(cButton1);
        cButton1.setBounds(306, 413, 57, 23);

        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Item", "Qty", "UOM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        cxTable1.getColumnModel().getColumn(0).setResizable(false);
        cxTable1.getColumnModel().getColumn(1).setResizable(false);
        cxTable1.getColumnModel().getColumn(2).setResizable(false);
        cxTable1.getColumnModel().getColumn(3).setResizable(false);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 124, 830, 261);
        add(titem);
        titem.setBounds(30, 90, 250, 25);

        cLabel1.setText("Item");
        add(cLabel1);
        cLabel1.setBounds(50, 60, 60, 25);
        add(tqty);
        tqty.setBounds(300, 90, 154, 25);

        cLabel4.setText("Qty");
        add(cLabel4);
        cLabel4.setBounds(330, 60, 60, 30);

        cLabel5.setText("unit");
        add(cLabel5);
        cLabel5.setBounds(500, 70, 50, 20);

        cButton2.setText("Add");
        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });
        add(cButton2);
        cButton2.setBounds(660, 90, 51, 23);

        cButton3.setText("Clear");
        cButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton3ActionPerformed(evt);
            }
        });
        add(cButton3);
        cButton3.setBounds(373, 413, 57, 23);

        tuom.setEditable(true);
        add(tuom);
        tuom.setBounds(470, 90, 90, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed

        try {
            String id = titem.getText();
            Item item = itemService.getDao().getByPropertySR("id", id); //get item from db
//            Item item = new Item();
            //item.setId(selectedItem);
            curlineItem = new GRNLine();
            curlineItem.setId("" + ++rownum);//set row number here 
            curlineItem.setItem(selectedItem);
            curlineItem.setQty(uiEty.tcToLong(tqty));
            
            
            Object rowid = TableUtil.rowID(cxTable1);
            if (rowid == null) {
                grn.getLines().add(curlineItem);
            } else {
                for (ListIterator<GRNLine> it = grn.getLines().listIterator(); it.hasNext();) {
                    GRNLine sil = it.next();
                    if (rowid.equals(sil.getId())) {
                        it.set(curlineItem);
                        break;
                    }
                }
            }
            addToTable(grn.getLines());
            curlineItem = new GRNLine();

            titem.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cButton2ActionPerformed

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed

        grn.setId(es.getKey());
        InventoryJournal ij=updateInventory(grn);
        ij.setId(es.getKey());
        service.getDao().save(grn);
        grn = new GRN();
        grn.setLines(new ArrayList<GRNLine>());
        TableUtil.cleardata(cxTable1);
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }//GEN-LAST:event_cButton1ActionPerformed

    public InventoryJournal updateInventory(GRN grn){
        InventoryJournal ij= new InventoryJournal();
        ij.setLines(new ArrayList<InventoryJournalLine>());
        
        for (GRNLine gl : grn.getLines()) {
        InventoryJournalLine ijl = new InventoryJournalLine();
        ijl.setDescription(gl.getDescription());    
        ijl.setItem(gl.getItem());    
        ijl.setQty(gl.getQty());    // + becas we add to inventory
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


    private void cButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton3ActionPerformed

        grn = new GRN();
        grn.setLines(new ArrayList<GRNLine>());
        TableUtil.cleardata(cxTable1);
                TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});


    }//GEN-LAST:event_cButton3ActionPerformed
    private void remove() {
        Object rowid = TableUtil.rowID(cxTable1);
        if (rowid != null) {
            //new row new
            for (Iterator<GRNLine> it = grn.getLines().iterator(); it.hasNext();) {
                GRNLine si = it.next();
                if (si.getId().equals(rowid)) {
                    it.remove();
                    break;
                }
            }
            addToTable(grn.getLines());
        }

    }

    public void addToTable(List<GRNLine> items) {
        TableUtil.cleardata(cxTable1);
        if (items == null || items.isEmpty()) {
            return;
        }
        for (GRNLine salesInvoiceLineItem : items) {
            addToTable(salesInvoiceLineItem);
        }

        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    public void addToTable(GRNLine item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getItem().getCode(), item.getQty() 
                });
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
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.components.controls.CTextField titem;
    private org.components.controls.CTextField tqty;
    private org.components.controls.CComboBox tuom;
    // End of variables declaration//GEN-END:variables
}
