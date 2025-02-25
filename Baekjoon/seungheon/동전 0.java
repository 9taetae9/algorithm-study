import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] v = new int[N];
        while (N-- > 0) {
            v[N] = Integer.parseInt(br.readLine());
        }
        
        int cnt = 0;
        for (int n : v) {
            while (K - n >= 0) {
                K -= n;
                cnt++;
            }
            
            if (K == 0) break;
        }
        
        System.out.println(cnt);
    }
}
