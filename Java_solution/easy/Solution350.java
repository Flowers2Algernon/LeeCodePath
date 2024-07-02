package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution350 {
    public int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i,map1.getOrDefault(i,0)+1);
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums2) {
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
        //return the minimal appear numbers
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())){
               int number =  entry.getValue()<map2.get(entry.getKey())?entry.getValue():map2.get(entry.getKey());
                while ( number>0){
                    result.add(entry.getKey());
                    number--;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int point1 = 0;
        int point2 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(point1<nums1.length||point2<nums2.length){
            if (nums1[point1]==nums2[point2]){
                result.add(nums1[point1]);
                point1++;
                point2++;
            } else {
                if (nums1[point1]<nums2[point2]){
                    point1++;
                }else point2++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] ints = new int[1001];
        for (int i : nums1) {
            ints[i]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (ints[i]>0){
                result.add(i);
            }
            ints[i]--;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
