package Application;

import Models.Enums.TipoUsuario;
import Models.Peixe;
import Repository.PeixeRepository;

public class PeixeApp extends BaseApp<Peixe> {

    private PeixeRepository _peixeRepository;

    public PeixeApp() { _peixeRepository = new PeixeRepository();}

    public void hasDuplicate(Peixe novo) throws Exception {
        Peixe existente = _peixeRepository.getByName(novo);
        if (existente != null) {
            if ((novo.id != existente.id) && (novo.getEspecie().toLowerCase().trim().equals(existente.getEspecie().toLowerCase().trim()))) {
                throw new Exception("Já existe um registro com esta espécie.");
            }
        }
    }

    public boolean hasPermition(){
        return Session.getInstance().getUsuarioLogado().getTipoUser().equals(TipoUsuario.ADMINISTRADOR.toString());
    }
    public Peixe getById(int id) throws Exception {
        return super.getById("Peixe",id);
    }
}
