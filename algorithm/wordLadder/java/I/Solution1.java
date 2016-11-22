package wordLadder1.I;

import java.util.*;

/**
 * Created by davidtan on 11/20/16.
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
class WordNode {
    String word;
    int steps;

    public WordNode(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }

}

public class Solution1 {

    public int wordLadder(String startWord, String endWord, HashSet<String> dict) {

        ///////
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(startWord, 1));
        dict.add(endWord);

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word1 = top.word;
            if (word1.equals(endWord)) return top.steps;
            ///////////////
            char[] arr1 = word1.toCharArray();
            for (int i = 0; i < arr1.length; i++) {

                // for a-z
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char tmp = arr1[i];
                    arr1[i] = ch;
                    String newWord = new String(arr1);

                    if (dict.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.steps + 1));
                        System.out.print(newWord +"-->");
                        dict.remove(newWord);
                    }

                    arr1[i] = tmp;//reset

                }


            }
        }//while

        return 0;
    }

    public  static void main(String[] args){
        //["hot","dot","dog","lot","log"]
        HashSet<String> dict1 = new HashSet<>();
        dict1.add("hot");
        dict1.add("dot");
        dict1.add("dog");
        dict1.add("lot");
        dict1.add("log");

        Solution1 sol = new Solution1();
        System.out.print(sol.wordLadder("hit","cog",dict1));
        //hot-->dot-->lot-->dog-->log-->cog-->5
    }

}
/*

                     hit
                      |
                     hot
                /          \
              dot          lot
               |            |
              dog          log
                \           /
                     cog
 */