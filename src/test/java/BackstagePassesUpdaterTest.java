import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackstagePassesUpdaterTest {

    @Test
    void backstageItemsMaxQualityIs50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        BackstagePassesUpdater updater = new BackstagePassesUpdater();
        updater.update(item);
        assertEquals(50, item.quality);
    }

    @Test
    void backstagePassesQualityGoesToZeroWhenSellInLessThanZero() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        BackstagePassesUpdater updater = new BackstagePassesUpdater();
        updater.update(item);
        assertEquals(0, item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByOneWhenSellInGreaterThanTen() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        BackstagePassesUpdater updater = new BackstagePassesUpdater();
        updater.update(item);
        assertEquals(21, item.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByTwoWhenSellInBetweenFiveAndTen() {
        Item itemOne = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);
        Item itemTwo = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        BackstagePassesUpdater updater = new BackstagePassesUpdater();
        updater.update(itemOne);
        updater.update(itemTwo);
        assertEquals(22, itemOne.quality);
        assertEquals(22, itemTwo.quality);
    }

    @Test
    void backstagePassesQualityIncreasesByThreeWhenSellInBetweenFiveAndZero() {
        Item itemOne = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        Item itemTwo = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20);
        BackstagePassesUpdater updater = new BackstagePassesUpdater();
        updater.update(itemOne);
        updater.update(itemTwo);
        assertEquals(23, itemOne.quality);
        assertEquals(23, itemTwo.quality);
    }

    @Test
    void sellInValueForBackstagePassesDecreasesByOne() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0);
        BackstagePassesUpdater updater = new BackstagePassesUpdater();
        updater.update(item);
        assertEquals(-1, item.sellIn);
    }
}
