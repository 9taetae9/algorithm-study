// TreeNode node 파라미터로 받지 않는 방식
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
       
        return func(nums, 0, nums.length-1);
    }

    private TreeNode func(int[] nums, int s, int e){
        if(s > e){
            return null;
        }

        int mid = s + (e-s)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = func(nums, s, mid-1);
        node.right = func(nums, mid+1, e);
        
        return node;
    }
}
// TreeNode node를 파라미터로 받는 방식
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = func(nums, 0, nums.length - 1, null);
        return root;
    }

    private TreeNode func(int[] nums, int s, int e, TreeNode node) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        
        node = new TreeNode(nums[mid]);

        node.left = func(nums, s, mid - 1, node.left);
        node.right = func(nums, mid + 1, e, node.right);
        return node;
    }
}
