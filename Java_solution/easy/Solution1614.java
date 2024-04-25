package easy;

public class Solution1614 {
    public static void main(String[] args) {

    }
    public int maxDepth(String s) {
        int maxCount = 0;
        int resultCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                maxCount+=1;
                if (maxCount>resultCount){
                    resultCount = maxCount;
                }
            }
            if (s.charAt(i)==')'){
                maxCount-=1;
            }
        }
        return resultCount;
    }
}
