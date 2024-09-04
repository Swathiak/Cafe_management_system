import java.sql.SQLException;
import java.util.Scanner;

import Model.Connect;
// import Util.Input;
import View.AdminView;
import View.CustomerView;

public class App {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        try{
            Connect.getConnection();
            System.out.println("Connected");
        }
        catch(SQLException err){
            System.out.println("Database error");
            System.out.println(err.getMessage());
            return ;
        }
        boolean b=true;
        do
        {
            System.out.println();
            System.out.print(" 1.Admin \n 2.Customer \n \n Enter your mode of access : ");
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1)
            {
               AdminView.login();
            }
            else if(n==2)
            {
                CustomerView.login();
                // CustomerView.signin();
                // CustomerView.newlogin();
            }
            else
                b=false;
                System.out.println();
                System.out.print("Enter valid choice");
        }
        while(b);
    }
}
