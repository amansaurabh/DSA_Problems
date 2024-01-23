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

        //--------------Recursion--------------------
        
        if(head == null){
            return null;
        }

        head.next = removeNodes(head.next);

        if(head.next != null && head.val < head.next.val){
            return head.next;
        }
        return head;

        // ------------------------Approach 2: O(n)----------------------
        
    //     ListNode cur = head;
    //     List<ListNode> list = new ArrayList<>();
    //     while (cur != null) {
    //         list.add(cur);
    //         cur = cur.next;
    //     }
    //     int max = 0;
    //     int[] arr = new int[list.size()];
    //     //finding max from the end to include values into result
    //     for (int i = list.size() - 1; i >= 0; i--) {
    //         if (max <= list.get(i).val) {
    //             arr[i] = 1;
    //             max = list.get(i).val;
    //         }
    //     }
    //     boolean headSet = false;
    //     cur = head;
    //     //adding nodes to the result
    //     for (int i = 0; i < list.size(); i++) {
    //         if (arr[i] == 1) {
    //             if (!headSet) {
    //                 headSet = true;
    //                 head = list.get(i);
    //                 cur = head;
    //             } else {
    //                 cur.next = list.get(i);
    //                 cur = cur.next;
    //             }
    //         }
    //     }
    //     cur.next = null;
    //     return head;
    }
}