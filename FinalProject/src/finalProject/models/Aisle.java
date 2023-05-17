package finalProject.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Reburn
 */
public class Aisle {
    
    /**
     * Constructor of the Aisle object.
     * @param aisleNumber   The number on the aisle.
     * @param aisleName     The name of the aisle.
     */
    public Aisle(int aisleNumber, String aislename) {
        this.aisleNumber = aisleNumber;
        this.aisleName = aislename;
        this.items = new ArrayList<Item>();
    }

    /**
     * Returns the current aisle number.
     * @return aisleNumber      the number of the aisle.
     */
    public int getAisleNumber() {
        return aisleNumber;
    }
    
    
    /**
     * Returns the current aisle name.
     * @return aisleName      the name of the aisle.
     */
    public String getAisleName() {
        return aisleName;
    }

    /**
     * Returns the current aisle name.
     * @return aisleName      the name of the aisle.
     */
    public List<Item> getItems() {
        return items;
    }
    
    /**
     * Adds a Product object to the Aisle.
     * @param product       the Item being added to the Aisle.
     */
    public void addProduct(Item product) {
        items.add(product);
    }

    private final int aisleNumber;
    private final String aisleName;
    private final List<Item> items;
}