package Interface.Telas;
import Application.MonitoramentoApp;
import Models.Monitoramento;
import Application.BaseApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class EscolheTanqueController implements Initializable{


    public List ids;
    private ObservableList<Monitoramento> obsList;

    @FXML
    private ComboBox<Monitoramento> comboLista;

        public void carregaDados () {
            Monitoramento monitoramento;
            MonitoramentoApp monit = new MonitoramentoApp();


            java.util.List<Monitoramento> dados = monit.getAll(Monitoramento.class);

            for (int i = 0; i < dados.size(); i++) {
                monitoramento = dados.get(i);

            ids.add(monitoramento.getTanqueId());}

            obsList = FXCollections.observableArrayList(ids);
            comboLista.setItems(obsList);
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregaDados();
    }
}
