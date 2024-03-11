package com.example.javaalgo.DP;

// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//Return true if you can reach the last index, or false otherwise.
public class JumpGame {

    /*public static boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {

            for (int k = 0; k < i; k++) {
                if (dp[k] && nums[k] >= (i-k)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[nums.length - 1];
    }*/

    public static boolean canJump(int[] nums) {
        int destination = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (i + nums[i] >= destination) {
                destination = i;
            }
        }

        return destination == 0;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[]{3,2,1,0,4};

        System.out.println(canJump(nums));

    }
}
