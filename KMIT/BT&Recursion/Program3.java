import java.util.*;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode p1 = head, p2 = prev;
        while (p2 != null) {
            ListNode next1 = p1.next, next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }

        return head;
    }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        Solution sol = new Solution();
        ListNode newHead = sol.reorderList(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }
}