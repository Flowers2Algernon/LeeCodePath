package medium;

import java.util.HashMap;

public class Solution75 {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        int zero = map.getOrDefault(0,0);
        int first = map.getOrDefault(1,0);
        int two = map.getOrDefault(2,0);
        for (int i = 0; i < zero; i++) {
            nums[i]=0;
        }
        for (int i = zero; i < zero+first; i++) {
            nums[i]=1;
        }
        for (int i = first+zero; i < zero+two+first; i++) {
            nums[i]=2;
        }
    }
}
