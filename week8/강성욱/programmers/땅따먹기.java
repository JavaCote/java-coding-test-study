package week8.강성욱.programmers;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 땅따먹기
 * Author      : Baekgwa
 * Date        : 2025-06-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-17     Baekgwa               Initial creation
 */
public class 땅따먹기 {
	// 연속해서 땅을 밟을 수 없음.
	// 그말은 즉, 1 -> 2 -> 1 은 가능
	// 그럼 그전 단계 땅을 밟은 위치를 알고있으면 됨.
	// x는 4로 제한, y는 100,000 까지 늘어날 수 있음.

	class Solution {
		int solution(int[][] land) {
			int[][] sum = new int[land.length][land[0].length];
			//sum 은 최적의 누적합
			//즉, sum[1][0] 은 y축 1번행을 밟았을때, 가장 큰 누적 합을 가지고있는 배열
			//x = 0을 밟았을땐, land[0][0] 은 조건에 의해 밟을 수 없기땜문에, 1, 2, 3 중 가장 큰값을 더한걸 기록

			for (int x = 0; x < 4; x++) {
				sum[0][x] = land[0][x];
			}

			for (int y = 1; y < land.length; y++) {
				for (int x = 0; x < 4; x++) {
					int maxPrev = 0;
					//x == 0일때는, [y-1][1], [y-1][2], [y-1][3] 중 가장 큰걸 기록해놔야함.
					for (int k = 0; k < 4; k++) {
						if (k == x) continue;
						maxPrev = Math.max(maxPrev, sum[y - 1][k]);
					}
					sum[y][x] = land[y][x] + maxPrev;
				}
			}

			//마지막 y중, 가장 큰걸 return
			int answer = 0;
			for (int x = 0; x < 4; x++) {
				answer = Math.max(answer, sum[land.length - 1][x]);
			}

			return answer;
		}
	}
}
