package org.example.ch09_java_gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Form  extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // CREATE A GRID PANEL
        GridPane grid = new GridPane();
        grid.setId("root-container");
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(10);
        grid.setHgap(10);

        // ADDING TEXT CONTROL
        Text text =  new Text("Fill the form and Submit");
        text.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        grid.add(text, 0, 0, 2, 1);


        // First Name Label and Textfield
        Label firstNameLabel = new Label("First Name");
        TextField firstNameTextField =  new TextField();
        grid.add(firstNameLabel, 0, 1);
        grid.add(firstNameTextField, 1,1);

        // Last Name Label and Textfield
        Label lastNameLabel = new Label("Last Name");
        TextField lastNameTextField =  new TextField();
        grid.add(lastNameLabel, 0, 2);
        grid.add(lastNameTextField, 1,2);

        // Age label and Textfield
        Label ageLabel = new Label("Age");
        TextField ageField =  new TextField();
        grid.add(ageLabel, 0, 3);
        grid.add(ageField, 1,3);

        // Submit Button
        Button submitButton = new Button("submit");
        // change color of a button
        //submitButton.setStyle("-fx-background-color: yellow");
        grid.add(submitButton, 1, 4);

        // Handle button Click
        submitButton.setOnAction( e -> {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String age = ageField.getText();

            System.out.println("Form Submitted:");
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Age: " + age);
        });

        // CREATE THE SCENE
        Scene scene  = new Scene(grid, 350, 250);

        // LINK CSS FILE
       // scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());


        stage.setTitle("Simple Form Example");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}
