package yeonsup.java.leetcode;

import java.util.ArrayList;

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
class Solution3 {
    public ListNode swapPairs(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 1) {
               ListNode temp = list.get(i - 1);
               list.set(i - 1, list.get(i));
               list.set(i, temp);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                head = list.get(i);
                head.next = list.get(i + 1);
                cur = head.next;
            } else if (list.size() - 1 == i) {
                cur.next = null;
            } else {
                cur.next = list.get(i + 1);
                cur = cur.next;
            }
        }

        return head;
    }
}

public class SwapNodesInPairs {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head = new ListNode(1);

        head = new Solution3().swapPairs(head);
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
