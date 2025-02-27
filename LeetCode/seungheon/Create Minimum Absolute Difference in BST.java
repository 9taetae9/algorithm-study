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
    int diff = 987_654_321;
    int prev = -1;

    public int getMinimumDifference(TreeNode root) {
        getDiff(root);
        return diff;
    }

    void getDiff(TreeNode root) {
        if (root == null) return;

        getDiff(root.left);

        if (prev >= 0) {
            diff = Math.min(diff, root.val - prev);
        }
        prev = root.val;

        getDiff(root.right);
    }
}
