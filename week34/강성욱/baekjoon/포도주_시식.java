package week34.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week34.강성욱.baekjoon
 * FileName    : 포도주_시식
 * Author      : Baekgwa
 * Date        : 25. 12. 22.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 22.     Baekgwa               Initial creation
 */
public class 포도주_시식 {
	public class Main {

		// 가장 많은걸 마신다고 최대로 마시는게 아님.
		// 든 양을 확인해야함.
		// 즉, 결국 다 확인해야 함
		// 이번걸 먹을껀가 아닌가?
		// dp?
		// dp[3] 을 구할때는, dp[1] 에서 현재껄 추가하면 되는거 아닌가?
		// 6, 10, 13, 9, 8, 1
		// dp[0] = 6
		// dp[1] = 10
		// dp[2] = 23
		// 여기까진 수동으로 박아두고 4부터 점화식
		// dp[3] = dp[n-1] = dp[3] = 23
		// dp[3] = dp[n-2] + wine[n]
		// dp[3] = dp[n-3] + wine[n-1] + wine[n]

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine()); // 포도주 잔의 개수
			int[] dp = new int[n]; // n번까지 확인해서 마셨을 때 가장 큰 경우
			int[] wine = new int[n];

			for(int i=0; i<n; i++) {
				wine[i] = Integer.parseInt(br.readLine());
			}

			int now = wine[0];
			if(n == 1) {
				System.out.println(now);
				return;
			}
			dp[0] = now;

			now = wine[0] + wine[1];
			if(n == 2) {
				System.out.println(now);
				return;
			}
			dp[1] = now;

			now = Math.max(Math.max(dp[1], wine[0] + wine[2]), wine[1] + wine[2]);
			if(n == 3) {
				System.out.println(now);
				return;
			}
			dp[2] = now;

			for(int i=3; i<n; i++) {
				dp[i] = Math.max(Math.max(dp[i-1], dp[i-2] + wine[i]), dp[i-3] + wine[i-1] + wine[i]);
			}

			System.out.println(dp[n-1]);
		}
	}
}
