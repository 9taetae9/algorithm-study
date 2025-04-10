class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int n1 = arr1.length;
        int m1 = arr1[0].length;
        int m2 = arr2[0].length;
        
        int[][] arr3 = new int[n1][m2];
        for (int r = 0; r < n1; ++r) {
            for (int c = 0; c < m2; ++c) {
                for (int k = 0; k < m1; ++k) {
                    arr3[r][c] += arr1[r][k] * arr2[k][c];
                }
            }
        }
        
        return arr3;
    }
}
