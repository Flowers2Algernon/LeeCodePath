# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional

from medium import ListNode


class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
         # here we use stack to solve this question
         stack = []
         cur = head
         while cur!=None:
             while stack and stack[-1].val<cur.val:
                 stack.pop()
             stack.append(cur)
             cur = cur.next
         nxt = None
         while stack:
             cur = stack.pop()
             cur.next = nxt
             nxt = cur
         return cur
