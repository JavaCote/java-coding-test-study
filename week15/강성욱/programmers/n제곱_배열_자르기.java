package week15.강성욱.programmers;

/**
 * PackageName : week15.강성욱.programmers
 * FileName    : n제곱_배열_자르기
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class n제곱_배열_자르기 {
	// left 나 right 좌표를 2차원 좌표로 변경할 수 있으면 될듯?

	class Solution {
		public int[] solution(int n, long left, long right) {
			int size = (int)(right - left) + 1;
			int[] result = new int[size];

			int idx = 0;
			for(long l = left; l <= right; l++) {
				long y = l / (long)n;
				long x = l % (long)n;

				result[idx++] = (int) Math.max(x, y) + 1;
			}

			return result;
		}
	}
}
