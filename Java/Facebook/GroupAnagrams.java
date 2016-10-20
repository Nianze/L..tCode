// Created by Rym on 10/18/2016
public class GroupAnagrams {
    // Optimize: 
    // 1. store the index rather than the string in the value of map
    // 2. to avoid sort: use unique prime number mapping to calculate unique key for anagrams (a:2,b:3,c:5...)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());        
    }
}
