/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var removeNodes = function(head) {
    //use stack to solve this problem
    var stack = []
    var cur = head
    while (cur!=null){
        while((stack.length!==0)&&stack[stack.length-1].val<cur.val){
            stack.pop()
        }
        stack.push(cur)
        cur = cur.next;
    }
    var nxt = null;
    while(stack.length!==0){
        cur =  stack.pop();
        cur.next = nxt;
        nxt = cur;
    }
    return cur;

};