public class ConjuredUpdater implements Updateable{
    @Override
    public void update(Item item) {
        item.sellIn -= 1;
        if (item.sellIn > 0) {
            item.quality = Math.max(0, item.quality -= 2);
        } else {
            item.quality = Math.max(0, item.quality -= 4);
        }
    }
}
