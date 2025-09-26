package week22.강성욱.programmers;

/**
 * PackageName : week22.강성욱.programmers
 * FileName    : 숫자_블록
 * Author      : Baekgwa
 * Date        : 2025-09-26
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-26     Baekgwa               Initial creation
 */
public class 숫자_블록 {
	// 각 자리수는 end 까지 중, 각자의 자신을 제외한 최대약수 아냐?

	class Solution {
		private static final int LIMIT = 10_000_000;

		public int[] solution(long begin, long end) {
			int range = (int) (end - begin + 1);
			int[] result = new int[range];

			for (int idx = 0; idx < range; idx++) {
				int x = (int)begin + idx;

				if (x == 1) {
					result[idx] = 0;
				} else {
					result[idx] = calc(x);
				}
			}
			return result;
		}

		// private int calc(int x) {
		//     int r = (int) Math.sqrt(x);
		//     for (int i = 2; i <= r; i++) {
		//         if (x % i != 0) continue;
		//         return x / i;
		//     }
		//     return 1;
		// }

		private int calc(int x) {
			int best = 1;
			int r = (int) Math.sqrt(x);
			for (int i = 2; i <= r; i++) {
				if (x % i != 0) continue;
				int pair = x / i;
				if (pair <= LIMIT) {
					return pair;
				}
				if (i <= LIMIT && i > best) {
					best = i;
				}
			}
			return best;
		}
	}

}
