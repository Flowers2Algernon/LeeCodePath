package easy;

import java.util.HashMap;

public class Solution2441 {
    public static void main(String[] args) {
        Solution2441 solution2441 = new Solution2441();
        System.out.println(solution2441.findMaxK(new int[]{-1, 2, -3, 3}));
    }
    public int findMaxK(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNumber = Integer.MIN_VALUE;
        boolean dontHaveMax = true;
        for (int num : nums) {
            //there are two situation, the map dont contain and the map contain, if the map dont contain, add it, else,compare
            if (!map.containsKey(num)){
                map.put(num,0);
                if (map.containsKey(num*(-1))){
                    int abs = Math.abs(num);
                    if (abs>maxNumber){
                        maxNumber = abs;
                        dontHaveMax = false;
                    }
                }
            }
        }
        if (dontHaveMax){
            return -1;
        }
        return maxNumber;
    }
}
