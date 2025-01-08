//Definition for a binary tree node.

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() 
    {

    }
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public int amountOfTime(TreeNode root, int start) {
        // Find the starting node and parent relationships
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = findStartNode(root, start, parentMap);

        // BFS to calculate the time required
        return bfs(startNode, parentMap);
    }

    private TreeNode findStartNode(TreeNode node, int start, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode startNode = null;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val == start) {
                startNode = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.add(curr.right);
            }
        }

        return startNode;
    }

    private int bfs(TreeNode startNode, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean levelAdded = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Check neighbors: left, right, and parent
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                    levelAdded = true;
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                    levelAdded = true;
                }
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
                    queue.add(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                    levelAdded = true;
                }
            }

            if (levelAdded) {
                time++;
            }
        }

        return time;
    }
}
