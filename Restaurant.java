package QuickServe;
import java.util.ArrayList;


public class Restaurant {
    
        String name;
        String address;
        long contact;
        ArrayList<FoodItem> list;

        public Restaurant(String name, String address, long contact, ArrayList<FoodItem> list) {
            super();
            this.name = name;
            this.address = address;
            this.contact = contact;
            this.list = addFoodList();

        }

        private ArrayList<FoodItem> addFoodList() {
            ArrayList<FoodItem> list = new ArrayList<>();
            list.add(new FoodItem("Biryani","Non-veg", 200 ));
            list.add(new FoodItem("Chicken Tikka","Non-Veg", 300 ));
            list.add(new FoodItem("Chicken Tandoor","Non-veg", 400));
            list.add(new FoodItem("Pasta","Veg", 150));
            return list;

            
        }

    
}
