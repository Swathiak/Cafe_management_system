// package Model;

// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

// public class BillFunction 
// {

// public static List<Bill> viewBill(String cus_name) {
//     List<Bill> billList = new ArrayList<>();
//     try (PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM bill WHERE cus_name = ?")) {
//         statement.setString(1, cus_name); // Set the value for the parameter
//         try (ResultSet resultSet = statement.executeQuery()) {
//             while (resultSet.next()) {
//                 int retrievedBillId = resultSet.getInt("bill_id");
//                 String cusName = resultSet.getString("cus_name");
//                 String itemName = resultSet.getString("item_name");
//                 int quantity = resultSet.getInt("quantity");
//                 double unitPrice = resultSet.getDouble("unit_price");
//                 double netPrice = resultSet.getDouble("net_price");
//                 double totalPrice = resultSet.getDouble("net_price");
//                 Bill bill = new Bill(retrievedBillId, cusName, itemName, quantity, unitPrice, netPrice,totalPrice);
//                 billList.add(bill);
//             }
//         }
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
//     return billList;
// }

// //Viewing Final Bill
// public static List<Bill> viewTotal(String name) {
//     List<Bill> billList = new ArrayList<>();
//     try (PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT bill_id,cus_name,total_price FROM bill WHERE name = ?")) {
//         statement.setString(1, name); // Set the value for the parameter
//         try (ResultSet resultSet = statement.executeQuery()) {
//             while (resultSet.next()) {
//                 int retrievedBillId = resultSet.getInt("bill_id");
//                 String cusName = resultSet.getString("cus_name");
//                 String itemName = resultSet.getString("item_name");
//                 int quantity = resultSet.getInt("quantity");
//                 double unitPrice = resultSet.getDouble("unit_price");
//                 double netPrice = resultSet.getDouble("net_price");
//                 double totalPrice = resultSet.getDouble("total_price");
//                 Bill bill = new Bill(retrievedBillId, cusName, itemName, quantity, unitPrice, netPrice,totalPrice);
//                 billList.add(bill);
//             }
//         }
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
//     return billList;
// }
// }


    
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillFunction 
{

public static List<Bill> viewBill(String name) throws Exception{
    List<Bill> billList = new ArrayList<>();
    try (PreparedStatement statement = Connect.getConnection().prepareStatement("SELECT * FROM bill WHERE cus_name = ?")) {
       // statement.setInt(1, bill_id); 
        statement.setString(1, name); // Set the value for the parameter
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
               // int retrievedBillId = resultSet.getInt("bill_id");
                String cusName = resultSet.getString("cus_name");
                String itemName = resultSet.getString("item_name");
                int quantity = resultSet.getInt("quantity");
                double unitPrice = resultSet.getDouble("unit_price");
                double netPrice = resultSet.getDouble("net_price");
                double totalPrice = resultSet.getDouble("total_price");
                Bill bill = new Bill( cusName, itemName, quantity, unitPrice, netPrice,totalPrice);
                billList.add(bill);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return billList;
}
public static double addname(String email) throws Exception{
    double price=0;
    try (
        PreparedStatement statement = Connect.getConnection().prepareStatement(
                "SELECT name from customer WHERE email=?")) 
   {
       statement.setString(1, email);
       ResultSet resultSet=statement.executeQuery();
       if(resultSet.next()){
        price=resultSet.getDouble("name");
       }
       resultSet.close();
       statement.close();
       
   } catch (SQLException e) {
       e.printStackTrace();
       throw new Exception("DB ERROR");
   }
   return price;
}
}


    


