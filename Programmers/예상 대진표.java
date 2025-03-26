package org.example;

import java.util.*;
import java.io.*;

public class TodayAlgorithm {

  public static void main(String[] args) {
    int solution = solution(16, 9, 11);
    System.out.println("solution = " + solution);
  }

  public static int solution(int n, int a, int b) {
    //12985 - 예상 대진표
    //97.2%
    double log2 = Math.log(n) / Math.log(2);
    double result = 0;
    int mid = n / 2;
    int midHelp = mid;
    for (int i = 0; i <= log2; i++) {
      if (a <= mid && b > mid ){
        result = log2 - i;
        break;
      }else if (a > mid && b <= mid) {
        result = log2 - i;
        break;
      }
      //
      if(a < mid){
        midHelp = midHelp/2;
        mid = mid - midHelp;
      }else if (a > mid) {
        midHelp = midHelp/2;
        mid = mid + midHelp;
      }
    }
    return (int) result;
  }
  //정답코드
  int answer = 0;
        
        // a와 b가 다르면 반복
        while (a != b) {
            // a와 b를 각각 2로 나눈 몫과 나머지와 더함
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;

            // answer 증가(라운드 증가)
            answer++;
        }

        return answer;
출처: https://ittrue.tistory.com/513 [IT is True:티스토리]
}
