package Model;

public class Bill {
    // private int bill_id;
    private String cus_name;
    private String item_name;
    private int quantity;
    private double unit_price; 
    private double net_price; 
    private double total_price; 


    public Bill(String cus_name,String item_name, int quantity, double unit_price, double net_price,double total_price) {
        // this.bill_id = bill_id;
        this.cus_name = cus_name;
        this.item_name = item_name;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.net_price = net_price;
        this.total_price = total_price;
    }


    // public int getBill_id() {
    //     return this.bill_id;
    // }

    // public void setBill_id(int bill_id) {
    //     this.bill_id = bill_id;
    // }
    public String getcus_name() {
        return this.cus_name;
    }

    public void setcus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getItem_name() {
        return this.item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getUnit_price() {
        return this.unit_price;
    }
    
    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    
    public double getNet_price() {
        return this.net_price;
    }
    
    public void setNet_price(double net_price) {
        this.net_price = net_price;
    }
    
    public double getTotal_price() {
        return this.total_price;
    }
    
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    
    public String toString() {
        return " Your Bill:-" +
                // " \n \n Bill Id : " + bill_id  +
                "\n \n Cus Name : " + cus_name+
                "\n \n Item_name : " + item_name  +
                "\n \n Quantity : " + quantity + 
                "\n \n Unit_Price : " + unit_price+
                "\n \n Net_Price : " + net_price +
                "\n \n Total_Price: " + total_price +
                "\n" ;
    }
    // public String toString1() {
    //     return " Final Bill:-" +
    //             "\n \n Total_Price : " + total_price;
    // }
    
}
