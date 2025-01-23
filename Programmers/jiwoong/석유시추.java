

// 풀이 1
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int n, m;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    Map<Integer, Integer> colValue = new HashMap<>();
    boolean[][] visited;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;

        visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(i,j,land);
                }
            }
        }

        for(int num : colValue.values()){
            answer = Math.max(num, answer);
        }

        return answer;
    }

    void bfs(int sx, int sy, int[][] land){

        Queue<Point> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();

        Point start = new Point(sx, sy);
        q.offer(start);
        s.add(sy);
        visited[sx][sy] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(land[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                Point nPoint = new Point(nx, ny);
                visited[nx][ny] = true;
                q.offer(nPoint);
                s.add(ny);
                cnt++;
            }
        }

        for(int i : s){
            colValue.put(i, colValue.getOrDefault(i, 0) + cnt);
        }
    }
}

// 풀이 2
class UnionFind{
    private int[] parent;
    private int[] size;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return;

        if(size[rootX] > size[rootY]){
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }else{
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    int getSize(int x){
        return size[find(x)];
    }
}

class Solution{
    int n, m;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visited;
    public int solution(int[][] land) {
        int ans = 0;

        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];

        UnionFind uf = new UnionFind(n * m);

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(land[i][j] == 1){
                    for(int k = 0; k<4; k++){
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if(ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
                        if(land[ni][nj] == 0) continue;

                        visited[ni][nj] = true;
                        uf.union(i * m + j, ni * m + nj);
                    }
                }
            }
        }

        Set<Integer> s = new HashSet<>();

        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                if(land[j][i] == 1){
                    s.add(uf.find(j * m + i));
                }
            }

            int sum = 0;
            for(int num : s){
                sum += uf.getSize(num);
            }
            s.clear();
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}