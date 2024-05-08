# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

from medium.ListNode import ListNode


class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        head1= ListNode(0)
        head1.next = head

        left = head1
        right = head

        while right!=None:
            if  (right.val*2)>=10:
                left.val +=1
            right.val = (right.val*2)%10
            left = left.next
            right = right.next
        return head1 if head1.val>0 else head