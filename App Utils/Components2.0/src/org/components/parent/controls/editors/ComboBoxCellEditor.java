/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author nnjj
 */
public class ComboBoxCellEditor extends AbstractCellEditor
        implements TableCellEditor {

    private JComboBox component;
    private JTable tbl;
    // This method is called when a cell value is edited by the user.

    @Override
    public boolean stopCellEditing() {
//        if (component.getText().equals("abcd") || component.getText().equals("")) {

//            TableColumn tc= masterTbl.getColumnModel().getColumn(selcol); 

        boolean b = false;
        if (isValide()) {
            int selcol = getTbl().getSelectedColumn();
            int selrow = getTbl().getSelectedRow();
            b = super.stopCellEditing();
//            getTbl().changeSelection(selrow, selcol + 1, true, true);
            System.out.println("col" + selcol);
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
        component.addActionListener(new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
//                stopCellEditing();

            }
        });
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
                }
            }
        });
        addCellEditorListener(new CellEditorListener() {

            @Override
            public void editingStopped(ChangeEvent e) {
                boolean b = false;
//        if (isCellValid()) {
                int selcol = tbl.getSelectedColumn();
                int selrow = tbl.getSelectedRow();
//            b = super.stopCellEditing();
                tbl.changeSelection(selrow, selcol+1, true, true);
//tbl.revalidate();
//         }/
//        return b;
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
if (!isSelected) {
            JLabel jl = new JLabel();
            if (value == null) {
                jl.setText("");
            } else {
                jl.setText(value.toString());
            }
            return jl;
        }
        return component;
    }

    @Override
    public Object getCellEditorValue() {
        return component.getEditor().getItem();
    }
}
