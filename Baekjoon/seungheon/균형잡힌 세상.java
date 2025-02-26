import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String t;
        while (!(t = br.readLine()).equals(".")) {
            if (isBalanced(t)) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            bw.newLine();
        }
        bw.flush();
        
        br.close();
        bw.close();
    }
    
    static boolean isBalanced(String t) {
        Deque<Character> s = new ArrayDeque<>();
        for (char c : t.toCharArray()) {
            if (c == '(' || c == '[') {
                s.push(c);
            } else if (c == ')' || c == ']') {
                if (s.isEmpty() ||
                   (s.peek() == '(' && c != ')') ||
                   (s.peek() == '[' && c != ']')) {
                    return false;
                } else {
                    s.pop();
                }
            }
        }
        
        return s.isEmpty();
    }
}
