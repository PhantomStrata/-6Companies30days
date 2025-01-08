//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // Dictionary of valid characters in sorted order
        char[] dict = new char[]{'!', '#', '$', '%', '&', '*', '?', '@', '^'};
        
        //Store all characters present in the nuts array in a HashSet for quick lookup
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nuts[i]);
        }
        
        //Traverse the dictionary and arrange both nuts and bolts
        int index = 0; // Tracks the current position for nuts and bolts arrays
        for (char ch : dict) {
            // If the character exists in the nuts set, add it to both arrays
            if (set.contains(ch)) {
                nuts[index] = ch;
                bolts[index] = ch;
                index++;
            }
        }
    }
}
