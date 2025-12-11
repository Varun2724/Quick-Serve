package QuickServe;

import java.util.List;

public class Billing {

    private List<FoodItem> items;
    private double total;
    private double taxAmount;
    private double grandTotal;

    private static final double Tax_percent = 0.05;
    public Billing(List<FoodItem> items) {
        this.items = items;
        calculateTotals();
    }
    private void calculateTotals() {
        total = 0;
        for (FoodItem item : items) {
            total = total+item.getPrice();
        }
        taxAmount = total*Tax_percent;
        grandTotal = total + taxAmount;
    }
    public void printBill(User user) {
        System.out.println();
        System.out.println("---------- BILL----------");
        if (user != null) {
            System.out.println("Customer : " + user.name);
            System.out.println("Contact  : " + user.contact);
        }
        System.out.println("Items:");
        for (FoodItem item : items) {
            System.out.printf(" - %-25s %.2f Rs%n", item.getName(), item.getPrice());
        }
        System.out.println("----------------------------------");
        System.out.printf("Subtotal : %.2f Rs%n", total);
        System.out.printf("Tax (%.0f%%) : %.2f Rs%n", Tax_percent* 100, taxAmount);
        System.out.println("----------------------------------");
        System.out.printf("TOTAL   : %.2f Rs%n", grandTotal);
        System.out.println("---------------------------");
        System.out.println("Thank you for ordering with QuickServe!");
    }
    public void Bill() {
        System.out.println("Bill has been passed.");
    }
}
