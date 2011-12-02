/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SupplerMasterUI.java
 *
 * Created on Nov 19, 2011, 12:13:25 AM
 */
package org.biz.invoicesystem.master.ui;

import javax.swing.JPanel;
import org.components.windows.TabPanelUI;

/**
 *
 * @author Administrator
 */
public class SupplerMasterUI extends TabPanelUI {

    /** Creates new form SupplerMasterUI */
    public SupplerMasterUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
       return "Suppler Master";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
}
