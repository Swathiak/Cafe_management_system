package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import Model.BillFunction;
import Model.Connect;

public class BillController {
    static Map<String,Integer> cart=new HashMap<>();
	static int tot=0;
	

    public static boolean addToCart(String item_name,int quantity,double unit_price,double net_price) {
		
		String query="select unit_price,quantity from bill where item_name=?";
		try {
			Connection con=Connect.getConnection();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, item_name);
			ResultSet rs=pst.executeQuery();rs.next();
			
			if(rs.getInt(2)>=quantity) {
			tot+=(quantity*rs.getDouble(1));
			cart.put(item_name, quantity);
			return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}


	public static void displayCart() {
		System.out.println("Bill for the items: ");
		for(Map.Entry<String,Integer> map:cart.entrySet()) {
			System.out.println("------------------------------------");
			System.out.println("Item_name:"+map.getKey());
			System.out.println("Quantity:"+map.getValue());
			System.out.println("------------------------------------");
		}
		System.out.println("Total:"+tot);
	}

    
	public static double addname(String email) throws Exception{
		try{
			double price=BillFunction.addname(email);
			return price;
		}
		catch(Exception e)
		{
		   throw new Exception("Error");
		}
	}
}

