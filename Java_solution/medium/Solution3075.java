package medium;

import java.util.Arrays;

/*You are given an array happiness of length n, and a positive integer k.
There are n children standing in a queue, where the ith child has happiness value happiness[i].
You want to select k children from these n children in k turns.
In each turn, when you select a child,
the happiness value of all the children that have not been selected till now decreases by 1.
Note that the happiness value cannot become negative and gets decremented only if it is positive.
Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.*/
public class Solution3075 {
    public static void main(String[] args) {
        Solution3075 solution3075 = new Solution3075();
        System.out.println(solution3075.maximumHappinessSum(new int[]{1,1,1,1}, 2));
    }
    public long maximumHappinessSum(int[] happiness, int k) {
        //each time select a number, the other deduct one
        long sum = 0;
        int n = happiness.length;
        int[] clone = happiness.clone();
        Arrays.sort(clone);//ascending order

        for (int i = 0; i < k; i++) {
               if (clone[n-i-1]-i>=0){
                   sum += clone[n-i-1]-i;
               }else sum += 0;
        }
        return sum;
    }
}
