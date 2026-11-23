package mapFunction;

import java.util.HashMap;
import java.util.Map;

public class Mapping {
    private final Map<Integer, Integer> map = new HashMap<>();
    public boolean isNotEmpty;
    public Object remove;

    public void put(int key, int value) {
        map.put(key, value);
    }

    public boolean contains(int key) {
        return map.containsKey(key);
    }

    public int replace(int key, int newValue) {
        return map.replace(key, newValue);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}

