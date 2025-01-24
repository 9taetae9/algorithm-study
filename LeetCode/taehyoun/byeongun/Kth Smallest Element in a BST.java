class TodayAlgorithm {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int count;
    int val;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        search(root);
        return val;
    }
    //중위 순회
    private void search(TreeNode node) {
        if (node == null) return;
        search(node.left);
        if (--count == 0) {
            val = node.val;
            return;
        }
        search(node.right);
    }
}
