package Interface.Telas;


import Application.MonitoramentoApp;
import Application.TanqueApp;
import Interface.Utils;
import Models.Monitoramento;
import Models.Tanque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
<<<<<<< HEAD
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;


import java.net.URL;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
=======
import javafx.scene.layout.Pane;

import java.net.URL;
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
import java.util.ResourceBundle;

public class HistoryDataController implements Initializable {

    @FXML
    private ComboBox<String> cmbTanques;
    @FXML
    private Pane paneView1;
    @FXML
    private Pane paneView2;

    ObservableList<String> tanquesList = FXCollections.observableArrayList();

    Map<String, Integer> mapNameTanqueToIdTanque = new HashMap<String, Integer>();

    Utils utils = new Utils();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TanqueApp tanqueApp = new TanqueApp();

        for (Tanque tanque : tanqueApp.getAll(Tanque.class)) {
            tanquesList.add(tanque.getNomeTanque());
            mapNameTanqueToIdTanque.put(tanque.getNomeTanque(), tanque.id);
        }
        cmbTanques.setItems(tanquesList);
        loadDatapH();
        loadDataTemp();
    }

    public void callGetCurrentHistoryData(ActionEvent event) throws Exception {

        MonitoramentoApp monitoramentoApp = new MonitoramentoApp();

        ObservableList<Monitoramento> listCurrentMonitoramentoData;

        listCurrentMonitoramentoData = monitoramentoApp.getCurrentHistoryData(mapNameTanqueToIdTanque, cmbTanques.getValue(), monitoramentoApp);

        updateDatapH(listCurrentMonitoramentoData);
        updateDataTemp(listCurrentMonitoramentoData);
    }

<<<<<<< HEAD
    private void loadDatapH()
    {
=======
    private void loadDatapH() {
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        paneView1.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1, 30, 1);
        xAxis.setLabel("Dias");
        NumberAxis yAxis = new NumberAxis(0, 14, 0.5);
        yAxis.setLabel("pH");
        LineChart<Number, Number> markChart = new LineChart(xAxis, yAxis);
        markChart.setTitle("pH do tanque nos últimos 30 dias");
        XYChart.Series series = new XYChart.Series();
        series.setName("pH");
<<<<<<< HEAD
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView1.getChildren().add(markChart);
    }

    private void loadDataTemp()
    {
        paneView2.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1,30,1);
        xAxis.setLabel("Dias");
        NumberAxis yAxis = new NumberAxis(1,40,2);
        yAxis.setLabel("Temperatura");;
        LineChart<Number,Number> markChart = new LineChart(xAxis,yAxis);
        markChart.setTitle("Temperatura do tanque nos últimos 30 dias");
        XYChart.Series series = new XYChart.Series();
        series.setName("Temperatura");
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView2.getChildren().add(markChart);
    }

    private void updateDatapH(ObservableList<Monitoramento> currentList) throws ParseException {
        paneView1.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1,30,1);
        xAxis.setLabel("Dias");
        NumberAxis yAxis = new NumberAxis(0,14,0.5);
        yAxis.setLabel("pH");;
        LineChart<Number,Number> markChart = new LineChart(xAxis,yAxis);
        markChart.setTitle("pH do tanque nos últimos 30 dias");
        XYChart.Series series = new XYChart.Series();
        series.setName("pH");
        for (Monitoramento dados : currentList) {
            System.out.println("DATA TYPE: "+dados.getLogData());
            series.getData().add(new XYChart.Data<>(utils.getDays(dados.getLogData()),dados.getPh()));
            //series.getData().add(new XYChart.Data<>(contador,dados.getPh()));
        }
        /*series.getData().add(new XYChart.Data<>(0,0));
        series.getData().add(new XYChart.Data<>(1,5));
        series.getData().add(new XYChart.Data<>(2,6));
        series.getData().add(new XYChart.Data<>(3,6.4));
        series.getData().add(new XYChart.Data<>(4,4));
        series.getData().add(new XYChart.Data<>(5,5));
        series.getData().add(new XYChart.Data<>(6,6));
        series.getData().add(new XYChart.Data<>(7,6.4));
        series.getData().add(new XYChart.Data<>(8,7));
        series.getData().add(new XYChart.Data<>(9,5));
        series.getData().add(new XYChart.Data<>(10,6));
        series.getData().add(new XYChart.Data<>(11,6.4));
        series.getData().add(new XYChart.Data<>(12,2));
        series.getData().add(new XYChart.Data<>(13,5));
        series.getData().add(new XYChart.Data<>(14,6));
        series.getData().add(new XYChart.Data<>(15,6.4));*/
