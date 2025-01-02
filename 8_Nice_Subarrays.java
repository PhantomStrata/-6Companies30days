class Solution 
{
    public int numberOfSubarrays(int[] nums, int k) 
    {
        int left = 0, oddCount = 0; //left here is the sliding window left pointer

        int atMostK = 0;
        
        // number of subarrays with AT MOST k odd numbers
        for (int right = 0; right < nums.length; right++)
        {
            if (nums[right] % 2 == 1) 
            {
                oddCount++;
            }

            // shrinking window when the oddCount goes beyond k value
            while (oddCount > k) 
            {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
            }

            // all subarrays between LEFT and RIGHT which end at RIGHT
            atMostK += right - left + 1;
        }
        
        // Subarrays with exactly k odd numbers = subarrays with [(at most k odd no.) - (at most k-1 odd no.)]
        left = 0;
        int atMostKMinusOne = 0;
        oddCount=0;

        //subarrays with at most k-1 odd numbers
        for (int right = 0; right < nums.length; right++) 
        {
            if (nums[right] % 2 == 1) 
                oddCount++;

            // shrink window if oddCount exceeds k-1
            while (oddCount > k - 1) 
            {
                if (nums[left] % 2 == 1) 
                    oddCount--;
                left++;
            }

            // all subarrays between LEFT and RIGHT which end at RIGHT
            atMostKMinusOne += right - left + 1;
        }
        
        return atMostK - atMostKMinusOne;
    }
}
