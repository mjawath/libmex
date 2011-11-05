/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PostedSalesInvoiceUI.java
 *
 * Created on May 25, 2011, 10:12:47 PM
 */
package invoicingsystem.posted;

import invoicingsystem.SalesInvoiceUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.biz.app.ui.util.TableUtil;
import org.biz.invoicesystem.entity.transactions.SalesInvoice;
import org.biz.invoicesystem.service.inventory.InventoryJournalService;
import org.biz.invoicesystem.service.transactions.SalesInvoiceService;
import org.components.util.Sessions;
import org.components.windows.MainWindow;
import org.components.windows.TabPanelUI;

/**
 *
 * @author jawath
 */
public class PostedSalesInvoiceUI extends TabPanelUI {

    List<SalesInvoice> invoices;
    SalesInvoiceService service;
    InventoryJournalService journalService;

    /** Creates new form PostedSalesInvoiceUI */
    public PostedSalesInvoiceUI() {
        initComponents();
        init();
    }

    @Override
    public void init() {
        service = new SalesInvoiceService();
        journalService = new InventoryJournalService();
        invoices = new ArrayList<SalesInvoice>();

        cxTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

            }
        });

        cxTable1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (cxTable1.getSelectedRow() > -1) {

                        Object ob = TableUtil.getSelectedValue(cxTable1, 0);
                        if (ob != null) {
                            for (SalesInvoice salesInvoice : invoices) {
                                if (salesInvoice.getId().equals(ob)) {
                                    openSalesInvoice(salesInvoice);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public void openSalesInvoice(SalesInvoice invoice) {
        MainWindow mw = (MainWindow) Sessions.getObj("mainui");
        mw.addToTabpanelToUI("Invoice master",SalesInvoiceUI.class,invoice );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();
        cDatePicker1 = new org.components.controls.CDatePicker();
        cButton1 = new org.components.controls.CButton();
        cButton2 = new org.components.controls.CButton();

        cxTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cxTable1);
        cxTable1.getColumnModel().getColumn(0).setResizable(false);
        cxTable1.getColumnModel().getColumn(1).setResizable(false);

        cButton1.setText("Search");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });

        cButton2.setText("Delete");
        cButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(cDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed
        //search invoice by query

        Date date = cDatePicker1.getDate();
        System.out.println(date);
//        invoices= service.getDao().getByDay(date);
        invoices = service.getDao().getByDay(date);
        //addto table
        addToTable(invoices);

    }//GEN-LAST:event_cButton1ActionPerformed

    private void cButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton2ActionPerformed
        int sr = cxTable1.getSelectedRow();
        if (sr > -1) {
            String id = (String) cxTable1.getValueAt(sr, 0);
            service.getDao().delete(id);
        }


    }//GEN-LAST:event_cButton2ActionPerformed

    @Override
    public String getTabName() {
        return " Posted Invoices ";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }

    public void addToTable(List<SalesInvoice> invoice) {
        TableUtil.cleardata(cxTable1);
        for (SalesInvoice salesInvoice : invoices) {
            addToTable(salesInvoice);
        }
    }

    public void addToTable(SalesInvoice invoice) {
        TableUtil.addrow(cxTable1, new Object[]{invoice.getId(), invoice.getId()});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CDatePicker cDatePicker1;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
