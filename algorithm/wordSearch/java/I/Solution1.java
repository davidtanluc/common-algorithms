package wordSearchI;

/**
 * Created by davidtan on 11/14/16.
 * LeetCode – Word Search (Java)
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * For example, given board =
 * <p>
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Solution1 {
    private String word;

    public boolean exist(char[][] board, String word) {
        int h = board.length; // height
        int w = board[0].length; // height
        boolean result = false;

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (dfs(board, word, row, col, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }


    public boolean dfs(char[][] board, String word, int row, int col, int next) {
        // limits
        int h = board.length; // height
        int w = board[0].length; // height
        if (row < 0 || col < 0 || col > w - 1 || row > h - 1) return false;

        //////
        if (board[row][col] == word.charAt(next)) { //found
            char tmp = board[row][col];
            board[row][col] = '#';  //visited

            if (next == word.length() - 1) {
                return true;

            } else {
                if (dfs(board, word, row - 1, col, next + 1) || //down
                        dfs(board, word, row + 1, col, next + 1) || //up
                        dfs(board, word, row, col - 1, next + 1) || // left
                        dfs(board, word, row, col + 1, next + 1)) {  //right
                    return true;
                }

            }

            board[row][col] = tmp;
        }


        return false;

    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Solution1 sol = new Solution1();
        System.out.println(sol.exist(board, "ABCCED"));//true
        System.out.println(sol.exist(board, "SEE"));//true
        System.out.println(sol.exist(board, "ABCB"));//false

    }
}
