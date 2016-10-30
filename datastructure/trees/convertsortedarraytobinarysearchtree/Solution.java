package convertsortedarraytobinarysearchtree;

/**
 * Created by davidtan on 10/29/16.
 */
class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) {

        val = x;

    }

}
public class Solution {

    public TreeNode sortedArrayToBST(int[] num) {

        if (num.length == 0)

            return null;

        return sortedArrayToBST(num, 0, num.length - 1);

    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {

        if (start > end)

            return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(num[mid]);

        root.left = sortedArrayToBST(num, start, mid - 1);

        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }

    public void inOrder(TreeNode root) {
        if(root !=  null) {
            inOrder(root.left);
            //Visit the node by Printing the node data
            System.out.printf("%d ",root.val);
            inOrder(root.right);
        }
    }


    public static void main(String[] args){

        Solution sol = new Solution();
        int[] A = {1,2,3,4,5};
        TreeNode root = sol.sortedArrayToBST(A);
        sol.inOrder(root);//1 2 3 4 5
    }
}
