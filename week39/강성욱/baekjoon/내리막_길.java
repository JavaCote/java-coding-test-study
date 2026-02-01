package week39.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week39.강성욱.baekjoon
 * FileName    : 내리막_길
 * Author      : Baekgwa
 * Date        : 26. 1. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 30.     Baekgwa               Initial creation
 */
public class 내리막_길 {
	public class Main {

		private static int M, N;
		private static int[][] map;
		private static int[][] dp;
		private static final int[] dy = {0, -1, 0, 1};
		private static final int[] dx = {-1, 0, 1, 0};

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			map = new int[M][N];
			dp = new int[M][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = -1;
				}
			}

			System.out.println(dfs(0, 0));
		}

		static int dfs(int y, int x) {
			if (y == M - 1 && x == N - 1) {
				return 1;
			}

			if (dp[y][x] != -1) {
				return dp[y][x];
			}

			dp[y][x] = 0;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if(ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
				if(map[y][x] <= map[ny][nx]) continue;

				dp[y][x] += dfs(ny, nx);
			}

			return dp[y][x];
		}
	}
}
