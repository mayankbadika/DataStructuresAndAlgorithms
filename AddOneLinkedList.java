package myclass;

import java.util.Stack;

public class AddOneLinkedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(9);
        root.next.next = new ListNode(9);
        root.next.next.next = new ListNode(9);

        /*addOne(root);
        printList(root);  // Should print: 2 → 0 → 0 → 0

        addOne(root);
        printList(root);  // Should print: 2 → 0 → 0 → 1
        */

        printList(root);
        addOneItr(root);
        printList(root);

        addOneItr(root);
        printList(root);

    }

    public static void addOneUsingStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;

        //add all elements to stack
        while(curr != null) {
            stack.add(curr);
            curr = curr.next;
        }

        // Add one
        int carry = 1;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();

            int val = node.val + carry;
            if(val > 9) {
                carry = val / 10;
                node.val = val % 10;
            } else {
                node.val = val;
                carry = 0;
            }
        }

        //add a new node
        if (carry > 0) {
           ListNode newNode = new ListNode(carry);
           newNode.next = head;
           head = newNode;
        }
    }

    public static void printList(ListNode node) {
        System.out.print(node.val);
        node = node.next;

        while(node != null) {
            System.out.print(" -> ");
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void addOneItr(ListNode head) {
        head  = reverseLinkedList(head);
        ListNode curr = head;

        // Add one
        int carry = 1;
        while(curr != null) {
            int val = curr.val + carry;
            carry = 0;
            if (val > 9) {
                curr.val = val % 10;
                carry = val / 10;
            } else {
                curr.val = val;
            }

            if(curr.next == null && carry !=0) {
                ListNode newNode = new ListNode(carry);
                curr.next = newNode;
            }

            curr = curr.next;
        }

        head  = reverseLinkedList(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
