class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            // Find the kth node
            ListNode kth = prevGroup;
            for (int i = 0; i < k && kth != null; i++)
                kth = kth.next;

            // Fewer than k nodes left
            if (kth == null) break;

            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;

            // Reverse k nodes
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect reversed group
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }

        return dummy.next;
    }
}