package com.example.javaalgo.LLD;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRing<T> {

    private final HashFunction<T> hashFunction;
    private final SortedMap<Integer, T> circle;

    public ConsistentHashRing(HashFunction<T> hashFunction) {
        this.hashFunction = hashFunction;
        this.circle = new TreeMap<>();
    }

    public void add(T node) {
        circle.put(hashFunction.hashCode(node), node);
    }

    public void remove(T node) {
        circle.remove(hashFunction.hashCode(node));
    }

    public T getServer(T key) {
        if (circle.isEmpty()) {
            return null;
        }

        int hash = hashFunction.hashCode(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, T> tailMap = circle.tailMap(hash);  // return subset of map containing keys greater than or equal to current key
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public static void main(String[] args) {
        HashFunction<String> hashFunc = new StringHashFunction();
        ConsistentHashRing<String> cache = new ConsistentHashRing<>(hashFunc);

        cache.add("A"); // hash - 282
        cache.add("B"); // hash - 283
        cache.add("D"); // hash - 285
        cache.add("E"); // hash - 286
        cache.add("G"); // hash - 288
        cache.remove("E");

        System.out.println(cache.getServer("C")); // returns D
        System.out.println(cache.getServer("E")); // return G
    }

}

interface HashFunction<T> {
    Integer hashCode(T node);
}

class StringHashFunction implements HashFunction<String> {

    @Override
    public Integer hashCode(String node) {
        int hash = 7;
        for (int i = 0; i < node.length(); i++) {
            hash = hash * 31 + node.charAt(i);
        }
        return hash;
    }
}