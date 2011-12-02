 package org.biz.invoicesystem.master.ui.testx;

import java.util.List;
import javax.swing.JPanel;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.Customer;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.master.ui.ItemPopUp;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author Administrator
 */
public class ItemMasterUI2 extends TabPanelUI  {

    /** Creates new form ItemMasterUI2 */
    public ItemMasterUI2() {
        initComponents();
        init();
    }

    List<Item> items;
    ItemService itemService;
    EntityService es;
    ItemPopUp ipu;
    Item selectedItem;
    
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
        cItmCarton = new org.components.controls.CTextField();
        cTextField2 = new org.components.controls.CTextField();
        cItmUnit2 = new org.components.controls.CComboBox();
        tdesc = new org.components.controls.CTextField();
        cItmcode = new org.components.controls.CTextField();
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
        cItmCategory = new org.components.controls.CComboBox();
        cComboBox4 = new org.components.controls.CComboBox();
        cTextField18 = new org.components.controls.CTextField();
        cItmUnit1 = new org.components.controls.CComboBox();
        cClose = new org.components.controls.CButton();
        cButton2 = new org.components.controls.CButton();
        cSaveBtn = new org.components.controls.CButton();
        cClear = new org.components.controls.CButton();
        cDeleteBtn = new org.components.controls.CButton();

        setLayout(null);

        jLabel1.setText("Item Code");
        add(jLabel1);
        jLabel1.setBounds(30, 10, 50, 20);

        jLabel2.setText("Description ");
        add(jLabel2);
        jLabel2.setBounds(30, 40, 60, 20);

        jLabel4.setText("Category");
        add(jLabel4);
        jLabel4.setBounds(30, 70, 60, 14);

        jLabel3.setText("Carton ");
        add(jLabel3);
        jLabel3.setBounds(30, 100, 36, 14);

        jLabel5.setText("Sales Price");
        add(jLabel5);
        jLabel5.setBounds(30, 160, 60, 20);

        jLabel6.setText("Unit");
        add(jLabel6);
        jLabel6.setBounds(30, 130, 50, 20);

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

        add(jPanel1);
        jPanel1.setBounds(310, 130, 270, 190);

        jLabel9.setText("Min.Price");
        add(jLabel9);
        jLabel9.setBounds(30, 220, 60, 20);

        jLabel10.setText("%");
        add(jLabel10);
        jLabel10.setBounds(80, 250, 20, 20);

        jLabel11.setText("Cost Price");
        add(jLabel11);
        jLabel11.setBounds(30, 190, 60, 20);

        jLabel12.setText("Discount ");
        add(jLabel12);
        jLabel12.setBounds(30, 250, 60, 20);

        jLabel13.setText("$");
        add(jLabel13);
        jLabel13.setBounds(200, 190, 10, 20);

        jLabel14.setText("Val");
        add(jLabel14);
        jLabel14.setBounds(190, 250, 20, 20);

        jLabel15.setText("Location");
        add(jLabel15);
        jLabel15.setBounds(30, 310, 60, 20);

        jLabel16.setText("Commission");
        add(jLabel16);
        jLabel16.setBounds(30, 280, 60, 20);

        jLabel17.setText("Min.Stock");
        add(jLabel17);
        jLabel17.setBounds(30, 340, 60, 20);

        jLabel18.setText("Image");
        add(jLabel18);
        jLabel18.setBounds(30, 400, 60, 20);

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

        add(jPanel2);
        jPanel2.setBounds(310, 10, 100, 110);

