class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(), c = d;
        int s, carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            s = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            c = c.next = new ListNode(s % 10);
            carry = s / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return d.next;
    }
}