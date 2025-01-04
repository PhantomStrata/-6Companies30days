import java.util.Arrays;

class Solution 
{
    public void wiggleSort(int[] nums) 
    {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted); // Sort the array in ascending order

        int left = (n - 1) / 2; // Middle of the array for the smaller half
        int right = n - 1;     // End of the array for the larger half

        for (int i = 0; i < n; i++) 
        {
            if (i % 2 == 0) 
                nums[i] = sorted[left--]; // Assign from the smaller half
            else 
                nums[i] = sorted[right--]; // Assign from the larger half
        }
    }
}