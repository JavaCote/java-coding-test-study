package week2.김누리.programmers;

import java.util.Stack;

/**
 * PackageName : week2.김누리.programmers
 * FileName    : 같은_숫자는_싫어
 * Author      : 김누리
 * Date        : 2025-05-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 05.     김누리               Initial creation
 * 2025. 05. 05.     김누리               스택을 통한 초기 개발 완료
 */
public class 같은_숫자는_싫어 {
	public int[] solution(int []arr) {
		Stack<Integer> stk = new Stack<>();

		for(int i : arr) {
			if ( stk.isEmpty() || stk.peek() != i ) stk.push(i);
		}

		int[] answer = new int[stk.size()];

		for(int i = 0; i < stk.size(); i++) {
			answer[i] = stk.get(i);
		}

		return answer;
	}
}
