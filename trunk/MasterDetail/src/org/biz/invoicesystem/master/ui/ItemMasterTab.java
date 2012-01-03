 
package org.biz.invoicesystem.master.ui;

import java.util.List;
import javax.swing.JPanel;
import org.biz.app.ui.util.TableUtil;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

 
public class ItemMasterTab extends TabPanelUI {

public static String ListUiTabName="List";
public static String FormUiTabName="Form";

    List<Item> items;
    ItemService itemService;
 //   EntityService es;
 //   ItemPopUp ipu;
//   Item selectedItem;
      public ItemMasterTab() {
        initComponents();
   init();
   
   itemListUi1.setMastertab(this);
   itemMasterUI21.setMastertab(this);
   itemListUi1.setFormUi(itemMasterUI21);
   itemMasterUI21.setListUi(itemListUi1);
   
      }
      
      
      
      ////////////////////////
      
    @Override
       public void init() {
        try {
     itemService=new ItemService();       
        } catch (Exception e) {
      e.printStackTrace();
        }   
    }
///////////////////////////////////////
    
//    public void callItemByCode(String itemid){
//    
//        try {
//     itemListUi1.callItemByCode(itemid);            
//     
//        } catch (Exception e) {
//      e.printStackTrace();  }
//    
//    }
//    
   //////////////////////////////////////////////////////
    @Override
    public void updateEntityUI() {
        
        getItemTabPane().setSelectedIndex(getItemTabPane().indexOfTab("List"));
      itemListUi1.loadItemList2Tbl();
    }
      
      
 ///////////////////////     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tItemDescription = new org.components.controls.CTextField();
        itemTabPane = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        itemMasterUI21 = new org.biz.invoicesystem.master.ui.ItemMasterUI2();
        itemListUi1 = new org.biz.invoicesystem.master.ui.ItemListUi();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itemMasterUI21, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(itemMasterUI21, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        itemTabPane.addTab("Form", jPanel5);
        itemTabPane.addTab("List", itemListUi1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(itemTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.biz.invoicesystem.master.ui.ItemListUi itemListUi1;
    private org.biz.invoicesystem.master.ui.ItemMasterUI2 itemMasterUI21;
    private javax.swing.JTabbedPane itemTabPane;
    private javax.swing.JPanel jPanel5;
    private org.components.controls.CTextField tItemDescription;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
        return "Item Master";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }

    /**
     * @return the itemTabPane
     */
    public javax.swing.JTabbedPane getItemTabPane() {
        return itemTabPane;
    }

    /**
     * @param itemTabPane the itemTabPane to set
     */
    public void setItemTabPane(javax.swing.JTabbedPane itemTabPane) {
        this.itemTabPane = itemTabPane;
    }
}
