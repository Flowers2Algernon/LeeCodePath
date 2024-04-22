package medium;

import java.util.HashSet;

/*
* 238. Product of Array Except Self
Given an integer array nums, return an array answer
* such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
*Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*
* */
public class Solution238 {
}

class Solution23801 {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        int multipleOutcome = 1;
        HashSet<Integer> zeroLocation = new HashSet<>();
        int[] outCome = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                zeroLocation.add(i);//将出现0的位置记录下来
                if (count >= 2) {
                    return outCome;
                }
            }
            if (nums[i] != 0) {
                multipleOutcome = multipleOutcome * nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //还有出现一个零的情况没考虑到
            if (count == 1) {
                if (zeroLocation.contains(i)) {//此时有一个零
                    outCome[i] = multipleOutcome;
                    return outCome;
                }
            } else {
                outCome[i] = multipleOutcome / nums[i];
            }
        }
        return outCome;
    }
}
















