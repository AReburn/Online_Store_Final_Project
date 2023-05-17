package finalProject.controllers;

import finalProject.views.CheckoutViewUI;
import finalProject.models.Transaction;
import finalProject.models.Store;
import finalProject.views.DashboardViewUI;
import finalProject.models.Item;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Reburn
 */
public class CheckoutController {
    /**
     * Constructor that creates the Controller function.
     * @param view      the current CheckoutViewUI.
     * @param store     the store model.
     */
    public CheckoutController(CheckoutViewUI view, Store store) {
        //Adds a button listener for the user cancelling the CheckoutViewUI.
        view.addCancelButtonListener((ActionEvent e) -> {
            //Display DashboardViewUI
            DashboardViewUI dashView = new DashboardViewUI(store);
            dashView.setVisible(true);
            view.setVisible(false); //Hides the CheckoutViewUI
        });
        
        //Adds a button listener for the user confirming the CheckoutViewUI.
        view.addPurchaseButtonListener((ActionEvent e) -> {
            double cartCost = store.currentAccount.getCart().getTotal();
            double moneyInput = Double.parseDouble(view.moneyField.getText());
            List<Item> items = new ArrayList<>(store.currentAccount.getCart().getItems());
                        
            if(cartCost >= moneyInput) { //if the user does not have enough money.
                JOptionPane.showMessageDialog(null, 
                        "Insufficient money. Please re-enter currency.");
            } else { //if the user has enough money.
                //Removes items from the Users cart.
                for (Item product : items) {
                    store.currentAccount.getCart().removeItem(product);
                }
                
                //Adds the transaction to the list stored in the Store object.
                Transaction t = new Transaction(store.currentAccount, items);
                store.getTransactions().add(t);

                DashboardViewUI dashView = new DashboardViewUI(store);
                dashView.setVisible(true); //Display DashboardViewUI
                view.setVisible(false); //Hides the CheckoutViewUI   
            }
        });
    }
}
