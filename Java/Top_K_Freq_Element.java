public class Solution {
    // Bucket sort method
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        // use bucket sort to get top K freq elements, index is the freq
        List<Integer>[] bucket = new List[nums.length + 1]; // NOT: List<Integer>[] bucket = new List<Integer> [length+1];
        for (int n : freqMap.keySet()) {
            int freq = freqMap.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(n);
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = bucket.length - 1; ans.size() < k && i >= 0 ; i--) {
            if (bucket[i] != null) {  // Don't forget to judge the existance of bucket!
                ans.addAll(bucket[i]);
            }
        }
        return ans;
    }

    // Min Heap method
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        /*
        for (int n : nums) {
            if (!freqMap.containsKey) {
                freqMap.put(n, 1);
            } else {
                freqMap.put(n, freqMap.get(n) + 1);
            }
        }
        */
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
            new PriorityQueue<Map.Entry<Integer, Integer>>(
                                                           new Comparator<Map.Entry<Integer, Integer>>() {
                                                               public int compare(Map.Entry<Integer, Integer> p1, Map.Entry<Integer, Integer> p2) {
                                                                   return p1.getValue() - p2.getValue();
                                                               }
                                                           });
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (heap.size() < k) {
                heap.offer(entry);
            } else if (heap.peek().getValue() < entry.getValue()) {
                heap.poll();
                heap.offer(entry);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : heap) {
            ans.add(entry.getKey());
        }
        return ans;
    }
    
}
