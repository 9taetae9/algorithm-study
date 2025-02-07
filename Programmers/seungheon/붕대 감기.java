class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int h = health;
        int t = attacks[0][0];
        for (int[] a : attacks) {
            if (h < health) {
                int tt = a[0] - t - 1;
                h += tt * bandage[1];
                h += bandage[2] * (tt / bandage[0]);
                
                if (h > health) {
                    h = health;
                }
            }
            
            h -= a[1];
            
            if (h <= 0) return -1;
            
            t = a[0];
        }
        
        return h;
    }
}
