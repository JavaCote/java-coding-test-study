package week28.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week28.강성욱.programmers
 * FileName    : 단속카메라
 * Author      : Baekgwa
 * Date        : 25. 11. 14.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 14.     Baekgwa               Initial creation
 */
public class 단속카메라 {

	class Solution {
		public int solution(int[][] routes) {
			Arrays.sort(routes, (a, b) -> {
				if (a[1] == b[1]) {
					return a[0] - b[0]; // 종료 지점이 같으면 시작 지점 기준 오름차순
				}
				return a[1] - b[1];     // 종료 지점 기준 오름차순
			});

			int result = 0;
			int camera = Integer.MIN_VALUE;

			for (int[] route : routes) {
				int start = route[0];
				int end = route[1];

				if (start > camera) {
					camera = end;
					result++;
				}
			}

			return result;
		}
	}
}
