/*
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = root;

    while(cur != null || !s.isEmpty()){
        while(cur != null){
          s.push(cur);
          cur = cur.left;
      }
      cur = s.pop();
      k--;
      if(k == 0) return cur.val;
      cur = cur.right;
    }

    return -1;
  }
 */

class Solution {
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return res.get(k-1);
    }
    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}