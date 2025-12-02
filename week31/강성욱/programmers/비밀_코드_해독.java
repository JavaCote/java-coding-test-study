package week31.강성욱.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week31.강성욱.programmers
 * FileName    : 비밀_코드_해독
 * Author      : Baekgwa
 * Date        : 25. 12. 2.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 2.     Baekgwa               Initial creation
 */
public class 비밀_코드_해독 {
	// 조합 다 만들어서 처리
	// 30c5
	// 30 * 29 * 28 * 27 * 26 / 5!
	class Solution {
		public static List<List<Integer>> combList = new ArrayList<>();

		public int solution(int n, int[][] q, int[] ans) {
			//백트래킹을 활용한 조합 만들기
			makeComb(1, n, new ArrayList<>());

			int result = validComb(q, ans);

			return result;
		}

		// 생성된 조합들을 조회하며 검증 확인
		private int validComb(int[][] q, int[] ans) {
			int count = 0;

			// contains로 검증하면 될듯?
			for(List<Integer> comb : combList) {

				boolean isValid = true;

				for(int idx=0; idx<ans.length; idx++) {
					int correctCount = ans[idx];

					int nowCorrectCount = 0;
					for(int i=0; i<q[idx].length; i++) {
						if(comb.contains(q[idx][i])) nowCorrectCount++;
					}

					if(correctCount != nowCorrectCount) {
						isValid = false;
						break;
					}
				}

				if(isValid) count++;
			}

			return count;
		}

		private void makeComb(int start, int n, List<Integer> nowComb) {
			// 5개 다 채우면, 끝
			if(nowComb.size() >= 5) {
				combList.add(new ArrayList<>(nowComb));
				return;
			}

			// 1
			// -> 1, 2
			// -> 1, 2, 3
			// -> 1, 2, 3, 4...
			// -> 1, 3
			for(int i=start; i<=n; i++) {
				nowComb.add(i);
				makeComb(i+1, n, nowComb);
				nowComb.remove(nowComb.size() -1); //백트래킹, 마지막꺼 지우기
			}
		}
	}
}
