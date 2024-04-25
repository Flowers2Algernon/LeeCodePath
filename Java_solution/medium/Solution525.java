package medium;

/*
* 525. Contiguous Array
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
*
* Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

* Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*
* */


//如果运用前缀和。关键是零出现的次数和前缀和的数组

import java.util.HashMap;

public class Solution525 {
    public static void main(String[] args) {
        Solution52502 solution52501 = new Solution52502();
        int[] nums = {0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1};
        System.out.println(solution52501.findMaxLength(nums));
    }
}

class Solution52502 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        int longestSub = 0;
        hashMap.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i]==0)?-1:1;
            if (!hashMap.containsKey(sum)){
                hashMap.put(sum,i);
                longestSub = longestSub+1;
            }else {
                longestSub = Math.max(longestSub,i-hashMap.get(sum));
            }
        }
            return  longestSub;
    }
}

class Solution52501 {
    public int findMaxLength(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int count = 0;
        String string = "";
        for (int i = 0; i < nums.length; i++) {
            string += nums[i];
        }
        String string1 = "";
        for (int i = nums.length; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                zeroCount = 0;
                oneCount = 0;
                string1 = string.substring(j, i);
                for (int k = 0; k < string1.length(); k++) {
                    if (string1.charAt(k) == '0') {
                        zeroCount++;
                    } else {
                        oneCount++;
                    }
                }
                if (zeroCount == oneCount) {
                    if (zeroCount * 2 > count) {
                        count = zeroCount * 2;
                    }
                }
            }
        }
        return count;
    }
}