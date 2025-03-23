import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostArr = new ArrayList<>();
        List<Integer> reserveArr = new ArrayList<>();
        
        for (int l : lost) lostArr.add(l);
        for (int r : reserve) reserveArr.add(r);
        
        Iterator<Integer> it = lostArr.iterator();
        while (it.hasNext()) {
            int l = it.next();
            if (reserveArr.contains(l)) {
                it.remove();
                reserveArr.remove(Integer.valueOf(l));
            }
        }
        
        Collections.sort(lostArr);
        Collections.sort(reserveArr);
        
        int cnt = 0;
        for (int l : lostArr) {
            if (reserveArr.contains(l - 1)) {
                reserveArr.remove(Integer.valueOf(l - 1));
                cnt++;
            } else if (reserveArr.contains(l + 1)) {
                reserveArr.remove(Integer.valueOf(l + 1));
                cnt++;
            }
        }
        
        return n - lostArr.size() + cnt;
    }
}
