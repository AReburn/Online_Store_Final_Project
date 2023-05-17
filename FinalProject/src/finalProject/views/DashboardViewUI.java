package finalProject.views;

import finalProject.models.Store;
import finalProject.controllers.DashboardController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alex Reburn
 */
public class DashboardViewUI extends JFrame {
    /**
     * Constructor for the View of the Checkout functions.
     * @param store     the Model of the MVC.
     */
    public DashboardViewUI(Store store) {
        //Setup: Creates a Window for the CheckoutViewUI.
        browseByAisleButton = new JButton("Browse by Aisle");
        searchForItemButton = new JButton("Search for Item");
        proceedToCheckoutButton = new JButton("Proceed to Checkout");
        leaveToLoginButton = new JButton("Logout");

        //Create a new DashboardController instance to handle button clicks
        dashboardController = new DashboardController(this, store);

        //Adds the J-Objects into the Panel.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));
        buttonPanel.add(browseByAisleButton);
        buttonPanel.add(searchForItemButton);
        buttonPanel.add(proceedToCheckoutButton);
        buttonPanel.add(leaveToLoginButton);

        //Sets up the button action listener
        browseByAisleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the browseByAisle method of the DashboardController to handle the button click
                dashboardController.browseByAisle();
            }
        });

        //Sets up the button action listener
        searchForItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Calls the searchForItem method to handle the button click
                dashboardController.searchForItem();
            }
        });

        //Sets up the button action listener
        proceedToCheckoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Calls the proceedToCheckout method to handle the button click.
                dashboardController.proceedToCheckout();
            }
        });
        
        leaveToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Calls the proceedToCheckout method to handle the button click.
                dashboardController.logout();
            }
        });
        
        add(buttonPanel, BorderLayout.CENTER);

        // Set up the window properties
        setTitle("Dashboard");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private final JButton browseByAisleButton;
    private final JButton searchForItemButton;
    private final JButton proceedToCheckoutButton;
    private final JButton leaveToLoginButton;
    private DashboardController dashboardController;
}