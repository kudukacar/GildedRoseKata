public class SulfurasItem implements Itemable{
    public final String name;
    public int sellIn;
    public int quality;

    public SulfurasItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void update() {

    }
}
