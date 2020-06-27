package Interface.Telas;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

import java.net.URL;
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

    private void loadDatapH() {
        paneView1.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1, 30, 1);
        xAxis.setLabel("Dias");
        NumberAxis yAxis = new NumberAxis(0, 14, 0.5);
        yAxis.setLabel("pH");
        LineChart<Number, Number> markChart = new LineChart(xAxis, yAxis);
        markChart.setTitle("pH do tanque nos últimos 30 dias");
        XYChart.Series series = new XYChart.Series();
        series.setName("pH");
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
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView1.getChildren().add(markChart);

    }

    private void loadDataTemp() {
        paneView2.getChildren().clear();
        NumberAxis xAxis = new NumberAxis(1, 30, 1);
        xAxis.setLabel("Dias");
        NumberAxis yAxis = new NumberAxis(1, 40, 2);
        yAxis.setLabel("Temperatura");
        LineChart<Number, Number> markChart = new LineChart(xAxis, yAxis);
        markChart.setTitle("Temperatura do tanque nos últimos 30 dias");
        XYChart.Series series = new XYChart.Series();
        series.setName("Temperatura");
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
        markChart.getData().add(series);
        markChart.setMaxWidth(500);
        markChart.setMaxHeight(400);
        paneView2.getChildren().add(markChart);
    }
}
