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

        int[] arr = new int[100000];
        int index = 0;
        while(head!=null){
            arr[index++] = head.val;
            head = head.next;
        }
        //initialize the maxSum and traverse half through the array
        int maxSum = 0;
        for(int i=0;i<index/2;i++){
            //calculate twin sum
            int twinSum = arr[i]+arr[index-1-i];

            //update the max Sum
            maxSum = Math.max(maxSum, twinSum);
        }
        return maxSum;
    }
}