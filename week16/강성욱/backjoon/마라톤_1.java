package week16.강성욱.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week16.강성욱.backjoon
 * FileName    : 마라톤_1
 * Author      : Baekgwa
 * Date        : 2025-08-12
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-12     Baekgwa               Initial creation
 */
public class 마라톤_1 {
	//체크포인트를 모두 건너간다.
	// 그 중, 가장 큰 이동거리를 가지는 체크포인트를 기억해두기.
	// 그 체크포인트를 위해 이동한 A -> B -> C 만큼의 거리를 제거하고
	// A -> C 로 이동하는 거리 계산해서 추가.

	public class Main {
		public static void main(String[] args) throws Exception {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int maxSave = 0;
			int sum = 0;
			int maxIdx = 0;

			int[][] map = new int[n][2];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n - 1; i++) {
				int nowDistance = calDistance(map[i], map[i + 1]);
				sum += nowDistance;

				// 처음과 마지막 체크포인트는 건너뛰기 불가
				if (i == 0 || i == n - 1) continue;

				// 절약할 거리 계산.
				int save = calDistance(map[i - 1], map[i])
					+ calDistance(map[i], map[i + 1])
					- calDistance(map[i - 1], map[i + 1]);

				if (save > maxSave) {
					maxSave = save;
					maxIdx = i;
				}
			}

			System.out.println(sum - maxSave);
		}

		private static int calDistance(int[] from, int[] to) {
			return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
		}
	}
}
