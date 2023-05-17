package finalProject.models;

/**
 *
 * @author Alex Reburn
 */
public class DiscountedProduct implements Item {
    /**
     * Constructor of the Discounted Product.
     * @param product   the product being discounted.
     * @param discount  the discount factor of the product price.
     */
    public DiscountedProduct(Item product, double discount) {
        this.product = product;
        this.discount = discount;
    }
    
    /**
     * Retrieves the String of the Discounted Product.
     * @return the Discounted Product String.
     */
    @Override
    public String getName() {
        return "Discounted " + product.getName() + "(" + this.discount + " off)";
    }
    
    /**
     * Retrieves the discounted price.
     * @return the price of the discounted price.
     */
    @Override
    public double getPrice() {
        return product.getPrice() * (1 - discount);
    }
    
    /**
     * Retrieves the String of the Discounted Product.
     * @return the Discounted Product String.
     */
    @Override
    public String toString() {
        return this.getName();
    }
    
    @Override
    public boolean contains(String text) {
        return product.getName().toLowerCase().contains(text.toLowerCase());
    }
    
    private final Item product;
    private final double discount;
}
