package main.program.Repository;

import main.program.Interface.EstouraException;
import main.program.Models.Usuario;
import main.program.Repository.Base.BaseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.PrintWriter;
import java.io.StringWriter;

public class UsuarioRepository extends BaseRepository<Usuario> {


    public Usuario getUserByUsername(Usuario user){
        Session session = sessionFactory.openSession();
        EstouraException EE = new EstouraException();

        try{
            Query query = session.createQuery("FROM tb_usuarios WHERE username = :username");
            query.setParameter("username", user.getUsuario());
            return (Usuario) query.uniqueResult();

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
