import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GildedRoseTest {
    @Test
    void gildedRoseUpdatesEachItemWithTheAppropriateUpdater() {
        String brieItemName = "Brie";
        String baguetteItemName = "Baguette";
        Item brieItem = new Item(brieItemName, 0, 0);
        Item baguetteItem = new Item(baguetteItemName, 0, 0);
        Item[] items = new Item[] { brieItem, baguetteItem };
        HashMap<String, Updateable> updaters = new HashMap<String, Updateable>();
        updaters.put(brieItemName, new BrieUpdater());
        updaters.put(baguetteItemName, new BreadUpdater());
        GildedRose app = new GildedRose(items, updaters);
        app.updateQuality();
        assertEquals(1, brieItem.quality);
        assertEquals(1, brieItem.sellIn);
        assertEquals(0, baguetteItem.quality);
        assertEquals(0, baguetteItem.sellIn);
    }
    private class BrieUpdater implements Updateable {
        @Override
        public void update(Item item) {
            item.sellIn += 1;
            item.quality += 1;
        }
    }

    private class BreadUpdater implements Updateable {
        @Override
        public void update(Item item) {
        }
    }
}