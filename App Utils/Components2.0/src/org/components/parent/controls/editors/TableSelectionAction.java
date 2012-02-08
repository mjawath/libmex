/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import org.biz.app.ui.util.TableUtil;
import org.components.controls.TableEditable;

/**
 *
 * @author nnjj
 */
public class TableSelectionAction {

    JTable tbl;
    public static final int nextcol = -999;
    public static final int newrow = -998;
    public static final int specrow = -997;
    public static final int currow = -996;
    public static final int nextrow = -995;
    Map<Integer, TableSelectionAction> tableactions;

    public TableSelectionAction() {
        tableactions = new HashMap<Integer, TableSelectionAction>();

    }

    public TableSelectionAction(JTable tbl) {
        this.tbl = tbl;
        tableactions = new HashMap<Integer, TableSelectionAction>();

    }

    public TableSelectionAction(JTable tbl, Map<Integer, TableSelectionAction> tableactions) {
        this.tbl = tbl;
        this.tableactions = tableactions;
    }

    public Map<Integer, TableSelectionAction> getTableactions() {
        return tableactions;
    }

    public void addAction(int x, TableSelectionAction action) {
        action.setTbl(tbl);
        tableactions.put(x, action);
    }

    public JTable getTbl() {
        return tbl;
    }

    public void setTbl(JTable tbl) {
        this.tbl = tbl;
    }

    public void selectionAction() {
        int selcol = tbl.getSelectedColumn();
        int selrow = tbl.getSelectedRow();
        int colcount = tbl.getColumnCount();
        int rowcount = tbl.getRowCount();

        if (tableactions != null && !tableactions.isEmpty() && tableactions.get(selcol) != null) {
            TableSelectionAction ta = tableactions.get(selcol);
            if (ta != null) {
                int r = ta.actionPerformed();
                if (r == newrow) {
                    if (((rowcount - 1) == selrow)) { //false normal selection           
                        TableUtil.addnewrow(tbl);
                        ((TableEditable)tbl).getTableSelection().newRowAdded();
                        tbl.changeSelection(selrow + 1, 1, false, false);
                        return;
                    }

                    if (((rowcount - 1) > selrow)) {
                        if (TableUtil.newRowID.equals(TableUtil.getSelectedValue(tbl, 0))) { //false normal selection           
                            TableUtil.addnewrow(tbl);
                            ((TableEditable)tbl).getTableSelection().newRowAdded();
                            tbl.changeSelection(rowcount, 1, false, false);
                            return;
                        }
                        tbl.changeSelection(selrow + 1, 1, false, false);
                        return;
                    }

                }
//                if (r == nextrow) {
//                    tbl.changeSelection(selrow + 1, 1, false, false);
//                    return;
//                }
                if (r == nextcol) {
                    selcol = (colcount - 1) == selcol ? selcol : ++selcol;
                    tbl.changeSelection(selrow, selcol, false, false);
                    return;
                }
                if (r >= 0) {
                    tbl.changeSelection(selrow, r, false, false);
                    return;
                }
                return;

            }
            //Action will return true if it need new row or 
        }

        if (((rowcount - 1) == selrow && selcol == (colcount - 1))) { //false normal selection           
            TableUtil.addrow(tbl, new Object[]{});
            ((TableEditable)tbl).getTableSelection().newRowAdded();
            tbl.changeSelection(selrow + 1, 1, false, false);
            return;
        }

        if (((rowcount - 1) > selrow) && selcol == (colcount - 1)) {
            tbl.changeSelection(selrow + 1, 1, false, false);
            return;
        }
        selcol = (colcount - 1) == selcol ? selcol : ++selcol;
        tbl.changeSelection(selrow, selcol, false, false);

    }
    public void newRowAdded(){
    
    }

    public int actionPerformed() {
        return -11111;
    }

    public boolean rowValid() {
        return true;
    }
    
     public void commitChanges(int sr){
    
    }
}
