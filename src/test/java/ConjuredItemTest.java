import gildedroseinventory.ConjuredItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredItemTest {
    @Test
    void conjuredItemQualityMinIsZero() {
        ConjuredItem item = new ConjuredItem("Conjured", 0, 1);
        item.update();
        assertEquals(0, item.quality);
    }

    @Test
    void conjuredItemSellInDecreasesByOne() {
        ConjuredItem item = new ConjuredItem("Conjured", 2, 10);
        item.update();
        assertEquals(1, item.sellIn);
    }

    @Test
    void conjuredItemsDegradeByTwoWhenInDate() {
        ConjuredItem item = new ConjuredItem("Conjured", 1, 10);
        item.update();
        assertEquals(8, item.quality);
    }

    @Test
    void conjuredItemsDegradeByFourWhenExpired() {
        ConjuredItem item = new ConjuredItem("Conjured", 0, 10);
        item.update();
        assertEquals(6, item.quality);
    }
}