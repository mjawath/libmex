 package org.biz.invoicesystem.master.ui;

import java.awt.AWTKeyStroke;
import java.awt.BorderLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import org.biz.app.ui.util.MessageBoxes;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.ExtraSalesPrice;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.entity.master.ItemBarcode;
import org.biz.invoicesystem.entity.master.ItemVariation;
import org.biz.invoicesystem.entity.master.Supplier;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

 
public class ItemMasterUI2 extends TabPanelUI  {
 
    
    List<Item> items;
    ItemService itemService;
    EntityService es;
    ItemPopUp ipu;
    private Item selectedItem;
    
    public ItemMasterUI2() {
        initComponents();
keyListeners();
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
  ////////////////////////////////////////////////////////////////
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
  ////////////////////////////////////////////////////////////
  //landing cost listener field finished...
  
 //tItemMinimumPrice listener started..
  tItemMinimumPrice.addKeyListener(new KeyAdapter() {

  @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tItemdiscount.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
           
                    tItemLandingCost.requestFocus();
                
                }  
                }
  
  });
 ///////////////////////////////////////////////////////////////////////////       
      tItemdiscount.addKeyListener(new KeyAdapter() {

  @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tItemCommission.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
           
      tItemMinimumPrice.requestFocus();
                
                }  
                }
  
  }); //discount listener finished...... 
      
   
 ///////////////////////////////////////////////////////////////////////////       
      tItemCommission.addKeyListener(new KeyAdapter() {

  @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tItemLocation.getEditor().getEditorComponent().requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
           
      tItemdiscount.requestFocus();
                
                }  
                }
  
  }); //discount listener finished...... 
 /////////////////////////////////////////////
       tItemLocation.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

               
                @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
       tItemMinimumStock.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
           
      tItemCommission.requestFocus();
                
                }  
                }
       
           
       });
   ////////////////////////////////////////////////////////////////////////////
     tItemMinimumStock.addKeyListener(new KeyAdapter() {

  @Override
                public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
      tItemReOrder.requestFocus();  
             
                }
                 
                }

                @Override
                public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
           
    tItemLocation.getEditor().getEditorComponent().requestFocus();  
                   
                }  
                }
  
  });
   ////////////////////////////////////////////////////////////////////////////
    tItemTrakSerial.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_UP){
                 tItemReOrder.requestFocus();  
                  }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                    
                }

        
                @Override
                public void keyTyped(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
          tItemTrakSerial.setSelected( tItemTrakSerial.isSelected()?true:false);                                  
                    }
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
      tItemTrakExpiry.requestFocus();  
             
                }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                  
                }
    
    }    );   
  ///////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////
    tItemTrakExpiry.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_UP){
                 tItemTrakSerial.requestFocus();  
                  }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                    
                }

        
                @Override
                public void keyTyped(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
          tItemTrakExpiry.setSelected( tItemTrakExpiry.isSelected()?true:false);                                  
                    }
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
      tItemTrakNonStockItem.requestFocus();  
             
                }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                  
                }
    
    }    );   
  ///////////////////////////////////////////////////////////////////////////
   //tItemTrakNonStockItem request fct need to write....
  
      tItemTrakNonStockItem.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_UP){
                 tItemTrakExpiry.requestFocus();  
                  }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                    
                }

        
                @Override
                public void keyTyped(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
          tItemTrakNonStockItem.setSelected( tItemTrakNonStockItem.isSelected()?true:false);                                  
                    }
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
      tItemTrakInactive.requestFocus();  
             
                }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                  
                }
    
    }    );   
    
    ////////////////////////////////////////////////////////////////////////////
  
 ////////////////////////////////////////////////////////////////////////////

      tItemTrakInactive.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_UP){
                 tItemTrakNonStockItem.requestFocus();  
                  }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                    
                }

        
                @Override
                public void keyTyped(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
          tItemTrakInactive.setSelected( tItemTrakInactive.isSelected()?true:false);                                  
                    }
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
      tItemTrakManfctringItem.requestFocus();  
             
                }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                  
                }
    
    }    );   
     
 ///////////////////////////////////////////////////////////////////////////
 
 ////////////////////////////////////////////////////////////////////////////
 
      tItemTrakManfctringItem.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_UP){
                 tItemTrakInactive.requestFocus();  
                  }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                    
                }

        
                @Override
                public void keyTyped(KeyEvent e) {
                    try {
                        
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
          tItemTrakManfctringItem.setSelected( tItemTrakManfctringItem.isSelected()?true:false);                                  
                    }
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
              
      cSaveBtn.requestFocus();  
             
                }
                    } catch (Exception exx) {
                    exx.printStackTrace();
                    }
                  
                }
    
    }    );   
     
 ////////////////////////////////////////////////////////////////////////////
