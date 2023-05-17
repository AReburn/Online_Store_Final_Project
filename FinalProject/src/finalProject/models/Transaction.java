package finalProject.models;

import java.util.List;

/**
 *
 * @author Alex Reburn
 */
public class Transaction {
    
    /**
     * Constructor for the Transaction Object.
     * @param a
     * @param products 
     */
    public Transaction(Account a, List<Item> products) {
        this.account = a;
        this.products = products;
        
        //gets the total from the transaction.
        for (Item product : products) {
            total += product.getPrice();
        } 
    }
    
    /**
     * Retrieves the name of the Account object.
     * @return the username of the Account.
     */
    public String getName() {
        return account.getUsername();
    }
    
    /**
     * Retrieves the total of the Transaction.
     * @return total    the total amount for the transaction.
     */
    public double getTotal() {
        return total;
    }
    
    private Account account;
    private List<Item> products;
    private double total;

    
}