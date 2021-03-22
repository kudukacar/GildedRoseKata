import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalUpdaterTest {
    @Test
    void normalItemQualityMinIsZero() {
        Item item = new Item("An old sword", 0, 0);
        NormalUpdater updater = new NormalUpdater();
        updater.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void normalItemsDegradeByTwoAfterSellInIsLessThan0() {
        Item item = new Item("An old sword", 0, 10);
        NormalUpdater updater = new NormalUpdater();
        updater.update(item);
        assertEquals(8, item.quality);
    }

    @Test
    void normalItemsDegradeByOneWhenSellInIsAboveZero() {
        Item item = new Item("An old sword", 1, 10);
        NormalUpdater updater = new NormalUpdater();
        updater.update(item);
        assertEquals(9, item.quality);
    }

    @Test
    void normalItemsSellInDecreasesByOne() {
        Item item = new Item("An old sword", 0, 10);
        NormalUpdater updater = new NormalUpdater();
        updater.update(item);
        assertEquals(-1, item.sellIn);
    }
}