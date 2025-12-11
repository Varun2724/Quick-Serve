package QuickServe;

public class User {
    String name;
    long contact;
    String address;
    String email;
    String password;
    public User(String name, long contact, String address, String email, String password) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    public void displayUser() {
        System.out.println();
        System.out.println("---------USER PROFILE---------");
        System.out.println("Username : " + name);
        System.out.println("Contact  : " + contact);
        System.out.println("Email    : " + email);
        System.out.println("Address  : " + address);
        System.out.println("Password : " + password);
    }
}

    
