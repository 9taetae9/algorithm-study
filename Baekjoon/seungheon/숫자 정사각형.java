import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] t = new String[N];
        for (int i = 0; i < N; ++i) {
            t[i] = br.readLine();
        }
        
        int p = Math.min(N, M);
        int res = -1;
        while (true) {
            for (int r = 0; r <= N - p; ++r) {
                for (int c = 0; c <= M - p; ++c) {
                    char v1 = t[r].charAt(c);
                    char v2 = t[r].charAt(c + p - 1);
                    char v3 = t[r + p - 1].charAt(c);
                    char v4 = t[r + p - 1].charAt(c + p - 1);
                    
                    if (v1 == v2 && v2 == v3 && v3 == v4) {
                        res = p * p;
                    }
                }
            }
            
            if (res != -1) break;
            
            p--;
        }
        
        System.out.print(res);
    }
}
