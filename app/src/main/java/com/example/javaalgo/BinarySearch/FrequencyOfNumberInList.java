package com.example.javaalgo.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FrequencyOfNumberInList {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 2, 2, 2, 3, 3, 10));

        int key = 3;
        System.out.println("Count of " + key + " : " + countOfNum(arr, key));
    }

    static int countOfNum(ArrayList<Integer> arr, int key) {
        return countOfNum(arr, 0, arr.size() - 1, key);
    }

    static int countOfNum(ArrayList<Integer> arr, int start, int end, int key) {
        if (start == end) {
            if (arr.get(start) == key) {
                return 1;
            } else {
                return 0;
            }
        }

        int mid = (end + start) / 2;

        if (arr.get(mid) > key) {
            return countOfNum(arr, start, mid - 1, key);
        } else if (arr.get(mid) < key) {
            return countOfNum(arr, mid + 1, end, key);
        } else {
            int leftCount = 0;
            if (mid > start && arr.get(mid - 1) == key) {
                leftCount = countOfNum(arr, start, mid - 1, key);
            }

            int rightCount = 0;
            if (mid < end && arr.get(mid + 1) == key) {
                rightCount = countOfNum(arr, mid + 1, end, key);
            }

            return leftCount + 1 + rightCount;
        }
    }
}
