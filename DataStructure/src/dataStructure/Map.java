
package dataStructure;

import java.util.HashMap;

public class Map {

    private HashMap<String, String> elements;

    public Map() {
        elements = new HashMap<>();
    }

    public void put(String key, String value) {
        elements.put(key, value);
    }

    public String get(String key) {
        return elements.get(key);
    }

    public String remove(String key) {
        return elements.remove(key);
    }

    public String replace(String key, String newValue) {
        return elements.replace(key, newValue);
    }

    public void clear() {
        elements.clear();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
       return elements.isEmpty();
    }
}
