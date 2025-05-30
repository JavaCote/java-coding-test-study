package week5.김누리.programmers;

/**
 * PackageName : week5.김누리.programmers
 * FileName    : 타겟_넘버
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-28
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 28.     김누리(NRKim)               Initial creation
 */

/*
number[idx] 에 있는 값을 더한다 > dfs > number[idx] 에 있는 값을 뺀다 순번대로 처리

dfs의 파라미터는 (숫자 배열, 타겟 수치, 지금 어디쯤 왔는지, 얼마만큼 처리 되었는지)

dfs 매서드를 불렀을 때 sum == target이면 처리 ㄴㄴ
아니라면? 처리 진행.

*/
public class 타겟_넘버 {
	int answer = 0;

	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0,0);

		return answer;
	}

	public void dfs (int[] numbers, int target, int idx, int sum) {
		//  numbers에 있는 수를 모두 소진
		if (idx == numbers.length) {
			//  지금 처리한 sum 값이 target 값과 일치 하는가
			if(sum == target) {
				answer++;
			}

			return;
		}

		dfs(numbers, target, idx+1,sum + numbers[idx]); // (+ 처리)
		dfs(numbers, target, idx+1,sum - numbers[idx]); // (- 처리)
	}
}
