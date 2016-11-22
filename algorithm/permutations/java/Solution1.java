package permutations1;

import java.util.Arrays;

/**
 * Created by davidtan on 11/19/16.
 */
public class Solution1 {

    public void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }

    public void permutations(int[] A, int previous) {
        int n = A.length;
        if (previous == n) {
            System.out.println(Arrays.toString(A));
        } else {
            for (int current = previous; current < n; current++) {
                swap(A, previous, current);
                permutations(A, previous + 1);
                swap(A, previous, current);
            }

        }
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int[] A = {1, 2, 3};
        sol.permutations(A, 0);
        /*
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]
         */
    }
}
