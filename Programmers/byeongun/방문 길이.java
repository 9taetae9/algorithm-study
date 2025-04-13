package org.example;

import java.awt.Point;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TodayAlgorithm {

  static Set<Path> visitedPaths = new HashSet<>();

  public static void main(String[] args) {
    System.out.println(solution("ULURRDLLU"));
  }

  static class Path {
    Point from;
    Point to;
    public Path(Point from, Point to) {
      this.from = from;
      this.to = to;
    }
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Path)) return false;
      Path path = (Path) o;
      return (from.equals(path.from) && to.equals(path.to)) ||
          (from.equals(path.to) && to.equals(path.from));
    }
    @Override
    public int hashCode() {
      return Objects.hash(from) + Objects.hash(to);
    }
  }
  public static int solution(String dirs) {
    Point now = new Point(0, 0);
    for (char dir : dirs.toCharArray()) {
      Point next = new Point(now);
      switch (dir) {
        case 'U': next.y += 1; break;
        case 'D': next.y -= 1; break;
        case 'R': next.x += 1; break;
        case 'L': next.x -= 1; break;
      }
      if (next.x < -5 || next.x > 5 || next.y < -5 || next.y > 5) continue;
      visitedPaths.add(new Path(new Point(now), new Point(next)));
      now = next;
    }

    return visitedPaths.size();
  }
}
