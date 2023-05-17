package finalProject.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Reburn
 */
public class Store {

    public Store() {
        this.transactions = new ArrayList<>();
        this.aisles = new ArrayList<>();
        this.createAisles();
    }

    public void addAisle(Aisle aisle) {
        this.aisles.add(aisle);
    }

    public List<Aisle> getAisles() {
        return this.aisles;
    }

    public Aisle getAisle(int aisleNumber) {
        for (Aisle aisle : aisles) {
            if (aisle.getAisleNumber() == aisleNumber) {
                return aisle;
            }
        }
        return null;
    }

    public List<Item> getItems(int aisleNumber) {
        Aisle aisle = getAisle(aisleNumber);
        if (aisle != null) {
            return aisle.getItems();
        }
        return null;
    }
    
    public void createAisles() {
        Aisle fruitAisle = new Aisle(1, "Fruit");
        fruitAisle.addProduct(new Product("Apple", 0.99));
        fruitAisle.addProduct(new Product("Banana", 0.69));
        Product discountingItem = new Product("Orange", 1.19);
        fruitAisle.addProduct(discountingItem);
        fruitAisle.addProduct(new DiscountedProduct(discountingItem, 0.2));
        aisles.add(fruitAisle);

        Aisle drinksAisle = new Aisle(2, "Drinks");
        drinksAisle.addProduct(new Product("Coke", 1.99));
        drinksAisle.addProduct(new Product("Sprite", 1.99));
        drinksAisle.addProduct(new Product("Pepsi", 1.99));
        aisles.add(drinksAisle);

        Aisle meatsAisle = new Aisle(3, "Meats");
        meatsAisle.addProduct(new Product("Beef", 5.99));
        meatsAisle.addProduct(new Product("Pork", 4.99));
        meatsAisle.addProduct(new Product("Chicken", 3.99));
        aisles.add(meatsAisle);

        Aisle cheeseAisle = new Aisle(4, "Cheese");
        cheeseAisle.addProduct(new Product("Cheddar", 2.99));
        cheeseAisle.addProduct(new Product("Mozzarella", 3.99));
        cheeseAisle.addProduct(new Product("Swiss", 4.99));
        aisles.add(cheeseAisle);

        Aisle candyAisle = new Aisle(5, "Candy");
        candyAisle.addProduct(new Product("Gummy Bears", 0.99));
        candyAisle.addProduct(new Product("M&M's", 1.29));
        candyAisle.addProduct(new Product("Sour Patch Kids", 1.49));
        
        ProductBundle candyBundle = new ProductBundle();
        candyBundle.addProduct(new Product("Gummy Bears", 0.99));
        candyBundle.addProduct(new Product("M&M's", 1.29));
        
        candyAisle.addProduct(candyBundle);
        aisles.add(candyAisle);
        
        products = new ArrayList<Item>();
        for(Aisle a : aisles) {
            for(Item i : a.getItems()) {
                products.add(i);
            }
        }
    }
    
    /**
     * Finds and returns account with credentials matching the input.
     * @param username  the string in the username text box.
     * @param password  the string in the password text box.
     * @return account  the account matching the credentials.
     */
    public static Account getAccount(String username, String password) {
        for (Account account : accounts) {
            if (!account.getUsername().equals(username) 
                    || !account.checkPassword(password)){
            } else {
                return account;
            }
        }
        return null;
    }
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public List<Item> getItems() {
        return products;
    }
    
    private List<Item> products;
    private List<Aisle> aisles;
    public Account currentAccount;
    
    //List of Accounts in the database.
    private static final Account[] accounts = {
        new Account("Alex", "password1", new Cart()),
        new Account("John", "password2", new Cart()),
        Manager.getInstance() //Manager is a Singleton.
    };
    
    private List<Transaction> transactions;
}