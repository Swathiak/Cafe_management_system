package Controller;

import java.util.List;

import Model.Menu;
import Model.MenuFunction;

public class MenuController {
    public static List<Menu> viewAllMenu()
    {
        List<Menu> st =MenuFunction.viewAllMenu();
        return st;
    }


    public static boolean updateAvailableMenu(int quantity,String item_name) throws Exception
    {
        try
        {
            if(MenuFunction.updateAvailableMenu(quantity,item_name)) return true;
            else    
            return false;
        }
        catch(Exception e)
        {
            throw new Exception("Error During Order");
        }
    } 

    public static boolean removeMenu(int itemno) throws Exception
    {
        boolean b=MenuFunction.removeMenu(itemno);
        return b;
    }

    //Adding Menu
    public static boolean addMenu(String itemname,int price,int avail) throws Exception
    {
        try
        {
            boolean b=MenuFunction.addMenu(itemname,price,avail);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Insertion");
        }
    }

    //UpdatingMenu
      public static boolean updateMenu(int menu_avail,String item_name) throws Exception
    {
        try
        {
            boolean b=MenuFunction.updateMenu(menu_avail,item_name);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Updation");
        }
    }

    public static double addprice(String item_name) throws Exception{
        try{
            double price=MenuFunction.addprice(item_name);
            return price;
        }
        catch(Exception e)
        {
           throw new Exception("Error");
        }
    }

    public static boolean addBill(String item_name,int quantity,double unit_price,double net_price) throws Exception{
        try
        {
            boolean b=MenuFunction.addBill(item_name,quantity,unit_price,net_price);
            return b;
        }
        catch(Exception e) 
        {
           throw new Exception("Error");
        }
    }

    
}
