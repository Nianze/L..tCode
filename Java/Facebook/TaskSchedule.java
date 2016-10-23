// Created by Rym on 10/20/2016
public class TaskSchedule {
    public List<Integer> Printer(String[] tasks, int cooldown) {
        List<Integer> ret = new  LinkedList<Integer>();
        if (tasks == null || tasks.length == 0) {
            return;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int j = 0;
        for(int i = 0; i < tasks.length; i++) {
            while (map.containsKey(tasks[i]) && map.get(tasks[i]) + cooldown >= j) {
                ret.add("_");
                j++;
            }
            ret.add(tasks[i]);
            map.put(tasks[i], j);
            j++;
        }
        return ret;
    }
}
