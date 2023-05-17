package finalProject.controllers;

import finalProject.views.CheckoutViewUI;
import finalProject.views.DashboardViewUI;
import finalProject.views.LoginViewUI;
import finalProject.views.SearchViewUI;
import finalProject.models.Store;
import finalProject.views.AisleViewUI;

/**
 *
 * @author Alex Reburn
 */
public class DashboardController {
    /**
     * Constructor that creates the Controller function.
     * @param view      the current DashboardViewUI.
     * @param store     the store model.
     */
    public DashboardController(DashboardViewUI view, Store store) {
        this.view = view;
        this.store = store;
    }

    /**
     * Changes view to the AisleViewUI.
     */
    public void browseByAisle() {
        AisleViewUI aisleView = new AisleViewUI(store);
        aisleView.setVisible(true); //Display AisleViewUI
        view.setVisible(false); //Hides the DashboardViewUI
    }
    
    /**
     * Changes view to the SearchViewUI.
     */
    public void searchForItem() {
        SearchViewUI searchView = new SearchViewUI(store);
        searchView.setVisible(true); //Display SearchViewUI
        view.setVisible(false); //Hides the DashboardViewUI
    }
    
    /**
     * Changes view to the CheckoutViewUI.
     */
    public void proceedToCheckout() {
        CheckoutViewUI checkoutView = new CheckoutViewUI(store);
        checkoutView.setVisible(true); //Display CheckoutViewUI
        view.setVisible(false); //Hides the DashboardViewUI
    }
    
    /**
     * Changes view to the LoginViewUI.
     */
    public void logout() {
        LoginViewUI checkoutView = new LoginViewUI(store);
        checkoutView.setVisible(true); //Display LoginViewUI
        view.setVisible(false); //Hides the DashboardViewUI
    }
    
    private final DashboardViewUI view;
    private final Store store;
}