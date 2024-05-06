package medium;

import easy.ListNode;

import java.util.Stack;

/*You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.*/
public class Solution2487 {

    //monotonic approach
    //this approach is to traverse the linked list and maintain a stack to store nodes in non-decreasing order of their values
    public ListNode removeNodes1(ListNode head){
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur!=null){
            while (!stack.isEmpty()&&stack.peek().val<cur.val){
                ListNode a = stack.pop();
            }
            stack.push(cur);
            cur = cur.next;
        }
        //Reverse the stack to obtain the modified linked list.
        ListNode nxt = null;
        while (!stack.isEmpty()){
            cur = stack.pop();
            cur.next = nxt;
            nxt = cur;
        }
        return cur;
    }


    //method2 recursive approach
    public ListNode removeNodes2(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode node = head;
        ListNode nxtGreater = removeNodes2(node.next);

        node.next = nxtGreater;
        if (nxtGreater == null || node.val>= nxtGreater.val){
            return node;
        }
        return nxtGreater;

    }

    //method3 reverse and filter approach
    public ListNode removeNodes3(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode tempPrev = dummyHead;
        curr = prev;

        while (curr!=null){
            if (curr.val>= tempPrev.val){
                tempPrev.next = curr;
                tempPrev = curr;
                curr = curr.next;
                tempPrev.next = null;
            }else {
                curr = curr.next;
            }
        }

        ListNode newPrev = null;
        ListNode newCurr = dummyHead.next;
        while (newCurr!=null){
            ListNode next = newCurr.next;
            newCurr.next = newPrev;
            newPrev = newCurr;
            newCurr = next;
        }
        return newPrev;
    }

    //following is the first edition code
    public ListNode removeNodes(ListNode head) {
        ListNode pointer = head;
        int count = 0;
        int deleteCount = 0;
        int maxNumber = 0;
        int location = 0;
        while (head.next!=null){
            head = head.next;
            if (head.val>maxNumber){
                maxNumber = head.val;
                location = count;
            }
            count++;
        }
        head = pointer;
        boolean flag = true;
        while (head.next!=null){
            deleteCount++;
            if (head.val<maxNumber&&deleteCount<location){
                head.val = head.next.val;
                head.next=head.next.next;
                continue;
            }
            if (head.val<head.next.val){
                head.val = head.next.val;
                head.next=head.next.next;
                if (deleteCount>Math.sqrt(count) || count<100 || deleteCount > Math.log10( count)){
                    head = pointer;
                }
            }else {
                head = head.next;
                if (flag && deleteCount==count){
                    head = pointer;
                    flag = false;
                }
                continue;
            }
        }
        return pointer;
    }
}
