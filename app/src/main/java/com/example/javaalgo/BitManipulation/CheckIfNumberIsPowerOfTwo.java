package com.example.javaalgo.BitManipulation;

public class CheckIfNumberIsPowerOfTwo {

    // log a is log a to the base 10
    // log a/log b is log a to the base b
    public static boolean isNumberPowerOfTwo(int num) {
        double x = Math.log(num)/Math.log(2);
        return Math.floor(x) == Math.ceil(x);
    }

    public static boolean isNumberPowerOfTwoBitOp(int num) {
        // If power of 2 MSB is always 1
        // and num - 1 will always have MSB as 0
        // so if num & num - 1 == 0, then it means it is power of 2
        // one exception is 0
        return num != 0 && ((num & (num - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isNumberPowerOfTwo(12));
        System.out.println(isNumberPowerOfTwo(1024));
        System.out.println(isNumberPowerOfTwo(256));
        System.out.println(isNumberPowerOfTwo(2));
        System.out.println("--------------------");
        System.out.println(isNumberPowerOfTwoBitOp(12));
        System.out.println(isNumberPowerOfTwoBitOp(1024));
        System.out.println(isNumberPowerOfTwoBitOp(256));
        System.out.println(isNumberPowerOfTwoBitOp(2));
    }
}
