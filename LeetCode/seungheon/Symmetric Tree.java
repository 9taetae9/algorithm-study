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
    Deque<Integer> temp = new ArrayDeque<>(500);

    public boolean isSymmetric(TreeNode root) {
        l(root.left);
        r(root.right);

        return temp.isEmpty();
    }

    void l(TreeNode root) {
        if (root == null) {
            temp.offer(101);
            return;
        }

        temp.offer(root.val);
        l(root.left);
        l(root.right);
    }

    void r(TreeNode root) {
        if (root == null) {
            if (temp.peek() == 101) {
                temp.poll();
            }
            return;
        }

        if (temp.peek() != root.val) {
            return;
        }
        
        temp.poll();
        r(root.right);
        r(root.left);
    }
}


// 모범 답안
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
    public boolean isSymmetric(TreeNode root) {
        return isSame(root.left, root.right);
    }

    boolean isSame(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        return isSame(l.left, r.right) && isSame(l.right, r.left);
    }
}
