public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // base case
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int one_step_before = 1, two_steps_before = 1; // last move is one/two steps before
        int current = 0; // number of steps for until current point

        for (int i = 2; i <= n; i++) {
            current = one_step_before + two_steps_before;
            // update for next i
            two_steps_before = one_step_before;
            one_step_before = current;
        }
        return current;
    }
}
