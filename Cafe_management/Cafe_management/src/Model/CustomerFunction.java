package Model;

import java.io.EOFException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFunction {
    public static boolean addCustomer(String email,String password,String name,String phno) throws Exception
    {
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(
                     "INSERT INTO customer(email,password,name,phno) VALUES (?,?,?,?)");) 
        {
            //statement.setInt(1, id);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(4, phno);
            
            // Execute the SQL INSERT statement
            int rowsInserted = statement.executeUpdate();
            // Check if the insertion was successful
            if (rowsInserted > 0)
                return true;
            else
                return false;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new EOFException("DB error");
        }
    }

    public static boolean removeCustomer(int cusid) throws Exception
    {
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(
                     "DELETE FROM customer WHERE id = ?")) 
        {
            statement.setInt(1, cusid);
            // Execute the delete query
            int rowsDeleted = statement.executeUpdate();
            // Check if any rows were deleted
            if (rowsDeleted > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("DB ERROR");
        }
    }


     public static List<Customer> viewAllCustomer()
    {
        List<Customer> st = new ArrayList<>();
        try (
        PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM customer");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int cusid = resultSet.getInt("id");
                String email=resultSet.getString("email");
                String password=resultSet.getString("password");
                String name = resultSet.getString("name");
                String phno = resultSet.getString("phno");
                st.add(new Customer(cusid,email,password,name,phno));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }



    public static String getRole(String email) throws SQLException {
        String sql = "SELECT role FROM customer WHERE email = ?";
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? resultSet.getString("role") : null;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }

}
