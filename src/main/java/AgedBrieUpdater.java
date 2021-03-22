public class AgedBrieUpdater implements Updateable{

    @Override
    public void update(Item item) {
        item.sellIn -= 1;
        if (item.sellIn >= 0) {
            item.quality = Math.min(50, item.quality + 1);
        } else {
            item.quality = Math.min(50, item.quality + 2);
        }
    }
}
