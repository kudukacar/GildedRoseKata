import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdatersTest {
    @Test
    void itCreatesAMapOfUpdaters() {
        Updateable updater = new SimpleUpdater();
        String itemName = "item";
        Updaters updaters = new Updaters.Builder()
                .addUpdater(itemName, updater)
                .build();
        Map<String, Updateable> expectedUpdaters = new HashMap<>();
        expectedUpdaters.put(itemName, updater);
        assertThat(expectedUpdaters, samePropertyValuesAs(updaters.getUpdaters()));
    }

    @Test
    void itUpdatesAnItemWithTheRightUpdater() {
        Item item = new Item("item", 0, 0);
        Updateable updater = new SimpleUpdater();
        String itemName = "item";
        Updaters updaters = new Updaters.Builder()
                .addUpdater(itemName, updater)
                .build();
        updaters.update(item);
        assertEquals(1, item.sellIn);
        assertEquals(1, item.quality);
    }


    private class SimpleUpdater implements Updateable {
        @Override
        public void update(Item item) {
            item.sellIn += 1;
            item.quality += 1;
        }
    }

}