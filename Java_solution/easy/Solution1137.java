package easy;

import java.util.LinkedHashMap;

public class Solution1137 {
    public static void main(String[] args) {
        int n = 25;
        Solution1137 solution1137 = new Solution1137();
        System.out.println(solution1137.tribonacci(n));
    }
    public int tribonacci(int n) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, 0);//the first element describe location,the second element describe value
        map.put(1, 1);
        map.put(2, 1);
        findTribonacci(n,map);
        return map.get(n);
    }
    public LinkedHashMap<Integer, Integer> findTribonacci(int n,LinkedHashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {return map;}
        map.put(map.size(), map.get(map.size()-1)+map.get(map.size()-2)+map.get(map.size()-3) );
        findTribonacci(n,map);
        return map;
    }
}
