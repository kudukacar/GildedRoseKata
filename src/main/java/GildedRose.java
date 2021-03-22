import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GildedRose {
    private final HashMap<String, Updateable> updaters;
    public Item[] items;

    public GildedRose(Item[] items, HashMap<String, Updateable> updaters) {

        this.items = items;
        this.updaters = updaters;
    }

    public void updateQuality() {
        for (Item item : items) {
            updaters.get(item.name).update(item);
        }
    }
}
