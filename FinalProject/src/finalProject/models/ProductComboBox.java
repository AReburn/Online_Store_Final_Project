package finalProject.models;

import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Alex Reburn
 */
public class ProductComboBox extends JComboBox<String>{
    public ProductComboBox(List<Item> l)
    {
        super();
        this.list = l;
        for(Item obj:list)
        {
            this.addItem(obj.getName());
        }
    }
    
    List<Item> list;
}