package View;

import java.util.Scanner;

import Controller.UserController;

public class UserView {
    static Scanner sc=new Scanner(System.in);
    
    static UserController uc=new UserController();

    public static void signin()
    {
        System.out.println("------------------------------------------");
        System.out.print("Enter a Email    : ");
        String email=sc.next();
        System.out.print("Enter a password : ");
        String pass=sc.next();
        System.out.print("Enter Your Name : ");
            String name = sc.next();

            System.out.print("Enter Customer Phone.no: ");
            String phno=sc.next();

        try
        {
            if(UserController.addUser(email,pass,name,phno,"customer")){
                System.out.println("---SignedIn---");
                CustomerView.newlogin();
            }
            else
                System.out.println("LogIn Error");
        }
        catch(Exception e)
        {
            System.out.println("LogIn Error");
            // System.out.println("");
        }
    }


    public static void login() throws Exception
    {
        System.out.println("------------------------------------------");
        System.out.print("Enter your Email    : ");
        String email=sc.next();
        System.out.print("Enter your password : ");
        String pass=sc.next();

            try
            {
                if(UserController.validateUser(email,pass)==true)
                {
                    CustomerView.newlogin();
                }
            }
            catch (Exception e)
            {
                System.out.println("--- Enter valid Details---");
            }
    }

}
