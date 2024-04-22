package medium;

import java.util.Arrays;

public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        String num1 = "999";
        String num2 = "999";
        System.out.println(solution43.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        int num1Count = num1.length() - 1;
        int num2Count = num2.length() - 1;
        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] s = new int[num1Count + num2Count + 2];
        for (int i = num1Count; i >= 0; i--) {
            for (int j = num2Count; j >= 0; j--) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                s[i + j + 1] += num % 10;
                s[i + j] += num / 10;
            }
        }
        for (int i =1;i<s.length;i++){
            if (s[i]>=10){
                s[i-1] += s[i]/10;
                s[i] = s[i]%10;
                i=1;
            }
        }
        System.out.println(Arrays.toString(s));
        String outCome = "";
        boolean redlect = true;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != 0) {
                redlect = false;
            }
            if (!redlect) {
                outCome += s[i];
            }
        }
        return outCome;
    }
}
