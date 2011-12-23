
package org.biz.invoicesystem.dao.master;

import java.util.List;
import javax.persistence.EntityManager;
import org.biz.dao.service.GenericDAO;
import org.biz.invoicesystem.entity.master.Customer;

 
public class CustomerDAO extends GenericDAO<Customer>{

    
    public CustomerDAO() {
    setCls(Customer.class);
    }

 public Customer findCustomerByCode(String customercode){
     Customer i=null;
        try { 
//ExecuteQuery("");
    
   List<Customer> lst=ExecuteQuery("select i from Customer i Where i.code= '"+customercode+"'");
            for (Customer c : lst) {
           i=c;     
            }
 
        } catch (Exception e) {
             
        e.printStackTrace();
        }finally{
   
        }
           
   return i;      
    }
}
