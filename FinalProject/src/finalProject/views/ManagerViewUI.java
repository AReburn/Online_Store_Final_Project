package finalProject.views;

import finalProject.models.Store;
import finalProject.controllers.ManagerController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Alex Reburn
 */
public class ManagerViewUI extends JFrame {
    private JButton transactionButton;
    private JButton stockButton;
    private JButton financeButton;
    private ManagerController managerController;
    private final JButton leaveToLoginButton;

    public ManagerViewUI(Store store) {

        // Create the buttons and add them to the UI
        transactionButton = new JButton("View Transaction History");
        stockButton = new JButton("Stock Shelves");
        financeButton = new JButton("View Finances");
        leaveToLoginButton = new JButton("Logout");
        
        // Create a new ManagerController instance to handle button clicks
        managerController = new ManagerController(this, store);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(transactionButton);
        buttonPanel.add(stockButton);
        buttonPanel.add(financeButton);
        buttonPanel.add(leaveToLoginButton);
        
        // Set up the button action listeners
        transactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the browseByAisle method of the DashboardController to handle the button click
                managerController.viewTransactionHistory();
            }
        });
        
        // Set up the button action listeners
        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the browseByAisle method of the DashboardController to handle the button click
                managerController.viewStock();
            }
        });
        
        // Set up the button action listeners
        financeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the browseByAisle method of the DashboardController to handle the button click
                managerController.viewFinances();
            }
        });
        
        // Set up the button action listeners
        leaveToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the browseByAisle method of the DashboardController to handle the button click
                managerController.logout();
            }
        });
        
        
        add(buttonPanel, BorderLayout.CENTER);
        
        //Designs the layout for the ViewUI.
        pack();
        setTitle("Manager Dashboard");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}