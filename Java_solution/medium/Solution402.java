package medium;

import java.util.Stack;

/*Given string num representing a non-negative integer num,
and an integer k, return the smallest possible integer after removing k digits from num.*/
public class Solution402 {
    public static void main(String[] args) {
        Solution402 solution402 = new Solution402();
        System.out.println(solution402.removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> numStack = new Stack<>();
        for (char digit:num.toCharArray()){
            //when the current digit is less than the top of stack
            while (k>0 && !numStack.isEmpty() && digit<numStack.peek()){
                //remove digits from the stack
                numStack.pop();
                k--;
            }
            //push the current digit to stack
            numStack.push(digit);
        }
        //after iterator the full numsArrays, if there are still remaining removals,pop it form the stack
        while (k>0&&!numStack.isEmpty()){
            numStack.pop();
            k--;
        }
        //collect the digits from the stack
        StringBuilder stringBuilder = new StringBuilder();
        while (!numStack.isEmpty()){
            stringBuilder.append(numStack.pop());
        }
        stringBuilder.reverse();

        //remove the front zeros
        int m = stringBuilder.length();
        StringBuilder result = new StringBuilder();
        boolean findzero = false;
        for (int i =0;i<m;i++){
            if (stringBuilder.charAt(i)==0&&findzero){
                continue;
            }else {
                result.append(stringBuilder.charAt(i));
                findzero = true;
            }
        }

        //if the result is empty ,set it to zero
        if (result.length() == 0){
            result.append(0);
        }
        return result.toString();
    }
}
