# Sales Tax Calculator
======================
This simple Java program takes in a basket of items,
calculates the total tax and cost of the batch, and prints a receipt.

### How to Use
To run this simple Java Program in Terminal:
- first compile the program using "mvn clean package" in the project directory.
- This produces two jar files.
- Execute the jar file with dependencies in the target folder with "java -jar <jar file> <text file>"

The inputted text file must contain the list of items in a CSV format.
        Example of input:
        ```
        1,imported bottle of perfume,imported,27.99,MISC
        1,bottle of perfume,not imported,18.99,MISC
        1,packet of headache pills,not imported,9.75,MEDICAL
        1,imported box of chocolates,imported,11.25,FOOD
        ```
The program should output a receipt in this format:
        ```
        1 imported bottle of perfume: 32.19
        1 bottle of perfume: 20.89
        1 packet of headache pills: 9.75
        1 imported box of chocolates: 11.85
        Sales Taxes: 6.70
        Total: 74.68
        ```

- One can also run the script.sh file, which executes the program with above example (input3.txt in same directory).
