// Created by Rym on 11/25/2016

/**
 * Design a data structure that supports all 
 * following operations in average O(1) time:
 *    insert(val): Inserts an item val to the set if not already present.
 *    remove(val): Removes an item val from the set if present.
 *    getRandom: Returns a random element from current set of elements. 
 *         Each element must have the same probability of being returned.
 */

public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) return false;
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(loc, last);
            locs.put(last, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// Follow up:
public class RandomizedCollection {
    ArrayList<Integer> nums;
    HashMap<Integer, List<Integer>> locs;
    java.util.Random rand = new java.util.Random();

    public RandomizedCollection() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean contains = locs.containsKey(val);
        if (!contains) locs.put(val, new ArrayList<>());
        locs.get(val).add(nums.size());
        nums.add(val);
        return !contains;
    }

    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        int loc = locs.get(val).remove(locs.get(val).size() - 1);
        if (loc < nums.size() - 1) {
            int last = nums.get(nums.size() - 1);
            nums.set(loc, last);
            locs.get(last).set(locs.get(last).size() - 1, loc);
        }
        nums.remove(nums.size() - 1);
        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

