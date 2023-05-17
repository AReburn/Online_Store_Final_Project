package finalProject;

import finalProject.models.Store;
import finalProject.views.LoginViewUI;

/**
 *
 * @author rebur
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creation of the Mock Store for testing.
        Store store = new Store();
        store.createAisles();
        
        //Show the login view
        new LoginViewUI(store);
    }
    
}
