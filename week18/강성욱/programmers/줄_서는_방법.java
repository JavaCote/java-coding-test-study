package week18.강성욱.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week18.강성욱.programmers
 * FileName    : 줄_서는_방법
 * Author      : Baekgwa
 * Date        : 2025-08-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-29     Baekgwa               Initial creation
 */
public class 줄_서는_방법 {
	// 전체 가짓수는 n! 개만큼
	// 백트래킹 사용하면 최악의 조건에서 너무 확인을 많이해야함.
	// 마지막이 정답이면 20! 만큼 확인
	// ----
	// 계산?
	// 4, 24가지
	// 12번째를 구한다면?
	// 1을 선택했을때, [1, 2, 3, 4], [1, 2, 4, 3], [1, 3, 2, 4], [1, 3, 4, 2], [1, 4, 2, 3], [1, 4, 3, 2] 까지
	// 6씩 나누면 됨. 6 => 3*2;
	// 12번째는 맨앞자리가 2어야 함. [2, ?, ?, ?];

	// 2번째자리. 남아있는 숫자는 [1, 3, 4];
	// 2씩 나누기.

	class Solution {
		public int[] solution(int n, long k) {
			List<Integer> numList = new ArrayList<>(n);
			for (int i = 1; i <= n; i++) numList.add(i);
			long kIdx = k - 1;
			long block = 1L;
			for (int i = 2; i <= n - 1; i++) block *= i;

			int[] ans = new int[n];
			for (int pos = 0; pos < n; pos++) {
				int remaining = n - pos;
				int idx = (int)(kIdx / block);
				kIdx %= block;
				ans[pos] = numList.remove(idx);
				if (remaining > 1) block /= (remaining - 1);
			}
			return ans;
		}
	}
}
