class Solution {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallestHelper(root);
        return result;
    }

    private void kthSmallestHelper(TreeNode node) {
        if (node == null) return;

        kthSmallestHelper(node.left);

        if (--count == 0) {
            result = node.val;
            return;
        }

        kthSmallestHelper(node.right);
    }
}
