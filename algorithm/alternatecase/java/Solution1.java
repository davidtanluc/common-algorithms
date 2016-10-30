package alternatecase;

import static java.lang.Character.*;
import static java.lang.Character.toUpperCase;

/**
 * Created by davidtan on 10/27/16.
 */
public class Solution1 {

    public static String toAlternativeStrin4(String string) {
        // your code here!
        return new String(string.chars().map(c -> isUpperCase(c) ? toLowerCase(c) : toUpperCase(c)).toString());
    }

    public static String toAlternativeString(String string) {
        // your code here!
        return string.chars()
                .map(c -> isUpperCase(c) ? toLowerCase(c) : toUpperCase(c))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    ////////////////////////////////////////////////////////////////
    public static String toAlternativeString3(String string) {
        // your code here!
        return string.chars()
                .map(c -> isUpperCase(c) ? toLowerCase(c) : isLowerCase(c) ? toUpperCase(c) : c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String toAlternativeString2(String string) {
        // your code here!
        int n = string.length();
        String upper = string.toUpperCase();
        String lower = string.toLowerCase();

        String result = "";
        for (int i = 0; i < n; i++) {
            result += (Character.isLowerCase(string.charAt(i))) ? upper.charAt(i) : lower.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        System.out.println("Hello");
        System.out.println(sol.toAlternativeString("HesAsdd"));

    }
}
