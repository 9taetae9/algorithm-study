import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int tmp = 0;
        int max = 2;
        for (int i = 0; i < N; ++i) {
            int b = Integer.parseInt(st.nextToken());
            arr[i] = b;
            max = Math.max(max, b);
            tmp += b;
        }
        
        if (tmp <= total) {
            System.out.print(max);
            return;
        }
        
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; ++i) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }
            if (sum <= total) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
