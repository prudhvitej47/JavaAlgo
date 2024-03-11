package com.example.javaalgo.BitManipulation;

public class SetBitAtNthPosition {

    // sets 1 at pos from the end
    public static int set(int num, int pos) {
        return num | (1 << (pos - 1));
    }

    public static void main(String[] args) {
        int num = 24;      // 11000
        int temp = 1 << 2; // 00100

        System.out.println(temp);
        System.out.println(num | temp);
        System.out.println(set(num, 3));

    }
}
