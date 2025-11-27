package org.example.ch09_java_gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartSample extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // CREATING PIE CHART FOR BROWSER USAGE
        stage.setTitle("Browser Usage Chart");

        // CREATING OBJECT
        PieChart pieChart = new PieChart();
        pieChart.getData().add(new PieChart.Data("Chrome", 63));
        pieChart.getData().add(new PieChart.Data("Safari", 19));
        pieChart.getData().add(new PieChart.Data("Firefox", 4));
        pieChart.getData().add(new PieChart.Data("Edge", 10));
        pieChart.getData().add(new PieChart.Data("Others", 4));


        Scene scene = new Scene(pieChart, 600, 400);
        stage.setScene(scene);
        stage.show();

    }
}
