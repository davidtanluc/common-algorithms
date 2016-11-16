package trees1.binarytreetraversal1.levelorder1;

import java.util.*;

/**
 * Created by davidtan on 11/14/16.
 */
/*
/*
Use those traversals to output the following tree:

         1
        / \
       /   \
      /     \
     2       3
    / \     /
   4   5   6
  /       / \
 7       8   9

preorder:    1 2 4 7 5 3 6 8 9
inorder:     7 4 2 5 1 8 6 9 3
postorder:   7 4 5 2 8 9 6 3 1
level-order: 1 2 3 4 5 6 7 8 9
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution1 {
    /*
    queue
    while not empty
    deque
    if(left not null enqueue
    repeat right
     */
    public List<Integer> levelOrder(TreeNode root){

        List<Integer> result = new ArrayList<>();
        if(root==null)return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            TreeNode fifo = q.poll();
            result.add(fifo.val);

            if(fifo.left != null){
                q.add(fifo.left);
            }
            if(fifo.right != null){
                q.add(fifo.right);
            }

        }
        return result;
    }
    public void printArrayList(ArrayList<Integer> A) {
        for (Integer el : A) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public void printArrayList(List<Integer> A) {
        for (Integer el : A) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);

        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        Solution1 sol = new Solution1();
        TreeNode root1 = root;
        sol.printArrayList(sol.levelOrder(root1));//1 2 3 4 5 6 7 8 9


    }

}
