package easy;
/*
* 2586. Count the Number of Vowel Strings in Range
You are given a 0-indexed array of string words and two integers left and right.
A string is called a vowel string if
* it starts with a vowel character and ends with a vowel character
* where vowel characters are 'a', 'e', 'i', 'o', and 'u'.
Return the number of vowel strings words[i] where i belongs to the inclusive range [left, right].
*
* Example 1:

Input: words = ["are","amy","u"], left = 0, right = 2
Output: 2
Explanation:
- "are" is a vowel string because it starts with 'a' and ends with 'e'.
- "amy" is not a vowel string because it does not end with a vowel.
- "u" is a vowel string because it starts with 'u' and ends with 'u'.
The number of vowel strings in the mentioned range is 2.
*
* Example 2:
Input: words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
Output: 3
Explanation:
- "aeo" is a vowel string because it starts with 'a' and ends with 'o'.
- "mu" is not a vowel string because it does not start with a vowel.
- "ooo" is a vowel string because it starts with 'o' and ends with 'o'.
- "artro" is a vowel string because it starts with 'a' and ends with 'o'.
The number of vowel strings in the mentioned range is 3.
* */
public class Solution2586 {
}
class Solution258601 {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i =left;i<=right;i++){
            if ((words[i].charAt(0) == 'a'||words[i].charAt(0) == 'e'||words[i].charAt(0) == 'i'||words[i].charAt(0) == 'o'||words[i].charAt(0) == 'u')&&((words[i].charAt(words[i].length()-1) == 'a'||words[i].charAt(words[i].length()-1) == 'e'||words[i].charAt(words[i].length()-1) == 'i'||words[i].charAt(words[i].length()-1) == 'o'||words[i].charAt(words[i].length()-1) == 'u'))){
                count++;
            }
        }
        return count;
    }
}