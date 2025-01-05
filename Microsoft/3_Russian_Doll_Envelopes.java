import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) 
    {
        // sort by width (asc) and height (desc for same width)
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // extract height and find the LIS
        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) 
        {
            int height = envelope[1];
            
            // find insert position
            int idx = Arrays.binarySearch(dp, 0, len, height);
            if (idx < 0) 
            {
                idx = -(idx + 1); // convert to insertion point
            }
            dp[idx] = height;

            // if height append, then increase len
            if (idx == len) 
            {
                len++;
            }
        }
        return len;
    }
}