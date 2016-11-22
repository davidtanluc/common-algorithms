package wordsearchII;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by davidtan on 11/14/16.
 */
public class SolutionII {

    Set<String> result = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {

//HashSet<String> result = new HashSet<String>();

        Trie trie = new Trie();
        for (String word : words) {

            trie.insert(word);

        }

        int m = board.length;

        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                dfs(board, visited, "", i, j, trie);

            }

        }

        return new ArrayList<String>(result);

    }

    public void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {

        int m = board.length;

        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {

            return;

        }

        if (visited[i][j])

            return;

        str = str + board[i][j];

        if (!trie.startsWith(str))

            return;

        if (trie.search(str)) {

            result.add(str);

        }

        visited[i][j] = true;

        dfs(board, visited, str, i - 1, j, trie);

        dfs(board, visited, str, i + 1, j, trie);

        dfs(board, visited, str, i, j - 1, trie);

        dfs(board, visited, str, i, j + 1, trie);

        visited[i][j] = false;

    }

    public static void main(String[] args) {
        SolutionII ss = new SolutionII();

        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] strstr = new String[]{"oath", "pea", "eat", "rain"};

        List<String> kk = ss.findWords(board, strstr);
        System.out.println("#Result " + kk);//#Result [oath, eat]

        char[][] board2 = new char[][]{
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 'c'},
                {'a', 'd', 'e', 'e'}
        };
        String[] strstr2 = new String[]{"abcced", "see", "abcb", "rain"};
        List<String> kk2 = ss.findWords(board2, strstr2);
        System.out.println("#Result " + kk2);//#Result [abcced]

    }

}

class TrieNode {

    public TrieNode[] children = new TrieNode[26];

    public String item = "";

}

//Trie

class Trie {

    public TrieNode root = new TrieNode();

    public void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();

            node = node.children[c - 'a'];
        }

        node.item = word;

    }

    public boolean search(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            if (node.children[c - 'a'] == null) return false;

            node = node.children[c - 'a'];

        }

        return node.item.equals(word);

    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for (char c : prefix.toCharArray()) {

            if (node.children[c - 'a'] == null) return false;

            node = node.children[c - 'a'];

        }

        return true;

    }

}