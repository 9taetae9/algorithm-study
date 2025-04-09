import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] g = new char[n][n];

        for (int i = 0; i < n; ++i) {
            g[i] = br.readLine().toCharArray();
        }

        long max = 0;
        for (int i = 0; i < n; ++i) {
            boolean[] v = new boolean[n];

            for (int j = 0; j < n; ++j) {
                if (i == j) continue;

                if (g[i][j] == 'Y') {
                    v[j] = true;
                    continue;
                }
                
                for (int k = 0; k < n; ++k) {
                    if (g[i][k] == 'Y' && g[k][j] == 'Y') {
                        v[j] = true;
                        break;
                    }
                }
            }

            long cnt = IntStream.range(0, v.length)
                .filter(idx -> v[idx])
                .count();

            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}
