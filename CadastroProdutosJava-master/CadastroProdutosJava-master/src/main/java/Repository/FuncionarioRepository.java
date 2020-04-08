package Repository;

import Models.Funcionario;
import Repository.Base.BaseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class FuncionarioRepository extends BaseRepository<Funcionario> {

    public Funcionario getFuncByUsername(Funcionario func) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("FROM Funcionario WHERE username = :username");
            query.setParameter("username", func.getUsername());
            return (Funcionario) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
