/**
 * PackageName : week6.이상억.progarmmers;
 * FileName    : 괄호_회전하기
 * Author      : sangeok
 * Date        : 2025. 6. 5.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 5.     sangeok               Initial creation
 */

//문제 요구사항 :	문자열 s가 매개변수로 주어짐 s 를 왼쪽으로 x 칸 만큼 회전 시켰을 때
//        s가 올바른 문자열이 되게 하는 x 의 개수 return

//        접근 방식 :	(1) deque 사용
//        1) 최대 s-1 번 만큼 반복
//        2) 맨 앞 값 뒤로 회전
//        3) "(" 의 형식의 괄호면 스택에 담기 아니면 스택에 값 pop 해서 비교

// 회고 : 자료구조에 대한 이해가 아직 부족한 것 같다. 아직 머리에 자유자재로 그려지지가 않는다.
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }

        for (int i = 0; i < deque.size(); i++) {
            if (isValid(deque)) {
                answer++;
            }
            char front = deque.pollFirst();
            deque.addLast(front);
        }

        return answer;
    }

    public boolean isValid(Deque<Character> dq) {
        Stack<Character> stack = new Stack<>();

        for (char c : dq) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
