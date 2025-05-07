package week2.김나은.programmers;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (char item : s.toCharArray()) {
            if (item == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}