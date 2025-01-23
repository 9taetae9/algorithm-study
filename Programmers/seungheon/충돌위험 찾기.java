import java.util.*;

class Solution {
    int collisions = 0;
    Map<String, Integer> visited = new HashMap<>();
    
    void moveRobot(int r, int c, int er, int ec, int t, Queue<int[]> q) {
        if (r != er) 
            q.offer(new int[]{ r + (r < er ? 1 : -1), c, t + 1 });
        else if (c != ec) 
            q.offer(new int[]{ r, c + (c < ec ? 1 : -1), t + 1 });
    }
    
    int bfs(int sr, int sc, int er, int ec, int st) {
        int collision = 0;
        Queue<int[]> q = new ArrayDeque<>();
        
        if (st == 0)
            q.offer(new int[]{ sr, sc, st });
        else
            moveRobot(sr, sc, er, ec, st, q);

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int r = front[0], c = front[1], t = front[2];

            String key = r + "," + c + "," + t;
            visited.put(key, visited.getOrDefault(key, 0) + 1);
            
            if (visited.get(key) == 2)
                collisions++;

            if (r == er && c == ec)
                return t;

            moveRobot(r, c, er, ec, t, q);
        }

        return -1;
    }
    
    public int solution(int[][] points, int[][] routes) {
        for (int[] r : routes) {
            int currTime = 0;
            for (int i = 0; i < r.length - 1; ++i) {
                int sr = points[r[i] - 1][0];
                int sc = points[r[i] - 1][1];
                int er = points[r[i + 1] - 1][0];
                int ec = points[r[i + 1] - 1][1];
                
                currTime = bfs(sr, sc, er, ec, currTime);
            }
        }
        
        return collisions;
    }
}
