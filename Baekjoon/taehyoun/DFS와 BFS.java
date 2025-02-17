import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> order = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수
        int V = Integer.parseInt(st.nextToken()); //탐색 시작 번호

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());;
        }
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        for (List<Integer> l : list) {
            Collections.sort(l);
        }

        dfs(V);
        for (int n : order) {
            System.out.print(n+ " ");
        }

        order.clear();
        Arrays.fill(visited, false);

        System.out.println();
        bfs(V);
        for (int n : order) {
            System.out.print(n+ " ");
        }
    }

    private static void dfs(int cur) throws IOException {
        if(visited[cur]) return;
        visited[cur] = true;
        order.add(cur);

        for(int n : list.get(cur)){
            dfs(n);
        }
    }

    private static void bfs(int cur) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(cur);
        visited[cur] = true;
        while(!queue.isEmpty()){
            int n = queue.poll();
            order.add(n);

            for(int i : list.get(n)){
                if(!visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
