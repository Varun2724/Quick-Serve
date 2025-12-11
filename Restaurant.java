package QuickServe;

import java.util.ArrayList;

public class Restaurant {

    String name;
    String address;
    long contact;
    ArrayList<FoodItem> menu;
    public Restaurant(String name, String address, long contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.menu = new ArrayList<>();
        addFoodList();
    }
    private void addFoodList() {
        menu.add(new FoodItem("Masala Dosa", "Veg", 80));
        menu.add(new FoodItem("Paneer Butter Masala", "Veg", 180));
        menu.add(new FoodItem("Veg Biryani", "Veg", 150));
        menu.add(new FoodItem("Mushroom Biryani", "Veg", 220));
        menu.add(new FoodItem("Paneer Tikka", "Veg", 260));
        menu.add(new FoodItem("Paneer Tandoori", "Veg", 300));
        menu.add(new FoodItem("Pasta", "Veg", 140));
    }
    public void displayRestaurantDetails() {
        System.out.println("Restaurant : " + name);
        System.out.println("Address    : " + address);
        System.out.println("Contact    : " + contact);
    }
    public void displayMenu() {
        System.out.println();
        System.out.println("--------- MENU --------");
        for (FoodItem item : menu) {
            item.displayFoodItem();
        }
    }
    public FoodItem findFoodById(int id) {
        for (FoodItem item : menu) {
            if (item.getFoodId() == id) {
                return item;
            }
        }
        return null;
    }
}
