// Created by Rym on 11/02/2016

/**
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> deq;
    public NestedIterator(List<NestedInteger> nestedList) {
        deq = new ArrayDeque<>(nestedList == null ? Arrays.asList() : nestedList);
    }

    @Override
    public Integer next() {
        return deq.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!deq.isEmpty() && !deq.peekFirst().isInteger()) {
            List<NestedInteger> list = deq.removeFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                deq.addFirst(list.get(i));
            }
        }
        return !deq.isEmpty();
    }
}
