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
    public ListNode reverseList(ListNode head) {
        // ListNode temp = head;
        // ListNode prev = null;

        // if(head == null || head.next == null){
        //     return head;
        // }

        // while(temp != null){
        //     ListNode front = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = front;
        // }
        // return prev;


    //     ListNode prev_p = null;
    //     ListNode current_p = head;
    //     ListNode next_p;
       
    //    //step 2
    //     while(current_p != null) {

    //         next_p = current_p.next;
    //         current_p.next = prev_p;
            
    //         prev_p = current_p;
    //         current_p = next_p;
    //     }

    //     head = prev_p;
    //     return head;

        //----------- Using Recursion---------------

        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}