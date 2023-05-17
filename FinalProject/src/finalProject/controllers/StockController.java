package finalProject.controllers;

import finalProject.models.Cart;
import finalProject.models.Item;
import finalProject.views.ManagerViewUI;
import finalProject.models.Store;
import finalProject.models.Transaction;
import finalProject.views.StockViewUI;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Alex Reburn
 */
public class StockController {

    public StockController(StockViewUI view, Store store) {
        this.view = view;
        this.store = store;
        
        //adds a button listener for the user selecting an aisle.
        view.addAisleButtonListener((ActionEvent e) -> {
            //Retrieves aisle information.
            view.selectAisle(view.getAisleNumber());
        });
        
        //adds a button listener for the user adding an item to their cart.
        view.addItemButtonListener((ActionEvent e) -> {
            
            Item selectedItem = (Item) view.itemComboBox.getSelectedItem();
            int quantity = Integer.parseInt(view.quantityField.getText());
        
            for (int i=0; i<quantity; i++) {
                store.currentAccount.addToCart(selectedItem);
            }
            
            List<Item> currentCart = store.currentAccount.getCart().getItems();
            
            Transaction transaction = new Transaction(store.currentAccount, currentCart);
            
            store.getTransactions().add(transaction);
            
            //Returns the User to a dashboard.
            ManagerViewUI managerView = new ManagerViewUI(store);
            managerView.setVisible(true);
            
            view.setVisible(false); //Hides the AisleViewUI
        });
        
        //adds a button listener for the user cancelling the AisleViewUI.
        view.addCancelButtonListener((ActionEvent e) -> {
            //Returns the User to a dashboard.
            ManagerViewUI managerView = new ManagerViewUI(store);
            managerView.setVisible(true);
            
            view.setVisible(false); //Hides the AisleViewUI
        });
    }
    
    private final StockViewUI view;
    private final Store store;
}
