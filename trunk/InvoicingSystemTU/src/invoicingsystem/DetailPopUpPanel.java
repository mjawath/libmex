/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Detail.java
 *
 * Created on Dec 7, 2011, 10:14:09 PM
 */
package invoicingsystem;

import java.awt.KeyboardFocusManager;
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
public abstract class DetailPopUpPanel extends javax.swing.JPanel {

    JTable tbl;
    JTextField textField;
    TableEditor editor;
      int selectedColumn=0;

    /** Creates new form Detail */
    public DetailPopUpPanel(JTable tb, TableEditor field) {
        initComponents();
        tbl = tb;
        editor =field;
        textField = field.getComponent();    
        editor.setMasterTbl(tbl);
        init();
    }

    public DetailPopUpPanel(JTextField field) {
        initComponents();
        textField = field;
        jpm = new CPopupMenu();
        jpm.add(this);

//        this.requestFocusInWindow();
//        cTextField1.requestFocus();

        jpm.setFocusable(false);
     
        init();

    }

    public DetailPopUpPanel() {
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

//        this.requestFocusInWindow();
//        cTextField1.requestFocus();
        jpm.setFocusable(false);
        
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
        System.out.println(" filter this .." + qry);
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

        cLabel1.setText("Popo fff");

        cButton1.setText(">");

        cButton2.setText(">>");

        cButton3.setText(">|");

        cButton4.setText("<");

        cButton5.setText("<<");

        cButton6.setText("|<");

        jScrollPane1.setViewportView(cxTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
        
    void setObjectToTable(List lst) {
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
