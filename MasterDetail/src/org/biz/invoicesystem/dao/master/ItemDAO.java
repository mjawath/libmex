 
package org.biz.invoicesystem.dao.master;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.biz.dao.service.GenericDAO;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.Item;
import org.eclipse.persistence.queries.ScrollableCursor;

/**
 *
 * @author mjawath
 */
public class ItemDAO extends GenericDAO<Item>{

    
    public ItemDAO() {
    setCls(Item.class);
    }

     public Item findItemByCode(String itemcode){
     Item i=null;
//        try { 
//ExecuteQuery("");
//   //EntityManager em=createEmNew();
//  
//    //        em.getTransaction().begin();
// List<Item> lst=em.createQuery("select i from item Where i.code=?1").setParameter(1,itemcode).getResultList();
//            for (Item item : lst) {
//           i=item;     
//            }
// 
// em.getTransaction().commit();            
//em.close();
//        } catch (Exception e) {
//             
//        e.printStackTrace();
//        }finally{
//   
//        }
           
   return i;      
    }
    
    
    public void deleteItemByid(String itemid){
     
        try {
Item i=find(itemid);
i.setInactive(true);

   EntityManager em=null;
  
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
  EntityManager em=null;
  
            em.getTransaction().begin();
 lst=em.createQuery("select * From Item ",Item.class).getResultList();
 
em.getTransaction().commit();            
em.close();           
        } catch (Exception e) {
        e.printStackTrace();
        }
        return lst;
        
    }
    public static void main(String[] args) {
        ItemDAO i=new ItemDAO();
       // i.deleteItemByid("1000");
        
//        for(int x=0;x<5000;x++){
//            System.out.println("persist working.....");
//      Item ii=new Item();
//      
//      ii.setId(""+x);
//      ii.setCarton(00d);          
//      ii.setCategory("catt");
//      ii.setCode("erererrrr");
//      ii.setCommission(1000d);
//      ii.setCost(3200d);
//      ii.setDescription("des");
//      ii.setDifferent(7);
//      ii.setDiscount(5d);
//      ii.setUnitOne("ggg");
//      ii.setUnitTwo("dddd");
//      ii.setSalesPrice(600d);
//      ii.setSupplierId("seeeee");
//      
//      i.save(ii);
//              
//              
//              }
      List<Item> lst=i.getIndexItems(0,500);
      List<Item> lst1=i.getIndexItems(501, 1000);
      
        System.out.println("lst 500 item is "+lst.get(499).getId());
        System.out.println("lst 500 item is "+lst1.get(501).getId());
        System.out.println("lst size is "+lst.size());         
        System.out.println("lst size is "+lst1.size());         
    
    }
    
//           Query query = em.createQuery("SELECT e FROM Item e ");
//query.setHint("eclipselink.cursor.scrollable", true);
//ScrollableCursor scrollableCursor = (ScrollableCursor)query.getSingleResult();
////lst= scrollableCursor.next(100); 
//lst= query.getResultList();
//            System.out.println("came here....");
    
    public List<Item> getIndexItems(int strt,int end){
        List<Item> lst=new ArrayList<Item>();
        try {
            EntityManager em=null;
//            
         Query query = em.createQuery("SELECT e FROM Item e order by e.id asc");
 //lst= scrollableCursor.next(100); 
         query.setFirstResult(strt);
         query.setMaxResults(end);
         
lst= query.getResultList();
            System.out.println("came here....");
        } catch (Exception e) {
        
        }
        
        return lst;
    }
     
    
}
