package linkedlist1;

/**
 * Created by davidtan on 10/28/16.
 */
public class ListNode {
    public int data;       // data stored in this node
    public ListNode next;  // link to next node in the list

    //https://courses.cs.washington.edu/courses/cse143/16wi/lectures/ListNode.java
    // post: constructs a node with given data and given link
    public ListNode(int data) {
        this.data = data;
        next = null;
    }

}
/* Definition for singly-linked list.
        * class ListNode {
    *     int val;
    *     ListNode next;
    *     ListNode(int x) {
        *         val = x;
        *         next = null;
        *     }
    * }
*/
