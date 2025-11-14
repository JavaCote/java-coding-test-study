package week28.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week28.강성욱.baekjoon
 * FileName    : 동전2
 * Author      : Baekgwa
 * Date        : 25. 11. 14.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 14.     Baekgwa               Initial creation
 */
public class 동전2 {
	public class Main {

		public static int[] dp;
		public static List<Integer> coinList = new ArrayList<>();

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //동전 종류
			int k = Integer.parseInt(st.nextToken()); //목표 k

			//목표치 n 에 대해 몇개로 도달했는지 확인하는 지표.
			//즉, dp[100] 은 100을 만들기 위해 최소 몇개를 활용했는지 기록하는 메모이제이션
			dp = new int[k + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;

			// 동류 종류 입력
			for(int i=0; i<n; i++) {
				coinList.add(Integer.parseInt(br.readLine()));
			}

			// 재귀적 탐색으로, 확인
			dfs(0, k, 0);

			if(dp[k] == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(dp[k]);
		}

		private static void dfs(int now, int target, int depth) {

			int nowDepth = depth + 1;
			for (int coin : coinList) {
				int next = now + coin;

				// 다음에 방문할게 목표보다 더 크면 더이상 가지를 뻗을 이유가 없음.
				// 또한, 이미 도달해본 목표이고, 더 작은 경우로 처리한 경우가 있다면, 굳이 가지를 뻗을 필요가 없음. (중복 줄이기)
				if(next > target || dp[next] <= nowDepth) continue;

				dp[next] = nowDepth;
				dfs(next, target, nowDepth);
			}
		}
	}
}
