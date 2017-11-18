package com.sales.receipt;

import java.util.Vector;

public class Receipt {
    private Vector<PurchasedItem> purchasedItems;
    private double totalTax;
    private double totalCost;

    public Receipt(Vector<PurchasedItem> purchasedItems, double totalTax, double totalCost) {
        this.purchasedItems = purchasedItems;
        this.totalTax = totalTax;
        this.totalCost = totalCost;
    }
    public Vector<PurchasedItem> getPurchasedItems() {
        return purchasedItems;
    }

    public double getTotalTax() { return totalTax; }

    public double getTotalCost() {
        return totalCost;
    }
}
