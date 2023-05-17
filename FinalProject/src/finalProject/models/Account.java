package finalProject.models;

/**
 *
 * @author Alex Reburn
 */
public class Account {

    /**
     * Constructor for the Account object. 
     * Initializes the Account object with specified values u, p, and c.
     * @param u     the username of the account.
     * @param p     the password of the account.
     * @param c     the cart object of the account.
     */
    public Account(String u, String p, Cart c) {
        this.username = u;
        this.password = p;
        this.cart = c;
    }

    /**
     * Checks if the password is equal to the password in the Database.
     * @param password  the current string entered into the password text box.
     * @return    whether or not the entered string is the registered password.
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Returns the current Username.
     * @return username     the current username.
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * returns the Current users cart object. 
     * @return cart     user's cart.
     */
    public Cart getCart() {
        return cart;
    }
    
    /**
     * Adds Item to Cart object. 
     * @param item      item being added to cart.
     */
    public void addToCart(Item item) {
        cart.addItem(item);
    }
    
    private final String username;
    private final String password;
    private Cart cart;
}

