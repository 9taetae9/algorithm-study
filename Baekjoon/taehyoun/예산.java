//처음 제출 오답 원인 :  int low를 요청중 가장 작은 값으로 설정
//첫 통과코드 (low를 1로 설정 후 통과)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] requests;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    requests = new int[N];
//    int low = Integer.MAX_VALUE;
    int low = 1;
    int high = 0;
    for (int i = 0; i < N; i++) {
      requests[i] = Integer.parseInt(st.nextToken());
//      low = Math.min(low, requests[i]);
      high = Math.max(high, requests[i]);
    }

    int budget = Integer.parseInt(br.readLine());

    int optimal = 0;
    int optMid = low;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int actual = getBudget(mid);
      if( actual> budget){
        high = mid -1;
      } else {
        if(optimal < actual && optMid < mid){
          optimal = actual;
          optMid = mid;
        }
        low = mid + 1;
      }
    }

    System.out.println(optMid);

  }

  private static int getBudget(int mid) {
    int sum = 0;
    for (int request : requests) {
      sum += Math.min(request, mid);
    }
    return sum;
  }

}

//개선 코드
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
  static int[] requests;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    requests = new int[N];
    int maxRequest = 0;
    for (int i = 0; i < N; i++) {
      requests[i] = Integer.parseInt(st.nextToken());
      maxRequest = Math.max(maxRequest, requests[i]);
    }


    int budget = Integer.parseInt(br.readLine());

    int low = 1;
    int high = maxRequest;
    int result = 0;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      int sum = getBudget(mid);

      if (sum <= budget) {
        result = mid;
        low = mid + 1;
      }else{
        high = mid - 1;
      }
    }

    System.out.println(result);

  }

  private static int getBudget(int mid) {
    int sum = 0;
    for (int request : requests) {
      sum += Math.min(request, mid);
    }
    return sum;
  }

}

