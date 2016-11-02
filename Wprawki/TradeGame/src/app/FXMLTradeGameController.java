/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author grze
 */
public class FXMLTradeGameController implements Initializable {

    @FXML
    private VBox mainVBox;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    private AreaChart<Number, Number> areaChart;

    List<XYChart> list = new ArrayList<>();
    XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
    Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mainVBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        addDataToSeries();
                        break;
                }
            }
        });

        xAxis.setForceZeroInRange(false);
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(10);
        yAxis.setForceZeroInRange(false);
        yAxis.setAutoRanging(true);

        series.setName("My portfolio");
        series.getData().add(new XYChart.Data<>(0, 10));
        series.setName("Dane");

        areaChart.getData().add(series);
        areaChart.setAnimated(false);
//---------------------------------------------

        timeline = new Timeline(new KeyFrame(
                Duration.millis(2500),
                ds -> addDataToSeries()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();     
    }

    private void addDataToSeries() {

        series.getData().add(new XYChart.Data<>(series.getData().size(), 
                series.getData().get(series.getData().size() - 1).getYValue().intValue() +
                Math.random() * 10 - 5));

        if (series.getData().size() > 10) {
            series.getData().remove(0);
            series.getData().stream().forEach(p -> p.setXValue(p.getXValue().intValue() - 1));
        }

        xAxis.setLowerBound(0);
        xAxis.setUpperBound(10);

    }

    @Override
    protected void finalize() throws Throwable {
        timeline.stop();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
