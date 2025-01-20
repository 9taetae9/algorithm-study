package Programmers_140108;

public class Solution {
    public static void main(String[] args) {
        String s = "abracadabra";
        int result = countSegments(s);
        System.out.println("Segments count: " + result);
    }

    static int countSegments(String s) {
        int count = 0;
        int same = 0;
        int diff = 0;
        char x = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == x) {
                same++;
            } else {
                diff++;
            }
            if (same == diff) {
                count++;
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
                same = 0;
                diff = 0;
            }
        }

        if (same != 0 || diff != 0) {
            count++;
        }
        return count;
    }
}
