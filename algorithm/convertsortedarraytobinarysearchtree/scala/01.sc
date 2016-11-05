/*

/////////////////////////////////////////////////////////////
http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/

=================================================
What is the definition of a balanced tree?
=================================================

A binary tree is balanced if for each node it holds that the number of inner nodes in the left subtree and the number
of inner nodes in the right subtree differ by at most 1.

A binary tree is balanced if for any two leaves the difference of the depth is at most 1.


Sorted Array to Balanced BST
Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.

Examples:

Input:  Array {1, 2, 3}
Output: A Balanced BST
     2
   /  \
  1    3

Input: Array {1, 2, 3, 4}
Output: A Balanced BST
      3
    /  \
   2    4
 /
1


We strongly recommend that you click here and practice it, before moving on to the solution.


Algorithm
In the previous post, we discussed construction of BST from sorted Linked List. Constructing from sorted array in
 O(n) time is simpler as we can get the middle element in O(1) time. Following is a simple algorithm where we first
 find the middle node of list and make it root of the tree to be constructed.

1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.
Following is the implementation of the above algorithm. The main code which creates Balanced BST is highlighted.

 */
case class TreeNode(v: Int, var left: TreeNode = null, var right: TreeNode = null)
def dfs(A: Array[Int], l: Int, r: Int): TreeNode = {
  if (l > r) return null

  //////
  val mid = (l + r) / 2
  val root = TreeNode(A(mid))
  root.left = dfs(A, l, mid - 1)
  root.right = dfs(A, mid + 1, r)

  root

}
def preOrder(root: TreeNode): Unit = {
  if (root == null) return

  print(root.v+" ->");

  preOrder(root.left)
  preOrder(root.right)

}
def inOrder(root :TreeNode) {
  if(root !=  null) {
    inOrder(root.left);
    //Visit the node by Printing the node data
    print(root.v+" ->");
    inOrder(root.right);
  }
}
solution(Array(1, 2, 3, 4, 5, 6, 7))
def solution(A: Array[Int]) = {
  val sorted = A.sorted
  val n = sorted.length
  val result = dfs(sorted, 0, n - 1)
  //inOrder(result)//1 ->2 ->3 ->4 ->5 ->6 ->7
  preOrder(result)//4 ->2 ->1 ->3 ->6 ->5 ->7

}


/*
              4
            /    \
           2      6
          / \    /  \
         1   3   5   7
 */
