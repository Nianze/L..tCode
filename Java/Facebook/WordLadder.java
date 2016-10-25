// Created by Rym on 10/21/2016
public class Solution {
    // Using two-end search
    /**
     *The idea behind bidirectional search is to run two simultaneous 
     *searches—one forward from the initial state and the other 
     *backward from the goal—hoping that the two searches meet in
     * the middle. The  motivation is that b^(d/2) + b^(d/2) is much
     * less than b^d. b is branch factor, d is depth. "
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        int len = 1;
        HashSet<String> visited = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        //visited.add(beginWord);
        //visited.add(endWord);
        while (!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> buf = beginSet;
                beginSet = endSet;
                endSet= buf;
            }
            Set<String> nextLayer = new HashSet<String>();
            for (String word : beginSet) {
                char[] cs = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char oldChar = cs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cs[i] = c;
                        String nextWord = String.valueOf(cs);
                        if (endSet.contains(nextWord)) {
                            return len+1;
                        }
                        if (!visited.contains(nextWord) &&
                            wordList.contains(nextWord)) {
                            nextLayer.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    cs[i] = oldChar;
                }
            }
            beginSet = nextLayer;
            len++;
        }
        return 0;
    }

    // Another method is just use one end. No if (beginSet > endSet) in while loop
}
