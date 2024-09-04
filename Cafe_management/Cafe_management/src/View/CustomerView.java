package View;
import java.util.*;

import Controller.BillController;
import Controller.MenuController;
import Controller.RatingController;
import Model.Menu;
public class CustomerView
{
    static Scanner sc=new Scanner(System.in);
    public static void login() throws Exception
    {
        // boolean b=true;
        // do
        // {
            System.out.println("------------------------------------------");
            System.out.print("Press 1 for login || Press 2 for Signin : ");
            int n=sc.nextInt();
            sc.nextLine();
            if(n==1)
            {
                UserView.login();
            }
            else if(n==2)
            {
                UserView.signin();
            }
            else
                System.out.println("----Enter only 1 || 2 ---- ");
        // }
        // while(b);
    }
    ///////////////////////////////////////////
       

public static void newlogin() throws Exception
        {
            // System.out.print("Enter email: ");
            // String email = sc.nextLine();
    
            // System.out.print("Enter password: ");
            // String password = sc.nextLine();

            // System.out.print("Enter Your Name : ");
            // String name = sc.next();

            // System.out.print("Enter Customer Phone.no: ");
            // String phno=sc.next();

            // System.out.println();

            // try{
            //         if(CustomerController.addCustomer(email,password,name,phno))
            //             System.out.println("Customer has been added");
            //         else
            //             System.out.println("Error during adding Customer");
            //         }
            //         catch(Exception e)
            //         {
            //             System.out.println("Error during adding Customer");
            //         }
            boolean b = true;
            do {
                System.out.println();
                System.out.println(" 1.View Menu  \n 2.Order & Bill \n 3.Ratings \n 4.Exit");
                System.out.println();
                System.out.print("Enter service : ");
                int a = sc.nextInt();
                sc.nextLine(); // Consume newline
        
                switch (a) {
                    case 1:
                        // View menu
                        List<Menu> sList = MenuController.viewAllMenu();
                        if (!sList.isEmpty()) 
                        {
                            System.out.println();
                            System.out.println("        List of Menu:");
                            System.out.println("---------------------------------------");
                            for (Menu ve : sList)
                                System.out.println(ve);
                                // System.out.println();
                        } 
                        else
                            System.out.println("List of Menu Not Available !");
                            break;
                    case 2:
                        // Place order
                        boolean t=true; 
                        //double total_price = 0;
                        do{
                            // System.out.println("Place Your Order Here!");
                            System.out.println();
                            // System.out.print("Enter your name to order: ");
                            // String name=BillController.addname(email);

                            System.out.print("Enter item name: ");
                            String item_name=sc.nextLine();
        
                            System.out.print("Enter quantity: ");
                            int quantity=sc.nextInt();
                    
                            double unit_price=MenuController.addprice(item_name);
        
                            double net_price=(quantity*unit_price);
        
                           // total_price += net_price;

                            try
                            {
                                if(MenuController.updateAvailableMenu(quantity,item_name)) 
                                {
                                try
                                {
        
                                    // System.out.println("Order Placed!");
                                    System.out.println();
                                        boolean ad=MenuController.addBill(item_name,quantity,unit_price,net_price);
                                        if(ad) {
                                        System.out.print("Order Placed");
                                        System.out.println();
                                        BillController.addToCart(item_name,quantity,unit_price,net_price);
        
                                        // List<Bill> st = BillController.viewBill(name);
                                        //     if (!st.isEmpty()) 
                                        //     {
                                        //         System.out.println("Your Bill ");
                                        //         System.out.println("---------------------------------------");
                                        //         for (Bill ve : st)
                                        //             System.out.println(ve);
                                        //     } 
                                        
                                    }
                                        else {   
                                        System.out.println("Failed to add");}
        
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Ordered item or quantity not available.");
                                }
                            }
                                else
                                {
                                    System.out.println("Sorry for inconvienience!...Ordered item or quantity not available."); 
                                }
                        }
                        catch(Exception e)
                        {
                            System.out.println("Ordered item or quantity not available.");
                        }
                            System.out.println("Enter 1 to continue Order & 2 to stop");
                            int x=sc.nextInt();
                            sc.nextLine();
                            if(x==1)
                            t=true;
                            else{
                                System.out.println();
                                BillController.displayCart();
                                t=false;
                            }
                        } while(t);
                            break;
                    case 3:
                        // Rate the cafe
                        System.out.print("Rate the cafe (1-5): ");
                        int ratingValue = sc.nextInt();
                        RatingController.addRating(ratingValue);
                        break;
                    case 4:
                        // Exit
                        System.out.println();
                        System.out.println("Thank you for choosing us. We hope to see you again soon!");
                        System.out.println();
                        System.out.println( "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
                        b=false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (b);
    }



    
}
