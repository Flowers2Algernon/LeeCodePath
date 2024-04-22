package easy;
/*
13. Roman to Integer
* Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II.
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four.
The same principle applies to the number nine,
which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
*
Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*
* */


class Solution13 {

    public static void main(String[] args) {
        String s = "IVXC";
        romanToInt(s);
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int isCombined = 0;//
        for (int i = 0; i < s.length() - 1 || (isCombined == 0 && i == s.length()-1); i++) {
            switch (s.charAt(i)) {//i=s.leng(th-1)的时候还需要设置一个变量来进行判断，是否要将最后一个元素组合计算
                case 'I': {
                    if (i != s.length() - 1 && 'V' == s.charAt(i + 1)) {
                        sum = sum + 4;
                        if (i + 1 == s.length() - 1) {
                            isCombined = 1;
                        }
                        i = i + 1;
                        continue;
                    } else if (i != s.length() - 1 &&'X' == s.charAt(i + 1) ) {
                        sum = sum + 9;
                        if (i + 1 == s.length() - 1) {
                            isCombined = 1;
                        }
                        i = i + 1;
                        continue;
                    } else {
                        sum = sum + 1;
                        continue;
                    }
                }
                case 'V':
                    sum += 5;
                    continue;
                case 'X': {
                    if (i != s.length() - 1 &&'L' == s.charAt(i + 1)) {
                        sum = sum + 40;
                        if (i + 1 == s.length() - 1) {
                            isCombined = 1;
                        }
                        i = i + 1;
                        continue;
                    } else if (i != s.length() - 1 &&'C' == s.charAt(i + 1) ) {
                        sum = sum + 90;
                        if (i + 1 == s.length() - 1) {
                            isCombined = 1;
                        }
                        i = i + 1;
                        continue;
                    } else {
                        sum = sum + 10;
                        continue;
                    }
                }
                case 'L':
                    sum += 50;
                    continue;
                case 'C': {
                    if (i != s.length() - 1 &&'D' == s.charAt(i + 1) ) {
                        sum = sum + 400;
                        if (i + 1 == s.length() - 1) {
                            isCombined = 1;
                        }
                        i = i + 1;
                        continue;
                    } else if (i != s.length() - 1 &&'M' == s.charAt(i + 1) ) {
                        sum = sum + 900;
                        if (i + 1 == s.length() - 1) {
                            isCombined = 1;
                        }
                        i = i + 1;
                        continue;
                    } else {
                        sum = sum + 100;
                        continue;
                    }
                }
                case 'D':
                    sum += 500;
                    continue;
                case 'M':
                    sum += 1000;
                    continue;
            }
//            StringBuilder newString = new StringBuilder();
//            for (int j = 0; j < s.length() - 1; j++) {
//                newString.append(s.charAt(j));
//                newString.append(s.charAt(j + 1));
//                switch (newString.toString()) {
//                    case "IV":
//                        sum -= 1 * 2;
//                        continue;
//                    case "IX":
//                        sum -= 1 * 2;
//                        continue;
//                    case "XL":
//                        sum -= 10 * 2;
//                        continue;
//                    case "XC":
//                        sum -= 10 * 2;
//                        continue;
//                    case "CD":
//                        sum -= 100 * 2;
//                        continue;
//                    case "CM":
//                        sum -= 100 * 2;
//                        continue;
//
//                }
        }
        return sum;
    }

}
