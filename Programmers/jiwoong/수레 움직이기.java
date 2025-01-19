package org.example;


import java.util.Objects;

/**
 * Point 클래스는 좌표를 나타내는 단순한 데이터 구조입니다.
 * x 와 y 값이 같은지에 따라 동등성을 판별합니다.
 */
class Point {
  int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

}

/**
 * redStart, blueStart : 각 공의 시작위치
 * redGoal, blueGoal : 각 공의 목적지
 *
 */
class Solution {
  int n, m;
  Point redStart, redGoal, blueStart, blueGoal;
  int[] dx = {1, -1, 0, 0};
  int[] dy = {0, 0, 1, -1};
  int ans = Integer.MAX_VALUE;

  public int solution(int[][] maze) {

    n = maze.length;
    m = maze[0].length;

    boolean[][] redVisited = new boolean[n][m];
    boolean[][] blueVisited = new boolean[n][m];

    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        if (maze[i][j] == 1) redStart = new Point(i, j);
        else if (maze[i][j] == 2) blueStart = new Point(i, j);
        else if (maze[i][j] == 3) redGoal = new Point(i, j);
        else if (maze[i][j] == 4) blueGoal = new Point(i, j);
      }
    }

    redVisited[redStart.x][redStart.y] = true;
    blueVisited[blueStart.x][blueStart.y] = true;
    backtrack(0, maze, redVisited, blueVisited, blueStart, redStart);
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }

  /**
   *
   * @param cnt backtracking 의 깊이를 나타냅니다
   * @param maze 검증 로직에서 넘겨받을 기존 maze 입니다
   * @param redVisited 빨간 공이 방문한 visited 배열
   * @param blueVisited 파란 공이 방문한 visited 배열
   * @param curBlue 현재 파란공 좌표
   * @param curRed 현재 빨간공 좌표
   */

  void backtrack(int cnt, int[][] maze, boolean[][] redVisited, boolean[][] blueVisited, Point curBlue, Point curRed) {

    if (cnt >= ans) return;

    if (curRed.equals(redGoal) && curBlue.equals(blueGoal)) {
      ans = cnt;
      return;
    }

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {

        // 공이 목적지에 있다면 움직이지 않도록
        Point nextRed = (curRed.equals(redGoal)) ? redGoal : new Point(curRed.x + dx[i], curRed.y + dy[i]);
        Point nextBlue = (curBlue.equals(blueGoal)) ? blueGoal : new Point(curBlue.x + dx[j], curBlue.y + dy[j]);

        // 공이 목적지에 있다면 검증 로직을 돌 필요가 없음
        if(!nextRed.equals(redGoal) && !isPossible(nextRed, maze, redVisited)) continue;
        if(!nextBlue.equals(blueGoal) && !isPossible(nextBlue, maze, blueVisited)) continue;

        // 다음 공 위치는 같을 수 없음
        if(nextRed.equals(nextBlue)) continue;

        // swap 은 불가능
        if(nextRed.equals(curBlue) && nextBlue.equals(curRed)) continue;

        redVisited[nextRed.x][nextRed.y] = true;
        blueVisited[nextBlue.x][nextBlue.y] = true;

        backtrack(cnt + 1, maze, redVisited, blueVisited, nextBlue, nextRed);

        redVisited[nextRed.x][nextRed.y] = false;
        blueVisited[nextBlue.x][nextBlue.y] = false;
      }
    }
  }


  boolean isPossible(Point point, int[][] maze, boolean[][] visited){
    if(point.x < 0 || point.y < 0 || point.x >= n || point.y >= m) return false;
    if(maze[point.x][point.y] == 5) return false;
    if(visited[point.x][point.y]) return false;

    return true;
  }
}
