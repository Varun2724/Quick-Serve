package QuickServe;

import java.util.Scanner;

public class Driver {
    static Scanner scanner = new Scanner(System.in);
    static User user; // null

    public static void main(String[] args) {
        for (;;) {
            System.out.println();
            System.out.println("      WELCOME to QuickServe      ");
            
            System.out.println();/
            System.out.println("1. REGISTER USER");
            System.out.println("2. LOGIN");
            System.out.println("3. LOGOUT");
            System.out.println();

             
            System.out.println("Enter your option : ");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    registerUser();
                    break;
                case 2:
                     loginUser();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("HOME PAGE");
                    features();
                    break;
                case 3:
                    System.out.println("Thank you for using our service!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    
    private static void features() {
        // TODO Auto-generated method stub
        ((Driver) HomePage.java).features();
    }


    public static void loginUser() {
        if(user == null) {
            System.out.println("CREATE YOUR ACCOUNT FIRST");
            return;
        }
        System.out.println();
        System.out.println("LOGIN");
        System.out.println();
        System.out.println("USERNAME");
        String username = scanner.next();
        System.out.println("PASSWORD :");
        String password = scanner.next();

        for (int i = 3; i>= 1;i--){
            if (username.equals(user.name) && password.equals(user.password)){
                HomePage page = new HomePage();
                page.features();

            }else{
                System.out.println("INVALID CRED");
                System.out.println("ATTEMPT LEFT : " + (i-1));

            }
        }
        System.out.println("ITS NOT YOUR ACCOUNT");
        System.exit(0);
    }
    private static void registerUser(){
        System.out.println();
        System.out.println("REGISTER USER");
        System.out.println();
        System.out.println("Username : ");
        String name = scanner.next();
        System.out.println("Contact : ");
        long contact = scanner.nextLong();
        System.out.println("Email : ");
        String email = scanner.next();
        System.out.println("Address : ");
        scanner.nextLine();
        String address = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.next();

        user = new User(name, contact, address, email, password);
        System.out.println(user);
    }
}
