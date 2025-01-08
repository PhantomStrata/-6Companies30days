//Definition for a binary tree node.

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
         val = x; 
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return ""; // If tree null return empty string
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr != null) {
                sb.append(curr.val).append(","); // Append the value of the node
                q.add(curr.left);  // Add left child to the queue (nulls included)
                q.add(curr.right); // Add right child to the queue (nulls included)
            } else {
                sb.append("#,"); // Append '#' to represent null
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null; 
        }

        String[] tokens = data.split(","); // Split serialized string
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int index = 1; // Start processing from the second token
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // Process left child and add it to queue
            if (!tokens[index].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(tokens[index]));
                q.add(curr.left); // Add the left child to the queue
            }
            index++;

            // Process right child and add it to queue
            if (index < tokens.length && !tokens[index].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(tokens[index]));
                q.add(curr.right);
            }
            index++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
