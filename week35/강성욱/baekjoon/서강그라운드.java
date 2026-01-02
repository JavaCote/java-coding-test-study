package week35.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week35.강성욱.baekjoon
 * FileName    : 서강그라운드
 * Author      : Baekgwa
 * Date        : 25. 12. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 30.     Baekgwa               Initial creation
 */
public class 서강그라운드 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			int[] items = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				items[i] = Integer.parseInt(st.nextToken());
			}

			int[][] dist = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						dist[i][j] = 0;
					else
						dist[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				dist[a][b] = Math.min(dist[a][b], l);
				dist[b][a] = Math.min(dist[b][a], l);
			}

			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						if (dist[i][j] > dist[i][k] + dist[k][j]) {
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}

			int max = 0;

			// 각 지역을 시작점으로 아이템 합 계산
			for (int start = 1; start <= n; start++) {
				int sum = 0;
				for (int end = 1; end <= n; end++) {
					if (dist[start][end] <= m) {
						sum += items[end];
					}
				}
				max = Math.max(max, sum);
			}

			System.out.println(max);
		}
	}
}
