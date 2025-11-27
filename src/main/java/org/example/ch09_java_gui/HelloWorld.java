package org.example.ch09_java_gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hello World");
       // StackPane root = new StackPane(label);
        Pane pane = new Pane();
       Scene scene = new Scene(pane, 350, 150);
        Button btn = new Button("Exit");
        label.relocate(120, 60);
        btn.relocate(155, 80);

        pane.getChildren().addAll(label, btn);
        stage.setTitle("JavaFX Hello World");
        stage.setScene(scene);

        btn.setOnAction(actionEvent -> {
            System.out.println("Bye see you Later");
            Platform.exit();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
