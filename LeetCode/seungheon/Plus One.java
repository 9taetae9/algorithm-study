class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int d : digits) sb.append(d);

        StringBuilder sub = new StringBuilder(sb.length());
        for (int i = 0; i < sb.length() - 1; ++i) sub.append('0');
        sub.append('1');

        Deque<Integer> res = new ArrayDeque<>(sub.length());
        int c = 0;
        for (int i = sb.length() - 1; i >= 0; --i) {
            int t1 = sb.charAt(i) - '0';
            int t2 = sub.charAt(i) - '0';
            int sum = t1 + t2;

            if (c > 0) {
                sum++;
                c = 0;
            }

            if (sum > 9) {
                c = 1;
                sum = 0;
            }

            res.offerFirst(sum);
        }

        if (c > 0) {
            res.offerFirst(c);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 모범 답안
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        
        return digits;
    }
}
