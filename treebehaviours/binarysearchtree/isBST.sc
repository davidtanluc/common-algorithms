case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

def prn(x: TraversableOnce[_]) = println(x.mkString(x.getClass.getSimpleName + "(", ", ", ")"))

def ValidBST(root: TreeNode, min: Int, max: Int): Boolean = {
  if (root == null) return true
  if (root.value <= min || root.value >= max) return false

  ValidBST(root.left, min, root.value) && ValidBST(root.right, root.value, max)

}
def isValidBST(root: TreeNode): Boolean = {
  ValidBST(root, -2147483648, 2147483647)

}

var top = TreeNode(10, TreeNode(5), TreeNode(15))// true balance
var top2 = TreeNode(10, TreeNode(5), TreeNode(15, TreeNode(11), TreeNode(20)))  // not balance
var top3 = TreeNode(10, TreeNode(5,TreeNode(9)), TreeNode(15, TreeNode(18),TreeNode(11)))  // not balance
/*
(top)
   10
   / \
  5  15 (BST)
      (top2)
            10
            /  \
           5   15
              /  \
              18  20
   Not BST
   (top3)
   10 (BST)
   / \
  5  15
  /    \
 9     18
 */
println(top)
/*
       TreeNode(10,
       TreeNode(5,null,null),TreeNode(15,TreeNode(18,null,null),TreeNode(20,null,null)))


 */
println(isValidBST(top)) //true
println(isValidBST(top2))
println(isValidBST(top3))
/*
Question:
Given a binary tree, determine if it is a valid Binary Search Tree (BST)
First, you must understand the difference between Binary Tree and BST. Binary tree is a
tree data structure in which each node has at most two child nodes. A BST is based on
binary tree, but with the following additional properties:
- The left subtree of a node contains only nodes with keys less than the node’s key.
- The right subtree of a node contains only nodes with keys greater than the node’s
key.
- Both the left and right subtrees must also be binary search trees


TreeNode top = new TreeNode(10);
        top.left = new TreeNode(5);
        top.right = new TreeNode(15);
        top.right.left = new TreeNode(18);
        top.right.right = new TreeNode(20);

        */