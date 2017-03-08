/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.Orm;

import App.Services.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author youpi
 */
abstract public class DaoAbstract {

    static final Session session = HibernateUtil.getSessionFactory().openSession();
    private Class<?> Class;
    protected DaoAbstract(Class <?> Class){
        this.Class = Class;
    }
    protected List getAll() {
        List resultList = null;
        try {
            session.beginTransaction();
            resultList = session.createCriteria(Class).list();
            session.getTransaction().commit();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultList;
    }

    public void create(Object o) {
        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }

    protected void update(Object oldObj, Object newObj) {

    }

    protected void delete(Object obj) {

    }
    
    public List getQuery(String query){
        List resultList = null;
        try {
            session.beginTransaction();
            resultList = session.createQuery(query).list();
            session.getTransaction().commit();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultList;
    }
}
