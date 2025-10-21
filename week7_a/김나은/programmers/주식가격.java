package week7_a.김나은.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격 {

    class Solution {

        public int[] solution(int[] prices) {

            // 각 시점별로 '가격이 떨어지지 않은 기간(초)'을 저장할 배열
            int[] answer = new int[prices.length];

            // 스택에는 아직 '가격이 떨어지지 않은 시점(index)'을 저장
            Deque<Integer> stack = new ArrayDeque<>();

            // 모든 시점을 순회
            for (int i = 0; i < prices.length; i++) {
                // 스택이 비어있지 않고, 현재 가격이 스택 top의 가격보다 낮으면, 가격 하락 발생
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    // 떨어진 시점의 index 꺼냄
                    int prev = stack.pop();
                    // 현재 시점 i까지 걸린 시간 저장
                    answer[prev] = i - prev;
                }
                // 아직 안 떨어진 시점(index)을 스택에 저장
                stack.push(i);
            }

            // 끝까지 가격이 안 떨어진 시점들 처리
            while (!stack.isEmpty()) {
                int prev = stack.pop();
                // 마지막까지 안 떨어졌으므로 남은 전체 시간
                answer[prev] = prices.length - prev - 1;
            }

            return answer;
        }
    }
}
