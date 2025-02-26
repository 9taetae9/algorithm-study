package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TodayAlgorithm {
    public static void main(String[] args) throws IOException {
        //균형잡힌 세상 - 4949
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equals(".")) {
            if (isBalanced1(line)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }


    }
    private static boolean isBalanced2(String line) {
        Stack<Character> stack = new Stack<>();

        for (char ch : line.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }

        return true;
    }
    private static boolean isBalanced1(String line) {
        String[] split = line.split("");
        String stopString = "";
        Queue<String> queue = new LinkedList<>();
        while (!stopString.equals(".")) {
            for (String s : split) {
                stopString = s;
                //System.out.println("stopString = " + stopString);
                if( stopString.equals( ".")) break;
                if( stopString.equals("(") || stopString.equals(")") || stopString.equals("[") || stopString.equals("]") ) {
                    queue.add(stopString);
                }
            }

        }
        // ( [ ) ] 이런 경우 잡아야 될 거 같은데
        //일단 닫았을 때 옆에가 열린 같은 속성
        Stack<String> storeStack = new Stack<>();
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if( poll.equals("(") || poll.equals("[")) {
                storeStack.push(poll);
            }
            else if( poll.equals(")")) {
                //짝 맞는 지 확인
                if(storeStack.isEmpty()) return false;
                if( storeStack.peek().equals("(") ) {
                    System.out.println(storeStack.pop());
                }else {
                    System.out.println("poll = " + poll);
                    System.out.println("storeStack = " + storeStack.peek());
                    return false;
                }
            }else if(poll.equals("]")) {
                //짝 맞는 지 확인
                if(storeStack.isEmpty()) return false;
                if( storeStack.peek().equals("[") ) {
                    System.out.println(storeStack.pop());
                }else {
                    System.out.println("poll = " + poll);
                    System.out.println("storeStack = " + storeStack.peek());
                    return false;
                }
            }
        }
        return true;
        //stack 하나로 통일 
    }


}
