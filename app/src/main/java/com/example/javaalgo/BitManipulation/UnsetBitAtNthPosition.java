package com.example.javaalgo.BitManipulation;

public class UnsetBitAtNthPosition {

    public static int unset(int num, int pos) {
        int temp = 1 << (pos-1); // 01000   in case of pos=4
        int newTemp = ~temp;     // 10111   first bit is MSB

        System.out.println(temp);
        System.out.println(newTemp);

        return num & newTemp;   // 11000 & 10111
    }

    public static void main(String[] args) {
        System.out.println(unset(24, 4));
    }
}
