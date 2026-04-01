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
        ListNode reverse = null;

        while (head != null) {
            ListNode saveRemainder = head.next; // save off everything after head
            head.next = reverse; // attach the current head to the reversed list
            reverse = head; // move the pointer for reverse to the new head we've just attached
            head = saveRemainder; // reset head to point to the saved remainder. 
        }

        return reverse;
    }
}