tVariationName.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    try {
              if(e.getKeyChar()==KeyEvent.VK_ENTER){ 
                  
                 tVariationPrice1.requestFocus();
                 
              }
                    } catch (Exception exx) {
                   
                    }
                }

});
 /////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////

 /////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////

 /////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////

 /////////////////////////////////////////////////////////////////////////////
       
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
   
   public void clearMaster(){
       try {
           
           tVariationName.setSelectedItem("");
                tVariationPrice1.setText("");
                tVariationPrice2.setText("");
                
          tPriceRange.setSelectedItem("");           
         tRngeValue.setText("");
            TableUtil.cleardata(tblVariation);
            TableUtil.cleardata(tblPriceRanges);
          
           entity2Ui(new Item());
       } catch (Exception e) {
       }
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componentFactory1 = new org.components.util.ComponentFactory();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        cSaveBtn = new org.components.controls.CButton();
        cClear = new org.components.controls.CButton();
        cDeleteBtn = new org.components.controls.CButton();
        jLabel21 = new javax.swing.JLabel();
        tSupplierItem = new org.components.controls.CComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        cPanel1 = new org.components.containers.CPanel();
        tVariationPrice2 = new org.components.controls.CTextField();
        tVariationName = new org.components.controls.CComboBox();
        cLabel2 = new org.components.controls.CLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVariation = new javax.swing.JTable();
        tVariationPrice1 = new org.components.controls.CTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPriceRanges = new javax.swing.JTable();
        tRngeValue = new org.components.controls.CTextField();
        tPriceRange = new org.components.controls.CComboBox();
        cLabel1 = new org.components.controls.CLabel();
        tWholesalePrice = new org.components.controls.CTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblBarcode = new javax.swing.JTable();
        tType = new org.components.controls.CTextField();
        cLabel4 = new org.components.controls.CLabel();
        cLabel5 = new org.components.controls.CLabel();
        cLabel6 = new org.components.controls.CLabel();
        tItemBarcode = new org.components.controls.CTextField();
        cPanel3 = new org.components.containers.CPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tMetaInfo = new org.components.controls.CTextArea();
        cLabel3 = new org.components.controls.CLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cPanel2 = new org.components.containers.CPanel();
        tItemTrakSerial = new org.components.controls.CCheckBox();
        tItemTrakExpiry = new org.components.controls.CCheckBox();
        tItemTrakNonStockItem = new org.components.controls.CCheckBox();
        tItemTrakInactive = new org.components.controls.CCheckBox();
        tItemTrakManfctringItem = new org.components.controls.CCheckBox();
        cPanel4 = new org.components.containers.CPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cPanel5 = new org.components.containers.CPanel();
        cScrollPane1 = new org.components.controls.CScrollPane();
        jLabel23 = new javax.swing.JLabel();
        tItemCommissionValue = new org.components.controls.CTextField();

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
        jLabel14.setBounds(190, 320, 20, 30);

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
        tUnitItem2.setBounds(220, 180, 80, 23);
        add(tItemDescription);
        tItemDescription.setBounds(90, 40, 210, 25);
        add(tItemcode);
        tItemcode.setBounds(90, 10, 210, 25);

        tItemSalesPriceUnit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemSalesPriceUnit1ActionPerformed(evt);
            }
        });
        add(tItemSalesPriceUnit1);
        tItemSalesPriceUnit1.setBounds(90, 205, 80, 20);

        tItemSalesPriceUnit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemSalesPriceUnit2ActionPerformed(evt);
            }
        });
        add(tItemSalesPriceUnit2);
        tItemSalesPriceUnit2.setBounds(220, 205, 80, 20);
        add(tItemLandingCost);
        tItemLandingCost.setBounds(210, 260, 90, 25);
        add(tItemCostPrice);
        tItemCostPrice.setBounds(90, 260, 90, 25);
        add(tItemMinimumPrice);
        tItemMinimumPrice.setBounds(90, 290, 90, 25);

        tItemdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemdiscountActionPerformed(evt);
            }
        });
        add(tItemdiscount);
        tItemdiscount.setBounds(90, 320, 90, 25);

        tItemdiscValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemdiscValueActionPerformed(evt);
            }
        });
        add(tItemdiscValue);
        tItemdiscValue.setBounds(210, 320, 90, 25);

        tItemCommission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemCommissionActionPerformed(evt);
            }
        });
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
        tDifferentPerUnit.setBounds(170, 180, 50, 20);

        tUnitItem1.setEditable(true);
        tUnitItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tUnitItem1ActionPerformed(evt);
            }
        });
        add(tUnitItem1);
        tUnitItem1.setBounds(90, 180, 80, 23);

        cClose.setText("Goto List ");
        cClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCloseActionPerformed(evt);
            }
        });
        add(cClose);
        cClose.setBounds(650, 420, 90, 50);

        cSaveBtn.setText("Save");
        cSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSaveBtnActionPerformed(evt);
            }
        });
        add(cSaveBtn);
        cSaveBtn.setBounds(380, 420, 80, 50);

        cClear.setText("Clear");
        cClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cClearActionPerformed(evt);
            }
        });
        add(cClear);
        cClear.setBounds(470, 420, 80, 50);

        cDeleteBtn.setText("Delete");
        cDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDeleteBtnActionPerformed(evt);
            }
        });
        add(cDeleteBtn);
        cDeleteBtn.setBounds(560, 420, 80, 50);

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

        cPanel1.setLayout(null);

        tVariationPrice2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tVariationPrice2ActionPerformed(evt);
            }
        });
        tVariationPrice2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tVariationPrice2KeyTyped(evt);
            }
        });
        cPanel1.add(tVariationPrice2);
        tVariationPrice2.setBounds(310, 30, 140, 25);

        tVariationName.setEditable(true);
        cPanel1.add(tVariationName);
        tVariationName.setBounds(10, 30, 130, 23);

        cLabel2.setText("Item Variation");
        cPanel1.add(cLabel2);
        cLabel2.setBounds(10, 0, 130, 25);

        tblVariation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "S Price 1", "S Price 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVariation);

        cPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 440, 120);

        tVariationPrice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tVariationPrice1KeyTyped(evt);
            }
        });
        cPanel1.add(tVariationPrice1);
        tVariationPrice1.setBounds(150, 30, 140, 25);

        jTabbedPane1.addTab("Variation", cPanel1);

        jPanel1.setLayout(null);

        jLabel7.setText("Whole Sale  Price");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 10, 130, 20);

        tblPriceRanges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Range", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPriceRanges);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 340, 70);

        tRngeValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tRngeValueKeyTyped(evt);
            }
        });
        jPanel1.add(tRngeValue);
        tRngeValue.setBounds(270, 70, 120, 25);

        tPriceRange.setEditable(true);
        tPriceRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPriceRangeActionPerformed(evt);
            }
        });
        jPanel1.add(tPriceRange);
        tPriceRange.setBounds(50, 70, 130, 23);

        cLabel1.setText("Feed Price Ranges For Wholesale Needs");
        jPanel1.add(cLabel1);
        cLabel1.setBounds(60, 40, 310, 25);
        jPanel1.add(tWholesalePrice);
        tWholesalePrice.setBounds(260, 10, 180, 25);

        jTabbedPane1.addTab("Price Range", jPanel1);

        jPanel4.setLayout(null);

        tblBarcode.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Barcode"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblBarcode);

        jPanel4.add(jScrollPane5);
        jScrollPane5.setBounds(50, 70, 340, 110);

        tType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tTypeKeyTyped(evt);
            }
        });
        jPanel4.add(tType);
        tType.setBounds(50, 30, 160, 25);

        cLabel4.setText("Barcode Number");
        jPanel4.add(cLabel4);
        cLabel4.setBounds(230, 0, 160, 25);

        cLabel5.setText("Type");
        jPanel4.add(cLabel5);
        cLabel5.setBounds(50, 0, 160, 25);

        cLabel6.setText("Enter");
        jPanel4.add(cLabel6);
        cLabel6.setBounds(404, 30, 40, 25);

        tItemBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tItemBarcodeKeyTyped(evt);
            }
        });
        jPanel4.add(tItemBarcode);
        tItemBarcode.setBounds(230, 30, 160, 25);

        jTabbedPane1.addTab("Barcode", jPanel4);

        cPanel3.setLayout(null);

        tMetaInfo.setColumns(20);
        tMetaInfo.setRows(5);
        jScrollPane4.setViewportView(tMetaInfo);

        cPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(10, 80, 440, 96);

        cLabel3.setText("Meta Information ");
        cPanel3.add(cLabel3);
        cLabel3.setBounds(10, 50, 300, 25);
        cPanel3.add(jPanel3);
        jPanel3.setBounds(100, -30, 100, 100);

        jTabbedPane1.addTab("Meta Details ", cPanel3);

        add(jTabbedPane1);
        jTabbedPane1.setBounds(310, 10, 470, 220);
        add(jPanel2);
        jPanel2.setBounds(320, 200, 10, 10);

        cPanel2.setLayout(null);

        tItemTrakSerial.setText("Track Serial Number");
        tItemTrakSerial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tItemTrakSerial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tItemTrakSerial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tItemTrakSerial.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tItemTrakSerial.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tItemTrakSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakSerialActionPerformed(evt);
            }
        });
        cPanel2.add(tItemTrakSerial);
        tItemTrakSerial.setBounds(0, 10, 110, 50);

        tItemTrakExpiry.setText("Track Expiry ");
        tItemTrakExpiry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tItemTrakExpiry.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tItemTrakExpiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakExpiryActionPerformed(evt);
            }
        });
        cPanel2.add(tItemTrakExpiry);
        tItemTrakExpiry.setBounds(110, 0, 71, 60);

        tItemTrakNonStockItem.setText("Non Stock Item");
        tItemTrakNonStockItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tItemTrakNonStockItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tItemTrakNonStockItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemTrakNonStockItemActionPerformed(evt);
            }
        });
        cPanel2.add(tItemTrakNonStockItem);
        tItemTrakNonStockItem.setBounds(180, 0, 90, 60);

        tItemTrakInactive.setText("Inactive");
        tItemTrakInactive.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tItemTrakInactive.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cPanel2.add(tItemTrakInactive);
        tItemTrakInactive.setBounds(270, 0, 60, 60);

        tItemTrakManfctringItem.setText("Manufacturing Item");
        tItemTrakManfctringItem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tItemTrakManfctringItem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cPanel2.add(tItemTrakManfctringItem);
        tItemTrakManfctringItem.setBounds(330, 0, 110, 60);

        add(cPanel2);
        cPanel2.setBounds(330, 240, 440, 60);
        add(cPanel4);
        cPanel4.setBounds(370, 330, 10, 10);

        cPanel5.setLayout(null);

        cScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        cPanel5.add(cScrollPane1);
        cScrollPane1.setBounds(0, 0, 470, 100);

        jScrollPane3.setViewportView(cPanel5);

        add(jScrollPane3);
        jScrollPane3.setBounds(320, 310, 470, 100);

        jLabel23.setText("Val");
        add(jLabel23);
        jLabel23.setBounds(190, 340, 20, 40);

        tItemCommissionValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tItemCommissionValueActionPerformed(evt);
            }
        });
        add(tItemCommissionValue);
        tItemCommissionValue.setBounds(210, 350, 90, 25);
    }// </editor-fold>//GEN-END:initComponents
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void addToVariationTbl(){
   try{
   // TableUtil.cleardata(tblVariation);
   String variationDesc=uiEty.cmbtostr(tVariationName);
   double variaiotnPrice1=uiEty.tcToDble0(tVariationPrice1);
   double variaiotnPrice2=uiEty.tcToDble0(tVariationPrice2);
   TableUtil.addrow(tblVariation,new Object[]{variationDesc,variaiotnPrice1,variaiotnPrice2});                   
  
   } catch (Exception e) {
   
   e.printStackTrace();   
   
   }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //this method ADD VALUES TO THE TABLE OF EXTRA SALES PRICE...TABLE.
    public void addToExtraPriceTbl(){
   try {
   // TableUtil.cleardata(tblVariation);
   String tPriceDes=uiEty.cmbtostr(tPriceRange);
   double ExtraPrice1=uiEty.tcToDble0(tRngeValue);
   TableUtil.addrow(tblPriceRanges,new Object[]{tPriceDes,ExtraPrice1});
    
   } catch (Exception e) {
     e.printStackTrace();   
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //this method ADD barcode TO THE TABLE OF barcodeTbl...TABLE.
    public void addToBarcode(){
      try {
   // TableUtil.cleardata(tblVariation);
    
   String type=uiEty.tcToStr(tType);
   String barcode=uiEty.tcToStr(tItemBarcode);
    
   TableUtil.addrow(tblBarcode,new Object[]{type,barcode});
          
        } catch (Exception e) {
     e.printStackTrace();   
        }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Item uiToEntity(Item i)throws Exception{
        try {
         i.setId(EntityService.getEntityService().getKey(""));              
         i.setCode(uiEty.tcToStr(tItemcode));
         i.setDescription(uiEty.tcToStr(tItemDescription)); 
   i.setCategory(uiEty.cmbtostr(tItemCategory)); //    combo 
   i.setSupplierId(uiEty.cmbtostr(tSupplierItem)); //    combo 
   i.setCarton(uiEty.tcToDble0(tCartonItem)); //     
   i.setUnitOne(uiEty.cmbtostr(tUnitItem1));//      combo
  i.setDifferent(uiEty.tcToInt(tDifferentPerUnit));//tDifferentPerUnit
 i.setUnitTwo(uiEty.cmbtostr(tUnitItem2));//tUnitItem2       combo
  i.setUnit1SalesPrice(uiEty.tcToDble0(tItemSalesPriceUnit1)); //tItemSalesPriceUnit1      
 i.setUnit2SalesPrice(uiEty.tcToDble0(tItemSalesPriceUnit2));//tItemSalesPriceUnit2
  i.setCost(uiEty.tcToDble0(tItemCostPrice));//tItemCostPrice
  i.setLandCost(uiEty.tcToDble0(tItemLandingCost)); //tItemLandingCost     
  i.setMinSalesPrice(uiEty.tcToDble0(tItemMinimumPrice)); //tItemMinimumPrice
  i.setDiscount(uiEty.tcToDble0(tItemdiscount));//tItemdiscount        
  i.setDiscountValue(uiEty.tcToDble0(tItemdiscValue));
  i.setCommission(uiEty.tcToDble0(tItemCommission));//tItemCommission
  i.setCommissionValue(uiEty.tcToDble0(tItemCommissionValue));//tItemCommission
   i.setLocation(uiEty.cmbtostr(tItemLocation));//tItemLocation   combo   
   i.setMinStock(uiEty.tcToDble0(tItemMinimumStock));//tItemMinimumStock   
   i.setReOrder(uiEty.tcToDble0(tItemReOrder)); //tItemReOrder
   i.setTrackSerial(tItemTrakSerial.isSelected());  //tItemTrakSerial chk
   i.setTrackExpiry(tItemTrakExpiry.isSelected());  //tItemTrakExpiry chk
   i.setNonStockItems(tItemTrakNonStockItem.isSelected());//tItemTrakNonStockItem chk
   i.setManufactItem(tItemTrakManfctringItem.isSelected());//tItemTrakManfctringItem chk      
   i.setInactive(tItemTrakInactive.isSelected());//tItemTrakInactive chk      
   i.setWholesalePrice(uiEty.tcToDble0(tWholesalePrice));//tWholesalePrice      
   i.setMetaInfo(tMetaInfo.getText());  //tMetaInfo
   i.setVariations(ui2ItemVariation(tblVariation,i.getId()));            
   i.setExtrasalespriceCollection(ui2ExtraSalesPrice(tblPriceRanges,i.getId()));
   
        } catch (Exception e) {
    e.printStackTrace();
    throw e;
        }
        return i;
    }
    
     
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
 
//    public String idForDb(String shopName){
//    String id="";
//    
//        try {
//           
//            id+=uiEty.nowTimesStamp()+shopName;
//    //id must be first autonumber ,second timestamp (8 digits),third shopname;  
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    
//    return id;
//    }
    
    //this method will get all the itemvariation details from 
    //itemvariation table /grid.
    public List<ItemVariation> ui2ItemVariation(JTable tbl,String itemid){
    List<ItemVariation> lstOfVariation=new ArrayList<ItemVariation>();
        try {
       Vector<Vector> vecOfVec=TableUtil.getDataVector(tbl);
            for (Iterator<Vector> it = vecOfVec.iterator(); it.hasNext();) {
                
           Vector row = it.next();
           ItemVariation var=new ItemVariation();
           var.setId(EntityService.getEntityService().getKey(""));
           var.setDescription(row.get(0)==null?"":row.get(0).toString());
           var.setsPrice1(row.get(1)==null?0.0:Double.parseDouble(row.get(1).toString()));
           var.setsPrice2(row.get(2)==null?0.0:Double.parseDouble(row.get(2).toString()));
           lstOfVariation.add(var);                
         
            }
       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lstOfVariation;
    }
    
    
    public List<ExtraSalesPrice> ui2ExtraSalesPrice(JTable tbl,String itemid){
    List<ExtraSalesPrice> lstOfExSalePrice=new ArrayList<ExtraSalesPrice>();
        try {
       Vector<Vector> vecOfVec=TableUtil.getDataVector(tbl);
            for (Iterator<Vector> it = vecOfVec.iterator(); it.hasNext();) {
                Vector row = it.next();
           ExtraSalesPrice extraSprice=new ExtraSalesPrice();
           extraSprice.setId(EntityService.getEntityService().getKey(""));
           extraSprice.setDescription(row.get(0)==null?"":row.get(0).toString());
           extraSprice.setPrice(row.get(1)==null?0.0:Double.parseDouble(row.get(1).toString()));
             lstOfExSalePrice.add(extraSprice);                
         
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        return lstOfExSalePrice;
    }
    
    ////////////////////////////
    public List<ItemBarcode> ui2Barcodes(JTable tbl,String itemid){
    List<ItemBarcode> lstFBarcodes=new ArrayList<ItemBarcode>();
        try {
       Vector<Vector> vecOfVec=TableUtil.getDataVector(tbl);
            for (Iterator<Vector> it = vecOfVec.iterator(); it.hasNext();) {
                Vector row = it.next();
           ItemBarcode bCode=new ItemBarcode();
           bCode.setId(EntityService.getEntityService().getKey(""));
           bCode.setType(row.get(0)==null?"":row.get(0).toString());
           bCode.setBarcode(row.get(1)==null?"":row.get(1).toString());
              lstFBarcodes.add(bCode);                
         
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        return lstFBarcodes;
    }
    
    ////////////////////////////
    
    public void entity2Ui(Item i){
    
        try {
         uiEty.objToUi(tItemcode, i.getCode());
    uiEty.objToUi(tItemDescription,i.getDescription());// tItemDescription
  uiEty.objToUi(tItemCategory,i.getCategory());//   i.setCategory(uiEty.cmbtostr(tItemCategory)); //    combo 
  uiEty.objToUi(tSupplierItem,i.getSupplierId());//   i.setSupplierId(uiEty.cmbtostr(tSupplierItem)); //    combo 
  uiEty.objToUi(tCartonItem,i.getCarton());//   i.setCarton(uiEty.tcToDble0(tCartonItem)); //     
  uiEty.objToUi(tUnitItem1,i.getUnitOne());//   i.setUnitOne(uiEty.cmbtostr(tUnitItem1));//      combo
  uiEty.objToUi(tDifferentPerUnit,i.getDifferent());//  i.setDifferent(uiEty.tcToInt(tDifferentPerUnit));//tDifferentPerUnit
  uiEty.objToUi(tUnitItem2,i.getUnitTwo());// i.setUnitTwo(uiEty.cmbtostr(tUnitItem2));//tUnitItem2       combo
  uiEty.objToUi(tItemSalesPriceUnit1,i.getUnit1SalesPrice());//  i.setUnit1SalesPrice(uiEty.tcToDble0(tItemSalesPriceUnit1)); //tItemSalesPriceUnit1      
  uiEty.objToUi(tItemSalesPriceUnit2,i.getUnit2SalesPrice());// i.setUnit2SalesPrice(uiEty.tcToDble0(tItemSalesPriceUnit2));//tItemSalesPriceUnit2
  uiEty.objToUi(tItemCostPrice,i.getCost());//  i.setCost(uiEty.tcToDble0(tItemCostPrice));//tItemCostPrice
    uiEty.objToUi(tItemLandingCost,i.getLandCost());//  i.setLandCost(uiEty.tcToDble0(tItemLandingCost)); //tItemLandingCost     
    uiEty.objToUi(tItemMinimumPrice,i.getMinSalesPrice());//  i.setMinSalesPrice(uiEty.tcToDble0(tItemMinimumPrice)); //tItemMinimumPrice
    uiEty.objToUi(tItemdiscount,i.getDiscount());//  i.setDicount(uiEty.tcToDble0(tItemdiscount));//tItemdiscount        


    uiEty.objToUi(tItemdiscValue,i.getDiscountValue());//   //tItemdiscValue       

    uiEty.objToUi(tItemCommission,i.getCommission());//   i.setCommission(uiEty.tcToDble0(tItemCommission));//tItemCommission
    uiEty.objToUi(tItemCommissionValue,i.getCommission());//  i.setCommissionValue(uiEty.tcToDble0(tItemCommissionValue));//tItemCommission
    uiEty.objToUi(tItemLocation,i.getLocation());//   i.setLocation(uiEty.cmbtostr(tItemLocation));//tItemLocation   combo   
    uiEty.objToUi(tItemMinimumStock,i.getMinStock());//   i.setMinStock(uiEty.tcToDble0(tItemMinimumStock));//tItemMinimumStock   
    uiEty.objToUi(tItemReOrder,i.getReOrder());//   i.setReOrder(uiEty.tcToDble0(tItemReOrder)); //tItemReOrder
    uiEty.objToUi(tItemTrakSerial,i.getTrackSerial());//   i.setTrackSerial(tItemTrakSerial.isSelected());  //tItemTrakSerial chk
    uiEty.objToUi(tItemTrakExpiry,i.getTrackExpiry());//   i.setTrackExpiry(tItemTrakExpiry.isSelected());  //tItemTrakExpiry chk
    uiEty.objToUi(tItemTrakNonStockItem,i.getNonStockItems());//   i.setNonStockItems(tItemTrakNonStockItem.isSelected());//tItemTrakNonStockItem chk
    uiEty.objToUi(tItemTrakManfctringItem,i.getManufactItem());//   i.setManufactItem(tItemTrakManfctringItem.isSelected());//tItemTrakManfctringItem chk      
    uiEty.objToUi(tItemTrakInactive,i.getInactive());//   i.setInactive(tItemTrakInactive.isSelected());//tItemTrakInactive chk      
    uiEty.objToUi(tWholesalePrice,i.getWholesalePrice());//   i.setWholesalePrice(uiEty.tcToDble0(tWholesalePrice));//tWholesalePrice      
    uiEty.objToUi(tMetaInfo,i.getMetaInfo());//   i.setMetaInfo(tMetaInfo.getText());  //tMetaInfo
    itemVariation2Ui(i.getVariations());//uiEty.objToUi(//   i.setVariations(ui2ItemVariation(tblVariation));            
    extraSalesPrice2Ui(i.getExtrasalespriceCollection());//uiEty.objToUi(//   i.setExtrasalespriceCollection(ui2ExtraSalesPrice(tblPriceRanges));
    //        
            
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    public void itemVariation2Ui(List<ItemVariation> lstOfVariation){
    
        try {
            for (Iterator<ItemVariation> it = lstOfVariation.iterator(); it.hasNext();) {
                ItemVariation i = it.next();

                TableUtil.addrow(tblVariation, new Object[]{i.getDescription(),i.getsPrice1(),i.getsPrice2()});
      
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
   public void extraSalesPrice2Ui(List<ExtraSalesPrice> lstOfExtraPrice){
   
       
        try {
            for (Iterator<ExtraSalesPrice> it = lstOfExtraPrice.iterator(); it.hasNext();) {
                ExtraSalesPrice i = it.next();

                TableUtil.addrow(tblVariation, new Object[]{i.getDescription(),i.getPrice()});
      
            }
        } catch (Exception e) {
        e.printStackTrace();
        } 
       
   }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////
   /////////////////////////////////////////////////////////////////////////////////////////////////
   public void barcode2Ui(List<ItemBarcode> lstOfBarcode){
   
       
        try {
            for (Iterator<ItemBarcode> it = lstOfBarcode.iterator(); it.hasNext();) {
                ItemBarcode i = it.next();

                TableUtil.addrow(tblVariation, new Object[]{i.getType(),i.getBarcode()});
      
            }
        } catch (Exception e) {
        e.printStackTrace();
        } 
       
   }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////

   ///////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    private void cSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSaveBtnActionPerformed
        
 
        try {
     //validate vendor..
     //code
     //description
     //salesprice
            
            if(uiEty.tcToStr(tItemcode)==null || uiEty.tcToStr(tItemcode).equals("")){
           MessageBoxes.wrnmsg(null,"Please Type Item Code","Empty Item Code");                 
                return;
            }
       createDefSupplier("");     
            
            
        Item item=uiToEntity(new Item());
        
        Item exist=itemService.getDao().findItemByCode(item.getCode());
  if(exist==null){
        itemService.getDao().save(item);
        
   }else{
  //item exist so ask user to update ...
      String[] ObjButtons = { "Yes", "No" };
  int PromptResult = JOptionPane.showOptionDialog(null, "Item Already Exist Do You Want to Update it?", "Item Form", -1, 2, null, ObjButtons, ObjButtons[1]);
 
      if (PromptResult == 0) {
     item.setId(exist.getId());
       itemService.getDao().update(item); 
      }
  
  }  
          // addToTable(items);
//        ipu.populateTable(items);
  clearMaster();
        } catch (Exception e) {
        e.printStackTrace();
     MessageBoxes.errormsg(null,e.getMessage(),"Error");
        }
     
          
    }//GEN-LAST:event_cSaveBtnActionPerformed

    private void tItemTrakExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakExpiryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakExpiryActionPerformed

    private void tItemTrakNonStockItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakNonStockItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakNonStockItemActionPerformed

    private void tItemSalesPriceUnit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemSalesPriceUnit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemSalesPriceUnit2ActionPerformed

    private void tUnitItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tUnitItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tUnitItem1ActionPerformed

    private void tItemTrakSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemTrakSerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tItemTrakSerialActionPerformed

    private void tPriceRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPriceRangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPriceRangeActionPerformed

    private void tItemdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemdiscountActionPerformed
        try {
        double dis=uiEty.tcToDble0(tItemdiscount);
     if(dis!=0){
     
     dis=dis/100*uiEty.tcToDble0(tItemSalesPriceUnit1);
     uiEty.objToUi(tItemdiscValue,dis);
        
     }else{
      uiEty.objToUi(tItemdiscValue,"");
    
     }
            
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_tItemdiscountActionPerformed

    private void tItemCommissionValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemCommissionValueActionPerformed
  try {
       double comAmount=uiEty.tcToDble0(tItemCommissionValue);
       if(comAmount!=0){
       
           comAmount=comAmount/uiEty.tcToDble0(tItemSalesPriceUnit1)*100;
      uiEty.objToUi(tItemCommission,comAmount);     
       }else{
        uiEty.objToUi(tItemCommission,"");     
     
       }
                   
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_tItemCommissionValueActionPerformed

    private void tItemdiscValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemdiscValueActionPerformed
        try {
       double disAmount=uiEty.tcToDble0(tItemdiscValue);
       if(disAmount!=0){
       
           disAmount=disAmount/uiEty.tcToDble0(tItemSalesPriceUnit1)*100;
      uiEty.objToUi(tItemdiscount,disAmount);     
       }else{
        uiEty.objToUi(tItemdiscount,"");     
      
       }
                   
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_tItemdiscValueActionPerformed

    private void tItemCommissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemCommissionActionPerformed
                  try {
        double com=uiEty.tcToDble0(tItemCommission);
     if(com!=0){
     
     com=com/100*uiEty.tcToDble0(tItemSalesPriceUnit1);
     uiEty.objToUi(tItemCommissionValue,com);
        
     }else{
       uiEty.objToUi(tItemCommissionValue,"");
   
     }
            
        } catch (Exception e) {
        e.printStackTrace();
        }

    }//GEN-LAST:event_tItemCommissionActionPerformed

    private void tItemSalesPriceUnit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tItemSalesPriceUnit1ActionPerformed
        try {
         if(!uiEty.cmbtostr(tUnitItem2).trim().equals("") && uiEty.tcToDble0(tDifferentPerUnit)>0){
                         
               
           tItemSalesPriceUnit2.setText(""+uiEty.tcToDble0(tItemSalesPriceUnit1)/uiEty.tcToDble0(tDifferentPerUnit));                           
         
  
         } else{
             tItemSalesPriceUnit2.setText("");
                 }    
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tItemSalesPriceUnit1ActionPerformed

    private void tRngeValueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tRngeValueKeyTyped
        try {
            if(evt.getKeyChar()==KeyEvent.VK_ENTER){
        //need to clear table before adding rows....
         addToExtraPriceTbl();   
         tPriceRange.setSelectedItem("");
         tRngeValue.setText("");
      tPriceRange.getEditor().getEditorComponent().requestFocus();  
            
            }
        } catch (Exception e) {
     e.printStackTrace();   }
    }//GEN-LAST:event_tRngeValueKeyTyped

    private void tVariationPrice2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tVariationPrice2KeyTyped
    try {
         
         if(evt.getKeyChar()==KeyEvent.VK_ENTER){
         //need to clear table before adding rows....
         addToVariationTbl();
         
         tVariationName.setSelectedItem("");
         tVariationPrice1.setText("");
         tVariationPrice2.setText("");
         
         tVariationName.getEditor().getEditorComponent().requestFocus();  
         
         }
         
         } catch (Exception e) {
     e.printStackTrace();   }
    }//GEN-LAST:event_tVariationPrice2KeyTyped

    private void cClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cClearActionPerformed
clearMaster();        
    }//GEN-LAST:event_cClearActionPerformed

    private void cDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDeleteBtnActionPerformed
        try {
            
            if(uiEty.tcToStr(tItemcode)==null || uiEty.tcToStr(tItemcode).equals("")){
           MessageBoxes.wrnmsg(null,"Please Type Item Code","Empty Item Code");                 
                return;
            }
             
        Item item=uiToEntity(new Item());
            
       Item exist=itemService.getDao().findItemByCode(item.getCode());
  if(exist!=null){
  itemService.getDao().delete(exist);
  }else{
  MessageBoxes.errormsg(null,"No Item Found.",getTabName());                    
   return;
   
   }  
  clearMaster();
        } catch (Exception e) {
            
    MessageBoxes.errormsg(null,e.getMessage(),getTabName());                    
        }
                
    }//GEN-LAST:event_cDeleteBtnActionPerformed

    private void cCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCloseActionPerformed
      //cal item list form....
        //hide this form
    }//GEN-LAST:event_cCloseActionPerformed

    private void tTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTypeKeyTyped
        try {
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
        
        tItemBarcode.requestFocus();
        }    
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_tTypeKeyTyped

    private void tItemBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tItemBarcodeKeyTyped
        try {
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
   
            addToBarcode();
      tType.setText("");   
      tItemBarcode.setText("");
      tType.requestFocus();
   
        }    
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_tItemBarcodeKeyTyped

    private void tVariationPrice1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tVariationPrice1KeyTyped
       
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
        
        tVariationPrice2.requestFocus();
       
        }
        
    }//GEN-LAST:event_tVariationPrice1KeyTyped

    private void tVariationPrice2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tVariationPrice2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tVariationPrice2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cClear;
    private org.components.controls.CButton cClose;
    private org.components.controls.CButton cDeleteBtn;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CLabel cLabel6;
    private org.components.containers.CPanel cPanel1;
    private org.components.containers.CPanel cPanel2;
    private org.components.containers.CPanel cPanel3;
    private org.components.containers.CPanel cPanel4;
    private org.components.containers.CPanel cPanel5;
    private org.components.controls.CButton cSaveBtn;
    private org.components.controls.CScrollPane cScrollPane1;
    private org.components.util.ComponentFactory componentFactory1;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.components.controls.CTextField tCartonItem;
    private org.components.controls.CTextField tDifferentPerUnit;
    private org.components.controls.CTextField tItemBarcode;
    private org.components.controls.CComboBox tItemCategory;
    private org.components.controls.CTextField tItemCommission;
    private org.components.controls.CTextField tItemCommissionValue;
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
    private org.components.controls.CTextArea tMetaInfo;
    private org.components.controls.CComboBox tPriceRange;
    private org.components.controls.CTextField tRngeValue;
    private org.components.controls.CComboBox tSupplierItem;
    private org.components.controls.CTextField tType;
    private org.components.controls.CComboBox tUnitItem1;
    private org.components.controls.CComboBox tUnitItem2;
    private org.components.controls.CComboBox tVariationName;
    private org.components.controls.CTextField tVariationPrice1;
    private org.components.controls.CTextField tVariationPrice2;
    private org.components.controls.CTextField tWholesalePrice;
    private javax.swing.JTable tblBarcode;
    private javax.swing.JTable tblPriceRanges;
    private javax.swing.JTable tblVariation;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
        return "Item Master";
    }

    @Override
    public JPanel getJPanel() {
        return this; 
    }
    //////////////////////////////////////////////
    public Supplier createDefSupplier(String typedName)throws Exception{
    Supplier s=null;
        try {
            
        } catch (Exception e) {
            
            e.printStackTrace();
                    }
        
        return s;
    }
    //////////////////////////////////////////////////////
    
    
    
    public static void main(String[] args) {
    final JTabbedPane tp = new JTabbedPane();

    // Remove Tab as the focus traversal key - Could always add another key stroke here instead.
    tp.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.<AWTKeyStroke>emptySet());

    KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);

    Action nextTab = new AbstractAction("NextTab") {
        public void actionPerformed(ActionEvent evt) {
            int i = tp.getSelectedIndex();
            tp.setSelectedIndex(i == tp.getTabCount() - 1 ? 0 : i + 1);
        }
    };

    // Register action.
    tp.getActionMap().put("NextTab", nextTab);
    tp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ks, "NextTab");

    tp.addTab("Foo", new JPanel());
    tp.addTab("Bar", new JPanel());
    tp.addTab("Baz", new JPanel());
    tp.addTab("Qux", new JPanel());

    JFrame frm = new JFrame();

    frm.setLayout(new BorderLayout());
    frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frm.add(new JButton(nextTab), BorderLayout.NORTH);
    frm.add(tp, BorderLayout.CENTER);
    frm.setBounds(50,50,400,300);
    frm.setVisible(true);
}

    /**
     * @return the selectedItem
     */
    public Item getSelectedItem() {
        return selectedItem;
    }

    /**
     * @param selectedItem the selectedItem to set
     */
    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }
}
