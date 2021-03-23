import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassesItemTest {
    @Test
    void backstageItemsMaxQualityIs50() {
        BackstagePassesItem item = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        item.update();
        assertEquals(50, item.quality);
    }

    @Test
    void backstagePassesQualityGoesToZeroWhenSellInLessThanZero() {
        BackstagePassesItem item = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        item.update();
        assertEquals(0, item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByOneWhenSellInGreaterThanTen() {
        BackstagePassesItem item = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        item.update();
        assertEquals(21, item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByTwoWhenSellInBetweenFiveAndTen() {
        BackstagePassesItem itemOne = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        BackstagePassesItem itemTwo = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        itemOne.update();
        itemTwo.update();
        assertEquals(22, itemOne.quality);
        assertEquals(22, itemTwo.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByThreeWhenSellInBetweenFiveAndZero() {
        BackstagePassesItem itemOne = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        BackstagePassesItem itemTwo = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 1, 20);
        itemOne.update();
        itemTwo.update();
        assertEquals(23, itemOne.quality);
        assertEquals(23, itemTwo.quality);
    }

    @Test
    void sellInValueForBackstagePassesDecreasesByOne() {
        BackstagePassesItem item = new BackstagePassesItem("Backstage passes to a TAFKAL80ETC concert", 0, 0);
        item.update();
        assertEquals(-1, item.sellIn);
    }
}