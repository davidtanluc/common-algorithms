package trees1.binarytreetraversal1.postOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by davidtan on 11/13/16.
 */

    /*
      tmp peek
      if (both not null)
      pop
      result.add(pop.val)

      else
      if(tmp.right NOT Null)
       stack.push(tmp.right)
       tmp.right  = null //

       repeat for left
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

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> returnList = new ArrayList<>();
        if (root == null) return returnList;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {

            TreeNode top = stack.peek();

            if (top.right == null && top.left == null) {
                TreeNode pop = stack.pop();
                returnList.add(pop.val);

            } else {

                if (top.right != null) {
                    stack.push(top.right);
                    top.right = null;
                }
                if (top.left != null) {
                    stack.push(top.left);
                    top.left = null;
                }

            }

        }

        return returnList;
    }

    public void postOrderRecursive(TreeNode root) {
        if (root == null) return;

        postOrderRecursive(root.left);

        postOrderRecursive(root.right);

        resultRecursive.add(root.val);

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
        sol.printArrayList(sol.postorderTraversal(root1));//7 4 5 2 8 9 6 3 1

        //////
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.left.left = new TreeNode(7);

        root2.right.left = new TreeNode(6);
        root2.right.left.left = new TreeNode(8);
        root2.right.left.right = new TreeNode(9);
        sol.postOrderRecursive(root2);
        sol.printArrayList(sol.resultRecursive);//7 4 5 2 8 9 6 3 1


    }
}
