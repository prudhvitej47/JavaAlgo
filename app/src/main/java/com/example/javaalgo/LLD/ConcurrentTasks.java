package com.example.javaalgo.LLD;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentTasks {

    public static int threadPoolSize = 30;

    static class MyRunnable implements Runnable {

        String url;

        public MyRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            String result = "";
            int responseCode;

            try {
                URL siteUrl = new URL(url);

                HttpURLConnection connection = (HttpURLConnection) siteUrl.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(3000);
                connection.connect();

                responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    result = "-> Green <-\t\t" + "Code: " + responseCode;
                } else {
                    result = "-> Yellow <-\t\t" + "Code: " + responseCode;
                }

            } catch (Exception e) {
                result = "-> Red <-\t\t" + "Wrong domain - Exception: " + e.getMessage();
            }

            System.out.println(url + "\t\t\t\tStatus: " + result + "\t\tThread: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        String[] crunchifyList = {
                "https://crunchify.com",
                "https://yahoo.com",
                "https://www.ebay.com",
                "https://google.com",
                "https://www.example.co",
                "https://paypal.com",
                "http://bing.com/",
                "https://techcrunch.com/",
                "http://mashable.com/",
                "https://crunchify.com/crunchy-sharing/",
                "https://wordpress.com/",
                "https://wordpress.org/",
                "https://example.com/",
                "https://sjsu.edu/",
                "https://crunchify.com/",
                "https://test.com.au/",
                "https://www.wikipedia.org/",
                "https://en.wikipedia.org"
        };

        for (String url: crunchifyList) {

            Runnable runnable = new MyRunnable(url);

            executorService.execute(runnable);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished all workers");
    }
}
