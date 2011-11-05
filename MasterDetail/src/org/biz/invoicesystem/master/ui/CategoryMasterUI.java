/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ItemMasterUI.java
 *
 * Created on 07-Apr-2011, 22:15:01
 */
package org.biz.invoicesystem.master.ui;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.Category;
import org.biz.invoicesystem.service.master.CategoryService;

import org.components.windows.TabPanelUI;

/**
 *
 * @author mjawath
 */
public class CategoryMasterUI extends TabPanelUI {

    List<Category> items;
    CategoryService itemService;
    EntityService es;
    CategoryPopUp ipu;
    Category selectedItem;

    /** Creates new form ItemMasterUI */
    public CategoryMasterUI() {
        initComponents();

        new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {                
                init();
                return null;
            }
        }.execute();
    }

    @Override
    public void init() {
        es = EntityService.getEntityService();
        itemService = new CategoryService();
        items = itemService.getDao().getAll();
        ipu = new CategoryPopUp(tsearch, items) {

            @Override
            public void action() {
                selectedItem = (Category) ipu.getSelectedItem();
                itemSelectedAction();
            }
        };
        ipu.setSecTable(cxTable1);
//        addToTable(items);

        addToTable(items);
        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                if (cxTable1.getSelectedRow() > -1) {
                    selectedItem = null;
                    for (Category item : items) {
                        Object rowid = TableUtil.rowID(cxTable1);
                        if (rowid != null) {
                            if (item.getId().equals(rowid)) {
                                selectedItem = item;
                                etyToUI(selectedItem);
                                return;
                            }
                        }
                    }                                    
                }
            }
        });
    }

    public void itemSelectedAction() {
        etyToUI(selectedItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cLabel1 = new org.components.controls.CLabel();
        tcode = new org.components.controls.CTextField();
        cLabel2 = new org.components.controls.CLabel();
        tname = new org.components.controls.CTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        tdescription = new org.components.controls.CTextField();
        cLabel4 = new org.components.controls.CLabel();
        tsearch = new org.components.controls.CTextField();

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cLabel1.setText("Item code :");

        cLabel2.setText("Item Name:");
        cLabel2.setFont(new java.awt.Font("Calibri", 1, 14));

        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Code", "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cxTable1);
        cxTable1.getColumnModel().getColumn(0).setResizable(false);
        cxTable1.getColumnModel().getColumn(1).setResizable(false);
        cxTable1.getColumnModel().getColumn(2).setResizable(false);
        cxTable1.getColumnModel().getColumn(3).setResizable(false);

        cLabel4.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGap(19, 19, 19)
                        .addComponent(cLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(361, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void etyToUI(Category item) {
        uiEty.objToUi(tdescription, item.getDescription());
        uiEty.objToUi(tname, item.getName());
        uiEty.objToUi(tcode, item.getCode());
        
    }

    public void uiToEty(Category item) {
        item.setName(uiEty.tcToStr(tname));
        item.setCode(uiEty.tcToStr(tcode));
        item.setDescription(uiEty.tcToStr(tdescription));

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed


        if (selectedItem != null) {
            Category item = itemService.getDao().deatach(selectedItem, selectedItem.getId());
            uiToEty(item);
            itemService.getDao().update(item);
            items = itemService.getDao().getAll();
            addToTable(items);
            return;
        }

        Category item = new Category();
        item.setId(es.getKey());
        uiToEty(item);
        itemService.getDao().save(item);
        items = itemService.getDao().getAll();
        addToTable(items);
        ipu.populateTable(items);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void addToTable(List<Category> items) {
        TableUtil.cleardata(cxTable1);
        for (Category item : items) {
            addToTable(item);
        }
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    public void addToTable(Category item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getCode(), item.getName(), item.getDescription()});
    }

    @Override
    public String getTabName() {
        return "Category Master";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.components.controls.CTextField tcode;
    private org.components.controls.CTextField tdescription;
    private org.components.controls.CTextField tname;
    private org.components.controls.CTextField tsearch;
    // End of variables declaration//GEN-END:variables
}
