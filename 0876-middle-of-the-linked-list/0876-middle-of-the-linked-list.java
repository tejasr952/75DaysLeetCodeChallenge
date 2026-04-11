
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}