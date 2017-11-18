package com.sales.calculator;

import com.sales.basket.Basket;
import com.sales.basket.Item;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static final String PROVIDED_INPUT_3 = "src/test/resources/input/testinput3.txt";
    @Test
    public void testTaxCalculator() {
        TaxCalculator taxCalculator = new TaxCalculator();
        assertEquals(0 , taxCalculator.calculateTax(new Item("chocolate", Item.Type.FOOD, false, 1, 2)), .005);
        assertEquals(1 , taxCalculator.calculateTax(new Item("music CD", Item.Type.MISC, false, 1, 10)), .005);
        assertEquals(.1 , taxCalculator.calculateTax(new Item("imported chocolate", Item.Type.FOOD, true, 1, 2)),.005);
        assertEquals(1.5 , taxCalculator.calculateTax(new Item("imported music CD", Item.Type.MISC, true, 1, 10)), .005);
        assertEquals(4.2, taxCalculator.calculateTax(new Item("imported perfume",Item.Type.MISC, true, 1, 27.99)), .005);
    }
    @Test
    public void testBillingCalculator() {
        BillingCalculator billingCalculator = new BillingCalculator(new TaxCalculator());
        Basket testBasket = new Basket();
        testBasket.addItem(new Item("chocolate", Item.Type.FOOD, false, 1, 2));
        Basket testBasket2 = new Basket();
        testBasket2.addItem(new Item("imported music CD", Item.Type.MISC, true, 1, 10));
        assertEquals(2,billingCalculator.purchase(testBasket).getTotalCost(), .005);
        assertEquals(0,billingCalculator.purchase(testBasket).getTotalTax(), .005);
        assertEquals(1, billingCalculator.purchase(testBasket).getPurchasedItems().size());
        assertEquals("chocolate", billingCalculator.purchase(testBasket).getPurchasedItems().get(0).getItem().getName());
        assertEquals(11.5,billingCalculator.purchase(testBasket2).getTotalCost(), .005);
        assertEquals(1.5,billingCalculator.purchase(testBasket2).getTotalTax(), .005);
        assertEquals(1, billingCalculator.purchase(testBasket2).getPurchasedItems().size());
        assertEquals("imported music CD", billingCalculator.purchase(testBasket2).getPurchasedItems().get(0).getItem().getName());
        testBasket2.addItem(new Item("imported perfume",Item.Type.MISC, true, 2, 27.99));
        assertEquals(2, billingCalculator.purchase(testBasket2).getPurchasedItems().size());
        assertEquals(8.4, billingCalculator.purchase(testBasket2).getPurchasedItems().get(1).getTax(), .005);
        assertEquals(75.88, billingCalculator.purchase(testBasket2).getTotalCost(),.005);
        assertEquals(9.9, billingCalculator.purchase(testBasket2).getTotalTax(),.005);


    }
}

