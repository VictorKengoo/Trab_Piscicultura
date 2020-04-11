package Repository;

import Repository.Base.BaseRepository;
import org.hibernate.Session;
import Models.Monitoramento;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitoramentoRepository extends BaseRepository<Monitoramento> {

    public List<Monitoramento> listTOP(){
        Session session = sessionFactory.openSession();

        try{
            List<Object> listaObjeto = session.createQuery("tanqueId,temperatura,ph,logdata FROM " +
                    "  ( SELECT *," +
                    "           ROW_NUMBER() OVER (PARTITION BY tanqueId" +
                    "                              ORDER BY id DESC" +
                    "                             )" +
                    "             AS rn" +
                    "    FROM Monitoramento" +
                    "  ) tmp " +
                    "WHERE rn <= 1" +
                    "ORDER BY tanqueId, rn;").list();
            List<Monitoramento> monitoramentoList = new ArrayList<Monitoramento>();

            for (Object object : listaObjeto){
                Object[] result = (Object[]) object;
                Monitoramento linha = new Monitoramento();
                linha.setTanqueId((Integer) result[0]);
                linha.setTemperatura((Double) result[1]);
                linha.setPh((Double) result[2]);
                linha.setLogData((Date) result[2]);
                monitoramentoList.add(linha);
            }
            return monitoramentoList;

        } catch (Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));

            return null;
        } finally{
            if(session != null && session.isOpen()){ session.close(); }
        }
    }
}
