package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    int solution = solution2(new int[]{3, 0, 6, 1, 5, 7});
    System.out.println("solution = " + solution);
  }
  public int solution(int[] citations) {
    int h = 0;
    Arrays.sort(citations);

    int lo = 0, hi = citations.length;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      int ref = 0, left = 0;

      for (int i = 0; i < citations.length; i++) {
        if (mid <= citations[i])
          ref++;
        else if (mid >= citations[i])
          left++;
      }

      if (ref >= mid && left <= mid) {
        h = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return h;
  }

  public static int solution2(int[] citations) {
    int answer = 0;
    Arrays.sort(citations);

    for (int i = 0; i < citations.length; i++) {
      int discussionCount = citations.length - i;

      if (citations[i] >= discussionCount) {
        answer = discussionCount;
        break;
      }
    }
    return answer;
  }
}
