package trees1.binarytreetraversal1.inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
    ArrayList<Integer> resultRecursive = new ArrayList<>();

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.empty() || p != null) {

            if (p != null) {
                stack.push(p);
                p = p.left;

            } else {
                TreeNode t = stack.pop();
                lst.add(t.val);
                p = t.right;
            }
        }
        return lst;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode top = stack.peek();

            if (top.left != null) {

                stack.push(top.left);
                top.left = null;

            } else {

                result.add(top.val);
                stack.pop(); // remove one

                if (top.right != null) {
                    stack.push(top.right);
                }
            }
        }
        //
        return result;
    }

    public void inOrderRecursive(TreeNode root) {
        if (root == null) return;

        inOrderRecursive(root.left);

        resultRecursive.add(root.val);

        inOrderRecursive(root.right);


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
        sol.printArrayList(sol.inorderTraversal(root));//7 4 2 5 1 8 6 9 3

        System.out.println(sol.inorderTraversal2(root));//[7, 4, 2, 5, 1, 8, 6, 9, 3]

        //////
        sol.inOrderRecursive(root);
        sol.printArrayList(sol.resultRecursive);//7 4 2 5 1 8 6 9 3


    }


}

