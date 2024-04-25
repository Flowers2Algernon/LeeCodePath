package medium;

/*
* 930. Binary Subarrays With Sum
Given a binary array nums and an integer goal,
* return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.

 Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
*
Example 2:
Input: nums = [0,0,0,0,0], goal = 0
Output: 15
*
* */
public class Solution930Unsolving {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
/*
* Output
14
Expected
10
* */
        Solution93001 solution93001 = new Solution93001();
        System.out.println(solution93001.numSubarraysWithSum(nums, 6));
    }
}

class Solution93001 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == goal) {
                    count++;
                    sum = 0;
                    index = j+1;
                    while ( index<nums.length&& nums[index]==0&&nums[j]!=0) {//此时后面有几个0就加几次
                        count++;
                        index++;
                    }
                }
            }
        }
        return count;
    }
}