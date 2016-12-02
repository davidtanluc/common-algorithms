package minimumpathsum;

/**
 * Created by davidtan on 11/29/16.
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * https://leetcode.com/problems/minimum-path-sum/
 * Note: You can only move either down or right at any point in time.
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class SolutionII {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];


// initialize left column

        for (int row = 1; row < m; row++) dp[row][0] = dp[row - 1][0] + grid[row][0];


// initialize top row

        for (int col = 1; col < n; col++) dp[0][col] = dp[0][col - 1] + grid[0][col];

// fill up the dp table

        for (int row = 1; row < m; row++) for (int col = 1; col < n; col++)
                dp[row][col] += Math.min(dp[row][col - 1], dp[row - 1][col]) + grid[row][col];


        return dp[m - 1][n - 1];

    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        int cost[][] = {
                {1, 2, 3},
                {4, 1, 2},
                {1, 1, 3}};
        SolutionII sol = new SolutionII();

        System.out.println("minimum cost to reach ) = " + sol.minPathSum(cost));//8
    }
}
