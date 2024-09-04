package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminFunction {
    public static String getPassword(String email)  throws Exception
    {
        String password = null;
        String sql = "SELECT passowrd FROM admin WHERE email = ?";
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(sql)) 
        {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                if (resultSet.next()) 
                    password = resultSet.getString("passowrd");
                else 
                    throw new SQLException("User with email " + email + " not found.");
                }
            }
        return password;
    }

    public static boolean addCustomer(String email, String password) throws SQLException {
        String sql = "INSERT INTO customer (email, password) VALUES (?, ?)";
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            //statement.setString(3, role);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }

    public static String getPass(String email)  throws Exception
    {
        String password = null;
        String sql = "SELECT password FROM customer WHERE email = ?";
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(sql)) 
        {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                if (resultSet.next()) 
                    password = resultSet.getString("password");
                else 
                    throw new SQLException("User with email " + email + " not found.");
                }
            }
        return password;
    }



}
