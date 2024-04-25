package easy;
/*
*  Monotonic Array
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
*  An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic,
* or false otherwise.
* Example 2:
Input: nums = [6,5,4,4]
Output: true

* Example 3:
Input: nums = [1,3,2]
Output: false
*
* solution:the question need us to determin is the array monotonic, monotonic divided into two situation, increase and decrease, so we first set two count means decreasecount and increasecount, then we use the for loop to travalse the array, once increase -> increasecount+1;else decreasecount +1;
but in the process , we found a special situation, that is nums[i] = nums[i+1], at this time, we need to set both of the two count to add 1, because in the for loop the computer dont know how the arrays is increased or decreased, once the for loop ended, we check the two count is it equals the compare time or name compare counts, if it is ,the arrays is increased or decreased.
* */


class Solution896 {
    public static void main(String[] args) {
    int[] arrys = {1,2,2,3};
        isMonotonic(arrys);
    }
    public static boolean isMonotonic(int[] nums) {
        int increaseCount = 0 ;
        int decreaseCount = 0;
        for(int i = 0;i< nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                increaseCount++;//此时递增
            }else if(nums[i]>nums[i+1]){
                decreaseCount++;
            }else {
                increaseCount++;
                decreaseCount++;
            }

        }
        if(increaseCount== nums.length-1 || decreaseCount== nums.length-1){
            return  true;
        }
        else return false;
    }
}