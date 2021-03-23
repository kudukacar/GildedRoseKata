public class GildedRose {
    private final Updaters updaters;
    public Item[] items;

    public GildedRose(Item[] items, Updaters updaters) {

        this.items = items;
        this.updaters = updaters;
    }

    public void updateQuality() {
        for (Item item : items) {
            updaters.update(item);
        }
    }
}
