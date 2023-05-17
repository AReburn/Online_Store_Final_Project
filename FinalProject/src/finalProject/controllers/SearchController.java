package finalProject.controllers;

import finalProject.views.SearchViewUI;
import finalProject.models.Store;
import finalProject.models.ProductIterator;
import finalProject.views.DashboardViewUI;
import finalProject.models.Item;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alex Reburn
 */
public class SearchController {
    /**
     * Constructor that creates the Controller function.
     * @param view      the current DashboardViewUI.
     * @param store     the store model.
     */
    public SearchController(SearchViewUI view, Store store) {
        this.view = view;
        this.store = store;
        
        //Adds a button listener for the user cancelling the SearchViewUI.
        view.addCancelButtonListener((ActionEvent e) -> {
            DashboardViewUI dashView = new DashboardViewUI(store);
            dashView.setVisible(true); //Display DashboardViewUI
            view.setVisible(false); //Hides the SearchViewUI
        });
        
        //Adds a button listener for the user searching for an Item.
        view.addSearchButtonListener((ActionEvent e) -> {
            //Creates ArrayList for items matching Product.
            ArrayList<Item> matchingProduct = new ArrayList<>();
            
            Iterator<Item> iterator = new ProductIterator(store.getItems());
            
            while (iterator.hasNext()) {
                Item item = iterator.next();
                if (item.contains(view.searchField.getText())) {
                    matchingProduct.add(item);
                }
            }
            
            view.displayMatchingProducts(matchingProduct);
        });
        
        //adds a button listener for the user adding an item to their cart.
        view.addItemButtonListener((ActionEvent e) -> {
            Item selectedItem = (Item) view.itemComboBox.getSelectedItem();
            int quantity = Integer.parseInt(view.quantityField.getText());
        
            for (int i=0; i<quantity; i++) {
                store.currentAccount.addToCart(selectedItem);
            }
            
            //Returns the User to a dashboard.
            DashboardViewUI dashView = new DashboardViewUI(store);
            dashView.setVisible(true);
            
            view.setVisible(false); //Hides the AisleViewUI
        }); 
    }
    
    private final SearchViewUI view;
    private final Store store;
}