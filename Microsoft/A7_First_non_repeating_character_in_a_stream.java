class Solution {
    public int firstUniqChar(String s) 
    {
        int[] freq = new int[26]; // Frequency array for 'a' to 'z'

        // Count the frequency of each character
        for (char c : s.toCharArray()) 
            freq[c - 'a']++;

        // Find the first character with a count of 1
        for (int i = 0; i < s.length(); i++) 
        {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        
        return -1; // No unique character found
    }
}
