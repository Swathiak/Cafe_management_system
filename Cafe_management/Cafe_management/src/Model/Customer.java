package Model;

public class Customer {
    private int cusid;
    private String email;
    private String password;
    private String cusname;
    private String phno;


    public Customer(int cusid,String email,String password,String cusname, String phno) {
        this.cusid = cusid;
        this.email = email;
        this.password = password;
        this.cusname = cusname;
        this.phno = phno;
    }

    public String getemail() {
        return this.email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    


    public String toString() {
        return " Customer --- [" +
                " Customer Id- " + cusid + 
                "| Email- " + email + 
                "| Password- " + password + 
                "| Customer Name- " + cusname + 
                "| Phoneno- " + phno + 
                ']';
    }

}
