package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import org.example.ch09_java_gui.DbConnection;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Connection conn = DbConnection.getConnection(); // test connection
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/fxml/form.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 640, 480);

        stage.setTitle("FXML Form Example");
        stage.setScene(scene);
        stage.show();
    }
}