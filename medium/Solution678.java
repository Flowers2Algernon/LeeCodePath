package medium;

/*Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
The following rules define a valid string:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true
 */
public class Solution678 {
    public static void main(String[] args) {
        Solution678 solution678 = new Solution678();
        System.out.println(solution678.checkValidString("(**((((*))"));
    }
    public boolean checkValidString(String s) {
        int minLeft = 0;
        int maxLeft = 0;
        for (char c:s.toCharArray()){
            if (c=='('){
                minLeft++;
                maxLeft++;
            }
            if (c==')'){
                minLeft--;
                maxLeft--;
            }
            if (c=='*'){
                maxLeft++;
                minLeft--;
            }
            if (maxLeft<0){
                return false;
            }
            if (minLeft<0){
                minLeft = 0;
            }
        }
        if (minLeft==0){
            return true;
        }else return false;



//        HashMap<Integer, String> stringHashMap = new HashMap<>();
//        //第一步设置一个栈，
//        //当遇到左括号和星号时就放入栈，当前面最开始遇到右括号时，返回false
//        //需要设置一个值来表示是否有效。
//        //*既可以当左括号，又能当右括号，怎么处理？单独设置一个参数表示星号，看最后左括号和右括号的差值，如果差值在星号值以内，算true
//        int rightCount = 0;
//        int leftCount = 0;
//        int signalCount = 0;
//        for (int i = 0; i < s.length(); i++) {
//            stringHashMap.put(i,String.valueOf(s.charAt(i)));
//            if (s.charAt(i)=='('){
//                leftCount++;
//                if (leftCount>s.length()/2){
//                    return false;
//                }
//            }
//            if (s.charAt(i)==')'){
//                rightCount++;
//                if (rightCount>s.length()/2){
//                    return false;
//                }
//            }
//            if (s.charAt(i)=='*'){
//                signalCount++;
//            }
//            if (leftCount==0&&signalCount==0&&rightCount>0){
//                return false;
//            }
//
//        }
//        if (leftCount - rightCount == 0){
//            return true;
//        }else if ((leftCount-rightCount == signalCount ) || (rightCount -leftCount == signalCount)){
//            return true;
//        }
//        else  return false;
    }
}











