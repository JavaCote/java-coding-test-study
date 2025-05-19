package week4.김누리.programmers;

import java.util.Stack;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 짝지어_제거하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-19
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 19.     김누리(NRKim)               Initial creation
 */

/*
Stack 문제.

s를 문자열 배열로 만들고 Stack의 Peek와 s[i]와 값이 동일하지 않은 경우에만
stack에 push하면 되는 간단한 문제

*/

public class 짝지어_제거하기 {
	public int solution(String s)
	{
		int answer = -1;
		String[] tmp = s.split("");
		Stack<String> stk = new Stack<>();

		for(String s2 : tmp) {
			if(stk.isEmpty() || !stk.peek().equals(s2)) {
				stk.push(s2);
			} else if(stk.peek().equals(s2)) {
				stk.pop();
			}
		}

		answer = (stk.isEmpty()) ? 1 : 0;

		return answer;
	}
}
