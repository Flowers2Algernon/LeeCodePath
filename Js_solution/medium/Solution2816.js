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
var doubleIt = function(head) {
    let head1 = new ListNode(0);
    head1.next = head

    let left = head1
    let right = head
    while (right) {
        if (right.val*2>=10){
            left.val =left.val+ 1;
        }
        right.val = (right.val*2)%10;
        left=left.next;
        right=right.next;
    }
    return head1.val>0?head1:head;
};