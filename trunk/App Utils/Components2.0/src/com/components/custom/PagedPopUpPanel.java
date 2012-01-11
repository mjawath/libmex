/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Detail.java
 *
 * Created on Dec 7, 2011, 10:14:09 PM
 */
package com.components.custom;

import java.awt.KeyboardFocusManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.biz.app.ui.util.TableUtil;
import org.components.controls.CPopupMenu;

/**
 *
 * @author nnjj
 */
public abstract class PagedPopUpPanel extends javax.swing.JPanel {

    JTable tbl;
    JTextField textField;
    TableEditor editor;
    int selectedColumn=0;
    String pageKey;

    /** Creates new form Detail */
    public PagedPopUpPanel(JTable tb, TableEditor field) {
        initComponents();
        tbl = tb;
        editor =field;
        textField = field.getComponent();    
        editor.setMasterTbl(tbl);
        init();
    }

    public PagedPopUpPanel(JTextField field) {
        initComponents();
        textField = field;
 
//        this.requestFocusInWindow();
//        cTextField1.requestFocus();
    
      
     
        init();

    }

    public PagedPopUpPanel() {
        initComponents();
        tbl = new JTable();
    }
    JPopupMenu jpm;

    public void showPopUp() {
        try {
          if (!jpm.isVisible()) {
            jpm.setLocation(252, 300);
            jpm.setFocusable(false);
            jpm.show(textField, 30, 30);
            jpm.setFocusable(true);
//              this.setFocusable(true);            
//              tbl.setFocusable(true);
            this.setVisible(true);
            jpm.setVisible(true);
        }  
        } catch (Exception e) {
            
            System.out.println(" --------------   "+e.getMessage());                   
        }
        

    }

    public void init() { 
   
       jpm = new CPopupMenu();
        jpm.add(this);
        this.setSize(600, 300);         
          jpm.setSize(200, 200);
//        this.requestFocusInWindow();
//        cTextField1.requestFocus();
        jpm.setFocusable(false);
        textField.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                
            closePopup();
            }
        
        });
        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {       
                           getSeletedValue();
                           if(editor!=null){
                           editor.stopCellEditing();      
                           }
                           //move table selection
                           
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent(cxTable1, e);
                    e.consume();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent(cxTable1, e);
                    e.consume();
                }
            }
        });
        
        textField.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
               search(textField.getText());             
               showPopUp();
            }

            public void removeUpdate(DocumentEvent e) {
                search(textField.getText());
               showPopUp();
            }

            public void changedUpdate(DocumentEvent e) {
                search(textField.getText());
                showPopUp();
            }
        });
        
        
    }
//serach sort filter cache and within the cache we we do 
    //we find our entity
    public void search(String qry) {

    }

    public void getSeletedValue() {
        selectItem();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cLabel1 = new org.components.controls.CLabel();
        cTextField1 = new org.components.controls.CTextField();
        cButton1 = new org.components.controls.CButton();
        cButton2 = new org.components.controls.CButton();
        cButton3 = new org.components.controls.CButton();
        cButton4 = new org.components.controls.CButton();
        cButton5 = new org.components.controls.CButton();
        cButton6 = new org.components.controls.CButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cxTable1 = new org.components.controls.CxTable();

        setLayout(null);

        cLabel1.setText("Popo fff");
        add(cLabel1);
        cLabel1.setBounds(10, 0, 104, 25);
        add(cTextField1);
        cTextField1.setBounds(163, 31, 42, 25);

        cButton1.setText(">");
        add(cButton1);
        cButton1.setBounds(215, 34, 41, 23);

        cButton2.setText(">>");
        add(cButton2);
        cButton2.setBounds(262, 34, 49, 23);

        cButton3.setText(">|");
        add(cButton3);
        cButton3.setBounds(317, 34, 45, 23);

        cButton4.setText("<");
        add(cButton4);
        cButton4.setBounds(116, 34, 41, 23);

        cButton5.setText("<<");
        add(cButton5);
        cButton5.setBounds(61, 34, 49, 23);

        cButton6.setText("|<");
        add(cButton6);
        cButton6.setBounds(10, 34, 45, 23);

        jScrollPane1.setViewportView(cxTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 68, 510, 300);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CButton cButton2;
    private org.components.controls.CButton cButton3;
    private org.components.controls.CButton cButton4;
    private org.components.controls.CButton cButton5;
    private org.components.controls.CButton cButton6;
    private org.components.controls.CLabel cLabel1;
    private org.components.controls.CTextField cTextField1;
    private org.components.controls.CxTable cxTable1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void selectItem() {
      
        Object ob = TableUtil.getSelectedModelsValueAt(cxTable1, selectedColumn);        
        if(textField instanceof JTextField){
        textField.setText(ob.toString());
        }
        closePopup(); 
        action();
    }
       
    public void closePopup() {
        if (jpm.isVisible()) {
            jpm.setVisible(false);
        }
    }
    public  void action(){
        
        System.out.println("action implemented ......");
    };        
        
    public void setObjectToTable(List lst) {
        addToTable(lst);
    }
     
    public void addToTable(List items) {
        TableUtil.cleardata(cxTable1);
        if (items == null || items.isEmpty()) {
            return;
        }
        for (Object itm : items) {
            addToTable(itm);
        }
        TableUtil.addrow(cxTable1, new Object[]{TableUtil.newRowID, ""});
    }

    public void addToTable(Object item) {
        TableUtil.addrow(cxTable1, data(item) );
    }

    public Object[] data(Object item){
    return null;
    }
}
