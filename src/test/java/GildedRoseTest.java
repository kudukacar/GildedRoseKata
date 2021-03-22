import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void gildedRoseUpdatesEachItemWithTheUpdaters() {
        String brieItemName = "Brie";
        String baguetteItemName = "Baguette";
        Item brieItem = new Item(brieItemName, 0, 0);
        Item baguetteItem = new Item(baguetteItemName, 0, 0);
        Item[] items = new Item[] { brieItem, baguetteItem };
        Updaters updaters = new Updaters.Builder()
                .addUpdater(brieItemName, new BrieUpdater())
                .addUpdater(baguetteItemName, new BreadUpdater())
                .build();
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