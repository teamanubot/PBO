package controllers;

import database.DBHelper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    DBHelper dbHelper = new DBHelper();
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Label errorLabel;

    // Initialize method to set default values or behaviors
    @FXML
    private void initialize() {
        // Clear error label on initialization
        if (errorLabel != null) {
            errorLabel.setText("");
        }
    }

    @FXML
    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate inputs
        if (username == null || username.isEmpty()) {
            showError("Username cannot be empty.");
            return;
        }

        if (password == null || password.isEmpty()) {
            showError("Password cannot be empty.");
            return;
        }

        try (Connection conn = dbHelper.getConnection()) {
            if (conn == null) {
                showError("Database connection failed.");
                return;
            }

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                App.showDashboard(role);
            } else {
                showError("Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showError("An error occurred during login.");
        }
    }

    @FXML
    private void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            login();
        }
    }

    // Utility method to display error messages
    private void showError(String message) {
        if (errorLabel != null) {
            errorLabel.setText(message);
        }
    }
}