=======
        series.getData().add(new XYChart.Data<>(0, 0));
        series.getData().add(new XYChart.Data<>(1, 5));
        series.getData().add(new XYChart.Data<>(2, 6));
        series.getData().add(new XYChart.Data<>(3, 6.4));
        series.getData().add(new XYChart.Data<>(4, 4));
        series.getData().add(new XYChart.Data<>(5, 5));
        series.getData().add(new XYChart.Data<>(6, 6));
        series.getData().add(new XYChart.Data<>(7, 6.4));
        series.getData().add(new XYChart.Data<>(8, 7));
        series.getData().add(new XYChart.Data<>(9, 5));
        series.getData().add(new XYChart.Data<>(10, 6));
        series.getData().add(new XYChart.Data<>(11, 6.4));
        series.getData().add(new XYChart.Data<>(12, 2));
        series.getData().add(new XYChart.Data<>(13, 5));
        series.getData().add(new XYChart.Data<>(14, 6));
        series.getData().add(new XYChart.Data<>(15, 6.4));
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView1.getChildren().add(markChart);

    }
<<<<<<< HEAD
    private void updateDataTemp(ObservableList<Monitoramento> currentList) throws ParseException {
=======

    private void loadDataTemp() {
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        paneView2.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1, 30, 1);
        xAxis.setLabel("Dias");
        NumberAxis yAxis = new NumberAxis(1, 40, 2);
        yAxis.setLabel("Temperatura");
        LineChart<Number, Number> markChart = new LineChart(xAxis, yAxis);
        markChart.setTitle("Temperatura do tanque nos últimos 30 dias");
        XYChart.Series series = new XYChart.Series();
        series.setName("Temperatura");
<<<<<<< HEAD
        for (Monitoramento dados : currentList) {
            series.getData().add(new XYChart.Data<>(utils.getDays(dados.getLogData()),dados.getTemperatura()));
            //series.getData().add(new XYChart.Data<>(contador ,dados.getTemperatura()));
        }
        /*series.getData().add(new XYChart.Data<>(0,20));
        series.getData().add(new XYChart.Data<>(1,25));
        series.getData().add(new XYChart.Data<>(2,26));
        series.getData().add(new XYChart.Data<>(3,26.4));
        series.getData().add(new XYChart.Data<>(4,24));
        series.getData().add(new XYChart.Data<>(5,25));
        series.getData().add(new XYChart.Data<>(6,12));
        series.getData().add(new XYChart.Data<>(7,16.4));
        series.getData().add(new XYChart.Data<>(8,17));
        series.getData().add(new XYChart.Data<>(9,15));
        series.getData().add(new XYChart.Data<>(10,16));
        series.getData().add(new XYChart.Data<>(11,26.4));
        series.getData().add(new XYChart.Data<>(12,32));
        series.getData().add(new XYChart.Data<>(13,35));
        series.getData().add(new XYChart.Data<>(14,36));
        series.getData().add(new XYChart.Data<>(15,36.4));*/
=======
        series.getData().add(new XYChart.Data<>(0, 20));
        series.getData().add(new XYChart.Data<>(1, 25));
        series.getData().add(new XYChart.Data<>(2, 26));
        series.getData().add(new XYChart.Data<>(3, 26.4));
        series.getData().add(new XYChart.Data<>(4, 24));
        series.getData().add(new XYChart.Data<>(5, 25));
        series.getData().add(new XYChart.Data<>(6, 12));
        series.getData().add(new XYChart.Data<>(7, 16.4));
        series.getData().add(new XYChart.Data<>(8, 17));
        series.getData().add(new XYChart.Data<>(9, 15));
        series.getData().add(new XYChart.Data<>(10, 16));
        series.getData().add(new XYChart.Data<>(11, 26.4));
        series.getData().add(new XYChart.Data<>(12, 32));
        series.getData().add(new XYChart.Data<>(13, 35));
        series.getData().add(new XYChart.Data<>(14, 36));
        series.getData().add(new XYChart.Data<>(15, 36.4));
>>>>>>> f9c76c88962873aaeb646bef4cfdd1676d5bfbb4
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView2.getChildren().add(markChart);
    }
}
