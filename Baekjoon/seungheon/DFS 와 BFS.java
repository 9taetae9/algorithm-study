import java.util.*;
import java.io.*;

class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<List<Integer>> adj = new ArrayList<>(1_001);
    static boolean[] visited = new boolean[1_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int v = 0; v <= N; ++v) {
            adj.add(new LinkedList<>());
        }
        
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int v = 1; v <= N; ++v) {
            Collections.sort(adj.get(v));
        }

        Arrays.fill(visited, false);
        dfs(V);
        bw.newLine();

        Arrays.fill(visited, false);
        bfs(V);
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static void dfs(int v) throws IOException {
        if (visited[v]) return;

        visited[v] = true;
        bw.write(v + " ");

        for (int u : adj.get(v)) {
            if (!visited[u]) {
                dfs(u);
            }
        }
    }

    static void bfs(int s) throws IOException {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            bw.write(v + " ");

            for (int u : adj.get(v)) {
                if (!visited[u]) {
                    visited[u] = true;
                    q.offer(u);
                }
            }
        }
    }
}
