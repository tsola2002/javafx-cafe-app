package org.example.ch09_java_gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartSample extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {

        // CREATING PIE CHART FOR BROWSER USAGE
        stage.setTitle("Monthly Sales Chart");

        CategoryAxis xAxis =  new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // LABELLING OUR X AND Y AXIS
        xAxis.setLabel("Month");
        yAxis.setLabel("Sales");

        BarChart<String, Number> barChart = new BarChart<>( xAxis, yAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("2025 Sales");

        // ADD DATA TO THE CHART
        series.getData().add(new XYChart.Data<>("January", 200));
        series.getData().add(new XYChart.Data<>("February", 150));
        series.getData().add(new XYChart.Data<>("March", 300));

        barChart.getData().add(series);

        Scene scene = new Scene(barChart, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}
