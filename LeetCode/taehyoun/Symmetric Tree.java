class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        //base condition
        if(left == null && right == null) return true;  
        if(left == null || right == null) return false;
        
       return (left.val == right.val) &&                 // 현재 값(왼쪽 오른쪽) 비교
            isSymmetric(left.left, right.right) &&       // 다음: 동일 과정 수행
            isSymmetric(left.right, right.left);         // 다음: 동일 과정 수행
    }
}
