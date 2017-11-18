package com.sales.calculator;
import com.sales.basket.Basket;
import com.sales.basket.Item;
import static org.junit.Assert.*;
import org.junit.Test;


public class BasketTest {

    @Test
    public void testBasket() {
        Basket basket = new Basket();
        basket.addItem(new Item("chocolate", Item.Type.FOOD, false, 1, 2));
        assertEquals(1, basket.getItems().size());

        assertEquals("chocolate", basket.getItems().get(0).getName());
        assertEquals(Item.Type.FOOD, basket.getItems().get(0).getType());
        assertEquals(false, basket.getItems().get(0).isImported());
        assertEquals(1, basket.getItems().get(0).getQuantity());
        assertEquals(2, basket.getItems().get(0).getPrice(), .005);
    }
}
