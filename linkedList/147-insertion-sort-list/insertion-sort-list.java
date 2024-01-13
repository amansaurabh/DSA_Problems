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

        // ---------------- Brute force -----------------

        // ListNode curr = head.next;
        // ListNode temp = head;

        // while(curr != null){
        //     while(temp != curr){
        //         if(temp.val > curr.val){
        //             //swap
        //             int temp1 = temp.val;
        //             temp.val = curr.val;
        //             curr.val = temp1;
        //         }
        //         temp = temp.next;
        //     }
        //     temp = head;
        //     curr = curr.next;
        // }
        // return head;

        if(head == null || head.next == null){
            return head;
        }
        
        ListNode sorted = null;
        
        while(head != null){
            ListNode current = head;
            head = head.next;
            current.next = null;
            
            sorted = insertIntoSorted(sorted, current);
        }
        
        return sorted;
    }

    private static ListNode insertIntoSorted(ListNode sorted, ListNode node){
        if(sorted == null || node.val <= sorted.val){
            node.next = sorted;
            return node;
        }
        
        ListNode current = sorted;
        while(current.next != null && current.next.val < node.val){
            current = current.next;
        }
        
        node.next = current.next;
        current.next = node;
        
        return sorted;
    }
}