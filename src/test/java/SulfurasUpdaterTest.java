import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasUpdaterTest {
    @Test
    void sulfurasValuesAreConstant() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        SulfurasUpdater updater = new SulfurasUpdater();
        updater.update(item);
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }
}