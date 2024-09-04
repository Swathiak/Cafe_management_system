package Model;

// import java.util.Arrays;

public class Menu {
    private int itemno;
    private String itemname;
    private double price;
    private int availableMenu;
    // static int menu1[][]=new int[5][5];
    // static int menu2[][]=new int[5][5];

    // static int menu3[][]=new int[5][5];
    // static 
    // {
    //     for(int i=0;i<5;i++)
    //     {
    //         Arrays.fill(menu1[i],0);
    //         Arrays.fill(menu2[i],0);
    //         Arrays.fill(menu3[i],0);
    //     }
    // }

    public Menu(int itemno, String itemname, double price,int availableMenu) {
        this.itemno = itemno;
        this.itemname = itemname;
        this.price = price;
        this.availableMenu = availableMenu;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvail() {
        return availableMenu;
    }

    public void setAvail(int availableMenu) {
        this.availableMenu = availableMenu;
    }
    public String toString() {
        return " Menu ---[" +
                "Itemno- " + itemno + 
                " | Itemname- " + itemname + 
                "  | Price - " + price + 
                " |  Availability -  " + availableMenu+
                ']';

    }

}
