package medium;

import java.util.HashMap;

/*
* 2958. Length of Longest Subarray With at Most K Frequency
You are given an integer array nums and an integer k.
The frequency of an element x is the number of times it occurs in an array.
An array is called good if the frequency of each element in this array is less than or equal to k.
Return the length of the longest good subarray of nums.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,2,3,1,2,3,1,2], k = 2
Output: 6
Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3
* occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
It can be shown that there are no good subarrays with length more than 6.
* Example 2:
Input: nums = [1,2,1,2,1,2,1,2], k = 1
Output: 2
Explanation: The longest possible good subarray is [1,2] since the values 1 and 2 occur
*  at most once in this subarray. Note that the subarray [2,1] is also good.
It can be shown that there are no good subarrays with length more than 2.
*
*
* */
public class Solution2958Unsolve {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hashMapTimes = new HashMap<>();//第一个元素表示数组里面的元素，第二个元素表示出现次数，第三个元素表示出现的位置
        HashMap<Integer, Integer> hashMapLocation = new HashMap<>();//第一个元素表示数组里面的元素，第二个元素表示该元素当前出现的位置
        if (k==0) return 0;
        int length = -1;
        for (int j = 0; j < nums.length; j++) {
            if (hashMapTimes.containsKey(nums[j])) {
                int i = hashMapTimes.get(nums[j]);
                hashMapTimes.put(nums[j], i + 1);
                if (j - hashMapLocation.get(nums[j]) >length){
                    length = j - hashMapLocation.get(nums[j]);
                }
                if (hashMapTimes.get(nums[j])>k){
                    hashMapLocation.put(nums[j], j);
                }
            } else {
                hashMapTimes.put(nums[j], 1);
            }
        }


        return length;
    }
}










