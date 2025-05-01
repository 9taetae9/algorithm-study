package org.example;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    int[] solution = solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
        new int[]{500, 600, 150, 800, 2500});
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }
  public static int[] solution(String[] genres, int[] plays) {
    Map<String, Integer> genreTotalMap = new HashMap<>();
    Map<String, List<Point>> genreSongMap = new HashMap<>();
    for( int i=0; i<genres.length; i++ ) {
      String genre = genres[i];
      int play = plays[i];

      genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 0) + play);
      genreSongMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Point(i, play));
    }
    List<String> sortedGenres = new ArrayList<>(genreTotalMap.keySet());
    sortedGenres.sort((a,b)->genreTotalMap.get(b) - genreTotalMap.get(a));

    List<Integer> result = new ArrayList<>();
    for (String genre : sortedGenres) {
      List<Point> songs = genreSongMap.get(genre);
      songs.sort((a, b) -> {
        if (b.y != a.y) return b.y - a.y;
        return b.x - a.x;
      });

      for (int i = 0; i < Math.min(2, songs.size()); i++) {
        result.add(songs.get(i).x);
      }
    }

    return result.stream().mapToInt(i -> i).toArray();
  }
}
