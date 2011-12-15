 
package org.biz.invoicesystem.dao.master;

import java.util.List;
import javax.persistence.EntityManager;
import org.biz.dao.service.GenericDAO;
import org.biz.invoicesystem.entity.master.Item;

/**
 *
 * @author mjawath
 */
public class ItemDAO extends GenericDAO<Item>{

    
    public ItemDAO() {
    setCls(Item.class);
    }

    public void deleteItemByid(String itemid){
     
        try {
Item i=find(itemid);
i.setInactive(true);

   EntityManager em=createEmNew();
  
            em.getTransaction().begin();
 em.merge(i);
 
em.getTransaction().commit();            
em.close();
        } catch (Exception e) {
             
        e.printStackTrace();
        }finally{
   
        }
           
         
    }
    
    
    public List<Item> selectAll(){
        List<Item> lst=null;
        try {
  EntityManager em=createEmNew();
  
            em.getTransaction().begin();
 lst=em.createNamedQuery("select * From Item ",Item.class).getResultList();
 
em.getTransaction().commit();            
em.close();           
        } catch (Exception e) {
        e.printStackTrace();
        }
        return lst;
        
    }
    public static void main(String[] args) {
        ItemDAO i=new ItemDAO();
        i.deleteItemByid("1000");
    }
}
