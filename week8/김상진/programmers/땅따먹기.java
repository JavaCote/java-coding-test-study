package week8.김상진.programmers;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 땅따먹기
 * Author      : sangxxjin
 * Date        : 2025. 6. 17.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 17.     sangxxjin               Initial creation
 */
public class 땅따먹기 {
	// 1차구현방식으로는 실패
	// 이전 행의 데이터 중 다른 것을 골랐을때 더 높은게 나올 수 있기 때문
	// -> 선택한 열의 다음행은 못고르기 떄문.
	class Solution {
		int solution(int[][] land) {
			int answer = 0;
			int prevCol = -1;

			for (int i = 0; i < land.length; i++) {
				int[] arr = land[i];
				int max = 0;
				int idx = -1;

				for (int j = 0; j < arr.length; j++) {
					if (j == prevCol) continue;
					if (arr[j] > max) {
						max = arr[j];
						idx = j;
					}
				}

				answer += max;
				prevCol = idx;
			}
			return answer;
		}
	}
	// 2차 구현
	// ex - 1행에서 구한 값과 2행에서 구한값의 최대값을 확인
	// 각 행에서 구한 최대값 바로 밑에 더 높은 숫자가 있을 수 있음.
	class Solution {
		int solution(int[][] land) {
			int n = land.length;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 4; j++) {
					int maxPrev = 0;
					for (int k = 0; k < 4; k++) {
						if (k == j) continue;
						maxPrev = Math.max(maxPrev, land[i - 1][k]);
					}
					land[i][j] += maxPrev;
				}
			}
			int answer = 0;
			for (int i = 0; i < 4; i++) {
				answer = Math.max(answer, land[n - 1][i]);
			}
			return answer;
		}
	}


}
