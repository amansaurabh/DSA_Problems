/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode curr = head.next;
        curr = removeNodes(curr);

        while (curr != null && temp.val < curr.val) {
        temp = curr;
        curr = curr.next;
        }
        head.next = curr;
        return temp;
    }
}