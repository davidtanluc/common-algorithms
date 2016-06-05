case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

val NodeAll = TreeNode(1, TreeNode(2, TreeNode(4, TreeNode(7)), TreeNode(5)),
  TreeNode(3, TreeNode(6, TreeNode(8), TreeNode(9))))
val f1 = List(NodeAll)

def DFSPreOrder(root: TreeNode) { //recursive
  if (root == null) return
  println(root.value, " \n ") //pre order
  DFSPreOrder(root.left)
  DFSPreOrder(root.right)
}
def DFSInOrder(root: TreeNode) {
  if (root == null) return
  DFSInOrder(root.left)
  println(root.value, " \n ") //in order
  DFSInOrder(root.right)
}
def DFSPostOrder(root: TreeNode) {
  if (root == null) return
  DFSPostOrder(root.left)
  DFSPostOrder(root.right)
  println(root.value, " \n ") //post order

}