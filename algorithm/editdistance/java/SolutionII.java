package editDistance;

/**
 * Created by davidtan on 11/22/16.
 * An alignment of total cost 3:
 * s h o r t −
 * − p o r t s
 * Sample 3.
 */
public class SolutionII {

    public int editDistance(String left, String right) {
        int ln = left.length();
        int rn = right.length();
        int[][] dp = new int[ln + 1][rn + 1];

        for (int l = 0; l <= ln; l++) dp[l][0] = l;
        for (int r = 0; r <= rn; r++) dp[0][r] = r;

        for (int l = 0; l < ln; l++) {
            char cl = left.charAt(l);
            for (int r = 0; r < rn; r++) {
                char cr = right.charAt(r);
                if (cr == cl) {
                    dp[l + 1][r + 1] = dp[l][r];
                } else {
                    int replace = dp[l][r] + 1;
                    int insert = dp[l][r + 1] + 1;
                    int delete = dp[l + 1][r] + 1;

                    int min1 = Math.min(replace, insert);
                    min1 = Math.min(min1, delete);

                    dp[l + 1][r + 1] = min1;

                }

            }

        }

        return dp[ln][ln];
    }

    public static void main(String[] args) {
        SolutionII sol1 = new SolutionII();
        String left = "short";
        String right = "ports";
        System.out.println(sol1.editDistance(left, right));
    }
}
