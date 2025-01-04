import java.util.ArrayList;

class Solution 
{
    // Step 1: Check if a string is a palindrome
    public boolean isPalindrome(String str) 
    {
        int left = 0, right = str.length() - 1;
        while (left < right) 
            if (str.charAt(left++) != str.charAt(right--)) 
                return false;
        return true;
    }

    public int maxProduct(String s) 
    {
        int n = s.length();
        ArrayList<Integer> palinMasks = new ArrayList<>();
        
        // Step 2: Generate all bitmasks and check for palindromic subsequences
        for (int mask = 1; mask < (1 << n); mask++) 
        {
            StringBuilder subsequence = new StringBuilder();
            for (int i = 0; i < n; i++) 
            {
                if ((mask & (1 << i)) != 0) 
                    subsequence.append(s.charAt(i));
            }
            if (isPalindrome(subsequence.toString())) 
                palinMasks.add(mask);
        }

        int maxProduct = 0;

        // Step 3: Compare all pairs of disjoint palindromic subsequences
        for (int i = 0; i < palinMasks.size(); i++) 
        {
            int mask1 = palinMasks.get(i);
            for (int j = i + 1; j < palinMasks.size(); j++) 
            {
                int mask2 = palinMasks.get(j);
                if ((mask1 & mask2) == 0) 
                {   // Ensure disjoint masks
                    int len1 = Integer.bitCount(mask1);
                    int len2 = Integer.bitCount(mask2);
                    maxProduct = Math.max(maxProduct, len1 * len2);
                }
            }
        }
        return maxProduct;
    }
}
