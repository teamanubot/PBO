package models;

// Base class (Superclass)
abstract class BaseDashboard {
    private String name;

    public BaseDashboard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method for polymorphism
    public abstract String getDetails();
}

// Subclass (Child class)
public class Dashboard extends BaseDashboard {
    private String planName;
    private double price;
    private String startDate;
    private String endDate;

    public Dashboard(String name, String planName, double price, String startDate, String endDate) {
        super(name); // Call superclass constructor
        this.planName = planName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPlanName() {
        return planName;
    }

    public double getPrice() {
        return price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String getDetails() {
        return "Plan: " + planName + ", Price: $" + price +
               ", Start Date: " + startDate + ", End Date: " + endDate;
    }
}
