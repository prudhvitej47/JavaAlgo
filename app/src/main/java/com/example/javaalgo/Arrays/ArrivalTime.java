package com.example.javaalgo.Arrays;

// Uber - assessment question
// Given an array of arrival times, each person arrives at arr[i] does some work for 5 mins and leaves
// If a person arrives at a time while another is doing their work then they wait in a queue
// If the queue size is more than 10 than any new person who arrives won't do any work
// For each person print their departure time in seconds. If the person did not do any work then just print their arrival time

// Example: 4, 400, 450, 500, 550, 850
// Result: 304, 700, 1000, 1300, 1600, 1900
public class ArrivalTime {

    public static int[] getTimes(int[] times, int n) {
        int[] result = new int[n];
        int nextAvailableSlot = times[0] + 300;
        result[0] = nextAvailableSlot;
        int queueSize = 0;
        int l = 1;

        for (int i = 1; i < n; i++) {
            int arrivalTime = times[i];

            if (queueSize > 10 && nextAvailableSlot > arrivalTime) {
                // person skips work
                result[i] = arrivalTime;
                continue;
            }

            // if nextAvailableSlot <= arrivalTime then person does work
            if (nextAvailableSlot <= arrivalTime) {

                while (l <= i) {

                    if (nextAvailableSlot > arrivalTime) {
                        // add person to queue
                        queueSize++;
                        break;
                    }

                    // if the person has not skipped work
                    if (result[l] == 0) {
                        nextAvailableSlot = Math.max(times[l], nextAvailableSlot) + 300;
                        result[l] = nextAvailableSlot;

                        if (queueSize>0)
                            queueSize--;
                    }
                    l++;
                }
            } else {
                // person waits in queue
                queueSize++;
            }
        }

        while (l < n) {
            if (result[l] == 0) {
                nextAvailableSlot += 300;
                result[l] = nextAvailableSlot;
            }
            l++;
        }

        return result;
    }

    public static void main(String[] args) {
        // int[] times = new int[]{4, 400, 450, 500, 550, 850};
        // int[] times = new int[]{4, 400, 450, 500, 550, 555, 560, 580, 600, 620, 640, 660, 680, 13, 14, 720, 721};
        int[] times = new int[]{4, 400, 450, 500, 550, 555, 560, 580, 600, 620, 640, 660, 680, 13, 14, 720, 1050};
        int[] result = getTimes(times, times.length);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println();
    }
}
