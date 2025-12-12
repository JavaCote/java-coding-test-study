package week32.강성욱.programmers;

/**
 * PackageName : week32.강성욱.programmers
 * FileName    : 스티커_모으기_2
 * Author      : Baekgwa
 * Date        : 25. 12. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 12.     Baekgwa               Initial creation
 */
public class 스티커_모으기_2 {
	class Solution {
		public int solution(int[] sticker) {
			int n = sticker.length;
			if (n == 1) return sticker[0];
			if (n == 2) return Math.max(sticker[0], sticker[1]);

			int[] dp1 = new int[n];
			dp1[0] = sticker[0];
			dp1[1] = sticker[0];
			for (int i = 2; i < n - 1; i++) {
				dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
			}

			int[] dp2 = new int[n];
			dp2[0] = 0;
			dp2[1] = sticker[1];
			for (int i = 2; i < n; i++) {
				dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
			}

			return Math.max(dp1[n - 2], dp2[n - 1]);
		}
	}
}
