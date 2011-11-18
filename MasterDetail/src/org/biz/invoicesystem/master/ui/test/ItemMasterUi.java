/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ItemMaster.java
 *
 * Created on Nov 17, 2011, 8:06:21 PM
 */
package org.biz.invoicesystem.master.ui.test;

import java.util.List;
import javax.swing.JPanel;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.master.ui.ItemPopUp;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author jawath
 * @author zumri(18/11/2011 )
 */
public class ItemMasterUi extends TabPanelUI {

    
    List<Item> items;
    ItemService itemService;
    EntityService es;
    ItemPopUp ipu;
    Item selectedItem;
    /** Creates new form ItemMaster */
    public ItemMasterUi() {
        
        initComponents();
        
        init();
    }

    @Override
    public void init() {
        es = EntityService.getEntityService();
        itemService = new ItemService();
        items = itemService.getDao().getAll();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cTextField15 = new org.components.controls.CTextField();
        cTextField16 = new org.components.controls.CTextField();
        cTextField17 = new org.components.controls.CTextField();
        cComboBox2 = new org.components.controls.CComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cTextField1 = new org.components.controls.CTextField();
        cTextField2 = new org.components.controls.CTextField();
        cComboBox1 = new org.components.controls.CComboBox();
        tdesc = new org.components.controls.CTextField();
        tcode = new org.components.controls.CTextField();
        cTextField5 = new org.components.controls.CTextField();
        cTextField6 = new org.components.controls.CTextField();
        cTextField7 = new org.components.controls.CTextField();
        cTextField8 = new org.components.controls.CTextField();
        cTextField9 = new org.components.controls.CTextField();
        cTextField10 = new org.components.controls.CTextField();
        cTextField11 = new org.components.controls.CTextField();
        cTextField12 = new org.components.controls.CTextField();
        cTextField13 = new org.components.controls.CTextField();
        cTextField14 = new org.components.controls.CTextField();
        cComboBox3 = new org.components.controls.CComboBox();
        cComboBox4 = new org.components.controls.CComboBox();
        cTextField18 = new org.components.controls.CTextField();
        cComboBox5 = new org.components.controls.CComboBox();
        cButton1 = new org.components.controls.CButton();
        cButton2 = new org.components.controls.CButton();
        cButton3 = new org.components.controls.CButton();
        cButton4 = new org.components.controls.CButton();
        cButton5 = new org.components.controls.CButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Item Code");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 20));

        jLabel2.setText("Description ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 20));

        jLabel4.setText("Category");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, -1));

        jLabel3.setText("Carton ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel5.setText("Sales Price");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 20));

        jLabel6.setText("Unit");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 20));

        jPanel1.setLayout(null);

        jLabel7.setText("Whole Sale  Price");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 15, 82, 20);

        jLabel8.setText("Retail Price");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 42, 82, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 99, 250, 80);
        jPanel1.add(cTextField15);
        cTextField15.setBounds(176, 11, 80, 25);
        jPanel1.add(cTextField16);
        cTextField16.setBounds(180, 70, 80, 25);
        jPanel1.add(cTextField17);
        cTextField17.setBounds(180, 40, 80, 25);
        jPanel1.add(cComboBox2);
        cComboBox2.setBounds(10, 70, 130, 23);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 270, 190));

        jLabel9.setText("Min.Price");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, 20));

        jLabel10.setText("%");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 20, 20));

        jLabel11.setText("Cost Price");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 20));

        jLabel12.setText("Discount ");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 20));

        jLabel13.setText("$");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 10, 20));

        jLabel14.setText("Val");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 20, 20));

        jLabel15.setText("Location");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 60, 20));

        jLabel16.setText("Commission");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 60, 20));

        jLabel17.setText("Min.Stock");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 60, 20));

        jLabel18.setText("Image");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 60, 20));

        jLabel20.setText("Image");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel20)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel20)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, 110));

        jLabel19.setText("Re Order");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 60, 20));
        add(cTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 210, -1));
        add(cTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 140, -1));
        add(cComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, -1));
        add(tdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 210, -1));
        add(tcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 210, -1));
        add(cTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, -1));
        add(cTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 90, -1));
        add(cTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 90, -1));
        add(cTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 90, -1));
        add(cTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 90, -1));
        add(cTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 90, -1));
        add(cTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 90, -1));
        add(cTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 90, 20));
        add(cTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 210, -1));
        add(cTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 210, -1));
        add(cComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 210, -1));
        add(cComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 210, -1));
        add(cTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 30, -1));
        add(cComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 70, -1));

        cButton1.setText("Close");
        add(cButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, -1, -1));
        add(cButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, -1));

        cButton3.setText("Save");
        cButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton3ActionPerformed(evt);
            }
        });
        add(cButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, -1, -1));

        cButton4.setText("Clear");
        add(cButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));

        cButton5.setText("Delete");
        add(cButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, -1, -1));

        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Item Code", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cxTable1);
        cxTable1.getColumnModel().getColumn(0).setResizable(false);
        cxTable1.getColumnModel().getColumn(2).setResizable(false);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 340, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton3ActionPerformed

              if (selectedItem != null) {
            Item item = itemService.getDao().deatach(selectedItem, selectedItem.getId());
            uiToEty(item);
//            item.setProduct(selectedProd);
            itemService.getDao().update(item);
            items = itemService.getDao().getAll();
            addToTable(items);
            return;
        }

        Item item = new Item();
        item.setId(es.getKey());
        uiToEty(item);
