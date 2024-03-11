package com.example.javaalgo.LLD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentWebCrawler {

    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> mapOfVisitedUrls = new ConcurrentHashMap<>();

        List<Integer> listOfUrls = Collections.synchronizedList(new ArrayList<>());


    }
}
