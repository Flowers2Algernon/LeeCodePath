package easy;

import java.util.Arrays;

/*
* 976. Largest Perimeter Triangle
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
* formed from three of these lengths.
* If it is impossible to form any triangle of a non-zero area, return 0.
*
* Example 1:
Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
*
Example 2:
Input: nums = [1,2,1,10]
Output: 0
Explanation:
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
* */
public class Solution976 {
    public static void main(String[] args) {
        Solution97601 solution97601 = new Solution97601();
        int[] nums = {3, 4, 15, 2, 9, 4};
        System.out.println(solution97601.largestPerimeter(nums));
    }
}

class Solution97601 {
    public int largestPerimeter(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        for (int i =nums.length-1;i>1;i--){
            if (nums[i]+nums[i-1]>nums[i-2]&&nums[i]+nums[i-2]>nums[i-1]&&nums[i-1]+nums[i-2]>nums[i]&&nums[i]+nums[i-1]+nums[i-2]>sum){
                sum  = nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return sum;
    }
}