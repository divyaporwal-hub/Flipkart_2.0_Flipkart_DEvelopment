package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Utility class for managing database connections.
 * Provides methods to establish a connection to the database and close the connection.
 */
public class DBUtil {
    
    /** Singleton instance of the database connection. */
    private static Connection connection = null;
    
    /**
     * Gets a connection to the database.
     * If the connection already exists, it returns the existing connection.
     * Otherwise, it establishes a new connection using properties from a configuration file.
     * 
     * @return the database connection
     */
    public static Connection getConnection() {
        
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = new FileInputStream("/Users/rhythm.v/Downloads/JEDI3.0_Flipkart_Development_GE-main 2/CRS-FLIPKART-GROUP-E-JAVA-POS/src/config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
    
    /**
     * Closes the database connection if it exists.
     * 
     * @return true if the connection was closed successfully, false otherwise
     */
    public static boolean closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException se) {
            return false;
        }
        return true;
    }
}