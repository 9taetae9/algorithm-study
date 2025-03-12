import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            List<List<Integer>> adj = new ArrayList<>(N + 1);
            for (int i = 0; i <= N; ++i) {
                adj.add(new LinkedList<>());
            }
            
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                
                adj.get(v).add(u);
                adj.get(u).add(v);
            }
            
            boolean[] visited = new boolean[N + 1];
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(1);
            visited[1] = true;
            
            int cnt = 0;
            while (!q.isEmpty()) {
                int v = q.poll();
                
                for (int u : adj.get(v)) {
                    if (!visited[u]) {
                        visited[u] = true;
                        q.offer(u);
                        cnt++;
                    }
                }
            }
            
            System.out.println(cnt);
        }
    }
}

// MST 성질 이용 답안
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            while (M-- > 0) {
                br.readLine();
            }
            
            System.out.println(N - 1);
        }
    }
}
