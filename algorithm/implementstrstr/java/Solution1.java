package implementstrstr1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by davidtan on 10/27/16.
 */
public class Solution1 {

    public String findNeedle(Object[] haystack) {
        return "found the needle at position " + Arrays.asList(haystack).indexOf("needle");
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    private int loop(int i, String p, String t) {
        int pN = p.length();

        if (pN == 1) return i; // found if pattern size is one.

        int pK = 1;  // second char of pattern
        int tK = i + 1;

        while (tK < i + pN) { // until the size of pattern  m -1 ~~ log(m)

            if (p.charAt(pK) != t.charAt(tK)) return -1;

            pK += 1;
            tK += 1;
        }

        return i; //true
    }

    public int strStrLoop(String text, String pattern) {
        int nT = text.length();
        int nP = pattern.length();


        for (int i = 0; i <= nT - nP; i++) {
            if (text.charAt(i) == pattern.charAt(0)) {// compare head
                if (loop(i, pattern, text) != -1) {
                    return i;
                }
            }


        }
        return -1;

    }

    public static void main(String[] args) {
        Object[] haystack = {"hello", 1, 3, "needle", new ArrayList<>()};
        Object[] haystack2 = {"hello", 1, 3, "eedle", new ArrayList<>()};
        Solution1 sol = new Solution1();
        System.out.println(sol.findNeedle(haystack));//found the needle at position 3
        System.out.println(sol.findNeedle(haystack2));//found the needle at position -1
        /////////////////str str
        System.out.println(sol.strStr("abbraa", "br"));//2
        System.out.println(sol.strStrLoop("abbraa", "br"));//2
        System.out.println(sol.strStr("abbraa", "rii"));//-1
        System.out.println(sol.strStrLoop("abbraa", "rii"));//-1


    }
}
