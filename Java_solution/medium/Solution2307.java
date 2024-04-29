package medium;

import java.util.ArrayList;
import java.util.List;

/*You are given a string s consisting of lowercase letters and an integer k.
 We call a string t ideal if the following conditions are satisfied:
t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.
A subsequence is a string that can be derived from another string by deleting some or no characters
 without changing the order of the remaining characters.
Note that the alphabet order is not cyclic. For example,
 the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.*/
//be mind this question's subsequence dont ask for continuous sequence, just select the char and dont change their order
public class Solution2307 {
    public static void main(String[] args) {
        Solution2307 solution2307 = new Solution2307();
        String s = "dyyonfvzsretqxucmavxegvlnnjubqnwrhwikmnnrpzdovjxqdsatwzpdjdsneyqvtvorlwbkb";//edkdb
        int k = 7;
        System.out.println(solution2307.longestIdealString(s, k));
    }
//todo rewrite this question
    private int longestIdealString(String s, int k) {
        int[] dp = new int[27];
        int n = s.length();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            for(int j = idx;j>=0&&j>=idx-k;j++){
                dp[idx] = Math.max(dp[idx],dp[j]+1);
            }
            for(int j=idx+1;j<26&&j<=idx+k;j++){
                dp[idx] = Math.max(dp[idx],dp[j]+1);
            }
            ans = Math.max(ans, dp[idx]);
        }
        return ans;
    }

    //the following method also can do this, but just can handle simple input, when the input becomes complex,it will run memory out
    public int longestIdealString1(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String resultString = String.valueOf(stringBuilder.charAt(0));
        List<String> stringSet = new ArrayList<>();
        int count = 1;
        int index = 0;
        stringSet.add(resultString);
        while (count < s.length() ) {
            int loopTimes = stringSet.size();
            for (int i =0;i<loopTimes;i++) {
                String string = stringSet.get(i);
                 char c = string.charAt(string.length() - 1);
                int diff = stringBuilder.charAt(count) - c;
                if (diff < 0) diff = diff * -1;
                if (diff <= k){
                    stringSet.add(string);
                    string += stringBuilder.charAt(count);
                    stringSet .set(i, string);
                }else {
                    stringSet.add(String.valueOf( stringBuilder.charAt(count)));
                }
            }
            count++;
        }
        for (String string : stringSet) {
            if (string.length() > resultString.length()) {
                resultString = string;
            }
        }
        System.out.println(resultString);
        return resultString.length();
        }
    }
