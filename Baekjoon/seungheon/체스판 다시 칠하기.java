import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] b = new char[N][M];
        for (int r = 0; r < N; ++r) {
            String tmp = br.readLine();
            for (int c = 0; c < M; ++c) {
                b[r][c] = tmp.charAt(c);
            }
        }
        
        char[] cs = { 'W', 'B' };
        int min = 987_654_321;
        for (int r = 0; r <= N - 8; ++r) {
            for (int c = 0; c <= M - 8; ++c) {
                for (char s : cs) {
                    int cnt = 0;
                    for (int k = r; k < r + 8; ++k) {
                        for (int l = c; l < c + 8; ++l) {
                            char p;
                            
                            if ((k + l) % 2 == 0) {
                                p = s;
                            } else {
                                p = (s == 'B') ? 'W' : 'B';
                            }
                            
                            if (b[k][l] != p) cnt++;
                        }
                    }
                    
                    min = Math.min(min, cnt);
                }
            }
        }
        
        System.out.print(min);
    }
}
