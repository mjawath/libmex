package org.biz.dao.service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.dao.util.JPAUtil;

/**
 *
 * @author mjawath
 */
public class GenericDAO<T> {

    public static void main(String[] args) {
        GenericDAO aO = new GenericDAO();

    }
    private EntityManager em;
    String classname;
    Class<T> cls;
    String orderby = "";

    public GenericDAO(EntityManager em) {
        this.em = em;
    }

    public GenericDAO() {
        em = JPAUtil.getEntityManager();
    }

    public void setCls(Class<T> cls) {
        this.cls = cls;
        this.classname = cls.getSimpleName();
    }

    public Class<T> getCls() {
        return cls;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassname() {
        return classname;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public T find(Object key) {
        return (T) getEm().find(getCls(), key);

    }

    public T getWhere(String property, Object key) {

        return GenericDAOUtil.getWhere(property, key, cls);

    }

    public T getByPropertySR(String property, Number key) {

        return GenericDAOUtil.getByPropertySR(property, key, cls);

    }

    public T getByPropertySR(String property, String key) {
        return GenericDAOUtil.getByPropertySR(property, key, cls);

    }

    public List<T> getByProperty(String property, Number key) {
        return GenericDAOUtil.getByProperty(property, key, cls);

    }

    public List<T> getByProperty(String property, String key) {
        return GenericDAOUtil.getByProperty(property, key, cls);

    }

//    public T find(Object key ){
//        em.find(T, key);
//        return null;
//    }
    //use to retreve every objects database contains
    //dont be dum to use it when u hav 10000 of records
    public List<T> getAll() {
//        getEm().clear();
        return GenericDAOUtil.getAll(orderby, cls);
    }
    // save array of objects may be used to persist different kind of objects
    // eg car , dog ,customer in same time 

    public void save(Object... ob) {
        GenericDAOUtil.save(ob);
    }

//save a single object 
    public void save(T ob) {
        GenericDAOUtil.save(ob);
    }

    //save list of items
    public void saveList(List<T> ob) {
        GenericDAOUtil.save(ob);
    }

    //use this to delete a certain object 
    //@param is a rerieved object from database with a valid id
    public void delete(T ob) {
        GenericDAOUtil.delete(ob);
    }
//may be used to update a database entity

    public void update(T ob) {
        GenericDAOUtil.update(ob);
    }
//may be used to merge objects

    public void merge(EntityManager em, T ob) {
        em.merge(ob);
    }

    //use  this to execute the query 
    //@param query object
    public List<T> ExecuteQuery(Query qryString) {
        List<T> ts = GenericDAOUtil.ExecuteQuery(qryString);
        return ts;
    }

    //use  this to execute the query  string
    //@param query object is a string of jpql
    public List<T> ExecuteQuery(String qryString) {
        return GenericDAOUtil.ExecuteQuery(qryString, cls);
    }

    public T ExecuteQuerySR(String qryString) {

        return GenericDAOUtil.ExecuteQuerySR(qryString, cls);
    }

    public Object ExecuteQueryOb(String qryString) {

        return GenericDAOUtil.ExecuteQuerySR(qryString, cls);
    }
      
    
    public static<T>  T deatach(Object c, Object key) {
      
        T cc = (T)GenericDAOUtil.deatach(c, key);
        return cc;
    }
    /*
    ///////////////
    //
    T ->
     * retruns the unique  type querys with the 
    <T ->
    /////////
     * 
     */
}
