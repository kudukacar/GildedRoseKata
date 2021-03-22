import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieUpdaterTest {

    @Test
    void agedBrieQualityMaxIs50() {
        Item item = new Item("Aged Brie", 0, 50);
        AgedBrieUpdater updater = new AgedBrieUpdater();
        updater.update(item);
        assertEquals(50, item.quality);
    }

    @Test
    void agedBrieQualityIncreasesByOneWhenSellInGreaterThanOrEqualToZero() {
        Item item = new Item("Aged Brie", 1, 20);
        AgedBrieUpdater updater = new AgedBrieUpdater();
        updater.update(item);
        assertEquals(21, item.quality);
    }

    @Test
    void agedBrieQualityIncreasesByTwoWhenLessThanZero() {
        Item item = new Item("Aged Brie", 0, 20);
        AgedBrieUpdater updater = new AgedBrieUpdater();
        updater.update(item);
        assertEquals(22, item.quality);
    }

    @Test
    void agedBrieSellInDecreasesByOne() {
        Item item = new Item("Aged Brie", 0, 20);
        AgedBrieUpdater updater = new AgedBrieUpdater();
        updater.update(item);
        assertEquals(-1, item.sellIn);
    }
}