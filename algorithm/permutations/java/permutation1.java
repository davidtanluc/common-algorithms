package knaidu;

/**
 * Created by davidtan on 10/23/16.
 */
public class permutation1 {

    public void permutations(String s) {
        permutations(s.toCharArray(), 0);
    }

    private void permutations(char[] C, int idx) {
        if (idx == C.length) {
            System.out.println(new String(C));
        } else {
            for (int i = idx; i < C.length; i++) {
                swap(C, idx, i); // swap
                permutations(C, idx + 1);
                swap(C, idx, i); // put back
            }
        }
        System.out.print(C + " ");
        System.out.println();
    }

    private void swap(char[] C, int a, int b) {
        char tmp = C[a];
        C[a] = C[b];
        C[b] = tmp;
    }

    public static void main(String[] args) {
        permutation1 solution = new permutation1();
        String s = "hello";
        solution.permutations(s);
    }
}
