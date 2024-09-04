package Controller;

import Model.AdminFunction;

public class AdminController {
    public  boolean validateUser(String email,String pass) throws Exception
    {
        try
        {
            String dbpass=AdminFunction.getPassword(email);
            if(dbpass.equals(pass))
                return true;
            else 
                return false;
        }
        catch(Exception e)
        {
            throw new Exception("--- Enter valid Details ---");
        }
    }

    public static boolean addCustomer(String email,String pass) throws Exception
    {
        try
        {
            boolean b=AdminFunction.addCustomer(email,pass);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion doesn't performed");
        }
    }


    public  boolean validateCustomer(String email,String password) throws Exception
    {
        try
        {
            String dbpass=AdminFunction.getPass(email);
            if(dbpass.equals(password))
                return true;
            else 
                return false;
        }
        catch(Exception e)
        {
            throw new Exception("--- Enter valid Details ---");
        }
    }
}
