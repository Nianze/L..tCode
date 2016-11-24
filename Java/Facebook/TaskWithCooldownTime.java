// Created by Rym on 11/14/2016
import java.util.*;

class task_with_cooldown{
    public static int min_time(int[] tasks, int interval){
        if(tasks == null || tasks.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int time = 0;
        for(int task : tasks){
            Integer task_last_time = map.get(task);
            if(task_last_time != null && task_last_time + interval + 1 > time){
                time = task_last_time + interval + 1;
            }
            map.put(task, time);
            time++;
        }
        return time;
    }
    public static void main(String[] args){
        int[] tasks = {1, 2,3,2,3};
        System.out.println(min_time(tasks, 3));
    }

    // Improve: space complexity a little to no more than  O(n)
    // use LinkedHashMap to remove the elder task that exceeds the cooldown time
    Map<K,V> map = new LinkedHashMap<K,V>(int cooldown, 1.0f) {  // load factor 1.0
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size() > cooldown;
        }
    };

    // follow up
    // What if the order is ok to change?
    // Greedy algo: always look for the task with highest remaining time at each time

    // Two method:
    // 1. Use priorityQueue to sort the tasks with highest remaining times,
    //    time: O(nlog(n)), where n is the total number of tasks, space: O(n)
    // 2. use two array to store the remaining times and available time for
    //    each task, and each time scan these two arraies to find the appropriate task
    //    time: O(klog(n)), where k is the number of task kinds, space: O(n)

    // Method one:
    public int schedule(int[] tasks, int cooldown) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int t : tasks) {
            freqMap.put(t, freqMap.getOrDefault(t, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> maxHeap =
            new PriorityQueue<>(freqMap.size(), new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        return e2.getValue() - e1.getValue();
                    }
                });
        Deque<Map.Entry<Integer, Integer>> waitQueue = new ArrayDeque<>();
        HashMap<Integer, Integer> timeMap = new HashMap<>();
        int time = 0;
        maxHeap.addAll(freqMap.entrySet());        
        while (!maxHeap.isEmpty() || !waitQueue.isEmpty()) {
            if (!maxHeap.isEmpty()) {
                Map.Entry<Integer, Integer> cur = maxHeap.poll();
                time++;
                timeMap.put(cur.getKey(), time);
                cur.setValue(cur.getValue() - 1);
                waitQueue.offer(cur);
                if (waitQueue.size() < cooldown + 1) continue;
                Map.Entry<Integer, Integer> front = waitQueue.poll();
                if (front.getValue() > 0) maxHeap.offer(front);
            } else {
                Map.Entry<Integer, Integer> front = waitQueue.poll();
                if (front.getValue() > 0) {
                    maxHeap.offer(front);
                    time = timeMap.get(front.getKey()) + cooldown;
                }
            }
        }
        return time;
    }        
    
    // Method two:
    
}
