package anagram2;

import java.util.Arrays;

/**
 * Created by davidtan on 11/6/16.
 */
public class Solution3 {

    public boolean findAnagram(String A, String B) {
        int n = A.length();
        int m = B.length();

        return m == n && Arrays.equals(returnAnagram(A), returnAnagram(B));

    }

    public int[] returnAnagram(String A) {
        int n = A.length();

        int[] A1 = new int[26];

        for (int i = 0; i < n; i++) A1[A.charAt(i) - 'a']++;

        return A1;
    }

    public void printArray(int[] A) {
        for (int el : A) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        String A = "eat";
        String B = "ate";
        String C = "ati";
//        sol.printArray(sol.returnAnagram(A));
//        sol.printArray(sol.returnAnagram(B));
        System.out.println(sol.findAnagram(A, B)); //true
        System.out.println(sol.findAnagram(A, C)); //false


    }


}
