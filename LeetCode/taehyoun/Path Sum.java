//오답 풀이 (54 / 118 testcases passed)
class Solution {
        static boolean hasTarget;
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root == null) return false;
            hasPathSum(root, targetSum, root.val);
            return hasTarget;
        }

        public void hasPathSum(TreeNode root, int targetSum, int curSum) {
            if(root.left == null && root.right == null){
                if(targetSum == curSum) {
                    hasTarget = true;
                    return ;
                }
                return ;
            }


            if(root.left != null && !hasTarget){
                hasPathSum(root.left, targetSum, curSum + root.left.val);
            }


            if(root.right != null && !hasTarget){
                hasPathSum(root.right, targetSum, curSum + root.right.val);
            }
            return ;
        }
    }

//정답 풀이
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return hasPathSum(root, targetSum, root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int curSum) {
        if(root.left == null && root.right == null){
            return targetSum == curSum;
        }

        return root.left != null && hasPathSum(root.left, targetSum, curSum+root.left.val) || root.right !=null && hasPathSum(root.right, targetSum, curSum+root.right.val);
    }
}

//모범 답안
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
    
        if (root == null) {
            return false;
        }
        //리프노드
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        return hasPathSum(root.left, targetSum - root.val) || 
            hasPathSum(root.right, targetSum - root.val);
    }
}   
    
