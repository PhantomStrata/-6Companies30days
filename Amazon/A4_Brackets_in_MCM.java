class Solution {
    static String matrixChainOrder(int arr[]) {
        int n = arr.length;

        // dp[i][j] will hold the minimum number of scalar multiplications needed
        // to multiply matrices A[i]...A[j]
        int[][] dp = new int[n][n];

        // To store the optimal parenthesization as a string
        String[][] brackets = new String[n][n];

        // Initialize base cases
        for (int i = 1; i < n; i++) {
            brackets[i][i] = Character.toString((char) ('A' + i - 1)); // A, B, C, etc.
        }

        // Solve for chains of increasing length
        for (int len = 2; len < n; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try splitting the chain at every possible k
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;

                        // Update brackets for optimal parenthesization
                        brackets[i][j] = "(" + brackets[i][k] + brackets[k + 1][j] + ")";
                    }
                }
            }
        }

        // The result is stored in brackets[1][n-1]
        return brackets[1][n - 1];
    }
}
