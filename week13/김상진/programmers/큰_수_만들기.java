package week13.김상진.programmers;

import java.util.Stack;

public class 큰_수_만들기 {
import java.util.*;

    class Solution {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();

            for (char currentDigit : number.toCharArray()) {
                while (k > 0 && !stack.isEmpty() && stack.peek() < currentDigit) {
                    stack.pop();
                    k--;
                }
                stack.push(currentDigit);
            }
            while (k > 0) {
                stack.pop();
                k--;
            }
            StringBuilder sb = new StringBuilder();
            for (char digit : stack) {
                sb.append(digit);
            }
            if (sb.length() == 0) {
                return "0";
            }
            String finalResult = sb.toString();
            if (finalResult.length() > number.length() - k) {
                finalResult = finalResult.substring(0, number.length() - k);
            }

            return finalResult;
        }
    }
}
