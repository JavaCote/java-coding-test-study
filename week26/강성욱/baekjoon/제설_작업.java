package week26.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week26.강성욱.baekjoon
 * FileName    : 제설_작업
 * Author      : Baekgwa
 * Date        : 25. 10. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 10. 30.     Baekgwa               Initial creation
 */
public class 제설_작업 {
	public class Main {

		public static int[][] map;
		public static long[] ySumArray;
		public static long[] xSumArray;
		public static int N, M;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			ySumArray = new long[N];
			xSumArray = new long[M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					ySumArray[i] += map[i][j];
					xSumArray[j] += map[i][j];
				}
			}

			long left = 1;
			long right = 1_000_000_000L;
			long result = right;

			while (left <= right) {
				long mid = (left + right) / 2;

				if (check(mid)) {
					result = mid;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			System.out.println(result);
		}

		// 성능 P로 눈을 치울 수 있는지 확인
		public static boolean check(long P) {
			long[] xSum = xSumArray.clone();
			long[] ySum = ySumArray.clone();
			boolean[] clearedRows = new boolean[N];
			boolean[] clearedCols = new boolean[M];

			Queue<Job> q = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				if (ySum[i] <= P) {
					q.offer(new Job(i, 0));
					clearedRows[i] = true;
				}
			}
			for (int j = 0; j < M; j++) {
				if (xSum[j] <= P) {
					q.offer(new Job(j, 1));
					clearedCols[j] = true;
				}
			}

			while (!q.isEmpty()) {
				Job job = q.poll();

				if (job.dir == 0) {
					int r = job.point;
					for (int c = 0; c < M; c++) {
						if (!clearedCols[c]) {
							xSum[c] -= map[r][c];
							if (xSum[c] <= P) {
								clearedCols[c] = true;
								q.offer(new Job(c, 1));
							}
						}
					}
				} else {
					int c = job.point;
					for (int r = 0; r < N; r++) {
						if (!clearedRows[r]) {
							ySum[r] -= map[r][c];
							if (ySum[r] <= P) {
								clearedRows[r] = true;
								q.offer(new Job(r, 0));
							}
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				if (clearedRows[i]) continue;

				for (int j = 0; j < M; j++) {
					if (!clearedCols[j]) {
						return false;
					}
				}
			}

			return true;
		}

		public static class Job {
			private int point;
			private int dir;

			public Job(int point, int dir) {
				this.point = point;
				this.dir = dir;
			}
		}
	}
}
