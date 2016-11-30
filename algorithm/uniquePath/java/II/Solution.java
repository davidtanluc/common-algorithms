package uniquepath.II;

/**
 * Created by davidtan on 11/30/16.
 */
public class Solution {

    public int Toggle(int target, int result) {
        return (target == 1) ? 0 : result;
    }

    public int uniquePath(int[][] Grid) {
        int m = Grid.length;
        int n = Grid[0].length;
        if (m == 0 && n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int start = Grid[0][0];
        int end = Grid[m - 1][n - 1];
        if (start == 1 || end == 1) return 0;
        int[][] dp = new int[m][n];
//first col
        for (int row = 0; row < m; row++) dp[row][0] = Toggle(Grid[row][0], 1);
//first row
        for (int col = 0; col < n; col++) dp[0][col] = Toggle(Grid[0][col], 1);

        for (int row = 1; row < m; row++)
            for (int col = 1; col < n; col++)
                dp[row][col] = Toggle(Grid[row][col], dp[row - 1][col] + dp[row][col - 1]);

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution sol1 = new Solution();
        int grid[][] = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.print(sol1.uniquePath(grid));//16, 28
    }
}
