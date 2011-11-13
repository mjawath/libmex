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
import org.biz.invoicesystem.entity.master.Item;
import org.biz.invoicesystem.entity.master.Product;
import org.biz.invoicesystem.entity.master.UOM;
import org.biz.invoicesystem.service.master.CategoryService;
import org.biz.invoicesystem.service.master.ProductService;

import org.components.windows.TabPanelUI;

/**
 *
 * @author mjawath
 */
public class ProductMasterUI extends TabPanelUI {

    List<Product> items;
    ProductService itemService;
    EntityService es;
    ProductPopUp ipu;
    Product selectedItem;
    Category selectedCategory;
    CategoryPopUp cpu;
    List<Category> categorys;
    CategoryService categoryService;

    /** Creates new form ItemMasterUI */
    public ProductMasterUI() {
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
        itemService = new ProductService();
        items = itemService.getDao().getAll();
        ipu = new ProductPopUp(tsearch, items) {

            @Override
            public void action() {
                selectedItem = (Product) ipu.getSelectedItem();
                itemSelectedAction();
            }
        };
        ipu.setSecTable(cxTable1);
//        addToTable(items);
        categoryService = new CategoryService();
        categorys = categoryService.getDao().getAll();
        cpu = new CategoryPopUp(tcate, categorys) {

            @Override
            public void action() {
                selectedCategory = (Category) cpu.getSelectedItem();
            }
        };
        addToTable(items);
        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                if (cxTable1.getSelectedRow() > -1) {
                    selectedItem = null;
                    for (Product item : items) {
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
        cLabel3 = new org.components.controls.CLabel();
        cComboBox1 = new org.components.controls.CComboBox();
        cLabel4 = new org.components.controls.CLabel();
        tsearch = new org.components.controls.CTextField();
        tuom1 = new javax.swing.JTextField();
        cLabel5 = new org.components.controls.CLabel();
        cLabel6 = new org.components.controls.CLabel();
        tuom2 = new javax.swing.JTextField();
        tcate = new org.components.controls.CTextField();
        cLabel7 = new org.components.controls.CLabel();
        tmulti = new javax.swing.JTextField();

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cLabel1.setText("Product code :");

        cLabel2.setText("Product Name");
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

        cLabel3.setText("Invenotry method:");

        cComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FIFO", "LIFO", "AVARAGE" }));

        cLabel4.setText("Description");

        cLabel5.setText("UOM1");

        cLabel6.setText("UOM2");

        cLabel7.setText("Category Code :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tcode, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(cLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(cLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                        .addComponent(cLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tuom1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tuom2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tmulti, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(cLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tcate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tuom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tuom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tmulti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void etyToUI(Product item) {
        uiEty.objToUi(tdescription, item.getDescription());
        uiEty.objToUi(tname, item.getName());
        uiEty.objToUi(tcode, item.getCode());

    }

    public void uiToEty(Product item) {
        item.setName(uiEty.tcToStr(tname));
        item.setCode(uiEty.tcToStr(tcode));
        item.setDescription(uiEty.tcToStr(tdescription));

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (selectedItem != null) {
            Product item = itemService.getDao().deatach(selectedItem, selectedItem.getId());
            uiToEty(item);
            item.setCategory(selectedCategory);
            itemService.getDao().update(item);
            items = itemService.getDao().getAll();
            addToTable(items);
            return;
        }

        Product item = new Product();
        
        item.setId(es.getKey());
        uiToEty(item);
        item.setCategory(selectedCategory);
        setUOMS(selectedItem);
        
        itemService.getDao().save(item);
        items = itemService.getDao().getAll();
        addToTable(items);
        ipu.populateTable(items);

    }//GEN-LAST:event_jButton1ActionPerformed

    public void addToTable(List<Product> items) {
        TableUtil.cleardata(cxTable1);
        for (Product item : items) {
            addToTable(item);
        }
    }

    public void addToTable(Product item) {
        TableUtil.addrow(cxTable1, new Object[]{item.getId(), item.getCode(), item.getName(), item.getDescription()});
    }

    @Override
    public void updateEntityUI() {
        System.out.println("5555555555");
        categorys=categoryService.getDao().getAll();
        cpu.populateTable(categorys);
    }

    @Override
    public String getTabName() {
        return "Item Master";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CComboBox cComboBox1;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.components.controls.CTextField tcate;
    private org.components.controls.CTextField tcode;
    private org.components.controls.CTextField tdescription;
    private javax.swing.JTextField tmulti;
    private org.components.controls.CTextField tname;
    private org.components.controls.CTextField tsearch;
    private javax.swing.JTextField tuom1;
    private javax.swing.JTextField tuom2;
    // End of variables declaration//GEN-END:variables

    private void setUOMS(Product item) {
        UOM uom = new UOM();
        uom.setSimbol(uiEty.tcToStr(tuom1) );
       item.setUnitOne(uom);
        if(!uiEty.tcToStrE(tuom2).isEmpty()){
        UOM uom2 = new UOM();
        uom2.setSimbol(uiEty.tcToStr(tuom2));
        uom2.setMulti(uiEty.tcToDouble(tmulti));
        item.setUnitTwo(uom2);
        }
        
        
        
    }
}
