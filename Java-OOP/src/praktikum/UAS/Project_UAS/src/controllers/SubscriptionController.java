package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Subscription;
import database.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;

public class SubscriptionController {
    DBHelper dbHelper = new DBHelper();
    
    @FXML
    private TableView<Subscription> subscriptionTable;
    @FXML
    private TableColumn<Subscription, Integer> colId;
    @FXML
    private TableColumn<Subscription, String> colCustomerName; // Nama pelanggan
    @FXML
    private TableColumn<Subscription, String> colPlanName;
    @FXML
    private TableColumn<Subscription, Double> colPrice;
    @FXML
    private TableColumn<Subscription, String> colStartDate;
    @FXML
    private TableColumn<Subscription, String> colEndDate;

    @FXML
    private ComboBox<String> customerIdField; // Nama pelanggan di ComboBox
    @FXML
    private ComboBox<String> planNameField; // Paket langganan
    @FXML
    private TextField priceField; // Harga
    @FXML
    private DatePicker startDateField; // Tanggal mulai
    @FXML
    private DatePicker endDateField; // Tanggal berakhir

    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;

    private ObservableList<Subscription> subscriptionList = FXCollections.observableArrayList();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colPlanName.setCellValueFactory(new PropertyValueFactory<>("planName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        loadSubscriptions();
        loadCustomerNames(); // Load nama pelanggan
        loadPlanNames();     // Load nama paket langganan
    }

    private void loadSubscriptions() {
        subscriptionList.clear();
        try (Connection conn = dbHelper.getConnection()) {
            String sql = "SELECT s.subscription_id, c.name AS customer_name, " +
                         "s.plan_name, s.price, s.start_date, s.end_date " +
                         "FROM subscriptions s " +
                         "JOIN customers c ON s.customer_id = c.customer_id";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                subscriptionList.add(new Subscription(
                        rs.getInt("subscription_id"),
                        rs.getString("customer_name"), // Ambil nama pelanggan
                        rs.getString("plan_name"),
                        rs.getDouble("price"),
                        rs.getString("start_date"),
                        rs.getString("end_date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        subscriptionTable.setItems(subscriptionList);
    }

    private void loadCustomerNames() {
        try (Connection conn = dbHelper.getConnection()) {
            String sql = "SELECT name FROM customers";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ObservableList<String> customerNames = FXCollections.observableArrayList();
            while (rs.next()) {
                customerNames.add(rs.getString("name"));
            }
            customerIdField.setItems(customerNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPlanNames() {
        ObservableList<String> planNames = FXCollections.observableArrayList("Basic Plan", "Premium Plan", "Enterprise Plan");
        planNameField.setItems(planNames);
    }

    @FXML
    private void addSubscription() {
        String customerName = customerIdField.getValue();
        String planName = planNameField.getValue();
        double price = Double.parseDouble(priceField.getText());
        String startDate = (startDateField.getValue() != null) ? startDateField.getValue().format(DATE_FORMATTER) : null;
        String endDate = (endDateField.getValue() != null) ? endDateField.getValue().format(DATE_FORMATTER) : null;

        try (Connection conn = dbHelper.getConnection()) {
            String sql = "INSERT INTO subscriptions (customer_id, plan_name, price, start_date, end_date) " +
                         "VALUES ((SELECT customer_id FROM customers WHERE name = ?), ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerName);
            stmt.setString(2, planName);
            stmt.setDouble(3, price);
            stmt.setString(4, startDate);
            stmt.setString(5, endDate);
            stmt.executeUpdate();
            loadSubscriptions();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateSubscription() {
        Subscription selectedSubscription = subscriptionTable.getSelectionModel().getSelectedItem();
        if (selectedSubscription == null) {
            return;
        }

        try (Connection conn = dbHelper.getConnection()) {
            String sql = "UPDATE subscriptions SET customer_id = (SELECT customer_id FROM customers WHERE name = ?), " +
                         "plan_name = ?, price = ?, start_date = ?, end_date = ? WHERE subscription_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerIdField.getValue());
            stmt.setString(2, planNameField.getValue());
            stmt.setDouble(3, Double.parseDouble(priceField.getText()));
            stmt.setString(4, startDateField.getValue().format(DATE_FORMATTER));
            stmt.setString(5, endDateField.getValue().format(DATE_FORMATTER));
            stmt.setInt(6, selectedSubscription.getId());
            stmt.executeUpdate();
            loadSubscriptions();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteSubscription() {
        Subscription selectedSubscription = subscriptionTable.getSelectionModel().getSelectedItem();
        if (selectedSubscription == null) {
            return;
        }

        try (Connection conn = dbHelper.getConnection()) {
            String sql = "DELETE FROM subscriptions WHERE subscription_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, selectedSubscription.getId());
            stmt.executeUpdate();
            loadSubscriptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        customerIdField.getSelectionModel().clearSelection();
        planNameField.getSelectionModel().clearSelection();
        priceField.clear();
        startDateField.setValue(null);
        endDateField.setValue(null);
    }
}
