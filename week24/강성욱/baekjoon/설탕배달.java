package week24.강성욱.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * PackageName : week24.강성욱.baekjoon
 * FileName    : 설탕배달
 * Author      : Baekgwa
 * Date        : 2025-10-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-17     Baekgwa               Initial creation
 */
public class 설탕배달 {
	/**
	 * PackageName : baekgwa
	 * FileName    : ${NAME}
	 * Author      : Baekgwa
	 * Date        : 2025-09-11
	 * Description :
	 * =====================================================================================================================
	 * DATE          AUTHOR               NOTE
	 * ---------------------------------------------------------------------------------------------------------------------
	 * 2025-09-11     Baekgwa               Initial creation
	 */

	// -1 은 할 수 없다는 가정
	// 1 = -1
	// 2 = -1
	// 3 = 1;
	// 4 = -1;
	// 5 = 1;
	// dp[6] = ?
	// dp[3], dp[1] 확인
	// dp[3] = 1; +1 해서, dp[6] = 2;
	// dp[1] = -1, 패스
	// 즉, dp[6] = 2;
	// dp[7] = ?
	// dp[4], dp[2] 확인

	public class Main {
		public static final int[] wightArray = new int[] {3, 5};

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int[] dp = new int[N + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);

			if(N == 3) {
				System.out.println(1);
				return;
			}
			dp[3] = 1;
			if(N == 4) {
				System.out.println(-1);
				return;
			}
			if(N == 5) {
				System.out.println(1);
				return;
			}
			dp[5] = 1;

			for(int idx=6; idx<=N; idx++) {
				for (int weight : wightArray) {
					int beforeIdx = idx - weight;

					if(beforeIdx <= 0) continue;
					if(dp[beforeIdx] == Integer.MAX_VALUE) continue;

					dp[idx] = Math.min(dp[idx], dp[beforeIdx] + 1);
				}
			}

			System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
		}
	}
}
