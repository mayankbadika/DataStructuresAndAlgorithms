package myclass;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class CustomTreeMap {
    TreeMap<Integer, LinkedHashSet<String>> tmap;
    HashMap<String, Integer> hmap;

    public CustomTreeMap() {
        tmap = new TreeMap<>();
        hmap = new HashMap<>();
    }

    public void put(String key) {
        // Get the current frequency of the key
        int value = hmap.getOrDefault(key, 0);

        // Remove the key from the old frequency's queue if it exists
        if (value > 0) {
            LinkedHashSet<String> set = tmap.get(value);
            if (set != null) {
                set.remove(key);  // Remove key from the old frequency
                // Remove the queue if it becomes empty
                if (set.isEmpty()) {
                    tmap.remove(value);
                }
            }
        }

        // Update frequency in the HashMap
        value++;
        hmap.put(key, value);

        // Add the key to the new frequency's queue
        tmap.putIfAbsent(value, new LinkedHashSet<>()); // Create a new queue if it doesn't exist
        tmap.get(value).add(key);
    }

    public void put(String key, int value) {
        hmap.put(key, value);

        tmap.putIfAbsent(value, new LinkedHashSet<>()); // Create a new queue if it doesn't exist
        tmap.get(value).add(key);
    }

    public void remove(String key) {
        if (!hmap.containsKey(key)) {
            return; // Key does not exist, nothing to remove
        }

        int value = hmap.get(key); // Get the current frequency

        // Remove key from the frequency's queue
        LinkedHashSet<String> set = tmap.get(value);
        set.remove(key);
        if(set.isEmpty()) {
            //If the queue is empty i.e no other elem exist for that key in tmap remove the entry
            tmap.remove(value);
        }

        value --;

        if(value == 0) {
            hmap.remove(key);
        } else {
            put(key, value);
        }
    }

    public String getMaxKey() {
        if(tmap.isEmpty()) return "";

        int maxValue = tmap.lastKey();

        LinkedHashSet<String> set = tmap.get(maxValue);

        return set.iterator().next();
    }

    public String getMinKey() {
        if(tmap.isEmpty()) return "";

        int minValue = tmap.firstKey();

        LinkedHashSet<String> set = tmap.get(minValue);

        return set.iterator().next();
    }
}