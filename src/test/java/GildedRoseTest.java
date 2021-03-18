import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GildedRoseTest {
    @Test
    void sulfurasValuesAreConstant() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void backstageItemsMaxQualityIs50() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityGoesToZeroWhenSellInLessThanZero() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesByOneWhenSellInGreaterThanTen() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesByTwoWhenSellInBetweenFiveAndTen() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(22, app.items[1].quality);
    }

    @Test
    void backstagePassesQualityIncreasesByThreeWhenSellInBetweenFiveAndZero() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void sellInValueForBackstagePassesDecreasesByOne() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void agedBrieQualityMaxIs50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void agedBrieQualityIncreasesByOneWhenSellInGreaterThanOrEqualToZero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 1, 20),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void agedBrieQualityIncreasesByTwoWhenLessThanZero() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 20),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void agedBrieSellInDecreasesByOne() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 20),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void normalItemQualityMinIsZero() {
        Item[] items = new Item[] {
                new Item("An old sword", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void normalItemsDegradeByTwoAfterSellInIsLessThan0() {
        Item[] items = new Item[] {
                new Item("An old sword", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void normalItemsDegradeByOneWhenSellInIsAboveZero() {
        Item[] items = new Item[] {
                new Item("An old sword", 1, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void normalItemsSellInDecreasesByOne() {
        Item[] items = new Item[] {
                new Item("An old sword", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }
}