//{ Driver Code Starts
// Initial Template for Java

import java.io.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            String str2[] = read.readLine().trim().split(" ");

            int n = Integer.parseInt(str2[0]);
            int m = Integer.parseInt(str2[1]);
            new Solution().linkdelete(head, n, m);
            printList(head);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

/*
delete n nodes after m nodes
The input list will have at least one element
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/

class Solution {
    void linkdelete(Node head, int n, int m) {
        Node curr = head;
        while(curr != null){
            int count = m-1;
            while(count-- > 0 && curr != null){
                curr = curr.next;
            }
            if(curr == null){
                break;
            }
            Node temp = curr;
            count = n+1;
            while(count-- > 0 && temp != null){
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }
}
