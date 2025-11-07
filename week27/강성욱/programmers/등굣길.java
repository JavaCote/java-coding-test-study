package week27.강성욱.programmers;

/**
 * PackageName : week27.강성욱.programmers
 * FileName    : 등굣길
 * Author      : Baekgwa
 * Date        : 25. 11. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 6.     Baekgwa               Initial creation
 */
public class 등굣길 {
	class Solution {

		private static final int MOD = 1000000007;

		public int solution(int m, int n, int[][] puddles) {
			long[][] countMap = new long[n + 1][m + 1];
			boolean[][] isPuddle = new boolean[n + 1][m + 1];
			for (int[] puddle : puddles) {
				isPuddle[puddle[1]][puddle[0]] = true;
			}

			countMap[1][1] = 1;

			for (int y = 1; y <= n; y++) {
				for (int x = 1; x <= m; x++) {
					// 초기는 무시
					if (y == 1 && x == 1) continue;

					if (isPuddle[y][x]) {
						countMap[y][x] = 0;
					} else {
						long fromTop = countMap[y - 1][x];
						long fromLeft = countMap[y][x - 1];
						countMap[y][x] = (fromTop + fromLeft) % MOD;
					}
				}
			}
			return (int) countMap[n][m];
		}
	}
}
