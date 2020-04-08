package Repository.Base;

import Models.Entidade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseRepository<T extends Entidade> {

    protected SessionFactory sessionFactory;

    public BaseRepository() {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public T getById(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Id menor ou igual a 0");
        }

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            return (T) session.get(Entidade.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public T add(T entity) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            return null;
        }
    }

    public List<T> list(Class<T> entity) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM " + entity.getSimpleName());
            return (List<T>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    ;

    public void update(T entity) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(T entity) throws Exception {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}

