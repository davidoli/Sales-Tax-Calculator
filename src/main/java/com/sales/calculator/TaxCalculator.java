package com.sales.calculator;


import com.sales.basket.Item;

public class TaxCalculator {

    private static final double salesTax = 10;
    private static final double importTax = 5;

    public TaxCalculator(){}

    public double calculateTax(Item item){

        double tax = 0;

        if (item.getType() == Item.Type.MISC)
            tax += item.getPrice() * salesTax / 100;

        if (item.isImported())
            tax += item.getPrice() * importTax / 100;

        double roundedTax = Math.ceil(tax * 20.0) / 20.0;

        return roundedTax;
    }
}
