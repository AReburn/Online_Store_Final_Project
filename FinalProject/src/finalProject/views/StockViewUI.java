package finalProject.views;

import finalProject.models.Aisle;
import finalProject.controllers.StockController;
import finalProject.models.Item;
import finalProject.models.Store;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Alex Reburn
 */
public class StockViewUI extends JFrame {
    /**
     * Constructor creates a ViewUI for the Aisle.
     * @param store     the Model of the MVC.
     */
    public StockViewUI(Store store) {
        //Setup: Creates a Window for the AisleView.
        super("Aisle View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.store = store; //Conencts the store to the AisleViewUI.
        
        //Setup: a Panel object that will contain each of the objects in frame.
        aislePanel = new JPanel(new GridLayout(3, 1));
        aislePanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));

        //Setup: Creating the J-Objects within the Panel.
        cancelButton = new JButton("Cancel");
        aisleLabel = new JLabel("Select an aisle number:");
        aisleNumberField = new JTextField();
        aisleButton = new JButton("Select Aisle");
        addToCartButton = new JButton("Add to Cart");
        itemComboBox = new JComboBox();
        
        //Create a new StockController instance to handle button clicks.
        StockController stockController = new StockController(this, store);

        //Adds the J-Objects into the Panel.
        aislePanel.add(aisleLabel);
        aislePanel.add(aisleNumberField);
        aislePanel.add(aisleButton);
        aislePanel.add(cancelButton);
                
        //Creates the Container.
        containerPanel = getContentPane();
        containerPanel.add(aislePanel, BorderLayout.NORTH);

        //Designs the layout for the ViewUI.
        pack();
        setTitle("Aisle View");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Adds an action listener to the aisleButton.
     * @param listener  the event listener. 
     */
    public void addAisleButtonListener(ActionListener listener) {
        aisleButton.addActionListener(listener);
    }
    
    /**
     * Adds an action listener to the addToCartButton.
     * @param listener  the event listener. 
     */
    public void addItemButtonListener(ActionListener listener) {
        addToCartButton.addActionListener(listener);
    }
    
    /**
     * Adds an action listener to the cancelButton.
     * @param listener  the event listener. 
     */
    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }
    
    /**
     * Displays a different Aisle view that contains an item picker.
     * @param aisleNumber   the aisle that is being looked into.
     */
    public void selectAisle(int aisleNumber) {
        containerPanel.removeAll(); //clears the previous view.
        
        //Setup: a new Panel for selecting the items.
        itemPanel = new JPanel(new GridLayout(6, 1));
        itemPanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));

        //Creates an Label for selecting an item.
        JLabel itemLabel = new JLabel("Select an item:");
        Aisle currentAisle = store.getAisle(aisleNumber);
        JLabel aisleLabel = new JLabel(currentAisle.getAisleName());
        
        //Removes the items from a combo box only if it already has content.
        if (itemComboBox != null){
            itemComboBox.removeAllItems();
        }


        //Adds every product from the Aisle to the JComboBox.
        for (Item product : currentAisle.getItems()) {
            itemComboBox.addItem(product);
        }

        //Creates a Label and TextBox for quantity.
        JLabel quantityLabel = new JLabel("Enter the quantity:");
        quantityField = new JTextField();

        //Adds the J-Objects to the Panel.
        itemPanel.add(aisleLabel);
        itemPanel.add(itemLabel);
        itemPanel.add(itemComboBox);
        itemPanel.add(quantityLabel);
        itemPanel.add(quantityField);
        itemPanel.add(addToCartButton);

        //Resets the container with the new Panel.
        containerPanel.add(itemPanel, BorderLayout.NORTH);
        
        containerPanel.revalidate();
        containerPanel.repaint();       //Repaints the container.
    }
    
    /**
     * Adds the selected Item to the current users Cart.
     */
    public void addToCart() {
        Item selectedItem = (Item) itemComboBox.getSelectedItem();
        int quantity = Integer.parseInt(quantityField.getText());
        
        for (int i=0; i<quantity; i++) {
            store.currentAccount.addToCart(selectedItem);
        }
    }
    
    /**
     * Get the aisle number entered by the user.
     * @return  the number entered into the text field.
     */
    public int getAisleNumber() {
        return Integer.parseInt(aisleNumberField.getText());
    }
    
    private final Store store;
    private Container containerPanel;
    private JPanel aislePanel;
    private JPanel itemPanel;
    private final JLabel aisleLabel;
    public JComboBox itemComboBox;
    private JTextField aisleNumberField;
    private final JButton aisleButton;
    private final JButton cancelButton;
    public JTextField quantityField;
    private final JButton addToCartButton;
}