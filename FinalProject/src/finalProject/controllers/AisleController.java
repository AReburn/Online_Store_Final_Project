package finalProject.controllers;

import finalProject.views.DashboardViewUI;
import finalProject.models.Store;
import finalProject.views.AisleViewUI;
import java.awt.event.ActionEvent;

/**
 *
 * @author Alex Reburn
 */
public class AisleController {

    public AisleController(AisleViewUI view, Store store) {
        this.view = view;
        this.store = store;
        
        //adds a button listener for the user selecting an aisle.
        view.addAisleButtonListener((ActionEvent e) -> {
            //Retrieves aisle information.
            view.selectAisle(view.getAisleNumber());
        });
        
        //adds a button listener for the user adding an item to their cart.
        view.addItemButtonListener((ActionEvent e) -> {
            view.addToCart(); //tells the AisleViewUI to add the item to cart.
            
            //Returns the User to a dashboard.
            DashboardViewUI dashView = new DashboardViewUI(store);
            dashView.setVisible(true);
            
            view.setVisible(false); //Hides the AisleViewUI
        });
        
        //adds a button listener for the user cancelling the AisleViewUI.
        view.addCancelButtonListener((ActionEvent e) -> {
            //Returns the User to a dashboard.
            DashboardViewUI dashView = new DashboardViewUI(store);
            dashView.setVisible(true);
            
            view.setVisible(false); //Hides the AisleViewUI
        });
    }
    
    private final AisleViewUI view;
    private final Store store;
}
