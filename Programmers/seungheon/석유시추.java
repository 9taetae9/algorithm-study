import java.util.*;

class Solution {
    private static final int[][] dir = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };
    
    private static int dfs(int[][] land, int x, int y, int id) {
        if (land[x][y] != 1) return 0;
        
        int size = 1;
        land[x][y] = id;
        
        for (int d = 0; d < 4; ++d) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            
            if (nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length) {
                size += dfs(land, nx, ny, id);
            }
        }
        
        return size;
    }
    
    public int solution(int[][] land) {
        Map<Integer, Integer> table = new HashMap<>();
        Set<Integer> usedId = new HashSet<>();
        int chunkId = 2;
        int maxOil  = 0;
        for (int col = 0; col < land[0].length; ++col) {
            int rowOil = 0;
            for (int row = 0; row < land.length; ++row) {
                if (land[row][col] == 1) {
                    int chunkSize = dfs(land, row, col, chunkId);
                    table.put(chunkId++, chunkSize);
                }
                
                int cell = land[row][col];
                if (!usedId.contains(cell) && table.containsKey(cell)) {
                    rowOil += table.get(cell);
                    usedId.add(cell);
                }
            }
            usedId.clear();
            maxOil = Math.max(maxOil, rowOil);
        }
        
        return maxOil;
    }
}
