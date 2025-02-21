/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root, targetSum);
    }

    boolean hasPath(TreeNode root, int targetSum) {
        if (root == null) return false;

        int process = targetSum - root.val;

        if (root.left == null && root.right == null && process == 0) return true;

        return hasPath(root.left, process) || hasPath(root.right, process);
    }
}
