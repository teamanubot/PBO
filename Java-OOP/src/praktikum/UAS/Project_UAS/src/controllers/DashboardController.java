package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.App;

import javafx.fxml.FXML;

import java.io.IOException;

// BaseDashboardController class
abstract class BaseDashboardController {

    @FXML
    protected StackPane contentPane;

    @FXML
    public void initialize() {
        loadInitialPage();
    }

    protected abstract void loadInitialPage();

    protected void loadPage(String fxmlPath) {
        try {
            System.out.println("Loading page: " + fxmlPath);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane newContent = loader.load();
            System.out.println("FXML loaded successfully: " + fxmlPath);

            if (contentPane != null) {
                contentPane.getChildren().setAll(newContent);
                System.out.println("ContentPane updated successfully.");
            } else {
                System.err.println("ContentPane is null. Cannot load new content.");
            }
        } catch (IOException e) {
            System.err.println("Failed to load FXML: " + fxmlPath);
            e.printStackTrace();
        }
    }
}

public class DashboardController extends BaseDashboardController {

    @FXML
    private Button manageDashboardMenuButton;

    @FXML
    private Button manageCustomersMenuButton;

    @FXML
    private Button manageSubscriptionsMenuButton;

    @FXML
    private Button manageLogoutMenuButton;

    private String role;

    @Override
    protected void loadInitialPage() {
        manageDashboardMenu();
    }

    @FXML
    public void manageDashboardMenu() {
        System.out.println("Dashboard menu clicked");
        loadPage("/views/dashboard_content.fxml");
    }

    @FXML
    public void manageCustomersMenu() {
        System.out.println("Menu Customer clicked");
        loadPage("/views/customers.fxml");
    }

    @FXML
    public void manageSubscriptionsMenu() {
        System.out.println("Menu Subscription clicked");
        loadPage("/views/Subscriptions.fxml");
    }

    public void manageLogoutMenu() {
        try {
            App.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRole(String role) {
        this.role = role;
        adjustMenuBasedOnRole();
    }

    private void adjustMenuBasedOnRole() {
        boolean isAdmin = "admin".equals(role);
        boolean isCustomer = "customer".equals(role);

        manageCustomersMenuButton.setVisible(isAdmin);
        manageSubscriptionsMenuButton.setVisible(isAdmin);
    }
}
