import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(x);
        visited.add(x);
        
        int operations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                int[] nextValues = {current + n, current * 2, current * 3};
                
                for (int next : nextValues) {
                    if (next == y) return operations + 1; 
                    if (next < y && !visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            operations++;
        }
        
        return -1; 
    }
}
