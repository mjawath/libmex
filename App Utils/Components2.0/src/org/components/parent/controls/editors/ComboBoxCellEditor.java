/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author nnjj
 */
public class ComboBoxCellEditor extends CellEditor {

    private JComboBox component;
    private JTable tbl;
    // This method is called when a cell value is edited by the user.

    @Override
    public boolean stopCellEditing() {
        boolean b = false;
        if (isCellValid()) {
            b = super.stopCellEditing();
        }
        return b;
    }

    public ComboBoxCellEditor() {

//        super(new JComboBox());
        init();


    }

    public JTable getTbl() {
        return tbl;
    }

    public void setTbl(JTable tbl) {
        this.tbl = tbl;
    }

    public boolean isValide() {
        return true;
    }

    public ComboBoxCellEditor(JTable tbl) {
        init();
//        super(new JComboBox());
//        component = (JComboBox) getComponent();
//        component.setEditable(true);
        component.setModel(new DefaultComboBoxModel(new Object[]{"150", "250", "3650"}));
        //  component.getEditor().addActionListener(new AbstractAction() {
        
        this.tbl = tbl;
//        init();

    }

    public boolean isCellValid() {
        return true;
    }

    private void init() {
        //specify
        component = new JComboBox();
//        component.setEditable(true);
//       ComponentFactory.createDouble(component);
//        component.getEditor().addActionListener(new AbstractAction() {
//
//            public void actionPerformed(ActionEvent e) {
//                stopCellEditing();
//            }
//        });
        component.setEditable(true);
        component.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    stopCellEditing();
                    System.out.println(" "+e);
                }
            }
        });
        component.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {              
               if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   System.out.println(" "+e);
                   
              } 
            }
        });

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        return component;
    }

    @Override
    public Object getCellEditorValue() {
        return component.getEditor().getItem();
    }

    @Override
    public JComponent getComponent() {
        return component;
    }
}
