class Solution {
    public String addBinary(String a, String b) {
        int max = Math.max(a.length(), b.length());
        int min = Math.min(a.length(), b.length());

        StringBuilder sb = new StringBuilder(max + 1);
        while (sb.length() + min < max) sb.append('0');

        if      (a.length() < max) a = sb.toString() + a;
        else if (b.length() < max) b = sb.toString() + b;

        sb.setLength(0);
        int c = 0;
        for (int i = max - 1; i >= 0; --i) {
            int sum = a.charAt(i) - '0' + b.charAt(i) - '0';
            
            if (c != 0) {
                sum += c;
                c = 0;
            }

            if (sum >= 2) {
                c = 1;
                sb.insert(0, sum % 2);
                continue;
            }

            sb.insert(0, sum);
        }

        if (c == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
