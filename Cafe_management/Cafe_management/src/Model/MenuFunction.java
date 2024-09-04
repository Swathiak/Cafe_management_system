package Model;

import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuFunction {
     public static List<Menu> viewAllMenu()
    {
        List<Menu> st = new ArrayList<>();
        try (
        PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM menus");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int itemno = resultSet.getInt("itemno");
                String itemname = resultSet.getString("itemname");
                double price = resultSet.getDouble("price");
                int updateAvailableMenu = resultSet.getInt("menu_availability");
                st.add(new Menu(itemno,itemname,price,updateAvailableMenu));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
    

    public static boolean updateAvailableMenu(int quantity, String item_name) throws Exception 
    {
        String sqlSelect = "SELECT menu_availability FROM menus WHERE itemname = ?";
        String sqlUpdate = "UPDATE menus SET menu_availability = menu_availability - ? WHERE itemname = ?";
        
        int availableMenus;
        try (
             PreparedStatement selectStatement = Connect.getConnection().prepareStatement(sqlSelect);
             PreparedStatement updateStatement = Connect.getConnection().prepareStatement(sqlUpdate)) {
            selectStatement.setString(1, item_name);
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    availableMenus = resultSet.getInt("menu_availability");
                    
                } else {
                    throw new SQLException(" with itemname " + item_name + " not found.");
                }
            }
            if (availableMenus < quantity) {
                throw new Exception("there is no available menu " + item_name);
            }
            else if(availableMenus==0)
            throw new Exception("Menu currently not available " + item_name);
            
            // Update the available seats count
            updateStatement.setInt(1, quantity);
            updateStatement.setString(2,item_name);
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected>0;
        }
    }

    public static boolean removeMenu(int itemno) throws Exception
    {
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(
                     "DELETE FROM menus WHERE itemno = ?")) 
        {
            statement.setInt(1, itemno);
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

    public static boolean addMenu(String name,int price,int avail) throws Exception
    {
        try (
             PreparedStatement statement = Connect.getConnection().prepareStatement(
                     "INSERT INTO menus(itemname,price,menu_availability) VALUES (?,?,?)");) 
        {
            //statement.setInt(1, id);
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setInt(3, avail);
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



    public static boolean updateMenu(int menu_avail,String item_name) throws Exception
    {
        try (
            PreparedStatement statement = Connect.getConnection().prepareStatement(
                    "UPDATE menus SET menu_availability=? where itemname=?")) 
       {
           statement.setInt(1, menu_avail);
           statement.setString(2, item_name);
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

    public static double addprice(String item_name) throws Exception{
        double price=0;
        try (
            PreparedStatement statement = Connect.getConnection().prepareStatement(
                    "SELECT price from menus WHERE itemname=?")) 
       {
           statement.setString(1, item_name);
           ResultSet resultSet=statement.executeQuery();
           if(resultSet.next()){
            price=resultSet.getDouble("price");
           }
           resultSet.close();
           statement.close();
           
       } catch (SQLException e) {
           e.printStackTrace();
           throw new Exception("DB ERROR");
       }
       return price;
    }
   

    // public static boolean addBill(String cus_name,String item_name,int quantity,double unit_price,double net_price) throws Exception{
    //     try (
    //          PreparedStatement statement = Connect.getConnection().prepareStatement(
    //             "INSERT INTO bill (cus_name, item_name, quantity, unit_price, net_price) VALUES (?, ?, ?, ?, ?)");)
    //     {
    //         statement.setString(1, cus_name);
    //         statement.setString(2, item_name);
    //         statement.setInt(3, quantity);
    //         statement.setDouble(4,unit_price);
    //         statement.setDouble(5, net_price);
    //         // statement.setDouble(6, total_Price);
    //         // Execute the SQL INSERT statement
    //         int rowsInserted = statement.executeUpdate();
    //         // Check if the insertion was successful
    //         if (rowsInserted > 0)
    //             return true;
    //         else
    //             return false;
    //     } 
    //     catch (SQLException e) 
    //     {
    //         e.printStackTrace();
    //         throw new EOFException("DB error");
    //     }
    // }


    public static boolean addBill( String item_name, int quantity, double unit_price, double net_price) throws Exception {
    try (Connection connection = Connect.getConnection();
         PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO bill ( item_name, quantity, unit_price, net_price) VALUES (?, ?, ?, ?)")) {
        //statement.setString(1, cus_name);
        statement.setString(1, item_name);
        statement.setInt(2, quantity);
        statement.setDouble(3, unit_price);
        statement.setDouble(4, net_price);

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        throw new Exception("DB error: " + e.getMessage());
    }
}

    public static boolean addOrder(String cus_name,String item_name,int quantity,double unit_price,double net_price,double total_Price) throws Exception {
        try (PreparedStatement statement = Connect.getConnection().prepareStatement(
                "INSERT INTO Orders (cus_name,item_name,quantity,unit_price,net_price,total_price) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, cus_name);
            statement.setString(2, item_name);
            statement.setInt(3, quantity);
            statement.setDouble(4, unit_price);
            statement.setDouble(5, net_price);
            statement.setDouble(6, total_Price);
    
            int rowsInserted = statement.executeUpdate();
    
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("DB error");
        }
    }

    




}
