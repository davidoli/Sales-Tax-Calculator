package com.sales.basket;

public class Item {

    public enum Type {
        BOOK, FOOD, MEDICAL, MISC;
    }

    private String name;
    private Type type;
    private boolean imported;
    private int quantity;
    private double price;

    public Item(String name, Type type, boolean imported, int quantity, double price){
        this.name = name;
        this.type = type;
        this.imported = imported;
        this.quantity = quantity;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public boolean isImported() {
        return imported;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

}