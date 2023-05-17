package finalProject.models;

/**
 *
 * @author Alex Reburn
 */
public class Product implements Item {
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
    
    public boolean contains(String text) {
        return name.toLowerCase().contains(text.toLowerCase());
    }
    
    private String name;
    private double price;
}
