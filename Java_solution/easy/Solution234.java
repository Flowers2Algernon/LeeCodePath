package easy;

import java.util.ArrayList;

public class Solution234 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrays = new ArrayList<>();
        while (head!=null){
            arrays.add(head.val);
            head = head.next;
        }
        int j = arrays.size()-1;
        for (int i =0;i<arrays.size();i++,j--){
            if (arrays.get(i)!=arrays.get(j)){
                return false;
            }
        }
        return true;
    }
}

