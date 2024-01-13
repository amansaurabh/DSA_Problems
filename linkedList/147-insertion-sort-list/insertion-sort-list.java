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
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head.next;
        ListNode temp = head;

        while(curr != null){
            while(temp != curr){
                if(temp.val > curr.val){
                    //swap
                    int temp1 = temp.val;
                    temp.val = curr.val;
                    curr.val = temp1;
                }
                temp = temp.next;
            }
            temp = head;
            curr = curr.next;
        }
        return head;
    }
}