package week2.강성욱.programmers;

import java.util.*;

public class 올바른_괄호 {
    class Solution {
        boolean solution(String s) {
            Deque<Character> dq = new ArrayDeque<>();

            for(char c : s.toCharArray()) {
                if (c == '(') {
                    dq.push(c);
                } else {
                    if (dq.isEmpty()) return false;
                    dq.pop();
                }
            }

            return dq.isEmpty() ? true : false;
        }
    }
}
