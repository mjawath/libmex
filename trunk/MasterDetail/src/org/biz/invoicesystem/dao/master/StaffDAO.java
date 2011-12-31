
package org.biz.invoicesystem.dao.master;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.biz.dao.service.GenericDAO;
import org.biz.invoicesystem.entity.master.Customer;
import org.biz.invoicesystem.entity.master.Staff;

 
public class StaffDAO extends GenericDAO<Staff>{

    
    public StaffDAO() {
    setCls(Staff.class);
    }

    public List loadComboItems(){
    
    List lst=new ArrayList<Object>();
    //   EntityManager em=createEmNew();
        try {
    lst=ExecuteQuery("select  c.type , c.religion , c.title From Staff c ");      
     
            System.out.println("lst size "+lst.size());                 
        } catch (Exception e) {
            e.printStackTrace();
        }
    return lst;
    }
    
 public Staff findStaffByCode(String customercode){
     Staff i=null;
        try { 
//ExecuteQuery("");
    
   List<Staff> lst=ExecuteQuery("select i from Staff i Where i.code= '"+customercode+"'");
            for (Staff c : lst) {
           i=c;     
            }
 
        } catch (Exception e) {
             
        e.printStackTrace();
        }finally{
   
        }
           
   return i;      
    }
 
 
    public static void main(String[] args) {
        try {
     StaffDAO g=new StaffDAO();
     
     g.loadComboItems();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
