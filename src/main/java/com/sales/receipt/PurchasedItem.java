package com.sales.receipt;

import com.sales.basket.Item;

public class PurchasedItem {

    private Item item;
    private double tax;
    private double total;

    public PurchasedItem(Item item, double tax, double total){
        this.item = item;
        this.tax = tax;
        this.total = total;
    }

    public Item getItem() {return item;}

    public double getTax() {return tax;}

    public double getTotal() {return total;}
}
