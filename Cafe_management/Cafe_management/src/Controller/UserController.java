package Controller;

import Model.UserFunction;

public class UserController {
    public static  boolean validateUser(String email,String pass) throws Exception
    {
        try
        {
            String dbpass=UserFunction.getPassword(email);
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


    public static boolean addUser(String email,String pass,String name,String phno,String role) throws Exception
    {
        try
        {
            boolean b=UserFunction.addUser(email,pass,name,phno,role);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion doesn't performed");
        }
    }

    
    // public void chooseMenu(String email)throws Exception
    //     {
    //         try
    //         {
    //             String role=UserFunction.getRoleByEmail(email);
    //             if(role.equals("admin"))
    //                 AdminView.menu();
    //             else if(role.equals("employee"))
    //             {
    //                 String designation=EmployeeFunction.getDesignation(email);
    //                 if(designation.equals("Manager"))
    //                     ManagerView.menu();
    //                 else
    //                     EmployeeView.menu();
    //             }
    //             else 
    //                 CustomerView.menu();
    //         }
    //         catch(Exception e)
    //         {
    //             throw new Exception("--- Error During choosing role ---");
    //         }
    //     }
    
}
