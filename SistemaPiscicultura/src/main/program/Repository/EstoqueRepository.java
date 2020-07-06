package Repository;

import Interface.EstouraException;
import Models.Estoque;
import Repository.Base.BaseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;

public class EstoqueRepository extends BaseRepository<Estoque> {

    public Estoque getByName(Estoque newItem) {
        Session session = sessionFactory.openSession();
        EstouraException EE = new EstouraException();

        try {
            Query query = session.createQuery("FROM Estoque WHERE Marca = :Marca");
            query.setParameter("Marca", newItem.getMarca());
            return (Estoque) query.uniqueResult();

        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            EE.RaiseException(errors.toString());

            return null;

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
