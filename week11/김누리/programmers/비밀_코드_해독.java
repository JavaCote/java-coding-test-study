package week11.김누리.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week11.김누리.programmers
 * FileName    : 비밀_코드_해독
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-08
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 08.     김누리(NRKim)               Initial creation
 */

/*

q = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [3, 7, 8, 9, 10], [2, 5, 7, 9, 10], [3, 4, 5, 6, 7]]
ans = [2, 3, 4, 3, 3]

※  ans[i] => q[i] 번째 배열에서 택할수 있는 암호 갯수

y = q.length
x = q[0].length
pick = ans[i]

조합 알고리즘(dfs)를 이용해서 코드별 선택하여 조합

조합을 통해 만들어진 코드 비교

*/
public class 비밀_코드_해독 {
	public int solution(int n, int[][] q, int[] ans) {
		int answer = 0;
		List<int[]> candidates = new ArrayList<>();

		// Step 1. 1~n 중 5개 조합 생성
		combineAll(candidates, new ArrayList<>(), 1, n, 5);

		// Step 2. 각 후보군 검증
		for(int[] cand : candidates) {
			boolean isValid = true;

			//  조합된 코드를 순회하며 검증
			for(int i = 0; i < q.length; i++) {
				int count = 0;

				for(int num : q[i]) {
					for(int c : cand) {
						if(num == c) count++;
					}
				}

				if(count != ans[i]) {
					isValid = false;
					break;
				}
			}

			if(isValid) answer++;
		}

		return answer;
	}

	// 1~n 중 5개 조합 생성 함수
	public void combineAll(List<int[]> list, List<Integer> comb, int start, int n, int pick) {
		if(comb.size() == pick) {
			list.add(comb.stream().mapToInt(i -> i).toArray());
			return;
		}

		for(int i = start; i <= n; i++) {
			comb.add(i);
			combineAll(list, comb, i+1, n, pick);
			comb.remove(comb.size()-1);
		}
	}
}
