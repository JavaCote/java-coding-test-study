package week10.김상진.programmers;

import java.util.Stack;

public class 택배상자 {
import java.util.*;

    class Solution {
        public int solution(int[] order) {
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            int count = 0;

            for (int i = 1; i <= order.length; i++) {
                stack.push(i);

                while (!stack.isEmpty() && stack.peek() == order[index]) {
                    stack.pop();
                    count++;
                    index++;
                }
            }

            return count;
        }
    }

}
