// Created by Rym on 10/21/2016

/** The knows API is defined in the parent class Relation.
 *  boolean knows(int a, int b); if true, a knows b
 */

public class FindTheCelebrity extends Relation {
    // Two pass
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) candidate = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate &&
                (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }
}
