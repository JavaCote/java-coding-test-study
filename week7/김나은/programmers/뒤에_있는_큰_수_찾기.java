package week7.김나은.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 뒤에_있는_큰_수_찾기 {

    class Solution {

        public int[] solution(int[] numbers) {

            int[] answer = new int[numbers.length];

            // 인덱스를 저장할 스택 (Deque 사용, LIFO 구조)
            Deque<Integer> stack = new ArrayDeque<>();

            // 배열을 순회하면서
            for (int i = 0; i < numbers.length; i++) {
                // 현재 숫자가 스택의 top에 해당하는 인덱스의 값보다 크다면
                // 해당 인덱스에 대한 "뒤에 있는 큰 수"를 찾은 것
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    // 스택에서 인덱스를 꺼내고
                    int index = stack.pop();
                    // 해당 위치에 현재 숫자를 저장
                    answer[index] = numbers[i];
                }
                // 현재 인덱스를 스택에 추가 (아직 뒤에 있는 큰 수를 못 찾은 상태)
                stack.push(i);
            }

            // 스택에 남아있는 인덱스들은 "뒤에 있는 큰 수"가 없었던 것
            while (!stack.isEmpty()) {
                int index = stack.pop();
                answer[index] = -1; // 뒤에 더 큰 수가 없으므로 -1 설정
            }

            return answer; // 결과 배열 반환
        }
    }
}