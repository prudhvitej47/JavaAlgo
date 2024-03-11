package com.example.javaalgo.BitManipulation;

public class CheckBitAtNthPosition {

    public static int at_position(int num, int pos) {
        int temp = 1 << (pos - 1);  // 01000 for pos = 4
        return num & temp;          // 11000 & 01000
    }

    public static void main(String[] args) {
        System.out.println("Is bit set at pos: " + (at_position(24, 4) != 0));
        System.out.println("Is bit set at pos: " + (at_position(24, 3) != 0));
        System.out.println("Is bit set at pos: " + (at_position(24, 5) != 0));
        System.out.println("Is bit set at pos: " + (at_position(24, 6) != 0));
    }
}
