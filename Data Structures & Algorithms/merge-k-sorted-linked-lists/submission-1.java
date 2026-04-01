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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode list : lists) {
            while (list != null) {
                minHeap.offer(list);
                list = list.next;
            }
        }
        ListNode newHead = new ListNode();
        ListNode dummy = newHead;
        while (!minHeap.isEmpty()) {
            newHead.next = minHeap.poll();
            newHead = newHead.next;
        }

        return dummy.next;
    }
}
