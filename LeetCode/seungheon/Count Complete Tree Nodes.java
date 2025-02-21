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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root;
        TreeNode right = root;
        int ld = 1;
        int rd = 1;

        while ((left = left.left) != null)    ld++;
        while ((right = right.right) != null) rd++;

        return ld == rd ?
            (int) Math.pow(2, ld) - 1 :
            1 + countNodes(root.left) + countNodes(root.right);
    }
}
