import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        for(int i : arr) {
            if(stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}