package Repository;

import Interface.EstouraException;
import Models.Tanque;
import Repository.Base.BaseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TanqueRepository extends BaseRepository<Tanque> {
    public Tanque getByName(Tanque newTanque) {
        Session session = sessionFactory.openSession();
        EstouraException EE = new EstouraException();

        try{
            Query query = session.createQuery("FROM Tanque WHERE NomeTanque = :NomeTanque");
            query.setParameter("NomeTanque", newTanque.getNomeTanque());
            return (Tanque) query.uniqueResult();

        } catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            EE.RaiseException(errors.toString());

            return null;

        } finally{
            if(session != null && session.isOpen()){ session.close(); }
        }
    }
}
