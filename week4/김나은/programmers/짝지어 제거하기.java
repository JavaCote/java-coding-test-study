package week4.김나은.programmers;

import java.util.*;

class Solution {
    public int solution(String s) {
        // 문자 짝을 판별하기 위한 스택 생성
        Stack<Character> stack = new Stack<>();

        // 입력 문자열 s를 문자 배열로 변환 후 한 글자씩 순회
        for(char c : s.toCharArray()) {

            // 스택이 비어있지 않고, 현재 문자가 스택의 top(가장 위) 문자와 같으면
            if(stack.size() > 0 && stack.peek() == c) {

                stack.pop(); // 같은 문자가 연속된 것이므로 쌍으로 제거 (pop)

            } else {

                stack.push(c); // 아니면 스택에 현재 문자 추가

            }
        }

        // 스택이 비어있으면 모든 문자가 짝지어 제거된 상태
        return stack.isEmpty() ? 1 : 0;
    }
}