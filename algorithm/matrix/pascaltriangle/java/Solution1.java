package pascaltriangleI;

import java.util.ArrayList;

/**
 * Created by davidtan on 11/4/16.
 */
public class Solution1 {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (numRows <= 0) return result;

        ArrayList<Integer> pre = new ArrayList<>();

        pre.add(1);

        result.add(pre);

        for (int i = 2; i <= numRows; i++) {

            ArrayList<Integer> cur = new ArrayList<>();

            cur.add(1); //first

            for (int j = 0; j < pre.size() - 1; j++) {

                cur.add(pre.get(j) + pre.get(j + 1)); //middle

            }

            cur.add(1);//last

            result.add(cur);

            pre = cur;

        }

        return result;

    }
}
