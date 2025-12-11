package QuickServe;

public class FoodItem {

    private static int NEXT_ID = 101; 
    int foodId;
    String name;
    String type;   
    double price;
    public FoodItem(String name, String type, double price) {
        this.foodId = NEXT_ID++;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public int getFoodId() {
        return foodId;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public void displayFoodItem() {
        System.out.printf("%d : %s (%s) - %.2f Rs%n", foodId, name, type, price);
    }
    @Override
    public String toString() {
        return foodId + " : " + name + " (" + type + ") - " + price + " Rs";
    }
}
