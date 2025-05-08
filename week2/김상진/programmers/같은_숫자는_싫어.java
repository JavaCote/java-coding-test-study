package week2.김상진.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 같은_숫자는_싫어
 * Author      : sangxxjin
 * Date        : 2025. 5. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 8.     sangxxjin               Initial creation
 */
public class 같은_숫자는_싫어 {
	public class Solution {
		public List<Integer> solution(int[] arr) {
			List<Integer> answer = new ArrayList<>();
			int prev = -1;

			for (int num : arr) {
				if (num != prev) {
					answer.add(num);
					prev = num;
				}
			}
			return answer;
		}
	}
}
