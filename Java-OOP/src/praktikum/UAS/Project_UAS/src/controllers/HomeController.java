package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private AnchorPane dashboardContent;

    @FXML
    private Label noContentLabel;  // Label untuk menampilkan pesan "No content"
    
    @FXML
    private Button exitButton;


    @FXML
    private void initialize() {
        try {
            // Memuat konten dashboard ke dalam home
            AnchorPane dashboard = FXMLLoader.load(getClass().getResource("/views/dashboard_content.fxml"));
            dashboardContent.getChildren().add(dashboard);

            // Cek apakah dashboard ada atau kosong
            if (dashboardContent.getChildren().isEmpty()) {
                noContentLabel.setVisible(true);  // Tampilkan label jika tidak ada konten
                dashboardContent.setVisible(false);  // Sembunyikan konten
            } else {
                noContentLabel.setVisible(false);  // Sembunyikan label jika ada konten
                dashboardContent.setVisible(true);  // Tampilkan konten
            }
        } catch (Exception e) {
            e.printStackTrace();
            noContentLabel.setVisible(true);  // Jika ada kesalahan, tampilkan label "No content"
            dashboardContent.setVisible(false);  // Sembunyikan konten
        }
        exitButton.setOnAction(event -> {
            System.exit(0); // Menutup aplikasi
        });
    }

    @FXML
    private void goToLogin() {
        // Navigasi ke halaman login
        main.App.showLoginPage();
    }
}
