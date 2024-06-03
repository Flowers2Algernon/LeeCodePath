package medium;

public class Solution2486 {
    public static void main(String[] args) {
        Solution2486 solution2486 = new Solution2486();
        System.out.println(solution2486.appendCharacters("z", "abcde"));
    }
    public int appendCharacters(String s, String t) {
        if (s.contains(t)){
            return 0;
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int count = 0;
        for (char c : sCharArray) {
            if (c==tCharArray[count]){
                count++;
            }
        }
        return t.length()-count;
    }
}
