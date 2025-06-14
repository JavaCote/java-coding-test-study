package week7.김누리.programmers;

import java.util.Stack;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : 뒤에_있는_큰_수_찾기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-09
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 09.     김누리(NRKim)               Initial creation
 */

/*
  answer[0] = numbers[0] >= numbers[1] ? continue : numbers[1] ;
  1차 NG : 2중 for문. 실제로 100만건의 케이스가 들어오면? 100만^2 의 시간이 걸림
   >>  Stack을 이용해 보자.

   스택에는 numbers의 값을 적재 하기 보다 numbers 배열의 idx 자체를 적재 후 진행
*/

public class 뒤에_있는_큰_수_찾기 {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> stk = new Stack<>();

		//  answer 배열 초기화
		for(int i = 0; i < answer.length; i++) {
			answer[i] = -1;
		}

		for(int i = 0; i < numbers.length; i++) {
			//  스택의 이전 인덱스 값 보다 현재 인덱스의 값이 더 클 경우
			while (!stk.isEmpty() && numbers[i] > numbers[stk.peek()]) {
				answer[stk.pop()] = numbers[i];
			}

			stk.push(i); // 인덱스들을 일단 스택에 저장
		}

		return answer;
	}
}
