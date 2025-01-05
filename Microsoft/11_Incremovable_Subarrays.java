class Solution {
    public int incremovableSubarrayCount(int[] nums) 
    {
        int n = nums.length;
        int count = 0;

        // loop over all possible subarrays
        for (int start = 0; start < n; start++) 
        {
            for (int end = start; end < n; end++) 
            {
                // check if array is strictly increasing after removal of subarray
                if (isStrictlyIncreasingAfterRemoval(nums, start, end)) 
                {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isStrictlyIncreasingAfterRemoval(int[] nums, int start, int end) 
    {
        // check the elements before the subarray
        for (int i = 1; i < start; i++) 
        {
            if (nums[i] <= nums[i - 1]) 
            {
                return false;
            }
        }

        // check the element before the subarray and the first element after the subarray
        if (start > 0 && end < nums.length - 1) 
        {
            if (nums[start - 1] >= nums[end + 1]) 
            {
                return false;
            }
        }

        // Check the rest of the elements after the subarray
        for (int i = end + 2; i < nums.length; i++) 
        {
            if (nums[i] <= nums[i - 1]) 
            {
                return false;
            }
        }

        return true;
    }
}
