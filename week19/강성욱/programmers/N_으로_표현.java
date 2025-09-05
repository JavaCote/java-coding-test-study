package week19.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week19.강성욱.programmers
 * FileName    : N_으로_표현
 * Author      : Baekgwa
 * Date        : 2025-09-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-05     Baekgwa               Initial creation
 */
public class N_으로_표현 {
	class Solution {
		public int solution(int N, int number) {
			if (N == number) return 1;

			List<Set<Integer>> dp = new ArrayList<>();
			for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

			for (int cnt = 1; cnt <= 8; cnt++) {
				Set<Integer> cur = dp.get(cnt);

				// 1) cnt개 연속 N (예: 5, 55, 555 ...)
				int concat = 0;
				for (int k = 0; k < cnt; k++) concat = concat * 10 + N;
				cur.add(concat);

				// 2) 분할 결합: cnt = left + right
				for (int left = 1; left < cnt; left++) {
					int right = cnt - left;
					Set<Integer> A = dp.get(left);
					Set<Integer> B = dp.get(right);

					for (int a : A) {
						for (int b : B) {
							cur.add(a + b);
							cur.add(a - b);
							cur.add(b - a);
							cur.add(a * b);
							if (b != 0) cur.add(a / b);
							if (a != 0) cur.add(b / a);
						}
					}
				}

				if (cur.contains(number)) return cnt;
			}
			return -1;
		}
	}

}
