// Created by Rym on 10/30/2016
public class LongestAbsoluteFilePath {
    // use stack
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1; // number of "\t"
            while (stack.size() > level) {
                stack.pop();
            }
            int subDirLen = s.length() - level;  // remove len of "\t"
            if (stack.isEmpty()) {
                stack.push(subDirLen);
            } else {
                stack.push(stack.peek() + subDirLen + 1); // add "/"
            } 
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, stack.pop());
            }
        }
        return maxLen;
    }

    // use hashmap
    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // dummy
        int maxLen = 0;
        for (String s : iput.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.length() - level;
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, map.get(level) + len);x
            } else {
                map.put(level + 1, map.get(level) + len + 1);
            }
        }
        return maxLen;
    }
}
