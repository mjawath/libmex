/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package invoicingsystem;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import org.components.util.ComponentFactory;

/**
 *
 * @author nnjj
 */
public class ComboBoxCellEditor extends AbstractCellEditor
        implements TableCellEditor{

    JComboBox component;
    
    // This method is called when a cell value is edited by the user.

 

    @Override
    public boolean stopCellEditing() {
//        if (component.getText().equals("abcd") || component.getText().equals("")) {
     
//            TableColumn tc= masterTbl.getColumnModel().getColumn(selcol); 
                 boolean b = super.stopCellEditing();

            return b;
//        }
//
//        return false;
    }

    public ComboBoxCellEditor() {
        init();

    }

    
    private void init() {
        //specify
       component = new JComboBox();   
       component.setEditable(true);
//       ComponentFactory.createDouble(component);
       component.getEditor().addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                stopCellEditing();
            }
       });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        // 'value' is value contained in the cell located at (rowIndex, vColIndex)

        if (isSelected) {
            // cell (and perhaps other cells) are selected
        }
        // Configure the component with the specified value
        ((JComboBox) component).getEditor().setItem("");
        ((JComboBox) component).getEditor().selectAll();

        // Return the configured component
        return component;
    }

    // This method is called when editing is completed.
    // It must return the new value to be stored in the cell.
    public Object getCellEditorValue() {
        String s=(String) ((JComboBox) component).getSelectedItem();
     if(s!=""){
        Double dd =   new Double((s));
       return dd;
     }
     return s;
    }

    public JComboBox getComponent() {
        return component;
    }

    
}
