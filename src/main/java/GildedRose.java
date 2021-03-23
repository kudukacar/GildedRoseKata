public class GildedRose {
    public Itemable[] items;

    public GildedRose(Itemable[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Itemable item : items) {
                item.update();
        }
    }
}
