package yeonsup.java.leetcode;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class DeleteNodesAfterNodeofaLinkedList {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        int i = 1;
        while(cur.next != null) {
            int num = i % (m + n) + 1;
            System.out.println(num);
            if(num <= m) {
                cur = cur.next;
            } else if (num <= n + m) {
                cur.next = cur.next.next;
            }

            i++;
        }

        return head;
    }
}
