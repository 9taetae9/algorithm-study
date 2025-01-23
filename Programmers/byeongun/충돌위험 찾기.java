package org.example;

import java.awt.*;
import java.util.*;

public class TodayAlgorithm {

    public static void main(String[] args) {
        /*
        *
        * [[3, 2], [6, 4], [4, 7], [1, 4]], [[4, 2], [1, 3], [4, 2], [4, 3]]
        * */
        int[][] points = {
                {3, 2},
                {6, 4},
                {4, 7},
                {1, 4}
        };

        int[][] routes = {
                {4, 2},
                {1, 3},
                {4, 2},
                {4, 3}
        };
        solution(points, routes);
    }

    static Map<Integer, Map<Integer, Point>> node = new HashMap<>();
    static Map<Integer, Point> numbers = new HashMap();
    static Map<Integer, Point> nodes = new HashMap();

    public static int solution(int[][] points, int[][] routes) {
        //point는 번호 위치 의미
        //route는 4, 2 일 때 4번 노드가 2번에 가야함을 의미
        //다음 포인트로 이동할 때는 항상 최단 경로로 이동하며 최단 경로가 여러 가지일 경우, r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.
        int count = 1;
        for (int[] point : points) {
            numbers.put(count, new Point(point[0], point[1]));
            count++;
        }
        count = 1;
        for (int[] route : routes) {
            nodes.put(count, new Point(route[0], route[1]));
            count++;
        }//이거 제너레이터 가능?
        int nodeSize = nodes.size();
        //System.out.println("numbers = " + numbers);
        //System.out.println("nodes = " + nodes);
        //1. 각 번호의 최소 이동 횟수를 구함
        //2. 충돌 여부 확인 (노드, 움직인 수, 위치)
        for (int i = 1; i < nodeSize + 1; i++) {
            shortestPath(i, nodes.get(i).x, nodes.get(i).y);
        }
        count = 0;

        //여기서 충돌하는 부분 셈
        System.out.println("nodeSize = " + nodeSize);
        int max = 0;
        for (Map.Entry<Integer, Map<Integer, Point>> integerMapEntry : node.entrySet()) {
            max = Math.max(integerMapEntry.getValue().size(), max);
            System.out.println("integerMapEntry = " + integerMapEntry);
        }
        System.out.println("node = " + node.get(1));
        System.out.println("nodeSize = " + nodeSize);
        Set<Point> routeCheck = new HashSet<>();
        boolean[][] visited;
        System.out.println("max = " + max);
        for(int i=0; i<max+1; i++){
            routeCheck.clear();
            System.out.println(" 초기화! ");
            visited = new boolean[10][10]; //방문한 위치
            for(int j=1; j<nodeSize+1; j++){
                Point point = node.get(j).get(i); //각 노드의 포인터
                System.out.println("판별할 point = " + point);
                if(point == null){
                    System.out.println("point가 null입니다. ");
                    continue;
                } //null인 경우는 스킵
                if(routeCheck.contains(point) && !visited[point.x][point.y]){ //방문하지 않았고 같은 위치의 노드 존재
                    count++; //충돌
                    visited[point.x][point.y] = true; //방문함
                    System.out.println("충돌 감지");
                    System.out.println("point = " + point);
                    System.out.println("count = " + count);
                    System.out.println("============================");
                    continue;
                }
                routeCheck.add(point);
                if(visited[point.x][point.y]){ System.out.println("이미 방문 한 곳"); }
                else System.out.println("충돌 없음");
                System.out.println("point = " + point);
                System.out.println("============================");
            }
        }
        System.out.println("count = " + count);
        return count;
    }

    private static void shortestPath(int num, int x, int y) {
        Point startPoint = numbers.get(x);
        Point endPoint = numbers.get(y);
        node.put(num, new HashMap<>());
        Map<Integer, Point> shortRoute = node.get(num);
        int count = 1;

        shortRoute.put(count, new Point(startPoint.x, startPoint.y));
        count++;

        int currentX = startPoint.x;
        int currentY = startPoint.y;

        // x 방향 이동
        while (currentX != endPoint.x) {
            if (currentX < endPoint.x) {
                currentX++; // 오른쪽으로 이동
            } else {
                currentX--; // 왼쪽으로 이동
            }
            shortRoute.put(count, new Point(currentX, currentY));
            count++;
        }

        // y 방향 이동
        while (currentY != endPoint.y) {
            if (currentY < endPoint.y) {
                currentY++; // 아래로 이동
            } else {
                currentY--; // 위로 이동
            }
            shortRoute.put(count, new Point(currentX, currentY));
            count++;
        }
    }

}

