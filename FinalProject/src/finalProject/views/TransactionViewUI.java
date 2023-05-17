package finalProject.views;

import finalProject.controllers.TransactionController;
import finalProject.models.Transaction;
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
public class TransactionViewUI extends JFrame {
    public TransactionViewUI(Store store) {
        //Setup: Creates a Window for the CheckoutViewUI.
        historyPanel = new JPanel(new GridLayout(5, 1));
        historyPanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));
        transactionListPanel = new JPanel(new GridLayout(5, 1));
        
        //creates a JLabel for all of the Items.
        for (Transaction t : store.getTransactions()) {
            transactionListPanel.add(new JLabel("Account: " + t.getName() 
                    + ", Money: " + t.getTotal()));
        }
        
        //Setup: Creating the J-Objects within the Panel.
        leaveButton = new JButton("Leave");

        
        //Create a new CheckoutController instance to handle button clicks
        TransactionController transactionController = new TransactionController(this, store);

        //Adds the J-Objects into the Panel.
        historyPanel.add(transactionListPanel);
        historyPanel.add(leaveButton);
        
        //Creates the Container.
        containerPanel = getContentPane();
        containerPanel.add(historyPanel, BorderLayout.NORTH);

        //Designs the layout for the ViewUI.
        pack();
        setTitle("Transaction View");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Adds an action listener to the leaveButton.
     * @param listener  the event listener. 
     */
    public void addLeaveButtonListener(ActionListener listener) {
        leaveButton.addActionListener(listener);
    }
   
    private Container containerPanel;
    private JPanel historyPanel;
    private JPanel transactionListPanel;
    private final JButton leaveButton;
}