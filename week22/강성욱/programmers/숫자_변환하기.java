package week22.강성욱.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week22.강성욱.programmers
 * FileName    : 숫자_변환하기
 * Author      : Baekgwa
 * Date        : 2025-09-26
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-26     Baekgwa               Initial creation
 */
public class 숫자_변환하기 {
	// 음 dp 인듯?
	// dp[] = [n] => n을 몇번만에 만들었는지 저장.

	class Solution {
		// public static int[] dp;

		//     public int solution(int x, int y, int n) {
		//         if (x == y) return 0;
		//         dp = new int[y + 1];
		//         Arrays.fill(dp, Integer.MAX_VALUE);

		//         calDp(x, y, n, 0);

		//         return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
		//     }
		//
		//     private void calDp(int now, int target, int n, int depth) {
		//         if (now > target) return;
		//         if (depth >= dp[now]) return;
		//         dp[now] = depth;

		//         if (now == target) return;

		//         calDp(now + n, target, n, depth + 1);
		//         calDp(now * 2, target, n, depth + 1);
		//         calDp(now * 3, target, n, depth + 1);
		//     }


		public int solution(int x, int y, int n) {
			if (x == y) return 0;

			int[] dp = new int[y + 1];
			Arrays.fill(dp, -1);

			Queue<Integer> q = new LinkedList<>();
			dp[x] = 0;
			q.offer(x);

			while (!q.isEmpty()) {
				int now = q.poll();
				int d = dp[now];

				int[] nexts = {now + n, now * 2, now * 3};
				for (int nx : nexts) {
					if (nx > y) continue;
					if (dp[nx] != -1) continue;
					dp[nx] = d + 1;
					if (nx == y) return dp[nx];
					q.offer(nx);
				}
			}
			return -1;
		}
	}
}
