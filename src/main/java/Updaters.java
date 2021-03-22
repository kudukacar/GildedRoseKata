import java.util.HashMap;
import java.util.Map;

public class Updaters {
    private final Map<String, Updateable> updaters;

    private Updaters(Builder builder) {
        this.updaters = builder.updaters;
    }

    public Map<String, Updateable> getUpdaters() {
        return updaters;
    }

    public void update(Item item) {
        updaters.get(item.name).update(item);
    }

    public static class Builder {
        private final Map<String, Updateable> updaters = new HashMap<>();

        public Builder addUpdater(String itemName, Updateable updater) {
            updaters.put(itemName, updater);
            return this;
        }
        public Updaters build() {
            return new Updaters(this);
        }
    }
}
