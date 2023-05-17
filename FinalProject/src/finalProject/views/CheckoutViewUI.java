package finalProject.views;

import finalProject.controllers.CheckoutController;
import finalProject.models.Store;
import finalProject.models.Item;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Alex Reburn
 */
public class CheckoutViewUI extends JFrame {
    /**
     * Constructor for the View of the Checkout functions.
     * @param store     the Model of the MVC.
     */
    public CheckoutViewUI(Store store) {
        //Setup: Creates a Window for the CheckoutViewUI.
        checkoutPanel = new JPanel(new GridLayout(5, 1));
        checkoutPanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));
        productListPanel = new JPanel(new GridLayout(5, 1));
        
        //creates a JLabel for all of the Items.
        for (Item product : store.currentAccount.getCart().getItems()) {
            productListPanel.add(new JLabel("Item: " + product.getName() 
                    + ", Price Each: " + product.getPrice()));
        }
        
        //Setup: Creating the J-Objects within the Panel.
        cancelButton = new JButton("Cancel");
        totalLabel = new JLabel("Total: " 
                + store.currentAccount.getCart().getTotal());
        moneyField = new JTextField();
        purchaseButton = new JButton("Checkout Items");

        
        //Create a new CheckoutController instance to handle button clicks
        CheckoutController checkoutController = new CheckoutController(this, store);

        //Adds the J-Objects into the Panel.
        checkoutPanel.add(productListPanel);
        checkoutPanel.add(totalLabel);
        checkoutPanel.add(moneyField);
        checkoutPanel.add(purchaseButton);
        checkoutPanel.add(cancelButton);
        
        //Creates the Container.
        containerPanel = getContentPane();
        containerPanel.add(checkoutPanel, BorderLayout.NORTH);

        //Designs the layout for the ViewUI.
        pack();
        setTitle("Checkout View");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Adds an action listener to the cancelButton.
     * @param listener  the event listener. 
     */
    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }
    
    /**
     * Adds an action listener to the purchaseButton.
     * @param listener  the event listener. 
     */
    public void addPurchaseButtonListener(ActionListener listener) {
        purchaseButton.addActionListener(listener);
    }
   
    private Container containerPanel;
    private JPanel checkoutPanel;
    private JPanel productListPanel;
    private final JButton purchaseButton;
    private final JButton cancelButton;
    public JTextField moneyField;
    private final JLabel totalLabel;
}