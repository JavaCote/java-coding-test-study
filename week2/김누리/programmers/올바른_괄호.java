package week2.김누리.programmers;

import java.util.Stack;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 올바른_괄호
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 05.     김누리               풀이 완료
 */
public class 올바른_괄호 {
	boolean solution(String s) {
		boolean answer = true;
		Stack<String> stk = new Stack<>();

		String[] arr = s.split("");

		for(String s2 : arr) {
			String tmp = s2;

			if(stk.isEmpty()) {
				stk.push(tmp);
			} else if(stk.peek().equals("(") && tmp.equals(")")) {
				stk.pop();
			} else {
				stk.push(tmp);
			}
		}

		if(!stk.isEmpty()) {
			answer = false;
		}

		return answer;
	}
}
