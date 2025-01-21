package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Dashboard;
import database.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DashboardContentController {
    DBHelper dbHelper = new DBHelper();
    
    @FXML
    private TableView<Dashboard> dashboardTable;
    @FXML
    private TableColumn<Dashboard, String> colName;
    @FXML
    private TableColumn<Dashboard, String> colPlanName;
    @FXML
    private TableColumn<Dashboard, Double> colPrice;
    @FXML
    private TableColumn<Dashboard, String> colStartDate;
    @FXML
    private TableColumn<Dashboard, String> colEndDate;


    private ObservableList<Dashboard> dashboardList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Mengatur kolom tabel berdasarkan properti model Dashboard
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPlanName.setCellValueFactory(new PropertyValueFactory<>("planName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        // Memuat data dari database ke tabel
        loadDashboardData();
    }

    private void loadDashboardData() {
        // Membersihkan daftar data sebelum memuat ulang
        dashboardList.clear();
        try (Connection conn = dbHelper.getConnection()) {
            String sql = """
                         SELECT c.name, s.plan_name, s.price, s.start_date, s.end_date
                         FROM customers c
                         LEFT JOIN subscriptions s ON c.customer_id = s.customer_id;
                         """;
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                dashboardList.add(new Dashboard(
                        rs.getString("name"),
                        rs.getString("plan_name") != null ? rs.getString("plan_name") : "N/A",
                        rs.getDouble("price"),
                        rs.getString("start_date") != null ? rs.getString("start_date") : "N/A",
                        rs.getString("end_date") != null ? rs.getString("end_date") : "N/A"
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Mengatur data ke dalam tabel
        dashboardTable.setItems(dashboardList);
    }
}
