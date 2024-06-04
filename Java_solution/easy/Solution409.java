package easy;

import java.util.Collection;
import java.util.HashMap;

public class Solution409 {
    public static void main(String[] args) {
        Solution409 solution409 = new Solution409();
        System.out.println(solution409.longestPalindrome("aaaaaccbbddwww"));
    }
    //todo 还可以使用数组来另外实现，闲暇时尝试
    public int longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        Collection<Integer> values = map.values();
        int length = 0;
        boolean even = false;
        int maxEven = 0;
        for (Integer value : values) {
            if (value%2==0){
                length += value;
            }else {
                //有奇数,奇数也要能利用到其最近的偶数
//                maxEven = Math.max(maxEven,value);
                length += value-1;
               even = true;
            }
        }
        if (even){
            return length+1;
        }else return length;
    }
}
