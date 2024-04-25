package easy;

public class Solution21 {
    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        ListNode listNode2 = new ListNode();
        listNode2.val = 2;
        ListNode listNode3 = new ListNode();
        listNode3.val = 4;
        listNode1.next  =listNode2 ;
        listNode2.next  =listNode3 ;
        ListNode listNode11 = new ListNode();
        listNode11.val = 1;
        ListNode listNode22 = new ListNode();
        listNode22.val = 3;
        ListNode listNode33 = new ListNode();
        listNode33.val = 4;
        listNode11.next  =listNode22 ;
        listNode22.next  =listNode33 ;
        System.out.println(solution21.mergeTwoLists(listNode1, listNode11));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode();
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = resultNode;
        while (true) {
            if (list1.val <= list2.val) {
                //此时将list1的首节点赋给resultNode,并且将list1的节点往后移一位
                listNode1 = list1;
                list1 = list1.next;
                listNode1.next = null;
                while (resultNode.next!=null){
                    resultNode = resultNode.next;
                }
//                resultNode.next = listNode1.next;
                resultNode.next = listNode1;
            } else {
                listNode2 = list2;
                list2 = list2.next;
                listNode2.next = null;
                while (resultNode.next!=null){
                    resultNode = resultNode.next;
                }
                resultNode.next = listNode2;
//                resultNode.next = listNode2.next;
            }

            if (list1 == null || list2 == null) {
                break;
            }
        }
        if (list1 == null && list2 != null) {
            while (resultNode.next!=null){
                resultNode = resultNode.next;
            }
            resultNode.next = list2;
        }
        if (list2 == null && list1!= null) {
            while (resultNode.next!=null){
                resultNode = resultNode.next;
            }
            resultNode.next = list1;
        }
        return listNode3.next;
    }
}
