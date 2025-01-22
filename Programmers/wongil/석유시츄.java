import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(int[][] land) {

        int n = land.length;
        int m = land[0].length;

        List<OilLand> oilLands = new ArrayList<>();

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) { // 오일이 있고, 방문하지 않았으면
                    List<int[]> ground = new ArrayList<>();

                    dfs(land, visited, i, j, ground);

                    oilLands.add(new OilLand(ground));
                }
            }
        }


        // 석유 있는 열
        int[] oilHaveColumn = new int[m];
        for(OilLand oil : oilLands) {
            Set<Integer> set = new HashSet<>();

            for(int[] xy : oil.oilXy) {
                set.add(xy[1]);
            }

            for(int s : set) {
                oilHaveColumn[s] += oil.size;
            }
        }

        return Arrays.stream(oilHaveColumn).boxed().mapToInt(Integer::intValue).max().getAsInt();
    }

    public static void dfs(int[][] land, boolean[][] visited, int x, int y, List<int[]> ground) {
        int n = land.length;
        int m = land[0].length;

        ArrayDeque<int[]> stack = new ArrayDeque<>();

        int[] xy = new int[]{x, y};

        stack.push(xy);
        visited[x][y] = true;
        ground.add(xy);

        while(!stack.isEmpty()) {
            int[] currentXy = stack.pop();
            int currentX = currentXy[0];
            int currentY = currentXy[1];

            for(int i=0; i<4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                int[] xyArr = new int[]{nextX, nextY};

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY] && land[nextX][nextY]==1) {
                    stack.push(xyArr);
                    visited[nextX][nextY] = true;
                    ground.add(xyArr);
                }
            }
        }
    }


    static class OilLand {
        List<int[]> oilXy;
        int size;

        public OilLand(List<int[]> xy) {
            this.oilXy = xy;
            this.size = xy.size();
        }
    }
}
