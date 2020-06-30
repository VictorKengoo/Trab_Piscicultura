package Interface.Telas;
import Application.MonitoramentoApp;
import Models.Monitoramento;
import Application.BaseApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HistoryDataController implements Initializable {

    @FXML
    private Pane paneView1;
    @FXML
    private Pane paneView2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDatapH();

        loadDataTemp();


    }
    private void loadDatapH(){
        paneView1.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1,15,1);
        xAxis.setLabel("Registros (do mais antigo ao mais atual)");
        NumberAxis yAxis = new NumberAxis(0,14,0.5);
        yAxis.setLabel("pH");;
        LineChart<Number,Number> markChart = new LineChart(xAxis,yAxis);
        markChart.setTitle("Últimos 15 registros do pH do tanque");
        XYChart.Series series = new XYChart.Series();
        series.setName("pH");
        MonitoramentoApp monit = new MonitoramentoApp();
        java.util.List<Monitoramento> dados = monit.getAll(Monitoramento.class);
        int count = dados.size();

        for (int i =14; i > 0; i--) {
            Monitoramento monitoramento1;
            monitoramento1 = dados.get(count-i);
            int posicao = monitoramento1.id;
            double peaga = monitoramento1.getPh();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String data = formatter.format(monitoramento1.getLogData());


            series.getData().add(new XYChart.Data<>(posicao, peaga));
        }
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView1.getChildren().add(markChart);
        /*
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
        series.getData().add(new XYChart.Data<>(15,6.4));
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView1.getChildren().add(markChart);
*/
     }
    private void loadDataTemp()
    {
        paneView2.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1,15,1);
        xAxis.setLabel("Registros (do mais antigo ao mais atual)");
        NumberAxis yAxis = new NumberAxis(10,40,1);
        yAxis.setLabel("Temperatura");;
        LineChart<Number,Number> markChart = new LineChart(xAxis,yAxis);
        markChart.setTitle("Últimos 15 registros de Temperatura do tanque");
        XYChart.Series series = new XYChart.Series();
        series.setName("Temperatura");

        MonitoramentoApp monit = new MonitoramentoApp();
        java.util.List<Monitoramento> dados = monit.getAll(Monitoramento.class);
        int count = dados.size();

        for (int i =14; i > 0; i--) {
            Monitoramento monitoramento1;
            monitoramento1 = dados.get(count - i);
            int posicao = monitoramento1.id;
            double temp = monitoramento1.getTemperatura();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String data = formatter.format(monitoramento1.getLogData());
            series.getData().add(new XYChart.Data<>(posicao, temp));

        }

        /*series.getData().add(new XYChart.Data<>(1,25));
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
        series.getData().add(new XYChart.Data<>(15,36.4)); */
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView2.getChildren().add(markChart);
    }
}
