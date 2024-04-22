package easy;

import java.util.ArrayDeque;
import java.util.Iterator;

/*Given a string s of lower and upper case English letters.
A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters
that make the string bad and remove them. You can keep doing this until the string becomes good.
Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
Notice that an empty string is also good.
Example 1:
Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".

Example 2:
Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""*/
public class Solution1544 {
    public static void main(String[] args) {
        Solution1544 solution1544 = new Solution1544();
        System.out.println(solution1544.makeGood("abBABccs"));
    }

    public String makeGood(String s) {
        //现在先用栈来实现一下
        ArrayDeque<String> strings = new ArrayDeque<>();
        int i = 0;
        while (i<s.length()) {
            if (strings.isEmpty()){
                strings.push(String.valueOf(s.charAt(i)));
                i++;
            }else if (((char) (strings.getFirst().charAt(0) + 32) == s.charAt(i))||((char) (strings.getFirst().charAt(0) - 32) == s.charAt(i))) {
                i++;
                strings.pop();
            }else {
                strings.push(String.valueOf(s.charAt(i)));
                i++;
            }
        }
        String result = "";
        Iterator<String> stringIterator = strings.descendingIterator();
        while (stringIterator.hasNext()){
            result += stringIterator.next();
        }
        return result;
        //如果将list改成StringBuilder会减少两次循环
        //以下是使用list并使用三次循环来实现
//        List<String> strings = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            strings.add(String.valueOf(s.charAt(i)));
//        }
//        for (int j = 0;j<=strings.size()-2; j++) {
//            String string1 = strings.get(j);
//            char c1 = string1.charAt(0);
//            String string = strings.get(j + 1);
//            char c = (char) (string.charAt(0)+32);
//            char c11 = (char) (string.charAt(0)-32);
//            if (c1==c || c1 == c11) {
//                strings.remove(j);
//                strings.remove(j);
//                j = -1;
//            }
//        }
//        String resultString = "";
//        for (int i =0;i<strings.size();i++){
//            resultString += strings.get(i);
//        }
//        return resultString;
    }
}
