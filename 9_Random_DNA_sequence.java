import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


class Solution {
    public List<String> findRepeatedDnaSequences(String s) 
    {
        int n = s.length();
        if (n < 10) return new ArrayList<>();

        // frequency of each 10-character sequence
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> result = new HashSet<>();

        // traverse and extract 10-character substrings
        for (int i = 0; i <= n - 10; i++) 
        {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);

            // if substring repeat add it to result
            if (map.get(substring) == 2) 
            {
                result.add(substring);
            }
        }

        return new ArrayList<>(result);
    }
}