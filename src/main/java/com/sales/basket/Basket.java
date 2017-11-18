package com.sales.basket;

import java.util.*;

public class Basket {

    private Vector<Item> items;

    public Basket(){ items = new Vector<Item>(); }

    public Basket(Vector<Item> items) { this.items = items; }

    public Vector<Item> getItems() {return items;}

    public void addItem(Item item) { this.items.add(item); }
}
