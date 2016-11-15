// Created By Rym on 11/14/2016

// Similar to Facebook's task schedule with cooldown time follow up
public class RearrangeStringKDistanceApart {
    // Method 1: two arraies
    public String rearrangeString(String str, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            int c = findNext(count, valid, i);
            if (c == -1) return "";
            sb.append((char)('a'+c));
            count[c] -= 1;
            valid[c] = i + k;
        }
        return sb.toString();
    }
    private int findNext(int[] count, int[] valid, int index) {
        int pos = -1, max = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] > max && index >= valid[i]) {
                pos = i;
                max = count[i];
            }
        }
        return pos;
    }
    // Method 2: PriorityQueue (general method)
    public String rearrangeString(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Map.Entry<Character, Integer>> maxHeap =
            new PriorityQueue<>(map.size(), new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                        return e2.getValue() - e1.getValue();
                    }
                });
        Deque<Map.Entry<Character, Integer>> buffer = new ArrayDeque<>();
        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue()-1);
            buffer.offer(cur);
            if (buffer.size() < k) continue;
            Map.Entry<Character, Integer> front = buffer.poll();
            if (front.getValue() > 0) maxHeap.offer(front);
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
}
