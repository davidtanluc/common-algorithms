package trees1.binarytreetraversal1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by davidtan on 11/6/16.
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

    public ArrayList<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> returnList = new ArrayList<>();
        if (root == null) return returnList;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {

            TreeNode n = stack.pop();
            returnList.add(n.val);

            if (n.right != null) {
                stack.push(n.right);
            }

            if (n.left != null) {
                stack.push(n.left);
            }
        }

        return returnList;
    }

    public void printArrayList(ArrayList<Integer> A) {
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

        sol.printArrayList(sol.preorderTraversal(root));//1 2 4 7 5 3 6 8 9


    }
}
/*
         1
        / \
       /   \
      /     \
     2       3
    / \     /
   4   5   6
  /       / \
 7       8   9
 */