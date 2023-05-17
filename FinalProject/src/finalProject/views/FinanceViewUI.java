package finalProject.views;

import finalProject.controllers.FinanceController;
import finalProject.models.Manager;
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
public class FinanceViewUI extends JFrame {
    public FinanceViewUI(Store store) {
        //Setup: Creates a Window for the FinanceViewUI.
        historyPanel = new JPanel(new GridLayout(5, 1));
        historyPanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));
        transactionListPanel = new JPanel(new GridLayout(5, 1));
        
        double totalCost = 0;
        
        //creates a JLabel for all of the Items.
        for (Transaction t : store.getTransactions()) {
            if("manager".equals(t.getName())) {
                transactionListPanel.add(new JLabel("Account: " + t.getName() 
                    + ", Money: -" + t.getTotal()));
                totalCost -= t.getTotal();
            } else {
                transactionListPanel.add(new JLabel("Account: " + t.getName() 
                    + ", Money: " + t.getTotal()));
                totalCost += t.getTotal();
            }
        }
        
        totalLabel = new JLabel("Total: " + totalCost);
        //Setup: Creating the J-Objects within the Panel.
        leaveButton = new JButton("Leave");

        
        //Create a new FinanceController instance to handle button clicks
        FinanceController financeController = new FinanceController(this, store);

        //Adds the J-Objects into the Panel.
        historyPanel.add(transactionListPanel);
        historyPanel.add(totalLabel);
        historyPanel.add(leaveButton);
        
        //Creates the Container.
        containerPanel = getContentPane();
        containerPanel.add(historyPanel, BorderLayout.NORTH);

        //Designs the layout for the ViewUI.
        pack();
        setTitle("Finace View");
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
    private JLabel totalLabel;
    private JPanel historyPanel;
    private JPanel transactionListPanel;
    private final JButton leaveButton;
}
