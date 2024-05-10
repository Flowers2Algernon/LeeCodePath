package medium;

import java.util.Arrays;

/*Given an array nums with n integers, your task is to check if it could become non-decreasing
by modifying at most one element.
We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based)
such that (0 <= i <= n - 2).*/
public class Solution665 {
    public static void main(String[] args) {
        Solution665 solution665 = new Solution665();
        System.out.println(solution665.checkPossibility(new int[]{3, 4, 2, 3}));
    }
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int[] clone = nums.clone();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (clone[i]!=nums[i]){
                count++;
            }
            if (count>=2){
                return false;
            }
        }
        return true;
    }
}
