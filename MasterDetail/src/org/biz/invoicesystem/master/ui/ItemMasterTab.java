 
package org.biz.invoicesystem.master.ui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.ExtraSalesPrice;
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.entity.master.ItemVariation;
import org.biz.invoicesystem.service.master.ItemService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author Administrator
 */
public class ItemMasterTab extends TabPanelUI {

     
    List<Item> items;
    ItemService itemService;
    EntityService es;
    ItemPopUp ipu;
    Item selectedItem;
      public ItemMasterTab() {
        initComponents();
   init();
      }
  //////////////////////////////////////////////////
      public void fillItemTbl(){
      TableUtil.cleardata(tblItemList);
      
          try {
          items=itemService.getDao().selectAll();   
              for (Item i : items) {
    TableUtil.addrow(tblItemList, new Object[]{i.getCode(),i.getDescription(),i.getCost(),i.getSalesPrice(),i.getWholesalePrice()});                                
              }
          
          
          } catch (Exception e) {
          e.printStackTrace();
          }
           
      }
      
 /////////////////////////////////////////////////////     
      
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tItemDescription = new org.components.controls.CTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cItmcode = new org.components.controls.CTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblItemList = new org.components.controls.CxTable();
        cUpdateItemBtn = new org.components.controls.CButton();
        cRefreshItem = new org.components.controls.CButton();
        cDeleteItemBtn = new org.components.controls.CButton();
        cClose1 = new org.components.controls.CButton();
        cNewItemBtn = new org.components.controls.CButton();
        jPanel5 = new javax.swing.JPanel();
        itemMasterUI21 = new org.biz.invoicesystem.master.ui.ItemMasterUI2();

        jPanel4.setLayout(null);

        jLabel5.setText("Item Description Search");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(30, 10, 130, 20);

        cItmcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cItmcodeActionPerformed(evt);
            }
        });
        jPanel4.add(cItmcode);
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
        jScrollPane5.setViewportView(tblItemList);

        jPanel4.add(jScrollPane5);
        jScrollPane5.setBounds(10, 47, 760, 278);

        cUpdateItemBtn.setText("Update");
        cUpdateItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUpdateItemBtnActionPerformed(evt);
            }
        });
        jPanel4.add(cUpdateItemBtn);
        cUpdateItemBtn.setBounds(200, 340, 121, 49);

        cRefreshItem.setText("Refresh");
        cRefreshItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cRefreshItemActionPerformed(evt);
            }
        });
        jPanel4.add(cRefreshItem);
        cRefreshItem.setBounds(460, 340, 121, 49);

        cDeleteItemBtn.setText("Delete");
        cDeleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDeleteItemBtnActionPerformed(evt);
            }
        });
        jPanel4.add(cDeleteItemBtn);
        cDeleteItemBtn.setBounds(330, 340, 121, 49);

        cClose1.setText("Close");
        cClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cClose1ActionPerformed(evt);
            }
        });
        jPanel4.add(cClose1);
        cClose1.setBounds(590, 340, 110, 50);

        cNewItemBtn.setText("New ");
        cNewItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNewItemBtnActionPerformed(evt);
            }
        });
        jPanel4.add(cNewItemBtn);
        cNewItemBtn.setBounds(70, 340, 121, 49);

        jTabbedPane1.addTab("2", jPanel4);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("1", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cNewItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNewItemBtnActionPerformed
        //calling item master form...
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_cNewItemBtnActionPerformed

    private void cClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cClose1ActionPerformed
        // close this form...
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_cClose1ActionPerformed

    private void cDeleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDeleteItemBtnActionPerformed
        //call item master form with selected item to delete the item...
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_cDeleteItemBtnActionPerformed

    private void cRefreshItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cRefreshItemActionPerformed
        //refresh the item list and reinsert item tabl list...
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_cRefreshItemActionPerformed

    private void cUpdateItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUpdateItemBtnActionPerformed
        // call item master form with selected item details to update....
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_cUpdateItemBtnActionPerformed

    private void cItmcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cItmcodeActionPerformed
        // TODO add your handling code here:
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
}//GEN-LAST:event_cItmcodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cClose1;
    private org.components.controls.CButton cDeleteItemBtn;
    private org.components.controls.CTextField cItmcode;
    private org.components.controls.CButton cNewItemBtn;
    private org.components.controls.CButton cRefreshItem;
    private org.components.controls.CButton cUpdateItemBtn;
    private org.biz.invoicesystem.master.ui.ItemMasterUI2 itemMasterUI21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.components.controls.CTextField tItemDescription;
    private org.components.controls.CxTable tblItemList;
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
