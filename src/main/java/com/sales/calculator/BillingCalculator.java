package com.sales.calculator;

import com.sales.basket.Basket;
import com.sales.basket.Item;
import com.sales.receipt.PurchasedItem;
import com.sales.receipt.Receipt;
import java.util.Vector;

public class BillingCalculator {

    private final TaxCalculator taxCalculator;

    public BillingCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public Receipt purchase(Basket basket){
        Vector<PurchasedItem> purchasedItems = new Vector<PurchasedItem>();        //stores purchased items
        double totalTax = 0.0;
        double totalCost = 0.0;
        for (int i = 0; i < basket.getItems().size(); i++){        //iterate items in basket
            Item currentItem = basket.getItems().get(i);
            double numberOfItem = currentItem.getQuantity();
            double taxOfItem = taxCalculator.calculateTax(currentItem) * numberOfItem; //calculate tax for individual item
            double totalCostOfItem = currentItem.getPrice() * numberOfItem + taxOfItem;//calculate cost of individual item
            totalTax += taxOfItem;                                                     //add to total Tax
            totalCost += totalCostOfItem;                                              //add to total Cost
            purchasedItems.add(new PurchasedItem(currentItem, taxOfItem, totalCostOfItem));
        }
        return new Receipt(purchasedItems, totalTax, totalCost);
    }
}
