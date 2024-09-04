package Resources;

public class BillDTO {
    private int billid;
    private int total;
    private int itemno;

    public BillDTO(int billid, int total, int itemno) {
        this.billid = billid;
        this.total = total;
        this.itemno = itemno;
    }

    public int getBillid() {
        return this.billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getItemno() {
        return this.itemno;
    }

    public void setItemno(int itemno) {
        this.itemno = itemno;
    }

}
