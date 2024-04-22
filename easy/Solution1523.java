package easy;
/*1523. Count Odd Numbers in an Interval Range
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
*Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
* */
public class Solution1523 {
}
class Solution152301 {
    public int countOdds(int low, int high) {
        int count = 0;
        for(int i = low;i<=high;i++){
            if(i%2!=0){
                count++;
            }
        }
        return count;
    }
}