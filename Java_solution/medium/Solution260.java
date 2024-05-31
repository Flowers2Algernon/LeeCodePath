package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();//first element represent value, second element represent appear times
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        ArrayList<Integer> integers = new ArrayList<>();
        int[] result = {0,0};
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue()==1){
                integers.add(entry.getKey());
            }
        }
       result[0]= integers.get(0);
       result[1]= integers.get(1);
        return result;
    }
}
