case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

val NodeAll = TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(7)), TreeNode(5)),
  TreeNode(3, TreeNode(6, TreeNode(8), TreeNode(9))))

/*

                              1
                          /      \
                         2        3
                      /   \     /   \
                     4    5    6
                     /         / \
                    7         8   9
 */
val f1 = List(NodeAll)
//f1: List[TreeNode] =
// List(TreeNode(1,
// TreeNode(2,TreeNode(4,TreeNode(7,null,null),null),TreeNode(5,null,null)),
// TreeNode(3,TreeNode(6,TreeNode(8,null,null),TreeNode(9,null,null)),null)))
def DFSPreOrder(root: TreeNode) { //recursive
  if (root == null) return
  println(root.value, " \n ") //pre order
  DFSPreOrder(root.left)
  DFSPreOrder(root.right)
}
//DFSPreOrder(NodeAll)
/*
(1,
 )
(2,
 )
(4,
 )
(7,
 )
(5,
 )
(3,
 )
(6,
 )
(8,
 )
(9,
 )
 */
def DFSInOrder(root: TreeNode) {
  if (root == null) return
  DFSInOrder(root.left)
  println(root.value, " \n ") //in order
  DFSInOrder(root.right)
}
//DFSInOrder(NodeAll)
/*
(7,
 )
(4,
 )
(2,
 )
(5,
 )
(1,
 )
(8,
 )
(6,
 )
(9,
 )
(3,
 )
 */
def DFSPostOrder(root: TreeNode) {
  if (root == null) return
  DFSPostOrder(root.left)
  DFSPostOrder(root.right)
  println(root.value, " \n ") //post order

}
DFSPostOrder(NodeAll)
/*
(7,
 )
(4,
 )
(5,
 )
(2,
 )
(8,
 )
(9,
 )
(6,
 )
(3,
 )
(1,
 )
 */