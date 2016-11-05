package linkedlist1.reverseLinkedList1;

import linkedlist1.ListNode;

/**
 * Created by davidtan on 10/28/16.
 */
public class revll1 {

    //// using recursive ////
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //get second node
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;

        ListNode rest = reverseList(second);
        second.next = head;

        return rest;
    }

    public ListNode revll(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode second = head.next;

        head.next = null; //resets


        ListNode rest = revll(second);

        //System.out.println(rest.data);
        /// 3 3

        second.next = head;

       // System.out.println(second.data + "head " + head.data);
        /*
3head 2
2head 1
         */


        return rest;
    }

    public ListNode reverseListIter(ListNode head) {

        if (head == null || head.next == null)

            return head;

        ListNode p1 = head;

        ListNode p2 = p1.next;

        head.next = null; // remove one

        while (p1 != null && p2 != null) {

            ListNode t = p2.next; // temp swap

            p2.next = p1;

            p1 = p2;

            p2 = t;

        }

        return p1;
    }

    public void printLinkedList(ListNode ll) {
        ListNode tmp = ll;

        while (tmp != null) {
            System.out.print(tmp.data + "-> ");
            tmp = tmp.next;
        }
        System.out.print("");

    }

    public static void main(String[] args) {

        revll1 solution = new revll1();
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        //solution.printLinkedList(input);
        ListNode output = solution.revll(input);
        System.out.println();
        System.out.println();
        ListNode output2 = solution.reverseList(input);
        solution.printLinkedList(output);//3-> 2-> 1->
        //solution.printLinkedList(output2);


    }

}


