class Solution {
    private boolean[] visited;
    private int max = 0;
    private int[][] dungeons;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        dfs(k, 0);
        return max;
    }
    
    private void dfs(int k, int count){
        max = Math.max(max, count);
        for(int i=0; i<dungeons.length; i++){
            if(dungeons[i][0] <= k && !visited[i]){
                visited[i] = true;
                dfs(k - dungeons[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}
