package week13_a.김누리.progarmmers;

import java.util.Stack;

/**
 * PackageName : week13_a.김누리.progarmmers
 * FileName    : 짝지어_제거하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-01
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 01.     김누리(NRKim)               Initial creation
 */

public class 짝지어_제거하기 {
	public int solution(String s) {
		int answer = -1;
		String[] tmp = s.split("");
		Stack<String> stk = new Stack<>();

		for(String t : tmp) {
			if(stk.isEmpty() || !stk.peek().equals(t)) stk.push(t);
			else stk.pop();
		}

		return answer = stk.isEmpty() ? 1 : 0;
	}
}
