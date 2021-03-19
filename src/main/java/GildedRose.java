public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name) {
                case("Aged Brie"):
                    new AgedBrieUpdater().update(item);
                    break;
                case("Backstage passes to a TAFKAL80ETC concert"):
                    new BackstagePassesUpdater().update(item);
                    break;
                case("Sulfuras, Hand of Ragnaros"):
                    break;
                default:
                    new NormalUpdater().update(item);
                    break;
            }
        }
    }
}
