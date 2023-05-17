package finalProject.models;

/**
 *
 * @author Alex Reburn
 */
public class Manager extends Account {
    private static Manager instance;
    
    private Manager(String username, String password) {
        super(username, password, new Cart());
    }
    
    //static method to get th sigleton instance.
    public static Manager getInstance() {
        if(instance == null) {
            synchronized (Manager.class) {
                if (instance == null) {
                    instance = new Manager("manager", "password");
                }
            }
        }
        return instance;
    }
}