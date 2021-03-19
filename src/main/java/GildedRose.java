public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name) {
                case("Aged Brie"):
                    updateAgedBrie(item);
                    break;
                case("Backstage passes to a TAFKAL80ETC concert"):
                    updateBackstagePasses(item);
                    break;
                case("Sulfuras, Hand of Ragnaros"):
                    break;
                default:
                    updateNormalItems(item);
                    break;
            }
        }
    }
    private void updateAgedBrie(Item item) {
        item.sellIn -= 1;
        if (item.sellIn >= 0) {
            item.quality = Math.min(50, item.quality + 1);
        } else {
            item.quality = Math.min(50, item.quality + 2);
        }
    }

    private void updateBackstagePasses(Item item) {
        item.sellIn -= 1;
        if (item.sellIn >= 10) {
            item.quality = Math.min(50, item.quality + 1);
        } else if (item.sellIn < 10 && item.sellIn >= 5) {
            item.quality = Math.min(50, item.quality + 2);
        } else if (item.sellIn < 5 && item.sellIn >= 0) {
            item.quality = Math.min(50, item.quality + 3);
        } else {
            item.quality = 0;
        }
    }

    private void updateNormalItems(Item item) {
        item.sellIn -= 1;
        if (item.sellIn >= 0) {
            item.quality = Math.max(0, item.quality - 1);
        } else {
            item.quality = Math.max(0, item.quality - 2);
        }
    }
}
