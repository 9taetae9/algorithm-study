//내 풀이
/*
중위 순회하며 리스트에 작은 순서대로 넣고 리스트 인접 원소간 차이를 비교하는 방식
=> 인접 원소들간의 차이만 구하면 되었기 때문에 리스트를 만든건 메모리 낭비였다
*/
class Solution {
    List<Integer> list = new ArrayList<>();
    int min = 100001;
    public int getMinimumDifference(TreeNode root) {
        inOrderTraverse(root);
        for(int i=0; i<list.size()-1; i++){
            min = Math.min(min, list.get(i+1)-list.get(i));
        }

        return min;
    }

    private void inOrderTraverse(TreeNode node){
        if(node == null) return ;

        inOrderTraverse(node.left);
        list.add(node.val);
        inOrderTraverse(node.right);
    }
}

//모법 답안
class Solution {
    int prev = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return ans;
    }
    
    public void inOrder(TreeNode root){
        if(root.left!=null) inOrder(root.left);
        ans = Math.min(ans,Math.abs(root.val-prev));
        prev = root.val;
        if(root.right!=null) inOrder(root.right);
    }
}
