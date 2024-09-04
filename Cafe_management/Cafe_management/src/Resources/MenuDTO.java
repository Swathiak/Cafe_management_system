package Resources;

public class MenuDTO {
    private int itemno;
    private String itemname;
    private double itemprice;
    private int empid;

    public MenuDTO(int itemno, String itemname, double itemprice, int empid) {
        this.itemno = itemno;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.empid = empid;
    }

    public int getItemno() {
        return this.itemno;
    }

    public void setItemno(int itemno) {
        this.itemno = itemno;
    }

    public String getItemname() {
        return this.itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getItemprice() {
        return this.itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    public int getEmpid() {
        return this.empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }
    
}
