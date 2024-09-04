package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFunction {
     public static String getPassword(String email)  throws Exception
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

    public static boolean addUser(String email, String password,String name,String phno, String role) throws SQLException {
        String sql = "INSERT INTO customer (email, password,name,phno, role) VALUES (?, ?, ?,?,?)";
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(4, phno);

            statement.setString(5, role);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }
    
}
