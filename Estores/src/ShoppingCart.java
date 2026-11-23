import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {

        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {

        items.add(item);
    }

    public boolean removeItem(Item item) {

        return items.remove(item);
    }

    public List<Item> getItems() {

        return items;
    }
}