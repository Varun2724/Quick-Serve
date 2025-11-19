package QuickServe;

public class FoodItem {
    static int id = 1234;
    public static FoodItem java;
    int foodId;
    String name;
    String type;
    double price;

    public FoodItem( String name, String type, double price) {
        super();
        this.foodId = id++;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public void displayFoodItem(){
        System.out.println(foodId + ": " + type+ ": " + name + ": " + price+" Rs");
       
        System.out.println();
        System.out.println("101 : " + "MasalaDosa");
        System.out.println("102 : "  );
        System.out.println("103 : " );
        System.out.println("104 : " );
        System.out.println("105 : " );

    }
    
    
}
