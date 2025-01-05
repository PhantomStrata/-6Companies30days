class Solution 
{
    public int longestMountain(int[] arr) 
    {
        int n = arr.length;
        if (n < 3) return 0; // A mountain requires at least 3 elements

        int maxLength = 0;
        int i = 1; // Start from the second element

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) 
            {
                int left = i - 1;
                int right = i + 1;

                // Expand left to find the start of the mountain
                while (left > 0 && arr[left - 1] < arr[left]) 
                {
                    left--;
                }

                // Expand right to find the end of the mountain
                while (right < n - 1 && arr[right] > arr[right + 1]) 
                {
                    right++;
                }

                // Update the maximum mountain length
                maxLength = Math.max(maxLength, right - left + 1);

                // Move `i` to `right` for the next iteration
                i = right;
            } 
            else 
            {
                // If not a peak, move to the next element
                i++;
            }
        }

        return maxLength;
    }
}
