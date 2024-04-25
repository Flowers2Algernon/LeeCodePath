package easy;

import java.util.ArrayList;

/*Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]*/
public class Solution206 {
    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode listNode = new ListNode();
        listNode.val = 1;
        ListNode listNode1 = new ListNode();
        listNode1.val =2;
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode();
        listNode2.val = 3;
        listNode1.next = listNode2;
        System.out.println(solution206.reverseNode(listNode));
    }
    public ListNode reverseList(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (head!=null){
            integers.add(head.val);
            head = head.next;
        }
        int length = integers.size();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        listNode1.next = listNode2;
        //此处要使用链表的尾插法
        while (length>0){
            ListNode listNode = new ListNode();
            listNode.val = integers.get(length-1);
            listNode2.next = listNode;
            listNode2 = listNode2.next;
            length = length-1;
        }
        return listNode1.next.next;
    }
    //以上是暴力解决
    //以下是方法1，迭代法
    public ListNode reverseNode(ListNode head){
        //单链表没有指向前一个节点的指针域，因此我们需要增加一个指向前一个节点的指针pre
        //pre用来存储每一个节点的前一个节点
        //还需要定义一个保存当前节点的指针cur
        //以及指向下一个节点的next
        //当当前节点的指针指向前一个节点
        //然后控制三个指针往后挪
       //三指针法的关键就是将当前节点的指针域指向前一个节点后，三个指针往后移动
        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode nextNode = null;
        while (currentNode!=null){
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }
}