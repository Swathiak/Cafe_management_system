package Resources;

public class CustomerDTO {
    private int cusid;
    private String cusname;
    private String phno;
    private int itemno;

    public CustomerDTO(int cusid, String cusname, String phno, int itemno) {
        this.cusid = cusid;
        this.cusname = cusname;
        this.phno = phno;
        this.itemno = itemno;
    }

    public int getCusid() {
        return this.cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return this.cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getPhno() {
        return this.phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public int getItemno() {
        return this.itemno;
    }

    public void setItemno(int itemno) {
        this.itemno = itemno;
    }
}

