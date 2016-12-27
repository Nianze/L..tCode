// Created by Rym on 2016.12.21

// BFS (w/o queue, every time build a new set as next level), build adjList in map, whose structure
// looks like two side tree connected by answer path.
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        Map<String, List<String>> map =  new HashMap<>();
        buildAdj(set1, wordList, set2, map, false);
        List<List<String>> res = new ArrayList<>();
        List<String> builder = new ArrayList<>(Arrays.asList(beginWord)); //Arrays.asList: Returns a fixed-size list backed by the specified array. cannot structurally modify it.
        backTrack(builder, endWord, map, res);
        return res;
    }
    private boolean buildAdj(Set<String> set1, Set<String> dict, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) return false;
        if (set1.size() > set2.size()) return buildAdj(set2, dict, set1, map, !flip);
        dict.removeAll(set1);
        dict.removeAll(set2);
        boolean connected = false; // only need shortest path, connected used for early termination
        Set<String> nextLevel = new HashSet<>();
        for (String s : set1) {
            for (int i = 0; i < s.length(); i++) {
                char[] chs = s.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chs[i] = ch;
                    String temp = new String(chs);
                    String key = !flip ? s : temp;
                    String value = !flip ? temp : s;
                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();
                    if (set2.contains(temp)) {
                        connected = true;
                        list.add(value);
                        map.put(key, list);
                    }
                    if (!connected && dict.contains(temp)) {
                        nextLevel.add(temp);
                        list.add(value);
                        map.put(key, list);
                    }
                }
            }
        }
        return connected || buildAdj(set2, dict, nextLevel, map, !flip);
    }
    private void backTrack(List<String> builder, String target, Map<String, List<String>> map, List<List<String>> res) {
        String from = builder.get(builder.size()-1);
        if (from.equals(target)) {
            res.add(new ArrayList<String>(builder));
            return;
        }
        if (!map.containsKey(from)) return; // case of 'aa', 'cc', {'aa', 'ab', 'ac', 'cc'}, no key of 'ab' in map
        for (String next : map.get(from)) {
            builder.add(next);
            backTrack(builder, target, map, res);
            builder.remove(builder.size()-1);
        }
    }
}
