package com.example.javaalgo.Arrays;

// There is a string, s, of lowercase English letters that is repeated infinitely many times.
// Given an integer, n, find and print the number of letter a's in the first  letters of the infinite string.
// Example: s = 'abcac', n = 10
// The substring we consider is abcacabcac, the first 10 characters of the infinite string. There are 4 occurrences of 'a' in the substring.
public class RepeatedString {

    public static long numOccurrences(String s, long n) {
        int inputLength = s.length();
        char[] inputArr = s.toCharArray();
        long[] aCount = new long[inputLength];

        for (int i = 0; i < inputLength; i++) {
            boolean isA = inputArr[i] == 'a';
            if (i == 0) {
                aCount[i] = isA ? 1 : 0;
            } else {
                aCount[i] = aCount[i - 1] + (isA ? 1 : 0);
            }
        }

        long totalCount = 0;
        if (n < inputLength) {
            return aCount[(int)n - 1];
        } else {
            long temp1 = n / inputLength;
            totalCount += temp1 * aCount[inputLength - 1];

            long temp2 = n % inputLength;
            if (temp2 > 0)
                totalCount += aCount[(int)temp2 - 1];
        }

        return totalCount;
    }

    public static void main(String[] args) {
        // System.out.println(numOccurrences("abcac", 10));
        // System.out.println(numOccurrences("aba", 10));
        // System.out.println(numOccurrences("a", 1000000000000L));
        System.out.println(numOccurrences("ceebbcb", 817723));
    }
}
