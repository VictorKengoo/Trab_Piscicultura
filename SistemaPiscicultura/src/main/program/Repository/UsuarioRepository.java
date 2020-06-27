package Repository;

import Interface.EstouraException;
import Models.Usuario;
import Repository.Base.BaseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;

public class UsuarioRepository extends BaseRepository<Usuario> {


    public Usuario getUserByUsername(Usuario user) {
        Session session = sessionFactory.openSession();
        EstouraException EE = new EstouraException();

        try {
            Query query = session.createQuery("FROM Usuario WHERE Usuario = :Usuario");
            query.setParameter("Usuario", user.getUsuario());
            return (Usuario) query.uniqueResult();

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
