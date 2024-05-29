package medium;

public class Solution1404 {
    public static void main(String[] args) {
        Solution1404 solution1404 = new Solution1404();
        System.out.println(solution1404.numSteps("11000"));
    }
    public int numSteps(String s) {
        //there are three situations
        int len = s.length()-1;
        int count = 0;
        int carry = 0;
        for (int i =len;i>=1;i--){
            int num = s.charAt(i)-'0';
            if (num==0&&carry==0){
                count++;
            }else if (num==1&&carry==1){
                count++;
                carry = 1;
            }else {
                count = count +2;
                carry =1;
            }
        }
        if (carry==1) count++;
        return count;
    }
}
