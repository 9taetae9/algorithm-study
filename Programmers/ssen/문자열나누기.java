public class Solution {
    public static int solution(String s) {
        int count = 0; // 분리된 문자열의 개수
        int i = 0;

        while (i < s.length()) {
            char x = s.charAt(i); // 첫 글자 x
            int countX = 0; // x의 개수
            int countOther = 0; // x가 아닌 다른 글자의 개수

            while (i < s.length()) {
                if (s.charAt(i) == x) {
                    countX++;
                } else {
                    countOther++;
                }

                i++;

                // x와 다른 글자의 개수가 같아지면 분리
                if (countX == countOther) {
                    break;
                }
            }

            count++; // 문자열을 분리했으므로 개수 증가
        }

        return count;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution("banana")); // Output: 3
        System.out.println(solution("abracadabra")); // Output: 6
        System.out.println(solution("aaabbaccccabba")); // Output: 3
    }
}
