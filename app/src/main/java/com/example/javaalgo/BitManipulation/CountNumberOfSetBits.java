package com.example.javaalgo.BitManipulation;

public class CountNumberOfSetBits {

    public static int numSetBits(int num) {
        // num = 11000
        // when you do num - 1 the last bit with 1 will be changed to 0 and the bits after that will be changed to 1
        // example: num = 11000 ; num - 1 = 10111. Here the last bit with 1 was changed to 0 and remaining bits are changed to 1
        // Keep doing this until you get 0
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSetBits(24));
        System.out.println(numSetBits(7));
    }
}
