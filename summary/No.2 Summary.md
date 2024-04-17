# No.2 Summary

Additional knowledge:
The simplest way to reverse an ArrayList is use below method:
```Java
ArrayList<Integer> list = new ArrayList(asList(1,2,3));
Collection.reverse(list);
```
Notice: this method will not make a new ArrayList, but reverse it in the original ArrayList.

need to solve:
1. more than 100 bit, how to add them and output them? -- the method I use is BigInteger

###### first solution：
The problem: time consume unacceptable
so, how to optimize?
```Java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = new String();
        String s2 = new String();
        while (l1 != null) {//transfer the node to string
            s1 = l1.val + s1;
            l1 = l1.next;
        }
        while (l2 != null) {//transfer the node to string
            s2 = l2.val + s2;
            l2 = l2.next;
        }
        //use BigInteger to add 
        BigInteger bigInteger1 = new BigInteger(s1);
        BigInteger bigInteger = new BigInteger(s2);
        BigInteger bigInteger2 = new BigInteger(bigInteger1.add(bigInteger).toString());
        ListNode listNode = new ListNode(0);
        //the zero situation
        if (bigInteger2.equals(BigInteger.ZERO)) {
            return listNode;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        //after add, need to transfer a ListNode
        while (bigInteger2.compareTo(BigInteger.ONE) >=0) {
            BigInteger[] bigIntegers = bigInteger2.divideAndRemainder(new BigInteger("10"));
            integers.add(bigIntegers[1].intValue());
            bigInteger2 = bigIntegers[0];
        }
        ListNode listNode2 = new ListNode(0);
        listNode.next = listNode2;
        //add the spare node to the ListNode
        for (Integer integer : integers) {
            ListNode listNode1 = new ListNode(integer);
            listNode2.next = listNode1;
            listNode2 = listNode2.next;
        }
        return listNode.next.next;
    }
```
---
###### second solution:
this solution add the individual element in l1 and l2, don't need to mind the big bit.
The only thing need to mind is the carry
``` Java 
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();//set a head node
        ListNode curr = dummy;
        int sum =0;
        int carry = 0;
        //add the bit seperately
        while (l1!=null || l2!=null){
             sum = carry;
            if (l1!=null){
                sum+=l1.val;
            }
            if (l2!=null){
                sum+=l2.val;
            }
            ListNode listNode = new ListNode(sum % 10);
            carry = sum/10;//use carry to store the carry
            curr.next = listNode;
            curr = curr.next;
            if (l1!=null){//move the node
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        if (carry>0){//there is a carry add it to the ListNode
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    } 

```