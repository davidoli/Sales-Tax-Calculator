package com.sales;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import com.sales.calculator.*;
import com.sales.basket.*;
import com.sales.receipt.*;


public class Main {

    public static void main(String[] arg) {
        Logger logger = Logger.getLogger("Sales Calculator");
        BasicConfigurator.configure();

        if (arg.length < 1) {                                               //needs argument
            logger.warn("Expecting a input path for the item basket");
        }

        File input = new File(arg[0]);                         //reads in csv input file
        String line;
        Scanner sc = null;
        try {
            sc = new Scanner(input);
        } catch (FileNotFoundException e) {
            logger.error("File not Found!");
        }

        BillingCalculator billing = new BillingCalculator(new TaxCalculator());
        Basket basket = new Basket();

        while (sc.hasNextLine()) {                           //navigate through each line in csv file

            line = sc.nextLine();
            String[] wordsInLine = line.split(",");   //Split CSV file

            if(wordsInLine.length != 5) {              //check for valid basket item format
                logger.error("Incorrect CSV File Format");
                break;
            }

            String name = wordsInLine[1]; Item.Type type = Item.Type.MISC; boolean imp = false; int quantity = 0; double price = 0.0;

            try {                                            //catch Number Format Exception for Price or Quantity
                quantity = Integer.parseInt(wordsInLine[0]);
                price = Double.parseDouble(wordsInLine[3]);
            } catch(NumberFormatException e){
                logger.error("Improper number input in text file.");
            }

            if (wordsInLine[2].equals("imported"))                //check imported or not
                imp = true;
            if (wordsInLine[4].equals("BOOK")) { type = Item.Type.BOOK; }     //check for item type
            else if (wordsInLine[4].equals("FOOD")) { type = Item.Type.FOOD; }
            else if (wordsInLine[4].equals("MEDICAL")){ type = Item.Type.MEDICAL; }

            Item newItem = new Item(name, type, imp, quantity, price);

            basket.addItem(newItem);
        }

        Receipt receipt = billing.purchase(basket);            //calculate and store results in receipt object

        NumberFormat df = new DecimalFormat("#0.00");
        df.setMaximumFractionDigits(2);

        for (int i = 0; i<receipt.getPurchasedItems().size(); i++){       //print Receipt's variables
            System.out.println(
                    receipt.getPurchasedItems().get(i).getItem().getQuantity() + " "
                    + receipt.getPurchasedItems().get(i).getItem().getName() + ": "
                    + df.format(receipt.getPurchasedItems().get(i).getTotal())
            );
        }
        System.out.println("Sales Taxes: " + df.format(receipt.getTotalTax()));
        System.out.println("Total: " + df.format(receipt.getTotalCost()));
    }
}
