package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TodayAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int bitmask = 0;

        for (int i = 0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            switch (command) {
                case "add":
                    int addNum = Integer.parseInt(input[1]);
                    bitmask |= (1 << (addNum - 1));
                    break;
                case "remove":
                    int removeNum = Integer.parseInt(input[1]);
                    bitmask &= ~(1 << (removeNum - 1));
                    //0100 -> 1011 로 바꾼 후 &연산(둘 다 1일 때 1반환)
                    break;
                case "check":
                    int checkNum = Integer.parseInt(input[1]);
                    System.out.println(((bitmask & (1 << (checkNum - 1))) != 0 ? 1 : 0));
                    break;
                case "toggle":
                    int toggleNum = Integer.parseInt(input[1]);
                    bitmask ^= (1 << (toggleNum - 1)); // 해당 비트를 반전
                    break;
                case "all":
                    bitmask = (1 << 20) - 1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }
    }
}
