package Resources;

public class OrdersDTO {
    private int orderid;
    private int quantity;
    private int cusid;


    public OrdersDTO(int orderid, int quantity, int cusid) {
        this.orderid = orderid;
        this.quantity = quantity;
        this.cusid = cusid;
    }

    public int getOrderid() {
        return this.orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCusid() {
        return this.cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }
    

}
