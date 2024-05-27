package easy;

import java.util.Arrays;

/*
* You are given an array nums of non-negative integers.
* nums is considered special if there exists a number x such that there are
* exactly x numbers in nums that are greater than or equal to x.
Notice that x does not have to be an element in nums.
Return x if the array is special, otherwise, return -1.
* It can be proven that if nums is special, the value for x is unique.
* */
public class Solution1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //x的可能取值是0到n
        for (int i =0;i<=n;i++){
         //首先获取nums中大于i的元素个数
            int greatCount = 0;
            for (int j = 0;j<n;j++){
                if (nums[j]>=i){
                    greatCount++;
                }
            }
            if (i==greatCount){
                return i;
            }
        }
        return -1;
    }
    //优化--既然nums排序了，就不需要去再循环遍历nums找到大于i的数
    public int specialArray2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        //x的可能取值是0到n
        for (int i =0;i<=n;i++){
            //首先获取nums中大于i的元素个数
            int greatCount = 0;
            int i1 = Arrays.binarySearch(nums, i);
            greatCount=n-i1;
            if (i==greatCount){
                return i;
            }
        }
        return -1;
    }
}
