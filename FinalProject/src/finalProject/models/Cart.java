package finalProject.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Reburn
 */
public class Cart {

    /**
     * Constructor of the Cart object.
     */
    public Cart() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the current Cart object.
     * @param item  the item being added to the ArrayList.
     */
    public void addItem(Item item) {
        items.add(item);
        total += item.getPrice();
    }

    /**
     * Removes an item to the current Cart object.
     * @param item  the item being removed from the ArrayList.
     */
    public void removeItem(Item item) {
        items.remove(item);
        total -= item.getPrice();
    }

    /**
     * Returns a list of Items.
     * @return items    The list of items in the Cart.
     */
    public List<Item> getItems() {
        return items;
    }
    
    /**
     * Returns the total of the Cart.
     * @return total    The total of the items in the cart.
     */
    public double getTotal() {
        return total;
    }
    
    private List<Item> items;
    private double total;
}
