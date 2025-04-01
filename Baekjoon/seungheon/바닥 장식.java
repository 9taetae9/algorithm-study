import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());
        
        char[][] f = new char[N][M];
        for (int r = 0; r < N; ++r) {
            String t = br.readLine();
            for (int c = 0; c < M; ++c) {
                f[r][c] = t.charAt(c);
            }
        }
        
        int cnt = 0;
        boolean isC;
        for (int r = 0; r < N; ++r) {
            isC = false;
            for (int c = 0; c < M; ++c) {
                if (f[r][c] != '-') {
                    isC = false;
                    continue;
                }
                
                if (isC) {
                    continue;
                }
                
                cnt++;
                isC = true;
            }
        }
        
        for (int c = 0; c < M; ++c) {
            isC = false;
            for (int r = 0; r < N; ++r) {
                if (f[r][c] != '|') {
                    isC = false;
                    continue;
                }
                
                if (isC) {
                    continue;
                }
                
                cnt++;
                isC = true;
            }
        }
        
        System.out.print(cnt);
    }
}
