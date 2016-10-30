package anagram;

/**
 * Created by davidtan on 10/30/16.
 */
public class Solution2 {

    public boolean isAnagram(String s, String t){//ate ,eat
        int n = s.length();
        int nt = t.length();
        if(n != nt)return false;
        int[] test1 = new int[26]; // 26 characters.

        for(int i=0;i<n;i++){
            test1[s.charAt(i) - 'a']++;
            test1[t.charAt(i) - 'a']--;
        }
        for(int el:test1){
            if(el !=0)return false;
        }
        return true;
    }
    public static void main(String[] args){
        Solution2 sol = new Solution2();
        String s = "eat";
        String t = "ate";

        System.out.println(sol.isAnagram(s,t)); //true

        s = "ati";
        t = "ate";
        System.out.println(sol.isAnagram(s,t)); //false
    }
}
