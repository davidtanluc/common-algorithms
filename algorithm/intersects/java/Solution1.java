
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by davidtan on 10/7/16.
 */
public class Solution1 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                list.add(nums1[p1]);
                p1++;
                p2++;

            }
        }

        //// translate to array ///////
        int[] result = new int[list.size()];
        int i = 0;
        while (i < list.size()) {
            result[i] = list.get(i);
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution1 sol = new Solution1(); // has to be sorted
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] c = {4, 6, 6, 7, 8, 8, 9};
        int[] d = {1, 2, 3, 4, 5, 6, 7, 10, 11};
        System.out.println("Intersects " + Arrays.toString(sol.intersect(a, b)));
        System.out.println("Intersects " + Arrays.toString(sol.intersect(c, d)));//
        /*
        Intersects [2, 2]
Intersects [4, 6, 7]
         */
    }

}
