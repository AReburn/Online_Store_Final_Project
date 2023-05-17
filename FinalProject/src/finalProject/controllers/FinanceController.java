package finalProject.controllers;

import finalProject.models.Store;
import finalProject.views.ManagerViewUI;
import finalProject.views.FinanceViewUI;
import java.awt.event.ActionEvent;

/**
 *
 * @author Alex Reburn
 */
public class FinanceController {
        public FinanceController(FinanceViewUI view, Store store) {
        //Adds a button listener for the user cancelling the CheckoutViewUI.
        view.addLeaveButtonListener((ActionEvent e) -> {
            //Display DashboardViewUI
            ManagerViewUI dashView = new ManagerViewUI(store);
            dashView.setVisible(true);
            view.setVisible(false); //Hides the TransactionViewUI
        });
    }
}
