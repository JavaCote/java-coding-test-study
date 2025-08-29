package week18.강성욱.programmers;

import java.util.Arrays;

/**
 * PackageName : week18.강성욱.programmers
 * FileName    : 완전범죄
 * Author      : Baekgwa
 * Date        : 2025-08-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-29     Baekgwa               Initial creation
 */
public class 완전범죄 {
	class Solution {
		public int solution(int[][] info, int n, int m) {
			// dp[j] = A 도둑이 j개의 흔적을 남겼을 때, B 도둑이 남긴 흔적의 최솟값
			int[] dp = new int[n];

			// 도달할 수 없는 상태를 표현하기 위해 아주 큰 값을 사용 (무한대)
			Arrays.fill(dp, Integer.MAX_VALUE);

			// 초기 상태: A 흔적이 0개일 때 B 흔적도 0개
			// dp[10] = 20; A 흔적이 10일때 최소 B 흔적은 20;
			dp[0] = 0;

			// 각 물건을 순회하며 누가 훔칠지 결정
			for (int[] item : info) {
				int aTrace = item[0];
				int bTrace = item[1];

				// 다음 상태를 저장할 배열. Integer.MAX_VALUE 초기화하여 이전 상태와 완전히 분리
				int[] nextDp = new int[n];
				Arrays.fill(nextDp, Integer.MAX_VALUE);

				// 0부터 n-1까지 모든 가능한 A의 이전 흔적 상태를 확인
				for (int j = 0; j < n; j++) {
					// 이전 상태(dp[j])가 도달 가능할 때만 다음 상태로 전이 가능
					if (dp[j] == Integer.MAX_VALUE) {
						continue;
					}

					// 경우 1: B가 현재 물건을 훔치는 경우
					int bIfBSteals = dp[j] + bTrace;
					nextDp[j] = Math.min(nextDp[j], bIfBSteals);

					// 경우 2: A가 현재 물건을 훔치는 경우
					int newATrace = j + aTrace;
					if (newATrace < n) {
						int bIfASteals = dp[j];
						nextDp[newATrace] = Math.min(nextDp[newATrace], bIfASteals);
					}
				}
				dp = nextDp;
			}

			for (int j = 0; j < n; j++) {
				if (dp[j] < m) {
					return j;
				}
			}

			return -1;
		}
	}
}
