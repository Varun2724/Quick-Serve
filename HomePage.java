package QuickServe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class HomePage extends Driver { 
 static ArrayList<String> feedbacks = new ArrayList<String>();
 static ArrayList<FoodItem> basket;
 public static Object java;


 public void features() {
        for(;;){
            System.out.println("HOME PAGE ");
            System.out.println("1. Order Food");
            System.out.println("2. View All Orders");
            System.out.println("3. User Profile");
            System.out.println("4. Logout");

            System.out.println();
            System.out.println("Enter your Option : ");
            int opt = Driver.scanner.nextInt();
            switch (opt){
                case 1:
                    System.out.println("Order Food");
                    //FoodItem( String name, String type, double price);
                    orderFood();
                    break;
                case 2:
                    System.out.println("View All Orders");
                    break;
                case 3:
                    System.out.println("User Profile");
                    break;
                case 4:
                    System.out.println("Thank you for visit Again");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    private void userProfile() {
        
        Driver.user.displayUser();
    }
    private void viewOrders() {
        
    }
    private void orderFood() {
        ((FoodItem) FoodItem.java).displayFoodItem();
        basket = new ArrayList<FoodItem>();
        
    }
}
