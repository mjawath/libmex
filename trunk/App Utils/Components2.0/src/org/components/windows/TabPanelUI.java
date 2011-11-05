package org.components.windows;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TabPanelUI.java
 *
 * Created on Nov 22, 2010, 1:58:08 PM
 */
import java.awt.Component;
import java.awt.Container;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JPanel;
import org.components.util.orgFocusTraversalPolicy;

/**
 *
 * @author mjawath
 */
public abstract class TabPanelUI extends javax.swing.JPanel implements TabChildUI {

    /** Creates new form TabPanelUI */
    public TabPanelUI() {
        initComponents();

    }

    public void init() {
//        Set forwardKeys = getFocusTraversalKeys(
//                KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
//        Set newForwardKeys = new HashSet(forwardKeys);
//        newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
//        newForwardKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, 0));
//        setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
//                newForwardKeys);
//        Set backKeys = getFocusTraversalKeys(
//                KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS);
//        Set backwordKeys = new HashSet(backKeys);
//        backwordKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, 0));
//        setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS,
//                backwordKeys);
        events();
    }

    public void events() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    public abstract String getTabName();

    public abstract JPanel getJPanel();

    public void updateEntityUI() {
    }

    public void release(){

        
    }

    public void setFocusTraverce(Container m, Component... components) {

        Vector<Component> cs = new Vector<Component>();
        cs.addAll(Arrays.asList(components));
        orgFocusTraversalPolicy ftp = new orgFocusTraversalPolicy(cs);
        m.setFocusTraversalPolicy(ftp);
    }

    public void setobj(Object obj) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
