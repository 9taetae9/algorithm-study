import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> s = new ArrayDeque<>();
        int cnt = 0;
        for (int m : moves) {
            int pick = -1;
            for (int i = 0; i < board.length; ++i) {
                int temp = board[i][m - 1];
                if (temp == 0) continue;

                pick = temp;
                board[i][m - 1] = 0;
                break;
            }

            if (pick == -1) continue;

            if (!s.isEmpty() && pick == s.peekLast()) {
                s.pollLast();
                cnt += 2;
                continue;
            }

            s.offerLast(pick);
        }

        return cnt;
    }
}
