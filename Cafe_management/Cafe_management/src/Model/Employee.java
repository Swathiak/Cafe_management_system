package Model;

public class Employee {
    private int id;
    private String name;
    private String role;
    private int salary;


    public Employee( int id,String name, String role, int salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int empsalary) {
        this.salary = empsalary;
    }
    
    public String toString() {
        return " Employee --- [" +
                 "Emp Id-" + id  +
                "| Emp Name-" + name  +
                "| Role-" + role + 
                "| Salary-" + salary+
                ']';
    }
    
}
