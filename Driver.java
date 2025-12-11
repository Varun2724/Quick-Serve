package QuickServe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
    static Scanner scanner = new Scanner(System.in);
    static User user;                
    static Restaurant restaurant;   

    public static void main(String[] args) {
        restaurant = new Restaurant(
                "QuickServe ",
                "224, Food Street, City Pride Kothrud",
                9876543210L
        );

        while (true) {
            System.out.println();
            System.out.println("WELCOME to QuickServe");
            System.out.println("1. REGISTER USER");
            System.out.println("2. LOGIN");
            System.out.println("3. EXIT");
            System.out.println("-------------x-x-x-------------");
            int opt;
            try {
                opt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (opt) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Thank you for using QuickServe");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void registerUser() {
        System.out.println();
        System.out.println("--------- REGISTER USER ---------");
        System.out.print("Username : ");
        String name = scanner.nextLine();

        System.out.print("Contact no : ");
        long contact;
        String phone = scanner.nextLine();
        Pattern pt = Pattern.compile("^\\d{10}$");  // 9595716046
        Matcher mt = pt.matcher(phone);
        if(mt.matches()){
        }
        else{
            System.out.println("invalid");
        }
        contact = Long.parseLong(phone); 
        
        
        System.out.print("Email : ");
        String email = scanner.nextLine();
        Pattern pt1 = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$");
        Matcher mt1 = pt1.matcher(email);
        if(mt1.matches()){
    
        } else{
            System.out.println("invalid");
        }

        System.out.print("Address : ");
        String address = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        user = new User(name, contact, address, email, password);
        System.out.println("\nUser registered successfully!");
        user.displayUser();
    }
                                           //login
    public static void loginUser() {

        if (user == null) {
            System.out.println("\nNo User Register user Before Login");
            return;
        }

        int attempts = 3;

        while (attempts > 0) {
            System.out.println();
            System.out.println("--------------- LOGIN ---------------");
            System.out.print("USERNAME : ");
            String username = scanner.nextLine();
            System.out.print("PASSWORD : ");
            String password = scanner.nextLine();

            if (username.equals(user.name) && password.equals(user.password)) {
                System.out.println("\nLogin Successful! " + user.name + "!");
                HomePage page = new HomePage(user, restaurant);
                page.features();   
                return;
            } else {
                attempts--;
                System.out.println("INVALID CREDENTIALS. Attempts left : " + attempts);
            }
        }

        System.out.println("Maximum login attempts reached. Returning to main menu.");
    }
}

