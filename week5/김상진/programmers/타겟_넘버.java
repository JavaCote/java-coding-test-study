package week5.김상진.programmers;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 타겟_넘버
 * Author      : sangxxjin
 * Date        : 2025. 5. 26.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 26.     sangxxjin               Initial creation
 */
public class 타겟_넘버 {
	class Solution {
		int answer = 0;
		public int solution(int[] numbers, int target) {
			dfs(numbers, target, 0, 0);
			return answer;
		}
		void dfs(int[] numbers, int target, int depth, int sum) {
			//모든 숫자를 다 사용한 경우
			if (depth == numbers.length) {
				// 타겟값이 나올때
				if (sum == target) {
					answer++;
				}
				return;
			}
			// 현재값을 더한 경우
			dfs(numbers, target, depth + 1, sum + numbers[depth]);
			// 현재값을 뺀 경우
			dfs(numbers, target, depth + 1, sum - numbers[depth]);
		}
	}

}
