package medium;

import easy.ListNode;
/*You are given the head of a non-empty linked list
representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.*/
public class Solution2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode head1 = new ListNode();
        head1.next = head;

        ListNode left = head1;
        ListNode right = head;

        while (right!=null){
            if ((right.val*2)>10){
                left.val +=1;
            }
            right.val = (right.val*2)%10;
            left = left.next;
            right = right.next;
        }
        return head1.val>0?head1 : head;
    }
}
