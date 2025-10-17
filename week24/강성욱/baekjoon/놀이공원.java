package week24.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week24.강성욱.baekjoon
 * FileName    : 놀이공원
 * Author      : Baekgwa
 * Date        : 2025-10-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-17     Baekgwa               Initial creation
 */
public class 놀이공원 {
	/**
	 * PackageName : baekgwa
	 * FileName    : ${NAME}
	 * Author      : Baekgwa
	 * Date        : 2025-09-11
	 * Description :
	 * =====================================================================================================================
	 * DATE          AUTHOR               NOTE
	 * ---------------------------------------------------------------------------------------------------------------------
	 * 2025-09-11     Baekgwa               Initial creation
	 */

	public class Main {
		static long N;
		static int M;
		static int[] timeArray;

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			timeArray = new int[M];
			st = new StringTokenizer(br.readLine());
			int maxT = 0;
			for (int i = 0; i < M; i++) {
				timeArray[i] = Integer.parseInt(st.nextToken());
				if (timeArray[i] > maxT) maxT = timeArray[i];
			}

			// 시작 순간 처리
			if (N <= M) {
				System.out.println(N);
				return;
			}

			// 이분탐색
			long lo = 0, hi = (long) maxT * N;
			while (lo < hi) {
				long mid = (lo + hi) / 2;
				if (served(mid) >= N) hi = mid;
				else lo = mid + 1;
			}
			long time = lo;

			long before = served(time - 1);
			long remain = N - before;

			for (int i = 0; i < M; i++) {
				if (time % timeArray[i] == 0) { // 시간 T에 막 비는 기구
					remain--;
					if (remain == 0) {
						System.out.println(i + 1);
						return;
					}
				}
			}
		}

		// time 안에 태운 사람수를 구하는 함수.
		// 초기에 0초일때 한번 다 타므로, M 으로 초기화
		static long served(long time) {
			long sum = M;
			for (int i = 0; i < M; i++) {
				sum += time / timeArray[i];
			}
			return sum;
		}
	}
}