        jLabel19.setText("Re Order");
        add(jLabel19);
        jLabel19.setBounds(30, 370, 60, 20);
        add(cItmCarton);
        cItmCarton.setBounds(90, 100, 210, 25);
        add(cTextField2);
        cTextField2.setBounds(80, 400, 140, 25);
        add(cItmUnit2);
        cItmUnit2.setBounds(210, 130, 90, 23);
        add(tdesc);
        tdesc.setBounds(90, 40, 210, 25);
        add(cItmcode);
        cItmcode.setBounds(90, 10, 210, 25);
        add(cTextField5);
        cTextField5.setBounds(90, 160, 90, 25);
        add(cTextField6);
        cTextField6.setBounds(200, 160, 90, 25);
        add(cTextField7);
        cTextField7.setBounds(210, 190, 90, 25);
        add(cTextField8);
        cTextField8.setBounds(90, 190, 90, 25);
        add(cTextField9);
        cTextField9.setBounds(90, 220, 90, 25);
        add(cTextField10);
        cTextField10.setBounds(90, 250, 90, 25);
        add(cTextField11);
        cTextField11.setBounds(210, 250, 90, 25);
        add(cTextField12);
        cTextField12.setBounds(90, 280, 90, 20);
        add(cTextField13);
        cTextField13.setBounds(90, 340, 210, 25);
        add(cTextField14);
        cTextField14.setBounds(90, 370, 210, 25);
        add(cItmCategory);
        cItmCategory.setBounds(90, 70, 210, 23);
        add(cComboBox4);
        cComboBox4.setBounds(90, 310, 210, 23);
        add(cTextField18);
        cTextField18.setBounds(170, 130, 30, 25);
        add(cItmUnit1);
        cItmUnit1.setBounds(90, 130, 70, 23);

        cClose.setText("Close");
        add(cClose);
        cClose.setBounds(530, 400, 59, 23);

        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });
        add(cButton2);
        cButton2.setBounds(230, 400, 65, 23);

        cSaveBtn.setText("Save");
        cSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSaveBtnActionPerformed(evt);
            }
        });
        add(cSaveBtn);
        cSaveBtn.setBounds(350, 400, 57, 23);

        cClear.setText("Clear");
        add(cClear);
        cClear.setBounds(410, 400, 57, 23);

        cDeleteBtn.setText("Delete");
        add(cDeleteBtn);
        cDeleteBtn.setBounds(470, 400, 63, 23);
    }// </editor-fold>//GEN-END:initComponents

    public Item uiToEntity(Item i)throws Exception{
        try {
           
         i.setCode(uiEty.tcToStr(cItmcode));
         i.setDescription(uiEty.tcToStr(tdesc));               
        } catch (Exception e) {
    e.printStackTrace();
    throw e;
        }
        return i;
    }
    
    private void cSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSaveBtnActionPerformed
        
//        if (selectedItem != null) {
//            Item item = itemService.getDao().deatach(selectedItem, selectedItem.getId());
//            uiToEty(item);
//            //            item.setProduct(selectedProd);
//            itemService.getDao().update(item);
//            items = itemService.getDao().getAll();
//            addToTable(items);
//            return;
//        }
        
        Item item = new Item();
       // uiToEntity(item);
 
        itemService.getDao().save(item);
        items = itemService.getDao().getAll();
        
        System.out.println("list count "+items.size());
//        addToTable(items);?
//        ipu.populateTable(items);
        
    }//GEN-LAST:event_cSaveBtnActionPerformed

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton2;
    private org.components.controls.CButton cClear;
    private org.components.controls.CButton cClose;
    private org.components.controls.CComboBox cComboBox2;
    private org.components.controls.CComboBox cComboBox4;
    private org.components.controls.CButton cDeleteBtn;
    private org.components.controls.CTextField cItmCarton;
    private org.components.controls.CComboBox cItmCategory;
    private org.components.controls.CComboBox cItmUnit1;
    private org.components.controls.CComboBox cItmUnit2;
    private org.components.controls.CTextField cItmcode;
    private org.components.controls.CButton cSaveBtn;
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
    private javax.swing.JTable jTable1;
    private org.components.controls.CTextField tdesc;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
        return "Item Master";
    }

    @Override
    public JPanel getJPanel() {
        return this; 
    }
}
