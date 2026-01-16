package week37.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week37.강성욱.baekjoon
 * FileName    : 터렛
 * Author      : Baekgwa
 * Date        : 26. 1. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 12.     Baekgwa               Initial creation
 */
public class 터렛 {
	public class Main {
		// 좌표 기준으로, 거리는 반지름.
		// 결국 교집합을 구하라는 거잖아.
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			int T = Integer.parseInt(br.readLine());

			while (T-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int r1 = Integer.parseInt(st.nextToken());

				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());

				sb.append(countIntersection(x1, y1, r1, x2, y2, r2)).append('\n');
			}

			System.out.print(sb);
		}

		private static int countIntersection(
			int x1, int y1, int r1,
			int x2, int y2, int r2
		) {
			long dx = x1 - x2;
			long dy = y1 - y2;

			long distSq = dx * dx + dy * dy;
			long sumR = r1 + r2;
			long diffR = Math.abs(r1 - r2);

			long sumRSq = sumR * sumR;
			long diffRSq = diffR * diffR;

			// 중심이 같고 반지름도 같음 → 무한대
			if (distSq == 0 && r1 == r2) {
				return -1;
			}

			// 교점 없음
			if (distSq > sumRSq) {
				return 0;
			}
			if (distSq < diffRSq) {
				return 0;
			}

			// 한 점에서 만남
			if (distSq == sumRSq) {
				return 1;
			}
			if (distSq == diffRSq) {
				return 1;
			}

			// 두 점에서 만남
			return 2;
		}
	}
}
