package week20.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week20.강성욱.baekjoon
 * FileName    : 카드_구매하기
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */
public class 카드_구매하기 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int target = Integer.parseInt(br.readLine());
			int[] dp = new int[target + 1]; //dp[n] 은, n개 구매했을때 지불 금액의 최대를 저장
			int[] deck = new int[target + 1]; //deck[n] 은, 카드 n 개를 구매할때 필요한 금액

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= target; i++) {
				deck[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.fill(dp, Integer.MIN_VALUE);
			Queue<Integer> q = new LinkedList<>();
			q.add(target);
			dp[target] = 0;

			while (!q.isEmpty()) {
				int nowTarget = q.poll();

				for (int i = 1; i <= nowTarget; i++) {
					int nextCoast = dp[nowTarget] + deck[i];
					int nextTarget = nowTarget - i;

					if (dp[nextTarget] < nextCoast) {
						dp[nextTarget] = nextCoast;
						q.offer(nextTarget);
					}
				}
			}

			System.out.println(dp[0]);
		}
	}
}
