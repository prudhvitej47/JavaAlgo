package com.example.javaalgo.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    private final HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            timeMap.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            timeMap.put(key, treeMap);
        }
    }

    public String get(String key, int timestamp) {
        if (timeMap.containsKey(key)) {
            Map.Entry<Integer, String> entry = timeMap.get(key).floorEntry(timestamp);
            if (entry != null)
                return entry.getValue();
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap timeMap1 = new TimeMap();
        timeMap1.set("foo", "bar", 1);
        System.out.println(timeMap1.get("foo", 1));
        System.out.println(timeMap1.get("foo", 3));
        timeMap1.set("foo", "bar2", 4);
        System.out.println(timeMap1.get("foo", 4));
        System.out.println(timeMap1.get("foo", 3));
    }
}
