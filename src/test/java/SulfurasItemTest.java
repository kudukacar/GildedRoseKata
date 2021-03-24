import gildedroseinventory.SulfurasItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasItemTest {
    @Test
    void sulfurasValuesAreConstant() {
        SulfurasItem item = new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80);
        item.update();
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }

}