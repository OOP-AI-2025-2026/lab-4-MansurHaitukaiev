//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ua.opnu.java.inheritance.bill;

public class Item {
    private String name;
    private double price;
    private double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }
}
