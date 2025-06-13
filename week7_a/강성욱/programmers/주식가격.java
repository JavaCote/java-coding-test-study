package week7_a.강성욱.programmers;

/**
 * PackageName : week7_a.강성욱.programmers
 * FileName    : 주식가격
 * Author      : Baekgwa
 * Date        : 2025-06-13
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-13     Baekgwa               Initial creation
 */
public class 주식가격 {
	class Solution {
		public int[] solution(int[] prices) {
			int[] result = new int[prices.length];

			for(int i=0; i<prices.length; i++) {
				int cnt = 0;
				int now = prices[i];
				for(int j=i+1; j<prices.length; j++) {
					int next = prices[j];

					cnt++;

					if(now > next) break;
				}
				result[i] = cnt;
			}

			return result;
		}
	}
}
