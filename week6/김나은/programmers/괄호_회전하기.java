package week6.김나은.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호_회전하기 {

    class Solution {

        public int solution(String s) {

            int count = 0; // 유효한 괄호 문자열의 개수를 저장할 변수

            // 문자열의 길이만큼 회전하며 검사
            for (int i = 0; i < s.length(); i++) {
                // 문자열을 왼쪽으로 한 칸 회전시키기 위한 작업

                char firstChar = s.charAt(0); // 맨 앞 문자 하나 저장
                s = s.substring(1, s.length()); // 앞 문자 제외한 나머지 문자열 추출
                s = s + firstChar; // 저장해둔 앞 문자를 맨 뒤에 붙여 회전 완료
                boolean isCheck = check(s); // 회전된 문자열이 유효한 괄호 문자열인지 확인

                if (isCheck == true) { // 유효한 경우 개수 증가
                    count++;
                }
            }
            return count;
        }

        private boolean check(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            // 주어진 문자열 s를 문자 배열로 변환한 후 향상된 for문을 사용해 한 글자씩 순회
            for (Character c : s.toCharArray()) {
                // 여는 괄호인 경우, 스택에 넣어준다.
                if (c.equals('[') || c.equals('{') || c.equals('(')) {
                    stack.push(c);
                    // 여는 괄호인 경우 아래 조건문을 검사할 필요 없으므로
                    continue;
                }

                // 여는 괄호가 없는데, 닫는 괄호부터 오는 경우 false
                if (stack.isEmpty()) {
                    return false;
                }

                // 닫는 괄호인 경우, 마지막에 넣은 괄호랑 매칭이 되는지 확인
                Character lastC = stack.peek();
                if ((lastC.equals('[') && c.equals(']')) ||
                        (lastC.equals('{') && c.equals('}')) ||
                        (lastC.equals('(') && c.equals(')'))) {
                    stack.pop();
                    continue;
                }

                // 닫는 괄호인 경우, 스택 마지막 문자(여는 괄호)가 짝이 맞지 않는 경우
                return false;
            }

            // 스택이 비어있는 경우, 올바른 괄호 문자열
            if (stack.isEmpty() == true) {
                return true;
            }
            // 스택이 남아있는 경우, 열고 닫지 않은 괄호가 있음
            return false;
        }
    }
}