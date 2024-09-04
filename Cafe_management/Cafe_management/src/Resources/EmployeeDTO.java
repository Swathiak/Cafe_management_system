package Resources;

public class EmployeeDTO {
    private int empid;
    private String empname;
    private String designation;
    private String empSalary;

    public EmployeeDTO(int empid, String empname, String designation, String empSalary) {
        this.empid = empid;
        this.empname = empname;
        this.designation = designation;
        this.empSalary = empSalary;
    }

    public int getEmpid() {
        return this.empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return this.empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmpSalary() {
        return this.empSalary;
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = empSalary;
    }

}
