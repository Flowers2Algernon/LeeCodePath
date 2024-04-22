package easy;

/*
* 709. To Lower Case
Given a string s,
* return the string after replacing every uppercase letter
*  with the same lowercase letter
* .*/
public class Solution709 {
    public static void main(String[] args) {
        String s = "SdafSdas";
        Solution657.toLowerCase(s);
    }
}
class Solution70901 {
    public static String toLowerCase(String s) {
        String newS = "";
        newS.toLowerCase();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)<='Z' && s.charAt(i)>='A'){
                newS +=  (char)(s.charAt(i)-'A'+'a');
            }else newS += s.charAt(i);
        }
        return newS;
    }
}