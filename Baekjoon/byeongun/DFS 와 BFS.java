package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TodayAlgorithm {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //DFS와 BFS - 1260
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);  // 노드 개수
        int M = Integer.parseInt(split[1]);  // 간선 개수
        int startNode = Integer.parseInt(split[2]); // 시작 노드
        visited = new boolean[N + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (List<Integer> neighbors : graph.values()) {
            Collections.sort(neighbors);
        }

        dfs(graph, startNode);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(graph, startNode);
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int node) {
        visited[node] = true;
        System.out.print(node + " ");

        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dfs(graph, neighbor);
                }
            }
        }
    }

    private static void bfs(Map<Integer, List<Integer>> graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
    }
}
