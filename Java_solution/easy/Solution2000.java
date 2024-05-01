package easy;

public class Solution2000 {
    public static void main(String[] args) {
        Solution2000 solution2000 = new Solution2000();
        System.out.println(solution2000.reversePrefix("abcdefd", 'd'));
    }
    public String reversePrefix(String word, char ch) {
        StringBuilder stringBuilder = new StringBuilder();
        int point = -1;
        boolean exits = false;
        for (int i =0;i<word.length();i++){
            if (word.charAt(i)!=ch){
                stringBuilder.append(word.charAt(i));
            }else {
                //here find the ch
                point = i;
                stringBuilder.append(word.charAt(i));
                exits = true;
                break;
            }
        }
        if (!exits){
            return stringBuilder.toString();
        }else {
            StringBuilder reverse = stringBuilder.reverse();
            StringBuilder append = reverse.append(word.substring(point+1));
            return append.toString();
        }
    }
}
