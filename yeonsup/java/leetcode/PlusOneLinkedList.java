package yeonsup.java.leetcode;


import java.util.LinkedList;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}

class Solution2 {
    public ListNode2 plusOne(ListNode2 head) {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode2 cur = head;

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        boolean plus = true;

        for (int i = list.size() - 1; i >= 0; i--) {
            Integer num = list.get(i);
            if (plus) {
                if (num == 9) {
                    list.set(i, 0);
                } else {
                    list.set(i, num + 1);
                    plus = false;
                }
            }
        }

        if (plus) list.offerFirst(1);

        cur = head;
        ListNode2 pre = null;
        while (!list.isEmpty()) {
            if(cur == null) {
                cur = new ListNode2();
                pre.next = cur;
            }
            cur.val = list.poll();
            pre = cur;
            cur = cur.next;
        }

        return head;
    }
}

public class PlusOneLinkedList {
    public static void main(String[] args) {
        ListNode2 listNode = new ListNode2(9, new ListNode2(8, new ListNode2(7,
            new ListNode2(6, new ListNode2(5, new ListNode2(4, new ListNode2(3, new ListNode2(2, new ListNode2(1, new ListNode2(0)))))))
        )));
        new Solution2().plusOne(listNode);

    }
}
