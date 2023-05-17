package finalProject.controllers;

import finalProject.views.DashboardViewUI;
import finalProject.views.LoginViewUI;
import finalProject.models.Manager;
import finalProject.views.ManagerViewUI;
import finalProject.models.Store;
import finalProject.models.Account;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Reburn
 */
public class LoginController {

    public LoginController( LoginViewUI view, Store store) {
        this.view = view;
        this.store = store;
    }

    public void login(String username, String password) {
        // Attempt to find an account with the given username and password
        Account account = store.getAccount(username, password);

        if (account == null) {
            // If no account is found, show an error message
            JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
        } else {
            // If an account is found, check if it's a manager account
            if (account instanceof Manager) {
                // If it's a manager account, show the manager view
                store.currentAccount = account;
                ManagerViewUI managerViewUI = new ManagerViewUI(store);
                managerViewUI.setVisible(true);
                
                view.setVisible(false);
            } else {
                store.currentAccount = account;
                // If it's a regular user account, show the user dashboard view
                DashboardViewUI dashboardViewUI = new DashboardViewUI(store);
                dashboardViewUI.setVisible(true);
                
                view.setVisible(false);
            }
        }
    }
    
    private LoginViewUI view;
    private Store store;
}