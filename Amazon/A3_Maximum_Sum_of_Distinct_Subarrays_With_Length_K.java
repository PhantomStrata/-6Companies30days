import java.util.HashSet;

class Solution 
{
    public long maximumSubarraySum(int[] nums, int k) 
    {
        long maxSum = 0;     // Stores the maximum sum of valid subarrays
        long currSum = 0;    // Stores the current sum of the sliding window
        HashSet<Integer> windowSet = new HashSet<>(); // Tracks unique elements in the current window

        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < nums.length; right++) 
        {
            // Shrink the window if a duplicate is found
            while (windowSet.contains(nums[right])) 
            {
                currSum -= nums[left];
                windowSet.remove(nums[left]);
                left++;
            }

            // Add the current element to the window
            windowSet.add(nums[right]);
            currSum += nums[right];

            // Check if the window size matches k
            if (right - left + 1 == k) 
            {
                maxSum = Math.max(maxSum, currSum); // Update maxSum if necessary

                // Slide the window forward by removing the leftmost element
                currSum -= nums[left];
                windowSet.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }
}
