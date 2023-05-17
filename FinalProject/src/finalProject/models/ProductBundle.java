package finalProject.models;

import java.util.ArrayList;

/**
 *
 * @author Alex Reburn
 */
public class ProductBundle implements Item {
    private ArrayList<Item> products;
    
    public ProductBundle() {
        products = new ArrayList<>();
    }
    
    public void addProduct(Item product) {
        products.add(product);
    }
    
    public void removeProduct(Item product) {
        products.remove(product);
    }
    
    @Override
    public String getName() {
        String bundleName = "Bundle (";
        for (int i = 0; i < products.size(); i++) {
            bundleName += products.get(i).getName();
            if (i < products.size() - 1) {
                bundleName += ", ";
            }
        }
        bundleName += ")";
        return bundleName;
    }
    
    @Override
    public double getPrice() {
        double total = 0;
        for (Item product : products) {
            total += product.getPrice();
        }
        return total;
    }
    
    /**
     * Retrieves the String of the Bundled Product.
     * @return the Discounted Product String.
     */
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean contains(String text) {
        for (Item product : products) {
            if(product.getName().toLowerCase().contains(text.toLowerCase())) {
                return true;
            }    
        }
        return false;
    }
}