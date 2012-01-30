/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.components.parent.controls.editors;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import org.biz.app.ui.util.TableUtil;

/**
 *
 * @author nnjj
 */
public class TableSelectionAction {
    
    JTable tbl;
    
    
    Map<Integer ,TableSelectionAction >   tableactions;

    public TableSelectionAction() {
        tableactions =new HashMap<Integer, TableSelectionAction>();        
    
    }

    public TableSelectionAction(JTable tbl, Map<Integer, TableSelectionAction> tableactions) {
        this.tbl = tbl;
        this.tableactions = tableactions;
    }

    public Map<Integer, TableSelectionAction> getTableactions() {
        return tableactions;
    }
    
    
    public void addAction(int x,TableSelectionAction action){
    action.setTbl(tbl);
        tableactions.put(x, action);
    }

    public JTable getTbl() {
        return tbl;
    }

    public void setTbl(JTable tbl) {
        this.tbl = tbl;
    }
    
    
    
    public void selectionAction(){
        System.out.println("---------2222222----");
                int selcol = tbl.getSelectedColumn();
                int selrow = tbl.getSelectedRow();
                int colcount = tbl.getColumnCount();
                int rowcount = tbl.getRowCount();

                
                
                if(tableactions!=null && !tableactions.isEmpty() && tableactions.get(selcol)!=null){
                    System.out.println("----------eeeeeeeeeee---");
                    TableSelectionAction ta= tableactions.get(selcol);
                    if(ta!=null){
                        ta.actionper();
                    }                
                //Action will return true if it need new row or 
                }               
                
                if (((rowcount-1 )==selrow && selcol==(colcount-1)) ) { //false normal selection           
                    TableUtil.addrow(tbl, new Object[]{});                    
                    tbl.changeSelection(selrow+1 , 1, false, false);
                    System.out.println("--------ffffffff-----");
                    return;
                } 
                    
                if (((rowcount-1 ) > selrow) && selcol==(colcount-1)){                
                tbl.changeSelection(selrow+1, 1, false, false);
               System.out.println("----ddddddddd---------");
                return;
                }                
                
                selcol = (colcount - 1) == selcol ? selcol : ++selcol;
                tbl.changeSelection(selrow, selcol, false, false);               
                System.out.println("-------77777777777------");
    }
    
    public int actionper(){
    
        return -1;
    }
    
    
    
}

 class TableAction{
    
    public void action(){
    
        
    }
}