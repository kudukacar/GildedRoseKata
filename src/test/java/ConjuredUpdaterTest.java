import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredUpdaterTest {
    @Test
    void conjuredItemQualityMinIsZero() {
        Item item = new Item("Conjured", 0, 1);
        ConjuredUpdater updater = new ConjuredUpdater();
        updater.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void conjuredItemSellInDecreasesByOne() {
        Item item = new Item("Conjured", 2, 10);
        ConjuredUpdater updater = new ConjuredUpdater();
        updater.update(item);
        assertEquals(1, item.sellIn);
    }

    @Test
    void conjuredItemsDegradeByTwoWhenInDate() {
        Item item = new Item("Conjured", 1, 10);
        ConjuredUpdater updater = new ConjuredUpdater();
        updater.update(item);
        assertEquals(8, item.quality);
    }

    @Test
    void conjuredItemsDegradeByFourWhenExpired() {
        Item item = new Item("Conjured", 0, 10);
        ConjuredUpdater updater = new ConjuredUpdater();
        updater.update(item);
        assertEquals(6, item.quality);
    }
}