import java.util.Arrays;

class Solution 
{
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) 
    {
        int[][] dis = new int[26][26];
        // Initialize distance matrix
        for (int i = 0; i < 26; i++) 
        {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }

        // Populate direct transformation costs
        for (int i = 0; i < cost.length; i++) 
        {
            dis[original[i] - 'a'][changed[i] - 'a'] = 
                Math.min(dis[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        // Floyd-Warshall for all-pairs shortest paths
        for (int k = 0; k < 26; k++) 
        {
            for (int i = 0; i < 26; i++) 
            {
                if (dis[i][k] < Integer.MAX_VALUE) 
                {
                    for (int j = 0; j < 26; j++) 
                    {
                        if (dis[k][j] < Integer.MAX_VALUE) 
                        {
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
            }
        }

        // Transform the source string into the target string
        long ans = 0L;
        for (int i = 0; i < source.length(); i++) 
        {
            char ch1 = source.charAt(i);
            char ch2 = target.charAt(i);
            if (dis[ch1 - 'a'][ch2 - 'a'] == Integer.MAX_VALUE) 
                return -1L; // Transformation not possible
            ans += dis[ch1 - 'a'][ch2 - 'a'];
        }

        return ans;
    }
}