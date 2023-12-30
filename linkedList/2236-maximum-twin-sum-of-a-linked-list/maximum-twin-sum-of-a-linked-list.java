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
    public int pairSum(ListNode head) {
        // ListNode temp = head;
        // Stack<Integer> stk = new Stack<>();
        // while(temp != null){
        //     stk.push(temp.val);
        //     temp = temp.next;
        // }

        // int maxPair = Integer.MIN_VALUE;
        // int stkSize = stk.size();
        // temp = head;
        // for(int i = 0; i < stkSize / 2; i++){
        //     int sum = temp.val + stk.pop();
        //     maxPair = Math.max(maxPair, sum);
        //     temp = temp.next;
        // } 
        // return maxPair;

        // int[] arr = new int[100000];
        // ArrayList<Integer> al = new ArrayList<>();

        // while(head!=null){
        //     al.add(head.val);
        //     head = head.next;
        // }
        // //initialize the maxSum and traverse half through the array
        // int maxSum = 0;
        // int index = al.size();
        // for(int i=0;i<index/2;i++){
        //     //calculate twin sum
        //     int twinSum = al.get(i)+al.get(index-1-i);

        //     //update the max Sum
        //     maxSum = Math.max(maxSum, twinSum);
        // }
        // return maxSum;


         // Find the midpoint of the linked list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        ListNode mid = slow;

        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode next = null;
        while (mid != null) {
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        // Find the maximum twin sum
        int maxTwinSum = Integer.MIN_VALUE;
        ListNode current1 = head;
        ListNode current2 = prev;

        while (current2 != null) {
            int twinSum = current1.val + current2.val;
            maxTwinSum = Math.max(maxTwinSum, twinSum);
            current1 = current1.next;
            current2 = current2.next;
        }

        return maxTwinSum;
    }
}