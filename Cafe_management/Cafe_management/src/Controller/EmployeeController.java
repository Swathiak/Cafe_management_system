package Controller;

import java.util.List;

import Model.Employee;
import Model.EmployeeFunction;

public class EmployeeController {
   public static List<Employee> viewAllEmployee()
    {
        List<Employee> st =EmployeeFunction.viewAllEmployee();
        return st;
    }

    public static boolean removeEmployee(String emp_name) throws Exception
    {
        boolean b=EmployeeFunction.removeEmployee(emp_name);
        return b;
    }

    
    

    public static boolean addEmployee(String name,String role,int salary) throws Exception
    {
        try
        {
            boolean b=EmployeeFunction.addEmployee(name,role,salary);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Insertion");
        }
    }

    public static boolean updateEmployee(String new_role,int new_salary,String empname) throws Exception
    {
        try
        {
            boolean b=EmployeeFunction.updateEmployee(new_role,new_salary,empname);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Updation");
        }
    }
    
}
