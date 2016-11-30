package uniquepath.I;

/**
 * Created by davidtan on 11/30/16.
 */
public class Solution {

    public int uniquePath(int m, int n) {
        if (m == 0 && n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];

        //first col
        for (int row = 0; row < m; row++) dp[row][0] = 1
        //first row
        for (int col = 0; col < n; col++) dp[0][col] = 1;

        for (int row = 1; row < m; row++) for (int col = 1; col < n; col++)
            dp[row][col] = dp[row - 1][col] + dp[row][col - 1];


        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution sol1 = new Solution();
        System.out.print(sol1.uniquePath(3, 3));//6
    }
}
