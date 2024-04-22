package easy;

import java.util.*;

public class Solution205 {
    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        String s  = "aff";
        String t  = "egg";
        System.out.println(solution205.isIsomorphic(s, t));
    }
    public boolean isIsomorphic(String s, String t) {
//        All occurrences of a character must be replaced with another character while preserving the order of characters.
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<String, List<Integer>> hashMap1 = new HashMap<>();
        HashMap<String, List<Integer>> hashMap2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> orDefault = hashMap1.getOrDefault(String.valueOf(s.charAt(i)), new ArrayList<>());
            orDefault.add(i);
            hashMap1.put(String.valueOf(s.charAt(i)),orDefault);
        }
        for (int i = 0; i < t.length(); i++) {
            List<Integer> orDefault = hashMap2.getOrDefault(String.valueOf(t.charAt(i)), new ArrayList<>());
            orDefault.add(i);
            hashMap2.put(String.valueOf(t.charAt(i)),orDefault);
        }
        Set<Map.Entry<String, List<Integer>>> entries = hashMap1.entrySet();
        for (Map.Entry<String, List<Integer>> entry : entries) {
            if (hashMap2.containsValue(entry.getValue())){
                continue;
            }else return false;
        }
        return true;
    }
}
