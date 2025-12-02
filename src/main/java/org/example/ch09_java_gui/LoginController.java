package org.example.ch09_java_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleLogin(ActionEvent event) {
        // grab username and password fields
        String username = usernameField.getText();
        String password = passwordField.getText();

        // username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Missing Fields",
                    "Please enter both username and password.");
            return;
        }

        if (isValidUser(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful",
                    "Welcome " + username + "!");

            // OPTIONAL: Add a small delay before opening dashboard
            openDashboard();
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed",
                    "Incorrect username or password.");
        }

        // compare username and password against database fields
        String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";



        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            // running the sql query
            ResultSet rs = pst.executeQuery();



        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("An error occurred.");
        }


    }


    private boolean isValidUser(String username, String password) {
        String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true if match found

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error",
                    "Could not verify credentials.");
            e.printStackTrace();
            return false;
        }
    }


    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void openDashboard() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Dashboard");
            stage.show();

            // Close login window
            Stage current = (Stage) usernameField.getScene().getWindow();
            current.close();

        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Could not load dashboard.");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleSignup(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sign-up.fxml"));

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
