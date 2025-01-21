package models;

// Base class (Superclass)
abstract class Person {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Person(int id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public abstract void displayInfo(); // Polymorphic method
}

// Subclass (Customer extends Person)
public class Customer extends Person {

    public Customer(int id, String name, String email, String phone, String address) {
        super(id, name, email, phone, address); // Call the superclass constructor
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer Information:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhone());
        System.out.println("Address: " + getAddress());
    }
}
