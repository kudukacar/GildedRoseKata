public class NormalItem implements Itemable{
    public final String name;
    public int sellIn;
    public int quality;

    public NormalItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void update() {
        this.sellIn -= 1;
        if (this.sellIn >= 0) {
            this.quality = Math.max(0, this.quality - 1);
        } else {
            this.quality = Math.max(0, this.quality - 2);
        }
    }
}
