package com.example.javaalgo.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeMap2 {

    public static class Pair {
        String val;
        Integer timestamp;

        Pair(String val, Integer timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    private final HashMap<String, List<Pair>> timeMap;

    public TimeMap2() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            timeMap.get(key).add(new Pair(value, timestamp));
        } else {
            timeMap.put(key, new ArrayList<>(List.of(new Pair(value, timestamp))));
        }
    }

    public String get(String key, int timestamp) {
        if (timeMap.containsKey(key)) {
            List<Pair> list = timeMap.get(key);
            int n = list.size() - 1;
            int i = 0;
            int j = n;

            while (i <= j) {
                int mid = (i + j) / 2;

                if (list.get(mid).timestamp == timestamp) {
                    return list.get(mid).val;
                }
                else if (list.get(mid).timestamp > timestamp) {
                    j = mid - 1;
                }
                else if (list.get(mid).timestamp < timestamp && (mid == n || list.get(mid + 1).timestamp > timestamp)) {
                    return list.get(mid).val;
                }
                else {
                    i = mid + 1;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap2 timeMap2 = new TimeMap2();
        timeMap2.set("foo", "bar", 1);
        System.out.println(timeMap2.get("foo", 1));
        System.out.println(timeMap2.get("foo", 3));
        timeMap2.set("foo", "bar2", 4);
        System.out.println(timeMap2.get("foo", 4));
        System.out.println(timeMap2.get("foo", 3));
    }
}
