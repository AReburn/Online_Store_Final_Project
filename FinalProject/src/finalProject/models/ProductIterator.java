package finalProject.models;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Alex Reburn
 */
public class ProductIterator implements Iterator<Item>{
    /**
     * Constructor of ProductIterator.
     * @param a     the list being iterated.
     */
    public ProductIterator(List<Item> a) {
        this.array = a;
    }
    
    /**
     * Checks if the Item is the last in the Iterator.
     * @return whether or not the current item is not last.
     */
    @Override
    public boolean hasNext() {
        return position < array.size();
    }

    /**
     * Returns the next Item in the array.
     * @return the next Item in the array.
     */
    @Override
    public Item next() {
        if(!hasNext()) {
            throw new RuntimeException("No more elements in array");
        }
        return array.get(position++);
    }
    
    private int position = 0;
    private List<Item> array;
}