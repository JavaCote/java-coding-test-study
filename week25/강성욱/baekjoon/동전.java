package week25.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week25.강성욱.baekjoon
 * FileName    : 동전
 * Author      : Baekgwa
 * Date        : 2025-10-23
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-23     Baekgwa               Initial creation
 */
public class 동전 {
	// 음, 각 조건으로 분기가 될 수 있음.
	// [1, 2] 두개로 1000을 만들기.
	// 그럼 각 조건에서 1 추가? 2 추가? 이렇게 쭈욱 나갈 수 있음.
	// 그럼 N이 20까지 들어오니깐, 20개를 모든 조합을 세는건 미친짓이다.
	// 예시로, DP(10) 은, 10을 만들기 위한 방법수를 적어뒀다고 치면
	// DP(12) 는 DP(10) + 2 와 수렴하나?

	public class Main {
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int testCase = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

			while(testCase-- > 0) {
				int coinCount = Integer.parseInt(br.readLine());
				int[] coinArray = new int[coinCount];
				StringTokenizer st = new StringTokenizer(br.readLine());

				for(int i = 0; i < coinCount; i++) {
					coinArray[i] = Integer.parseInt(st.nextToken());
				}

				int target = Integer.parseInt(br.readLine());
				int[] dp = new int[target + 1];

				dp[0] = 1;

				for(int coin : coinArray) {
					for(int i = coin; i <= target; i++) {
						dp[i] += dp[i - coin];
					}
				}

				sb.append(dp[target]).append("\n");
			}

			System.out.println(sb);
		}
	}
}
