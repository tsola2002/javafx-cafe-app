package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/fxml/form.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("FXML Form Example");
        stage.setScene(scene);
        stage.show();
    }
}