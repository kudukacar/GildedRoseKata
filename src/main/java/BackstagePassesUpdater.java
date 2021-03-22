import java.util.ArrayList;

public class BackstagePassesUpdater implements Updateable{
    @Override
    public void update(Item item) {
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
}
