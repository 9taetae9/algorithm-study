import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Main {
    private static final int   EMPTY = 0;
    private static final int   EXIST = 1;
    private static final int   MAX   = 20;
    private static final int[] set   = new int[MAX + 1];
    
    public static void main(String[] args) throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            
            if (command.equals("all")) {
                all(); continue;
            }
            if (command.equals("empty")) {
                empty(); continue;
            }
            
            int x = Integer.parseInt(st.nextToken());
            switch (command) {
                case "add"   : add(x);    break;
                case "remove": remove(x); break;
                case "toggle": toggle(x); break;
                case "check" : bw.write(String.valueOf(check(x))); bw.newLine(); break;
                default      : System.exit(1);
            }
        }
        
        br.close();
        bw.close();
    }
    
    private static void add(int x) {
        set[x] = EXIST;
    }
    
    private static void remove(int x) {
        set[x] = EMPTY;
    }
    
    private static int check(int x) {
        return set[x];
    }
    
    private static void toggle(int x) {
        if (check(x) == EMPTY) add(x);
        else                   remove(x);
    }
    
    private static void all() {
        IntStream.rangeClosed(1, MAX).forEach(i -> set[i] = EXIST);
    }
    
    private static void empty() {
        IntStream.rangeClosed(1, MAX).forEach(i -> set[i] = EMPTY);
    }
}

// 개선
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Main {
    private static final int EMPTY = 0;
    private static final int EXIST = 1;
    private static final int MAX   = 20;
    private static int set = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("all")) {
                all(); continue;
            }
            if (command.equals("empty")) {
                empty(); continue;
            }

            int x = Integer.parseInt(st.nextToken());
            switch (command) {
                case "add"   : add(x);    break;
                case "remove": remove(x); break;
                case "toggle": toggle(x); break;
                case "check" : bw.write(String.valueOf(check(x))); bw.newLine(); break;
                default      : System.exit(1);
            }
        }

        br.close();
        bw.close();
    }

    private static void add(int x) {
        set |= 1 << (x - 1);
    }

    private static void remove(int x) {
        set &= ~(1 << (x - 1));
    }

    private static int check(int x) {
        if ((set & (1 << (x - 1))) == 0)
            return EMPTY;

        return EXIST;
    }

    private static void toggle(int x) {
        if (check(x) == EMPTY) add(x);
        else                   remove(x);
    }

    private static void all() {
        IntStream.rangeClosed(1, MAX).forEach(Main::add);
    }

    private static void empty() {
        IntStream.rangeClosed(1, MAX).forEach(Main::remove);
    }
}
