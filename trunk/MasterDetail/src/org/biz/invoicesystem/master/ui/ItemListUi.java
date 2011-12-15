
package org.biz.invoicesystem.master.ui;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import org.biz.app.ui.util.TableUtil;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

 
public class ItemListUi extends TabPanelUI   {

    private ItemService itemService;
    
    public ItemListUi() {
        initComponents();
    }

    public void loadItemList2Tbl(){
     
        SwingWorker<List<Item>,Object> sw=new SwingWorker<List<Item>,Object>() {

            @Override
            protected List<Item> doInBackground() throws Exception {
             List<Item> items=getItemService().getDao().getAll();
                return items;
            }

            @Override
            protected void done() {
                try {
                    TableUtil.cleardata(tblItemList);
                    
            List<Item> items=get();   
                    for (Item i : items) {
                    TableUtil.addrowSR(tblItemList,new Object[]{i.getCode(),i.getDescription(),i.getCost(),i.getUnit1SalesPrice(),i.getWholesalePrice()});                            
         
                    }
                           
                } catch (Exception e) {
            e.printStackTrace();
                }
            }
            
            
        };
        
        sw.execute();
                
    
    } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cItmcode = new org.components.controls.CTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemList = new org.components.controls.CxTable();
        cUpdateItemBtn = new org.components.controls.CButton();
        cRefreshItem = new org.components.controls.CButton();
        cDeleteItemBtn = new org.components.controls.CButton();
        cClose = new org.components.controls.CButton();
        cNewItemBtn = new org.components.controls.CButton();
        cButton1 = new org.components.controls.CButton();
        cButton2 = new org.components.controls.CButton();
        cButton3 = new org.components.controls.CButton();
        cButton4 = new org.components.controls.CButton();
        cTextFieldPopUp1 = new org.components.controls.CTextFieldPopUp();

        setLayout(null);

        jLabel1.setText("Item Description Search");
        add(jLabel1);
        jLabel1.setBounds(30, 10, 130, 20);

        cItmcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cItmcodeActionPerformed(evt);
            }
        });
        add(cItmcode);
        cItmcode.setBounds(160, 10, 470, 25);

        tblItemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Description", "Cost Price", "Sales Price", "Wh.Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
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
        tblItemList.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane1.setViewportView(tblItemList);
        tblItemList.getColumnModel().getColumn(0).setMinWidth(85);
        tblItemList.getColumnModel().getColumn(0).setPreferredWidth(85);
        tblItemList.getColumnModel().getColumn(0).setMaxWidth(85);
        tblItemList.getColumnModel().getColumn(1).setMinWidth(200);
        tblItemList.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblItemList.getColumnModel().getColumn(1).setMaxWidth(200);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 760, 278);

        cUpdateItemBtn.setText("Update");
        cUpdateItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUpdateItemBtnActionPerformed(evt);
            }
        });
        add(cUpdateItemBtn);
        cUpdateItemBtn.setBounds(200, 360, 121, 49);

        cRefreshItem.setText("Refresh");
        cRefreshItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cRefreshItemActionPerformed(evt);
            }
        });
        add(cRefreshItem);
        cRefreshItem.setBounds(460, 360, 121, 49);

        cDeleteItemBtn.setText("Delete");
        cDeleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDeleteItemBtnActionPerformed(evt);
            }
        });
        add(cDeleteItemBtn);
        cDeleteItemBtn.setBounds(330, 360, 121, 49);

        cClose.setText("Close");
        cClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCloseActionPerformed(evt);
            }
        });
        add(cClose);
        cClose.setBounds(590, 360, 110, 50);

        cNewItemBtn.setText("New ");
        cNewItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNewItemBtnActionPerformed(evt);
            }
        });
        add(cNewItemBtn);
        cNewItemBtn.setBounds(70, 360, 121, 49);

        cButton1.setText("<");
        add(cButton1);
        cButton1.setBounds(270, 40, 41, 23);

        cButton2.setText("<<");
        add(cButton2);
        cButton2.setBounds(210, 40, 49, 23);

        cButton3.setText(">>");
        add(cButton3);
        cButton3.setBounds(470, 40, 49, 23);

        cButton4.setText(">");
        add(cButton4);
        cButton4.setBounds(420, 40, 41, 23);
        add(cTextFieldPopUp1);
        cTextFieldPopUp1.setBounds(320, 40, 90, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void cUpdateItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUpdateItemBtnActionPerformed
        // call item master form with selected item details to update....
         try {
          
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_cUpdateItemBtnActionPerformed

    private void cRefreshItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cRefreshItemActionPerformed
        //refresh the item list and reinsert item tabl list...
         try {
          
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_cRefreshItemActionPerformed

    private void cDeleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDeleteItemBtnActionPerformed
        //call item master form with selected item to delete the item...
         try {
          
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_cDeleteItemBtnActionPerformed

    private void cCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCloseActionPerformed
        // close this form...
        try {
          
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_cCloseActionPerformed

    private void cItmcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cItmcodeActionPerformed
        // TODO add your handling code here:
         try {
          
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_cItmcodeActionPerformed

    private void cNewItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNewItemBtnActionPerformed
      //calling item master form...
         try {
          
        } catch (Exception e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_cNewItemBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CButton cButton4;
    private org.components.controls.CButton cClose;
    private org.components.controls.CButton cDeleteItemBtn;
    private org.components.controls.CTextField cItmcode;
    private org.components.controls.CButton cNewItemBtn;
    private org.components.controls.CButton cRefreshItem;
    private org.components.controls.CTextFieldPopUp cTextFieldPopUp1;
    private org.components.controls.CButton cUpdateItemBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.components.controls.CxTable tblItemList;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
       return "Customer List";
    }

    @Override
    public JPanel getJPanel() {
    
        return this;    
    }

    /**
     * @return the itemService
     */
    public ItemService getItemService() {
        return itemService;
    }

    /**
     * @param itemService the itemService to set
     */
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}
