package Model;

import java.io.EOFException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFunction {
    public static boolean addEmployee(String name,String role,int salary) throws Exception
    {
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(
                     "INSERT INTO employee(name,role,salary) VALUES (?,?,?)");) 
        {
            //statement.setInt(1, id);
            statement.setString(1, name);
            statement.setString(2, role);
            statement.setInt(3, salary);
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


    public  static List<Employee> viewAllEmployee()
    {
        List<Employee> st = new ArrayList<>();
        try (
        PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM employee");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                int salary = resultSet.getInt("salary");
                st.add(new Employee(id,name,role,salary));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
    
    public static boolean removeEmployee(String emp_name) throws Exception
    {
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(
                     "DELETE FROM employee WHERE name = ?")) 
        {
            statement.setString(1, emp_name);
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

    public static boolean updateEmployee(String new_role,int new_salary,String empname) throws Exception
    {
        try (
            PreparedStatement statement = Connect.getConnection().prepareStatement(
                    "UPDATE employee SET role=? , salary=? where name=?")) 
       {
           statement.setString(1, new_role);
           statement.setInt(2,new_salary);
            statement.setString(3,empname);
           // Execute the delete query
           int rowsUpdated = statement.executeUpdate();
           // Check if any rows were deleted
           if (rowsUpdated > 0) {
               return true;
           } else {
               return false;
           }
           
       } catch (SQLException e) {
           e.printStackTrace();
           throw new Exception("DB ERROR");
       }
    }

}
