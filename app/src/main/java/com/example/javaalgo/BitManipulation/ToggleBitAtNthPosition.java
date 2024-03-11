package com.example.javaalgo.BitManipulation;

public class ToggleBitAtNthPosition {

    public static int toggle(int num, int pos) {
        int temp = 1 << (pos - 1);  // 1000 for pos = 4
        return num ^ temp; // 11000 ^ 01000
    }

    public static void main(String[] args) {
        System.out.println(toggle(24, 4));
        System.out.println(toggle(24, 3));
    }
}
