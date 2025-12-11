package QuickServe;
import java.util.ArrayList;

public class HomePage {
    private ArrayList<FoodItem> basket;
    private User loggedInUser;
    private Restaurant restaurant;

    public HomePage(User user, Restaurant restaurant) {
        this.loggedInUser = user;
        this.restaurant = restaurant;
        this.basket = new ArrayList<>();
    }
    public void features() {
        while (true) {
            System.out.println();
            System.out.println("------------- HOME PAGE------------");
            System.out.println("Welcome, " + loggedInUser.name + "!");
            System.out.println("1. Order Food");
            System.out.println("2. View Cart & Billing");
            System.out.println("3. User Profile");
            System.out.println("4. Logout");
            System.out.println(" - - - - - - - - - - - -  - - - -");
            System.out.print("Enter your option : ");
            int opt;
            try {
                opt = Integer.parseInt(Driver.scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (opt) {
                case 1:
                    orderFood();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    userProfile();
                    break;
                case 4:
                    System.out.println("Logging out");
                    return; 
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void userProfile() {
        loggedInUser.displayUser();
    }
    private void viewOrders() {
    if (basket.isEmpty()) {
        System.out.println("\nYour cart is empty.");
        return;
    }
    System.out.println("\n--------- CURRENT CART --------");
    for (FoodItem item : basket) {
        System.out.println(item);
    }

    Billing bill = new Billing(basket);
    bill.printBill(loggedInUser);

    System.out.print("Do you want to CONFIRM this order? (yes/no): ");
    String ans = Driver.scanner.nextLine().trim().toLowerCase();

    if (ans.equals("yes")) {
        bill.Bill(); 
        basket.clear();
        System.out.println("Order placed successfully!");
    } else {
        System.out.println("Order not confirmed.");
    }
}


    private void orderFood() {

    while (true) {
        System.out.println();
        restaurant.displayRestaurantDetails();
        restaurant.displayMenu();

        System.out.print("Enter Food IDs separated by comma (0 to go back): ");
        String input = Driver.scanner.nextLine().trim();

        if (input.equals("0")) {
            System.out.println("Returning to Home Page...");
            return;
        }
        String[] parts = input.split(",");
        boolean addedAny = false;
        for (String part : parts) {
            part = part.trim();

            if (part.isEmpty()) continue;
            int id;
            try {
                id = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID: " + part);
                continue;
            }

            FoodItem item = restaurant.findFoodById(id);
            if (item != null) {
                basket.add(item);
                System.out.println(item.getName() + " added to cart.");
                addedAny = true;
            } else {
                System.out.println("Item not found for ID: " + id);
            }
        }

        if (!addedAny) {
            System.out.println("No valid items selected.");
        }

        System.out.print("Do you want to add more items? (y/n): ");
        String more = Driver.scanner.nextLine().trim().toLowerCase();
        if (!more.equals("y")) break;
    }
}
}
