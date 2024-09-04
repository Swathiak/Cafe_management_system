package View;

import java.util.List;
import java.util.Scanner;

import Controller.AdminController;
import Controller.CustomerController;
import Controller.EmployeeController;
import Controller.MenuController;
import Model.Customer;
import Model.Employee;
import Model.Menu;

public class AdminView {
    static Scanner sc=new Scanner(System.in);
    static AdminController uc=new AdminController();
    public static void login()
    {
        boolean t=true;
        do{
        System.out.println("------------------------------------------");
        System.out.print("Enter your Email    : ");
        String email=sc.next();
        System.out.print("Enter your password : ");
        String pass=sc.next();
        System.out.println("------------------------------------------");
        System.out.println();
        try
        {
            if(uc.validateUser(email,pass)==true)
            {
                //uc.chooseMenu(email);
                System.out.println();
                System.out.println("Welcome Admin");
                t=false;
            }
        }
        catch (Exception e)
        {
            System.out.println(" Please Enter valid Details ");
        }

    }while(t);
        boolean b=true;
        do
        {
            System.out.println();
            System.out.println(" 1.Add Employee \n 2.View Employee \n 3.Update Employee Details \n 4.Remove Employee \n 5.Add Menu \n 6.View Menu \n 7.Update Menu \n 8.Remove Menu \n 9.View Customer \n 10.Remove Customer \n 11.Exit ");
            System.out.println();
            System.out.print("Enter service : ");
            int a = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch(a){
                case 1:
                // 1.Add Employee 
                System.out.print("Enter Employee Name : ");
                String name = sc.next();
                System.out.print("Enter Role:  : ");
                String role = sc.next();
                System.out.print("Enter Employee Salary: ");
                int salary=sc.nextInt();
                System.out.println();
                    try{
                        if(EmployeeController.addEmployee(name,role,salary))
                            System.out.println("Employee added !");
                        else
                            System.out.println("Can't Add this Employee");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error during adding employee");
                    }
                    break;

                case 2:
                // 2.View Employee
                List<Employee> st = EmployeeController.viewAllEmployee();
                    if (!st.isEmpty()) 
                    {
                        System.out.println("        List of Employees ");
                        System.out.println("---------------------------------------");
                        for (Employee ve : st)
                            System.out.println(ve);
                    } 
                    else{
                        System.out.println("No Employees ");
                    }
                    break;
                
                case 3:
                // Update Employee Details 
                System.out.print("Enter employee name: ");
                String empname = sc.nextLine();        
                System.out.print("Enter new role: ");
                String new_role = sc.next();
                System.out.print("Enter new salary: ");
                int new_salary = sc.nextInt();
                System.out.println();
                try{
                    if(EmployeeController.updateEmployee(new_role,new_salary,empname))
                        System.out.println("Employee details updated !");
                    else
                        System.out.println("Employee can't be updated.");
                }
                catch(Exception e)
                {
                    System.out.println("Error during updating employee");
                }
                break;

                case 4:
                // 4.Remove Employee
                System.out.print("Enter the Employee Name to delete: ");
                   String emp_name = sc.next();
                    sc.nextLine();
                    try
                    {
                        boolean ad=EmployeeController.removeEmployee(emp_name);
                        if(ad) {
                         System.out.println();
                         System.out.println("Employee removed !");}
                        else    
                        System.out.println("Employee with this id does not exist !!");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove Employee .");
                    }
                    break;

                case 5:
                // Add Menu
                //System.out.println("You can Add Menus... ");

                System.out.print("Enter Item Name : ");
                String itemname = sc.nextLine();
                System.out.print("Enter Price: ");
                int price=sc.nextInt();
                System.out.print("Enter Menu_availability ");
                int avail=sc.nextInt();
                System.out.println();
                    try{
                        if(MenuController.addMenu(itemname,price,avail))
                            System.out.println("Menu added !");
                        else
                            System.out.println("Can't add this menu.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error during adding Menu");
                    }
                    break;

                case 6:
                //  6.View Menu
                List<Menu> sList = MenuController.viewAllMenu();
                    if (!sList.isEmpty()) 
                    {
                        System.out.println();
                        System.out.println("        List of Menu:");
                        System.out.println("---------------------------------------");
                        for (Menu ve : sList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Menu for today");
                break;
                case 7:
                
                // Update Menu
                System.out.print("Enter Item name : ");
                String item_name = sc.next();        
                System.out.print("Enter menu_availability : ");
                int menu_avail=sc.nextInt();
                try{
                    if(MenuController.updateMenu(menu_avail,item_name))
                        System.out.println("Menu quantity updated !");
                    else
                        System.out.println("You can't this menu.. ");
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
                break;

            
                case 8:
                //  7.Remove Menu
                System.out.print("Enter the Itemno to delete: ");
                    int itemno = sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    try
                    {
                        boolean ad=MenuController.removeMenu(itemno);
                        if(ad) 
                         System.out.println("Menu item removed !");
                        else    
                        System.out.println("No items available with this id.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove Menu item from the database.");
                    }
                    break;
                
               // case 9:
                // //Add Customer
                // System.out.print("Enter Customer Name : ");
                // String cusname = sc.next();
                // System.out.print("Enter Customer Phone.no: ");
                // String phno=sc.nextInt();
                // System.out.println();
                //     try{
                //         if(CustomerController.addCustomer(cusname,phno))
                //             System.out.println("Customer has been added");
                //         else
                //             System.out.println("Error during adding Customer");
                //     }
                //     catch(Exception e)
                //     {
                //         System.out.println("Error during adding Customer");
                //     }
                //     break;

                case 9:
                //View Customer
                List<Customer> list = CustomerController.viewAllCustomer();
                    if (!list.isEmpty()) 
                    {
                        System.out.println("        List of Customer ");
                        System.out.println("---------------------------------------");
                        for (Customer ve : list)
                            System.out.println(ve);
                    } 
                    else{
                        System.out.println("No Customers ");
                    }
                    break;

                case 10:
                //  9.Remove Customer
                System.out.print("Enter the Customer ID to delete: ");
                    int cusid = sc.nextInt();
                    sc.nextLine();
                    try
                    {
                        boolean ad=CustomerController.removeCustomer(cusid);
                        if(ad) {
                        System.out.println();
                         System.out.println("Customer removed !");}
                        else    
                        System.out.println();
                        System.out.println("Failed to remove Customer !");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove Customer from the database.");
                    }
                    break;
                    
                case 11:
                // 10.Exit
                    System.out.println();
                    System.out.println("You have managed the Cafe structure! ");
                    System.out.println();
                    System.out.println( "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
                    b=false;
                    break;
            }

        }
        while(b);
    }

}
