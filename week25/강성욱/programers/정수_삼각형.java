package week25.강성욱.programers;

/**
 * PackageName : week25.강성욱.programers
 * FileName    : 정수_삼각형
 * Author      : Baekgwa
 * Date        : 2025-10-23
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-23     Baekgwa               Initial creation
 */
public class 정수_삼각형 {
	class Solution {
		public int solution(int[][] triangle) {
			int size = triangle.length;
			int[][] dp = new int[size][size];
			dp[0][0] = triangle[0][0];

			for(int y=1; y<size; y++) {
				for(int x=0; x<triangle[y].length; x++) {
					if (x == 0) {
						dp[y][x] = dp[y-1][x] + triangle[y][x];
					} else if (x == y) {
						dp[y][x] = dp[y-1][x-1] + triangle[y][x];
					} else {
						dp[y][x] = Math.max(dp[y-1][x-1], dp[y-1][x]) + triangle[y][x];
					}
				}
			}

			int result = Integer.MIN_VALUE;
			for(int i=0; i < dp[size-1].length; i++) {
				result = Math.max(result, dp[size-1][i]);
			}

			return result;
		}
	}
}
