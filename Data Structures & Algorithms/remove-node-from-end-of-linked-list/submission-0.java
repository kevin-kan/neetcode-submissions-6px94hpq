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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode saveHead = new ListNode(0,head);
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        ListNode removal = saveHead;
        while (end != null) {
            end = end.next;
            removal = removal.next;
        }
        removal.next = removal.next.next;

        return saveHead.next;
    }
}
