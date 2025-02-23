
class P{
    int cnt;
    long val;

    public P(int cnt, long val) {
        this.cnt = cnt;
        this.val = val;
    }
}

/**
 * 이진트리의 root 이 주어진다. 각 level 의 평균값
 */
class Solution {

    Map<Integer, P> m = new HashMap<>();
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(1, root);
        List<Double> ans = new ArrayList<>();

        for(P p : m.values()){
            ans.add(((double)p.val) / ((double)p.cnt));
        }

        return ans;
    }

    void dfs(int level, TreeNode node){
        if(node == null) return;

        P cur = m.getOrDefault(level, new P(0, 0));
        cur.cnt++;
        cur.val += node.val;
        m.put(level, cur);
        if(node.left != null) dfs(level + 1, node.left);
        if(node.right != null) dfs(level + 1, node.right);
    }
}
