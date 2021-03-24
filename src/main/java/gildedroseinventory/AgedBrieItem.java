package gildedroseinventory;

public class AgedBrieItem implements Itemable{
    public final String name;
    public int sellIn;
    public int quality;

    public AgedBrieItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    @Override
    public void update() {
        this.sellIn -= 1;
        if (this.sellIn >= 0) {
            this.quality = Math.min(50, this.quality + 1);
        } else {
            this.quality = Math.min(50, this.quality + 2);
        }
    }
}
