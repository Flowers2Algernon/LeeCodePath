package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 */
public class Solution1249 {
    public static void main(String[] args) {
        Solution1249 solution1249 = new Solution1249();
        System.out.println(solution1249.minRemoveToMakeValid("())()((("));
    }

    public String minRemoveToMakeValid(String s) {
        HashMap<Integer, Integer> leftHashMap = new HashMap<>();
        HashMap<Integer, Integer> rightHashMap = new HashMap<>();
        int leftCount = 0;
        int rightCount = 0;
        int leftParenthesis = 0;
        int rightParenthesis = 0;
        int ignored = 0;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
                leftHashMap.put(leftParenthesis++, i-ignored);
            }
            if (s.charAt(i) == ')') {
                rightCount++;
                rightHashMap.put(rightParenthesis++, i-ignored);
            }
            if (rightCount>0&&leftCount==0 || rightCount == leftCount+1){
                rightCount--;
                rightHashMap.remove(rightParenthesis-1);
                rightParenthesis--;
                ignored++;
                continue;
            }
            strings.add(String.valueOf(s.charAt(i)));
        }
        while (leftHashMap.size()!=rightHashMap.size()){
            if (leftHashMap.size()>rightHashMap.size()){
                leftParenthesis--;
                strings.remove(leftHashMap.get(leftParenthesis)+0);
                leftHashMap.remove(leftParenthesis);
            }else {
                rightParenthesis--;
                strings.remove(rightHashMap.get(rightParenthesis)+0);
                rightHashMap.remove(rightParenthesis);
            }
        }
        return strings.stream().collect(Collectors.joining());
    }
}














