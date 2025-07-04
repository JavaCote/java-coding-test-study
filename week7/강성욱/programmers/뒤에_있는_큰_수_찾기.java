package week7.강성욱.programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * PackageName : week7.강성욱.programmers
 * FileName    : 뒤에_있는_큰_수_찾기
 * Author      : Baekgwa
 * Date        : 2025-06-11
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-11     Baekgwa               Initial creation
 */
public class 뒤에_있는_큰_수_찾기 {
	//아 이거 문제를 잘못읽음 다시 정리
	//1순위가 지금 숫자보다 큰거고, 그다음이 가장 가까운임
	//즉, [2, 1, 100, 200] 은, [100, 100, 200, -1] 이 정답임.
	//전체 반복해보니 답이 없이 느렸으니, 뭔가 생각이 필요.
	//

	class Solution {
		public int[] solution(int[] numbers) {
			int n = numbers.length;
			int[] answer = new int[n];
			Arrays.fill(answer, -1);

			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
					int idx = stack.pop();
					answer[idx] = numbers[i];
				}
				stack.push(i);
			}

			return answer;
		}
	}
}
