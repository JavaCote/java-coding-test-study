package week30.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week30.강성욱.baekjoon
 * FileName    : 퇴사
 * Author      : Baekgwa
 * Date        : 25. 11. 24.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 24.     Baekgwa               Initial creation
 */
public class 퇴사 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine());

			int[] T = new int[N + 1];
			int[] P = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());
				P[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[N + 2];

			for (int i = N; i >= 1; i--) {
				int nextDay = i + T[i];

				if (nextDay > N + 1) {
					dp[i] = dp[i + 1];
				}
				else {
					dp[i] = Math.max(dp[i + 1], P[i] + dp[nextDay]);
				}
			}
			System.out.println(dp[1]);
		}
	}
}
