class Solution {
    public String getHint(String secret, String guess) 
    {
        int bulls = 0;                
        int[] secretCount = new int[10]; // Positional array for unmatched digits in secret
        int[] guessCount = new int[10];  // Positional array for unmatched digits in guess
        
        // First pass: Calculate bulls and populate the positional array
        for (int i = 0; i < secret.length(); i++) 
        {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) 
            {
                bulls++; // compare both secret and guess characters directly, if matching, increment bulls
            } 
            else 
            {
                secretCount[s - '0']++; // as characters are represented by their ASCII/Unicode values, this increments frequency for non-matching digits in secret
                guessCount[g - '0']++;  // Increment frequency for non-matching digit in guess
            }
        }
        
        // Second pass: Calculate cows only
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]); // Take minimum of both frequency maps to avoid double counting
        }
        
        // final result in the desired output format of xAyB
        return bulls + "A" + cows + "B";
    }
}
