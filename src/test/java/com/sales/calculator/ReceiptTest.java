package com.sales.calculator;
import java.io.IOException;
import java.util.Vector;
import com.sales.basket.Item;
import com.sales.receipt.PurchasedItem;
import com.sales.receipt.Receipt;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReceiptTest {
    @Test
    public void testPurchasedItem() throws IOException {
        PurchasedItem purchasedItem = new PurchasedItem(
                new Item("chocolate", Item.Type.FOOD, false, 1, 2),
                0, 2
        );
        PurchasedItem purchasedItem2 = new PurchasedItem(
                new Item("imported music CD", Item.Type.MISC, true, 1, 10),
                1.5, 11.5
        );
        assertEquals(2, purchasedItem.getTotal(), .005);
        assertEquals(0, purchasedItem.getTax(), .005);
        assertEquals("chocolate", purchasedItem.getItem().getName());
        assertEquals(false, purchasedItem.getItem().isImported());
        assertEquals(Item.Type.FOOD, purchasedItem.getItem().getType());
        assertEquals(11.5, purchasedItem2.getTotal(), .005);
        assertEquals(1.5, purchasedItem2.getTax(), .005);
        assertEquals("imported music CD", purchasedItem2.getItem().getName());
        assertEquals(true, purchasedItem2.getItem().isImported());
        assertEquals(Item.Type.MISC, purchasedItem2.getItem().getType());
    }
    @Test
    public void testReceipt() throws IOException {
        Vector<PurchasedItem> purchasedItem = new Vector<PurchasedItem>();
        Receipt receipt = new Receipt(purchasedItem,0,0);
        assertEquals(0, receipt.getPurchasedItems().size());
        assertEquals(0, receipt.getTotalTax(), .005);
        assertEquals(0, receipt.getTotalCost(),.005);
    }
}