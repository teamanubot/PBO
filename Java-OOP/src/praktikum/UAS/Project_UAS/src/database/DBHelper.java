package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Base class (Superclass)
abstract class DatabaseHelper {
    // Database URL, user, and password should be defined in each subclass
    protected String url;
    protected String user;
    protected String password;

    // Abstract method to get the connection (to be implemented by subclasses)
    public abstract Connection getConnection() throws SQLException;
}

// Subclass for MySQL database connection
public class DBHelper extends DatabaseHelper {
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/langganan_wifi";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "123";

    public DBHelper() {
        this.url = MYSQL_URL;
        this.user = MYSQL_USER;
        this.password = MYSQL_PASSWORD;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
