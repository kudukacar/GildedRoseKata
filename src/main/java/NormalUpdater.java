import java.util.ArrayList;

public class NormalUpdater implements Updateable{
    @Override
    public void update(Item item) {
        item.sellIn -= 1;
        if (item.sellIn >= 0) {
            item.quality = Math.max(0, item.quality - 1);
        } else {
            item.quality = Math.max(0, item.quality - 2);
        }
    }
}
