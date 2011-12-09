 package org.biz.invoicesystem.master.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
 
    
    List<Item> items;
    ItemService itemService;
    EntityService es;
    ItemPopUp ipu;
    Item selectedItem;
    
    public ItemMasterUI2() {
        initComponents();
        init();
    }
    
    public void keyListeners(){
    
        try {
            //item code listener
  tItemcode.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                 if(e.getKeyChar()==KeyEvent.VK_ENTER){
             
                     tItemDescription.requestFocus();  
             
                 }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                  
                }
  
      
  });//finished item code listener
  
  //item description listener
  tItemDescription.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                 if(e.getKeyChar()==KeyEvent.VK_ENTER){
             
                tSupplierItem.getEditor().getEditorComponent().requestFocus();
             
                 }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
                    tItemcode.requestFocus();
                
                }  
                }
  
      
  });//finished item description listener                      
  
  //item category listener
  tItemCategory.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
             
                 tSupplierItem.getEditor().getEditorComponent().requestFocus();
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
                    tItemDescription.requestFocus();
                
                }  
                }
  
      
  }); //item category listener finished
  
  //supplier listener
   tSupplierItem.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
                    tCartonItem.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
                    tItemCategory.getEditor().getEditorComponent().requestFocus();
                
                }  
                }
  
      
  }); //suplier listener finished
  //item carton keylistener started
     tCartonItem.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tUnitItem1.getEditor().getEditorComponent().requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
            tSupplierItem.getEditor().getEditorComponent().requestFocus();
                
                }  
                }
  
      
  });//carton listener finished.
   
  //unit 1 listener strtd
  tUnitItem1.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tDifferentPerUnit.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
            tCartonItem.requestFocus();
                
                }  
                }
  
      
  });//unit1 listener finished   
     
  //unit different field listener strtd
  tDifferentPerUnit.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
          if(!uiEty.tcToStr(tDifferentPerUnit).equals("")) {   
       tUnitItem2.getEditor().getEditorComponent().requestFocus();  
            
                }else{
          tItemSalesPriceUnit1.requestFocus();
          }
                
                }
                 
                } 

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
            tUnitItem1.getEditor().getEditorComponent().requestFocus();
                
                }  
                }
  
      
  });//unit different field listener finished.
          
  // unit 2 comb listener strdtd.
  tUnitItem2.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tItemSalesPriceUnit1.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
           tDifferentPerUnit.requestFocus();
                
                }  
                }
  
      
  });
  ///unit 2 combo listener finished
  tItemSalesPriceUnit1.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    
                    
                    try {
                  double dif=uiEty.tcToDble0(tDifferentPerUnit);      
                  
                 if(dif!=0){
           tItemSalesPriceUnit2.setText(""+uiEty.tcToDble0(tItemSalesPriceUnit1)/dif);                           
                 }else{
             tItemSalesPriceUnit2.setText("");
                 } 
                  
                 if(e.getKeyChar()==KeyEvent.VK_ENTER){
        tItemCostPrice.selectAll();      
       tItemCostPrice.requestFocus();  
             
                }
                           
                    } catch (Exception exx) {
                    exx.printStackTrace();
            return;
                    }
                     
             
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
               
          
          if(!uiEty.tcToStr(tDifferentPerUnit).equals("")) {   
        tUnitItem2.getEditor().selectAll();      
       tUnitItem2.getEditor().getEditorComponent().requestFocus();  
            
                }else{
              tDifferentPerUnit.selectAll();
          tDifferentPerUnit.requestFocus();
          }      
                }  
                }
  
      
  }); 
  
  //cost price listener strtd
  tItemCostPrice.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tItemLandingCost.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
              tItemSalesPriceUnit1.selectAll(); 
           tItemSalesPriceUnit1.requestFocus();
                
                }  
                }
  
      
  });//cost price listener finished.
  
  //landing cost listener field strtd...
  
  tItemLandingCost.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tItemMinimumPrice.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
           
                    tItemCostPrice.requestFocus();
                
                }  
                }
  
      
  });
  
  //landing cost listener field finished...
          } catch (Exception e) {
        e.printStackTrace();
        }
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
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPriceRanges = new javax.swing.JTable();
        tRngeValue = new org.components.controls.CTextField();
        tPriceRange = new org.components.controls.CComboBox();
        cLabel1 = new org.components.controls.CLabel();
        tWholesalePrice = new org.components.controls.CTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tCartonItem = new org.components.controls.CTextField();
        tUnitItem2 = new org.components.controls.CComboBox();
        tItemDescription = new org.components.controls.CTextField();
        tItemcode = new org.components.controls.CTextField();
        tItemSalesPriceUnit1 = new org.components.controls.CTextField();
        tItemSalesPriceUnit2 = new org.components.controls.CTextField();
        tItemLandingCost = new org.components.controls.CTextField();
        tItemCostPrice = new org.components.controls.CTextField();
        tItemMinimumPrice = new org.components.controls.CTextField();
        tItemdiscount = new org.components.controls.CTextField();
        tItemdiscValue = new org.components.controls.CTextField();
        tItemCommission = new org.components.controls.CTextField();
        tItemMinimumStock = new org.components.controls.CTextField();
        tItemReOrder = new org.components.controls.CTextField();
        tItemCategory = new org.components.controls.CComboBox();
        tItemLocation = new org.components.controls.CComboBox();
        tDifferentPerUnit = new org.components.controls.CTextField();
        tUnitItem1 = new org.components.controls.CComboBox();
        cClose = new org.components.controls.CButton();
        cImgBrowse = new org.components.controls.CButton();
        cSaveBtn = new org.components.controls.CButton();
        cClear = new org.components.controls.CButton();
        cDeleteBtn = new org.components.controls.CButton();
        lImage = new javax.swing.JLabel();
        tItemTrakInactive = new org.components.controls.CCheckBox();
        tItemTrakSerial = new org.components.controls.CCheckBox();
        tItemTrakExpiry = new org.components.controls.CCheckBox();
        tItemTrakNonStockItem = new org.components.controls.CCheckBox();
        tItemTrakManfctringItem = new org.components.controls.CCheckBox();
        jLabel21 = new javax.swing.JLabel();
        tSupplierItem = new org.components.controls.CComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

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
        jLabel3.setBounds(30, 134, 60, 20);

        jLabel6.setText("Landing Cost");
        add(jLabel6);
        jLabel6.setBounds(210, 240, 80, 20);

        jPanel1.setLayout(null);

        jLabel7.setText("Whole Sale  Price");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 15, 82, 20);

        tblPriceRanges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblPriceRanges);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 300, 80);
        jPanel1.add(tRngeValue);
        tRngeValue.setBounds(180, 90, 120, 25);

        tPriceRange.setEditable(true);
        jPanel1.add(tPriceRange);
        tPriceRange.setBounds(10, 90, 130, 23);

        cLabel1.setText("Feed Price Ranges For Wholesale Needs");
        jPanel1.add(cLabel1);
        cLabel1.setBounds(10, 60, 310, 25);
        jPanel1.add(tWholesalePrice);
        tWholesalePrice.setBounds(156, 11, 150, 25);

        add(jPanel1);
        jPanel1.setBounds(330, 180, 320, 210);

        jLabel9.setText("Min.Price");
        add(jLabel9);
        jLabel9.setBounds(30, 290, 60, 20);

        jLabel10.setText("%");
        add(jLabel10);
        jLabel10.setBounds(80, 320, 20, 20);

        jLabel11.setText("Sales Price");
        add(jLabel11);
        jLabel11.setBounds(30, 200, 60, 30);

        jLabel12.setText("Discount ");
        add(jLabel12);
        jLabel12.setBounds(30, 320, 60, 20);

        jLabel13.setText("$");
        add(jLabel13);
        jLabel13.setBounds(200, 260, 10, 20);

        jLabel14.setText("Val");
        add(jLabel14);
        jLabel14.setBounds(190, 320, 20, 20);

        jLabel15.setText("Location");
        add(jLabel15);
        jLabel15.setBounds(30, 380, 60, 20);

        jLabel16.setText("Commission");
        add(jLabel16);
        jLabel16.setBounds(30, 350, 60, 20);

        jLabel17.setText("Min.Stock");
        add(jLabel17);
        jLabel17.setBounds(30, 410, 60, 20);

        jLabel19.setText("Re Order");
        add(jLabel19);
        jLabel19.setBounds(30, 440, 60, 20);
        add(tCartonItem);
        tCartonItem.setBounds(90, 130, 210, 25);

        tUnitItem2.setEditable(true);
        add(tUnitItem2);
        tUnitItem2.setBounds(210, 180, 90, 23);
        add(tItemDescription);
        tItemDescription.setBounds(90, 40, 210, 25);
        add(tItemcode);
        tItemcode.setBounds(90, 10, 210, 25);
        add(tItemSalesPriceUnit1);
        tItemSalesPriceUnit1.setBounds(90, 205, 80, 20);

        tItemSalesPriceUnit2.setEditable(false);
        tItemSalesPriceUnit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemSalesPriceUnit2ActionPerformed(evt);
            }
        });
        add(tItemSalesPriceUnit2);
        tItemSalesPriceUnit2.setBounds(210, 205, 90, 20);
        add(tItemLandingCost);
        tItemLandingCost.setBounds(210, 260, 90, 25);
        add(tItemCostPrice);
        tItemCostPrice.setBounds(90, 260, 90, 25);
        add(tItemMinimumPrice);
        tItemMinimumPrice.setBounds(90, 290, 90, 25);
        add(tItemdiscount);
        tItemdiscount.setBounds(90, 320, 90, 25);
        add(tItemdiscValue);
        tItemdiscValue.setBounds(210, 320, 90, 25);
        add(tItemCommission);
        tItemCommission.setBounds(90, 350, 90, 20);
        add(tItemMinimumStock);
        tItemMinimumStock.setBounds(90, 410, 210, 25);
        add(tItemReOrder);
        tItemReOrder.setBounds(90, 440, 210, 25);

        tItemCategory.setEditable(true);
        add(tItemCategory);
        tItemCategory.setBounds(90, 70, 210, 23);

        tItemLocation.setEditable(true);
        add(tItemLocation);
        tItemLocation.setBounds(90, 380, 210, 23);
        add(tDifferentPerUnit);
        tDifferentPerUnit.setBounds(170, 180, 40, 25);

        tUnitItem1.setEditable(true);
        tUnitItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUnitItem1ActionPerformed(evt);
            }
        });
        add(tUnitItem1);
        tUnitItem1.setBounds(90, 180, 80, 30);

        cClose.setText("Close");
        add(cClose);
        cClose.setBounds(540, 400, 59, 23);

        cImgBrowse.setText("Browse");
        cImgBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cImgBrowseActionPerformed(evt);
            }
        });
        add(cImgBrowse);
        cImgBrowse.setBounds(490, 150, 160, 23);

        cSaveBtn.setText("Save");
        cSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSaveBtnActionPerformed(evt);
            }
        });
        add(cSaveBtn);
        cSaveBtn.setBounds(360, 400, 57, 23);

        cClear.setText("Clear");
        add(cClear);
        cClear.setBounds(420, 400, 57, 23);

        cDeleteBtn.setText("Delete");
        add(cDeleteBtn);
        cDeleteBtn.setBounds(480, 400, 63, 23);

        lImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lImage.setText("Image");
        add(lImage);
        lImage.setBounds(490, 10, 160, 140);

        tItemTrakInactive.setText("Inactive");
        tItemTrakInactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakInactiveActionPerformed(evt);
            }
        });
        add(tItemTrakInactive);
        tItemTrakInactive.setBounds(330, 130, 140, 23);

        tItemTrakSerial.setText("Track Serial Number");
        tItemTrakSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakSerialActionPerformed(evt);
            }
        });
        add(tItemTrakSerial);
        tItemTrakSerial.setBounds(330, 10, 150, 23);

        tItemTrakExpiry.setText("Track Expiry ");
        tItemTrakExpiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakExpiryActionPerformed(evt);
            }
        });
        add(tItemTrakExpiry);
        tItemTrakExpiry.setBounds(330, 40, 150, 23);

        tItemTrakNonStockItem.setText("Non Stock Item");
        tItemTrakNonStockItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakNonStockItemActionPerformed(evt);
            }
        });
        add(tItemTrakNonStockItem);
        tItemTrakNonStockItem.setBounds(330, 70, 150, 23);

        tItemTrakManfctringItem.setText("Manufacturing Item");
        tItemTrakManfctringItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakManfctringItemActionPerformed(evt);
            }
        });
        add(tItemTrakManfctringItem);
        tItemTrakManfctringItem.setBounds(330, 100, 140, 23);

        jLabel21.setText("Supplier");
        add(jLabel21);
        jLabel21.setBounds(30, 100, 60, 20);

        tSupplierItem.setEditable(true);
        add(tSupplierItem);
        tSupplierItem.setBounds(90, 100, 210, 20);

        jLabel18.setText("Diff");
        add(jLabel18);
        jLabel18.setBounds(170, 160, 50, 20);

        jLabel20.setText("Unit 1");
        add(jLabel20);
        jLabel20.setBounds(90, 160, 50, 20);

        jLabel8.setText("Unit 2");
        add(jLabel8);
        jLabel8.setBounds(220, 160, 60, 20);

        jLabel22.setText("Cost Price");
        add(jLabel22);
        jLabel22.setBounds(30, 260, 60, 20);
    }// </editor-fold>//GEN-END:initComponents

    public Item uiToEntity(Item i)throws Exception{
        try {
           
         i.setCode(uiEty.tcToStr(tItemcode));
         i.setDescription(uiEty.tcToStr(tItemDescription)); 
    // tItemCategory   combo
    //tSupplierItem    combo 
    //tCartonItem     
   //tUnitItem1      combo
  //tDifferentPerUnit
  //tUnitItem2       combo
   //tItemSalesPriceUnit1      
     //tItemCostPrice
    //tItemLandingCost     
   //tItemMinimumPrice
   //tItemdiscount        
    //tItemdiscValue       
    //tItemCommission
    //tItemLocation   combo   
     //tItemMinimumStock   
    //tItemReOrder
     //tItemTrakSerial chk
     //tItemTrakExpiry chk
    //tItemTrakNonStockItem chk
   //tItemTrakManfctringItem chk      
   //tItemTrakInactive chk      
    //tWholesalePrice      
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
        try {
        Item item = new Item();
        uiToEntity(item);
       itemService.getDao().save(item);
        items = itemService.getDao().getAll();
        
        System.out.println("list count "+items.size());
//        addToTable(items);?
//        ipu.populateTable(items);
  
        } catch (Exception e) {
        e.printStackTrace();
        }
     
          
    }//GEN-LAST:event_cSaveBtnActionPerformed

    private void cImgBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cImgBrowseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cImgBrowseActionPerformed

    private void tItemTrakInactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakInactiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakInactiveActionPerformed

    private void tItemTrakSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakSerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakSerialActionPerformed

    private void tItemTrakExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakExpiryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakExpiryActionPerformed

    private void tItemTrakNonStockItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakNonStockItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakNonStockItemActionPerformed

    private void tItemTrakManfctringItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakManfctringItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakManfctringItemActionPerformed

    private void tItemSalesPriceUnit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemSalesPriceUnit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemSalesPriceUnit2ActionPerformed

    private void tUnitItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUnitItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tUnitItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cClear;
    private org.components.controls.CButton cClose;
    private org.components.controls.CButton cDeleteBtn;
    private org.components.controls.CButton cImgBrowse;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CButton cSaveBtn;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lImage;
    private org.components.controls.CTextField tCartonItem;
    private org.components.controls.CTextField tDifferentPerUnit;
    private org.components.controls.CComboBox tItemCategory;
    private org.components.controls.CTextField tItemCommission;
    private org.components.controls.CTextField tItemCostPrice;
    private org.components.controls.CTextField tItemDescription;
    private org.components.controls.CTextField tItemLandingCost;
    private org.components.controls.CComboBox tItemLocation;
    private org.components.controls.CTextField tItemMinimumPrice;
    private org.components.controls.CTextField tItemMinimumStock;
    private org.components.controls.CTextField tItemReOrder;
    private org.components.controls.CTextField tItemSalesPriceUnit1;
    private org.components.controls.CTextField tItemSalesPriceUnit2;
    private org.components.controls.CCheckBox tItemTrakExpiry;
    private org.components.controls.CCheckBox tItemTrakInactive;
    private org.components.controls.CCheckBox tItemTrakManfctringItem;
    private org.components.controls.CCheckBox tItemTrakNonStockItem;
    private org.components.controls.CCheckBox tItemTrakSerial;
    private org.components.controls.CTextField tItemcode;
    private org.components.controls.CTextField tItemdiscValue;
    private org.components.controls.CTextField tItemdiscount;
    private org.components.controls.CComboBox tPriceRange;
    private org.components.controls.CTextField tRngeValue;
    private org.components.controls.CComboBox tSupplierItem;
    private org.components.controls.CComboBox tUnitItem1;
    private org.components.controls.CComboBox tUnitItem2;
    private org.components.controls.CTextField tWholesalePrice;
    private javax.swing.JTable tblPriceRanges;
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
