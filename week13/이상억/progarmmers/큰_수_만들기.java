/**
 * PackageName : week13.이상억.progarmmers;
 * FileName    : 큰_수_만들기
 * Author      : sangeok
 * Date        : 2025. 07. 24.
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 24.     sangeok               Initial creation
 */


import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();

        for (int i = 0; i < len; i++) {
            char current = number.charAt(i);

            // 스택이 비어있지 않고, 제거 횟수가 남았고, 현재 숫자가 스택 top보다 클 때 pop
            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }

        // 아직 제거 안 한 수가 남은 경우 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택에 있는 문자를 StringBuilder로 연결
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
