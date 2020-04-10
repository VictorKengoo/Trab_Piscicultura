package main.program.Repository.Base;

import main.program.Interface.EstouraException;
import main.program.Models.Entidade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseRepository<T extends Entidade> {

    private EstouraException EE = new EstouraException();
    protected SessionFactory sessionFactory;

    public BaseRepository(){
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public T getById(int Id) throws Exception{
        if(Id <= 0){ EE.RaiseException("Id menor ou igual a 0."); }

        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            return (T) session.get(Entidade.class, Id);

        } catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            EE.RaiseException(errors.toString());

            return null;
        }
    }

    public T add(T entity){
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();

            return entity;

        } catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            EE.RaiseException(errors.toString());

        } finally {
            if(session != null && session.isOpen()){ session.close(); }
            return null;
        }
    }

    public List<T> list(Class<T> entity){
        Session session = sessionFactory.openSession();

        try{
            Query query = session.createQuery("FROM" + entity.getSimpleName());
            return (List<T>) query.getResultList();
        } catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            EE.RaiseException(errors.toString());

            return null;
        } finally{
            if(session != null && session.isOpen()){ session.close(); }
        }
    }

    public void update(T entity){
        Session session = sessionFactory.openSession();

        try{
            session.getTransaction().begin();
            session.update(entity);
            session.getTransaction().commit();

        } catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            EE.RaiseException(errors.toString());

        } finally {
            if(session != null && session.isOpen()){ session.close(); }
        }
    }

    public void delete(int Id, Class<T> entity) throws Exception{
        Session session = sessionFactory.openSession();
        try{
            session.getTransaction().begin();
            session.delete(String.format("FROM %s WHERE Id = %s", entity.getSimpleName(), Id));
            session.getTransaction().commit();

        } catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            EE.RaiseException(errors.toString());

        } finally {
            if(session != null && session.isOpen()){ session.close(); }
        }
    }
}
