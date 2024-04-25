package medium;

/*You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/

import easy.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode listNode = new ListNode();
        listNode.val = 9;
//        ListNode listNode1 = new ListNode(4);
//        listNode .next = listNode1;
//        ListNode listNode2 = new ListNode(9);
//        listNode1 .next = listNode2;
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(9);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(9);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(9);
        listNode6.next = listNode7;
        ListNode listNode8 = new ListNode(9);
        listNode7.next = listNode8;
        ListNode listNode9 = new ListNode(9);
        listNode8.next = listNode9;
        ListNode listNode10 = new ListNode(9);
        listNode9.next = listNode10;
        ListNode listNode11 = new ListNode(9);
        listNode10.next = listNode11;
        ListNode listNode12 = new ListNode(9);
        listNode11.next = listNode12;
        System.out.println(solution2.addTwoNumbers2(listNode, listNode3));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = new String();
        String s2 = new String();
        while (l1 != null) {
            s1 = l1.val + s1;
            l1 = l1.next;
        }
        while (l2 != null) {
            s2 = l2.val + s2;
            l2 = l2.next;
        }
        System.out.println(s1);
        BigInteger bigInteger1 = new BigInteger(s1);
        BigInteger bigInteger = new BigInteger(s2);
        System.out.println(bigInteger1);
        System.out.println(bigInteger);
        BigInteger bigInteger2 = new BigInteger(bigInteger1.add(bigInteger).toString());
        ListNode listNode = new ListNode(0);
        if (bigInteger2.equals(BigInteger.ZERO)) {
            return listNode;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (bigInteger2.compareTo(BigInteger.ONE) >=0) {
            BigInteger[] bigIntegers = bigInteger2.divideAndRemainder(new BigInteger("10"));
            integers.add(bigIntegers[1].intValue());
            bigInteger2 = bigIntegers[0];
        }
        System.out.println(integers);
        ListNode listNode2 = new ListNode(0);
        listNode.next = listNode2;
        for (Integer integer : integers) {
            ListNode listNode1 = new ListNode(integer);
            listNode2.next = listNode1;
            listNode2 = listNode2.next;
        }
        return listNode.next.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        //solution2
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int sum =0;
        int carry = 0;
        while (l1!=null || l2!=null){
             sum = carry;
            if (l1!=null){
                sum+=l1.val;
            }
            if (l2!=null){
                sum+=l2.val;
            }
            ListNode listNode = new ListNode(sum % 10);
            carry = sum/10;
            curr.next = listNode;
            curr = curr.next;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        if (carry>0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
