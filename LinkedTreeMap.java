package myclass;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.TreeMap;

public class LinkedTreeMap<k> {

    TreeMap<k, Integer> treeMap;
    LinkedHashMap<k, Integer> linkedHashMap;

    public LinkedTreeMap() {
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>((key1, key2) -> {
            Integer value1 = linkedHashMap.get(key1);
            Integer value2 = linkedHashMap.get(key2);

            // Handle null values
            if (value1 == null && value2 == null) return 0;
            if (value1 == null) return 1; // Nulls are treated as lower
            if (value2 == null) return -1; // Nulls are treated as lower

            return value2.compareTo(value1); // Descending order
        });
    }

    public void put(k key) {
        // Update the LinkedHashMap
        int newValue = linkedHashMap.getOrDefault(key, 0) + 1;
        linkedHashMap.put(key, newValue);

        // Update the TreeMap
        treeMap.put(key, newValue);
    }

    public void remove(k key) {
        int value = treeMap.get(key);
        value -= 1;

        if(value == 0) {
            treeMap.remove(key);
            linkedHashMap.remove(key);
        } else {
            treeMap.put(key, value);
            linkedHashMap.put(key, value);
        }
    }

    public k getMaxKey() {
        if(treeMap.isEmpty()) return null;
        k maxKey = null;
        k key = treeMap.firstKey();
        if(key == null) return null;

        int value = treeMap.get(key);

        for(k elem : linkedHashMap.keySet()) {
            int elemVal = linkedHashMap.get(elem);

            //Get the first inserted key of the max count
            if(elemVal == value) {
                maxKey = elem;
                break;
            }
        }

        return maxKey;
    }

    public k getMinKey() {
        if(treeMap.isEmpty()) return null;
        k minKey = null;
        k key = treeMap.lastKey();
        if(key == null) return null;

        int value = treeMap.get(key);

        for(k elem : linkedHashMap.keySet()) {
            int elemVal = linkedHashMap.get(elem);

            //Get the first inserted key of the max count
            if(elemVal == value) {
                minKey = elem;
                break;
            }
        }

        return minKey;
    }
}