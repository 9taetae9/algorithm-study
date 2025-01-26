import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
        
      int[] arr = new int[N];
      int start = 0;
      int end = 0;
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; ++i) {
        arr[i] = Integer.parseInt(st.nextToken());
          
        start = Math.max(start, arr[i]);
        end += arr[i];
      }
        
      while (start <= end) {
        int middle = (start + end) / 2;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; ++i) {
          if (sum + arr[i] > middle) {
            count++;
            sum = 0;
          }
          sum += arr[i];
        }
            
        if (sum != 0) count++;
            
        if (count > M) start = middle +1;
        else end = middle -1;
      }
        
      bw.write(Integer.toString(start));
        
      br.close();
      bw.close();
  }
}
