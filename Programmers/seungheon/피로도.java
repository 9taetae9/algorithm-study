import java.util.*;

class Solution {
    int[][] dd;
    boolean[] visited;
    int l;
    int ans;
    
    public int solution(int k, int[][] dungeons) {
        
        dd = dungeons;
        l = dungeons.length;
        visited = new boolean[l];
        for (int i = 0; i < l; ++i) {
            if (dd[i][0] <= k) {
                Arrays.fill(visited, false);
                dfs(i, 0, k);
            }
        }
        
        return ans;
    }
    
    void dfs(int s, int cnt, int k) {
        if (dd[s][0] > k) return;
        
        visited[s] = true;
        cnt++;
        k -= dd[s][1];
        ans = Math.max(ans, cnt);
        
        for (int i = 0; i < l; ++i) {
            if (!visited[i]) {
                dfs(i, cnt, k);
                visited[i] = false;
            }
        }
    }
}