//        item.setProduct(selectedProd);
        itemService.getDao().save(item);
        items = itemService.getDao().getAll();
        addToTable(items);
        ipu.populateTable(items);
        
        
    }//GEN-LAST:event_cButton3ActionPerformed

    
        public void uiToEty(Item item) {
//        item.setName(uiEty.tcToStr(tdesc));
        item.setCode(uiEty.tcToStr(tcode));
        item.setDescription(uiEty.tcToStr(tdesc));
//        UOM uom1 = new UOM();
//        uom1.setSimbol(uiEty.tcToStr(tuom1));
//        UOM uom2 = new UOM();
//        uom2.setSimbol(uiEty.tcToStr(tuom2));
//        item.setUnitOne(uom1);
//        item.setUnitTwo(uom2);

    }
        public void addToTable(List<Item> items) {
        TableUtil.cleardata(cxTable1);
        for (Item item : items) {
            addToTable(item);
        }
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    public void addToTable(Item item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getCode(), item.getName(), item.getDescription()});
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CButton cButton4;
    private org.components.controls.CButton cButton5;
    private org.components.controls.CComboBox cComboBox1;
    private org.components.controls.CComboBox cComboBox2;
    private org.components.controls.CComboBox cComboBox3;
    private org.components.controls.CComboBox cComboBox4;
    private org.components.controls.CComboBox cComboBox5;
    private org.components.controls.CTextField cTextField1;
    private org.components.controls.CTextField cTextField10;
    private org.components.controls.CTextField cTextField11;
    private org.components.controls.CTextField cTextField12;
    private org.components.controls.CTextField cTextField13;
    private org.components.controls.CTextField cTextField14;
    private org.components.controls.CTextField cTextField15;
    private org.components.controls.CTextField cTextField16;
    private org.components.controls.CTextField cTextField17;
    private org.components.controls.CTextField cTextField18;
    private org.components.controls.CTextField cTextField2;
    private org.components.controls.CTextField cTextField5;
    private org.components.controls.CTextField cTextField6;
    private org.components.controls.CTextField cTextField7;
    private org.components.controls.CTextField cTextField8;
    private org.components.controls.CTextField cTextField9;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private org.components.controls.CTextField tcode;
    private org.components.controls.CTextField tdesc;
    // End of variables declaration//GEN-END:variables

    //please specify the a name for this tab
    @Override
    public String getTabName() {
        return "Item Master";
    }

    
    //return this panel astab for the use of main window
    @Override
    public JPanel getJPanel() {
        return this;
    }
}
