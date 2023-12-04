/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        //------- Using HashTable-------------

        // HashSet <ListNode> hashTable = new HashSet<>();

        // while(head != null){
        //     if(hashTable.contains(head)) return true;
        //     hashTable.add(head);
        //     head = head.next;
        // }
        // return false;

        //---------Using slow and fast pointer----------

        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
            
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}