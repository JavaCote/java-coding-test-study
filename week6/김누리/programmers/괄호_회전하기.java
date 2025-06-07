package week6.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 괄호_회전하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 02.     김누리(NRKim)               Initial creation
 */

/*
Queue 채용

s의 각 자리에 있는 문자를 Queue에 입력
이 후 순환하며 체크 진행
*/

public class 괄호_회전하기 {
	public int solution(String s) {
		int answer = 0;
		Queue<String> que = new LinkedList<>();
		Stack<String>stk = new Stack<>();

		// 큐 초기화
		for(String ch : s.split("")) {
			que.offer(ch);
		}

		for (int i = 0; i < que.size(); i++) {
			//  현재 괄호 값들이 올바르게 배치 되어 있는가 확인.
			for(String ch : que) {
				valid(stk,ch);
			}

			//  처리 완료 후 스택이 비면 점수 추가
			if (stk.isEmpty()) answer++;

			//  괄호 회전
			que.offer(que.poll());

			//  스택 초기화
			stk.clear();
		}

		return answer;
	}

	public void valid (Stack<String>stk, String ch) {
		if(stk.isEmpty()) {
			stk.push(ch);
		} else if (stk.peek().equals("(") && ch.equals(")")) {
			stk.pop();
		} else if (stk.peek().equals("{") && ch.equals("}")) {
			stk.pop();
		} else if (stk.peek().equals("[") && ch.equals("]")) {
			stk.pop();
		} else {
			stk.push(ch);
		}
	}
}
