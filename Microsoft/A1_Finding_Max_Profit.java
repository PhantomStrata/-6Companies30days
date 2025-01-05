class Solution 
{
    public int maxProfit(int k, int[] prices) 
    {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // If k >= n/2, we can make unlimited transactions
        if (k >= n / 2) 
        {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) 
            {
                if (prices[i] > prices[i - 1]) 
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }

        // DP table: dp[i][j] - max profit using at most i transactions until day j
        int[][] dp = new int[k + 1][n];

        for (int i = 1; i <= k; i++) 
        {
            int maxPrevProfit = -prices[0]; // Tracks the max profit for (i-1)th transaction minus price
            for (int j = 1; j < n; j++) 
            {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxPrevProfit); // Skip or sell at j
                maxPrevProfit = Math.max(maxPrevProfit, dp[i - 1][j] - prices[j]); // Update max profit
            }
        }

        return dp[k][n - 1];
    }
}
