package org.example.ch09_java_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    // Triggered when signup button is clicked
    @FXML
    public void handleSignup() {

        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Username and password are required!");
            return;
        }

        // Save to database
        try {
            Connection conn = DbConnection.getConnection();

            String sql = "INSERT INTO employee (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            stmt.executeUpdate();

            showAlert(Alert.AlertType.INFORMATION, "Success", "User registered successfully!");

            // Clear fields
            usernameField.clear();
            passwordField.clear();

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Could not register user.\n" + e.getMessage());
            e.printStackTrace();
        }

    }



    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
