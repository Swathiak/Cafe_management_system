package Controller;

import java.util.List;

import Model.Customer;
import Model.CustomerFunction;

public class CustomerController {
    public static boolean addCustomer(String email,String password,String name,String phno) throws Exception
    {
        try
        {
            boolean b=CustomerFunction.addCustomer(email,password,name,phno);
            return b;
        } 
        catch(Exception e)
        {
           throw new Exception("Error During Insertion");
        }
    }
    
    public static boolean removeCustomer(int cusid) throws Exception
    {
        boolean b=CustomerFunction.removeCustomer(cusid);
        return b;
    }

    public static List<Customer> viewAllCustomer()
    {
        List<Customer> st =CustomerFunction.viewAllCustomer();
        return st;
    }


    
}
