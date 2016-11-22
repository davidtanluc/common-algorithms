package wordLadder1.III;
import java.util.*;

/**
 * Created by davidtan on 11/22/16.
 */

class WordNode{
    String word;
    int steps;
    WordNode pre;

    public WordNode(String word,int steps, WordNode pre){
        this.word = word;
        this.steps = steps;
        this.pre = pre;
    }

}

public class Solution2 {

    public List<List<String>> wordLadderII(String startWord, String endWord, Set<String> dict){
        List<List<String>> result = new ArrayList<>() ;
        Queue<WordNode> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>();
        dict.add(endWord);
        q.add(new WordNode(startWord,1,null));
        unvisited.addAll(dict);
        int minSteps =0;
        int preSteps = 0;

        while(!q.isEmpty()){
            WordNode top = q.remove();
            String current_word = top.word;
            int current_steps = top.steps;
            //// end
            if(current_word.equals(endWord)){
                if(minSteps ==0)minSteps = current_steps;
                if(minSteps == current_steps && minSteps !=0){
                    List<String> t = new ArrayList<>();
                    t.add(current_word);
                    while(top.pre != null){
                        t.add(0,top.pre.word);
                        top = top.pre;//loop
                    }
                    result.add(t);
                }
            }
            if(preSteps < current_steps)unvisited.removeAll(visited);
            preSteps = current_steps;
            /// reset
            char[] arr1 = current_word.toCharArray();
            ///find word ///
            for(int i=0;i <arr1.length;i++){
                for(char ch='a';ch<='z';ch++){
                    char tmp = arr1[i];
                    arr1[i] = ch;
                    String newWord = new String(arr1);
                    if(unvisited.contains(newWord)){
                        q.add(new WordNode(newWord,current_steps+1,top));
                        visited.add(newWord);
                    }

                    arr1[i] =tmp;
                }

            }
        }//while

        System.out.println(result);//[[hit, hot, dot, dog, cog], [hit, hot, lot, log, cog]]
        return result;
    }
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        sol.wordLadderII("hit", "cog", dict);


    }
}
