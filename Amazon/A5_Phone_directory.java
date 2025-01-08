//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // Sort contact array and remove dupllicates
        TreeSet<String> sortedContacts = new TreeSet<>(Arrays.asList(contact));
        
        //Conver the TreeSet to ArrayList to perform operations directly 
        ArrayList<String> contactsList = new ArrayList<>(sortedContacts);
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        //Process the prefix of string "s"
        StringBuilder prefix = new StringBuilder();
        for (char c : s.toCharArray()) {
            prefix.append(c); // Build the current prefix
            String currentPrefix = prefix.toString();
            
            //Find all matching prefix contacts
            ArrayList<String> matches = new ArrayList<>();
            for (String contactName : contactsList) {
                if (contactName.startsWith(currentPrefix)) {
                    matches.add(contactName);
                }
            }
            
            //Add "0" to the result if no match is found 
            if (matches.isEmpty()) {
                matches.add("0");
            }
            
            result.add(matches);
        }
        
        return result;
    }
}

