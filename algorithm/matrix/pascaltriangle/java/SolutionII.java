package pascaltriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidtan on 11/4/16.
 * 119. Pascal's Triangle II
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class SolutionII {

    public List<Integer> getRow(int rowIndex) {

        ArrayList<Integer> result = new ArrayList<>();

        if (rowIndex < 0) return result;

        result.add(1);

        for (int row = 1; row <= rowIndex; row++) {

            for (int col = result.size() - 2; col >= 0; col--) {

                result.set(col + 1, result.get(col) + result.get(col + 1));

            }

            result.add(1);

        }

        return result;

    }
    public static void main(String[] args){
        SolutionII sol = new SolutionII();
        System.out.println(sol.getRow(3));//[1, 3, 3, 1]
    }
}
