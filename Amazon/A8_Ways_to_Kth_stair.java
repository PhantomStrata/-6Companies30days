/* import java.util.HashMap;
import java.util.Map;

class Solution {

    public int waysToReachStair(int k) {
        // Memoization map to store the number of ways for a given state
        Map<String, Integer> memo = new HashMap<>();

        // Inner helper function using recursion with memoization
        return solve(k, 0, 0, 1, memo);
    }

    private int solve(int k, int isBackStep, int jump, int currentStep, Map<String, Integer> memo) {
        // Base cases: if the current step is out of bounds, return 0
        if (currentStep < 0 || currentStep > k + 1) return 0;

        // Memoization key: encode the state as a string
        String state = isBackStep + "," + jump + "," + currentStep;
        if (memo.containsKey(state)) {
            return memo.get(state);
        }

        int ways = 0;

        // If currentStep equals k, it's a valid way
        if (currentStep == k) {
            ways++;
        }

        // Backward move: only allowed if the last move was not a back step
        if (isBackStep == 0) {
            ways += solve(k, 1, jump, currentStep - 1, memo);
        }

        // Forward move: move forward by 2^jump steps and increment the jump
        ways += solve(k, 0, jump + 1, currentStep + (1 << jump), memo);

        // Store the result for the current state in memo and return it
        memo.put(state, ways);
        return ways;
    }

}

 */

class Solution {
    // Helper method to compute combinations (n choose k)
    private int comb(int n, int k) {
        if (k < 0 || k > n) {
            return 0; // Return 0 if k is out of bounds
        }

        long result = 1;
        // Compute the combination using an iterative method
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }

        return (int) result; // Return the result as an int
    }

    public int waysToReachStair(int k) {
        int result = 0;
        // Iterate over possible jumps (max 30 steps for reasonable values of k)
        for (int jump = 0; jump < 30; jump++) {
            int stepsToReach = (1 << jump) - k; // Calculate the number of steps to reach the target stair
            result += comb(jump + 1, stepsToReach); // Add the number of ways to achieve this
        }

        return result; // Return the total number of ways to reach stair k
    }

}
