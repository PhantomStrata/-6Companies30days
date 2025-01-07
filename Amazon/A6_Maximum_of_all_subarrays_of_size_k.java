import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}

class Solution {
    // Function to find the maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0) {
            return result;
        }

        Deque<Integer> deque = new LinkedList<>(); // To store array elements

        for (int i = 0; i < arr.length; i++) {
            // Remove elements that are out of the current window
            if (!deque.isEmpty() && i >= k && deque.peekFirst() == arr[i - k]) {
                deque.pollFirst();
            }

            // Remove elements smaller than the current element
            // as they will not be the maximum in this or any future window
            while (!deque.isEmpty() && deque.peekLast() < arr[i]) {
                deque.pollLast();
            }

            // Add the current element to the deque
            deque.offerLast(arr[i]);

            // Add the maximum for the current window to the result
            if (i >= k - 1) {
                result.add(deque.peekFirst());
            }
        }

        return result;
    }
}