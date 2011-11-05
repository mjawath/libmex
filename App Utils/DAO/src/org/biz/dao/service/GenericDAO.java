package org.biz.dao.service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.biz.dao.util.EntityService;
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

        String qry = "select c from  " + classname + " c  where c." + property + " ='" + key + "'";
        return ExecuteQuerySR(qry);

    }

    public T getByPropertySR(String property, Number key) {

        String qry = "select c from  " + classname + " c  where c." + property + " =" + key + "";
        return ExecuteQuerySR(qry);

    }

    public T getByPropertySR(String property, String key) {

        String qry = "select c from  " + classname + " c  where c." + property + " ='" + key + "' ";
        return ExecuteQuerySR(qry);

    }

    public List<T> getByProperty(String property, Number key) {

        String qry = "select c from  " + classname + " c  where c." + property + " =" + key + "";
        return ExecuteQuery(qry);

    }

    public List<T> getByProperty(String property, String key) {

        String qry = "select c from  " + classname + " c  where c." + property + " = '" + key + "'";
        return ExecuteQuery(qry);

    }

    public EntityService getES() {
        return EntityService.getEntityService();
    }

    public void findRefresh(Object c, Object key) {
        getEm().find(c.getClass(), key);
        getEm().refresh(c);
    }

    public T deatach(Object c, Object key) {
        T cc = (T) getEm().find(c.getClass(), key);
        getEm().refresh(cc);
        getEm().detach(cc);
        return cc;
    }

//    public T find(Object key ){
//        em.find(T, key);
//        return null;
//    }
    public List<T> getAll() {
//        getEm().clear();
        String order = "";
        if (!orderby.isEmpty()) {
            order = "order by item." + orderby + " ASC";
        }
        Query query = createEmNew().createQuery("select item from " + classname + " item   " + order);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

  
    public void persistob(EntityManager em, Object ob) {
        em.persist(ob);
    }

    public void persist(EntityManager em, Object... ob) {

        for (Object obj : ob) {
            persistob(em, obj);
        }
    }

    public void save(Object... ob) {
        EntityManager em = null;
        try {
            em = createEmNew();
            em.getTransaction().begin();
            persist(em, ob);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                try {
                    em.clear();
                    em.close();
                } catch (Exception e) {
                }

            }
        }

    }

    public void save(T ob) {
        EntityManager em = null;
        try {
            em = createEmNew();
            em.getTransaction().begin();
            persist(em, ob);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                try {
                    em.clear();
                    em.close();
                } catch (Exception e) {
                }

            }
        }
    }

    public void saveList(List<T> ob) {
        EntityManager em = null;
        try {
            em = createEmNew();
            em.getTransaction().begin();
            for (T it : ob) {
                persistob(em, it);
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                try {
                    em.clear();
                    em.close();
                } catch (Exception e) {
                }

            }
        }

    }

    public void remove(EntityManager em, T ob) {
        em.remove(em.merge(ob));
    }

    public void delete(T ob) {
        EntityManager em = null;
        try {
            em = createEmNew();
            em.getTransaction().begin();
            remove(em, ob);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                try {
                    em.clear();
                    em.close();
                } catch (Exception e) {
                }

            }
        }

    }

    public void update(T ob) {
        EntityManager em = null;
        try {
            em = createEmNew();
            em.getTransaction().begin();
            merge(em, ob);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                try {
                    em.clear();
                    em.close();
                } catch (Exception e) {
                }

            }
        }
    }

    public void merge(EntityManager em, T ob) {
        em.merge(ob);
    }

    public void begin() {
        getEm().getTransaction().begin();
    }

    public void commit() {
        getEm().getTransaction().commit();
    }

    public EntityManager createEmNew() {
        em = JPAUtil.getEntityManager();
        return em;
    }

    public Query getQuery(String qryString, boolean ref) {
        Query query = getEm().createQuery(qryString);
        if (ref) {
            refreshOn(query);
        }
        return query;
    }

    public Query getQueryWithClass(String qryString, Class c) {
        return getEm().createQuery(qryString, c);
    }

    public Query getQuery(String qryString) {
        return createEmNew().createQuery(qryString);
    }
//    public Query getQuery(String qryString,List<Parameter> ps){
//        Query q= em.createQuery(qryString);
//        for (Parameter parameter : ps) {
//            q.set
//        }
//        return .;
//    }

    public List<T> ExecuteQuery(String qryString) {
        Query query = getEm().createQuery(qryString, getCls());
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List ts = query.getResultList();
        return ts;
    }

    public List<T> ExecuteQuery(Query qryString) {
        qryString.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<T> ts = qryString.getResultList();
        return ts;
    }

    public T ExecuteQuerySR(String qryString) {

        Query query = getEm().createQuery(qryString, getCls());
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        T ts = null;

        try {
            ts = (T) query.getSingleResult();

        } catch (Exception e) {
            if (e instanceof NoResultException) {
                return null;
            }

        }
        return ts;
    }

    public Object ExecuteQueryOb(String qryString) {
        Object ts = null;
        try {
            Query query = getEm().createQuery(qryString, getCls());
            query.setHint(QueryHints.REFRESH, HintValues.TRUE);
            ts = query.getSingleResult();
        } catch (Exception e) {
            if (e instanceof NoResultException) {
                return null;
            }

        }

        return ts;
    }
//
//    public List<T> ExecuteQuery(Query query, Class<T> cc) {
//        List<T> ts = query.getResultList();
//        return ts;
//    }

    public T ExecuteQuerySR(Query query) {
        T ts = null;
        try {
            query.setHint(QueryHints.REFRESH, HintValues.TRUE);
            ts = (T) query.getSingleResult();

        } catch (Exception e) {
            if (e instanceof NoResultException) {
                return null;
            }
            throw new RuntimeException(e);
        }
        return ts;
    }

    public void refreshOn(Query query) {
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
    }

    public Date currentTime() {
        Date date = (Timestamp) getEm().createNativeQuery("select CURRENT_TIMESTAMP  ").getSingleResult();
        return date;
    }
}
