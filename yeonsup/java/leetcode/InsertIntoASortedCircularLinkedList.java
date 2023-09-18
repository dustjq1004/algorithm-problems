package yeonsup.java.leetcode;

// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};


class Solution {
    public Node insert(Node head, int insertVal) {

        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node currentNode = head;

        while (head != currentNode.next) {
            if((insertVal >= currentNode.val && insertVal < currentNode.next.val)
                || (insertVal >= currentNode.val && currentNode.val > currentNode.next.val)
                    || (currentNode.next.val < currentNode.val && insertVal <= currentNode.next.val)
            ) break;
            currentNode = currentNode.next;
        }

        System.out.println(currentNode.val);

        Node newNode = new Node(insertVal);
        Node next = currentNode.next;
        currentNode.next = newNode;
        newNode.next = next;

        return head;
    }
}
public class InsertIntoASortedCircularLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

//        new Solution().insert(node1, 2);

//        new Solution().insert(null, 1);

        Node node4 = new Node(1);
        node4.next = node4;
//        new Solution().insert(node4, 0);


        Node node5 = new Node(3);
        Node node6 = new Node(5);
        Node node7 = new Node(1);
        node5.next = node6;
        node6.next = node7;
        node7.next = node5;
        new Solution().insert(node5, 0);
    }



}
