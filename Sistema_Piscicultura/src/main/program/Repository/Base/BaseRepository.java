package main.program.Repository.Base;

import main.program.Interface.EstouraException;
import main.program.Models.Entidade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseRepository<T extends Entidade> {

    EstouraException EE = new EstouraException();
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
}
