package Repository;

import Interface.EstouraException;
import Models.Peixe;
import Repository.Base.BaseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PeixeRepository extends BaseRepository<Peixe> {

    public Peixe getByName(Peixe newPeixe) {
        Session session = sessionFactory.openSession();
        EstouraException EE = new EstouraException();

        try{
            Query query = session.createQuery("FROM Peixe WHERE Especie = :Especie");
            query.setParameter("Especie", newPeixe.getEspecie());
            return (Peixe) query.uniqueResult();

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
