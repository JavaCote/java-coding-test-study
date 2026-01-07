package week36.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week36.강성욱.baekjoon
 * FileName    : 출석체크
 * Author      : Baekgwa
 * Date        : 26. 1. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 7.     Baekgwa               Initial creation
 */
public class 출석체크 {
	public class Main {

		// 학생수 N
		// 졸고 있는 학생 수 K
		// 출석 코드를 보낼 학생의 수(시작) Q
		// 주어질 구간의 수 M
		// N  K Q M
		// 10 1 3 1
		// 7       -> 졸고 있는 학생의 입장 번호
		// 3 5 7   -> 출석 코드를 받는 학생들의 입장 번호
		// 출석을 못한 학생수를 구할 구간
		// 3 12

		// 그럼
		// 3 4 5 6 7 8 9 10 11 12
		// O X O O X X O  O  X  O
		// 0 1 1 1 2 3 3  3  4  4

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 학생 수
			int K = Integer.parseInt(st.nextToken()); // 졸고 있는 학생 수
			int Q = Integer.parseInt(st.nextToken()); // 출석코드 받는 학생 수
			int M = Integer.parseInt(st.nextToken()); // 구간 수

			boolean[] sleep = new boolean[N + 3]; // 자는지 확인 용
			Arrays.fill(sleep, false);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				int sleepNum = Integer.parseInt(st.nextToken());
				sleep[sleepNum] = true;
			}

			List<Integer> start = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < Q; i++) {
				int startNum = Integer.parseInt(st.nextToken());
				start.add(startNum);
			}

			// 전체 확인 처리
			boolean[] map = new boolean[N + 3];
			for (int sta : start) {
				if (sleep[sta])
					continue; // 처음 받는놈이 자면 패스

				for (int i = sta; i <= N + 2; i += sta) {
					if (sleep[i])
						continue;

					map[i] = true;
				}
			}

			// 미리 누적합 구해두기
			int[] result = new int[N + 3];
			for (int i = 3; i <= N + 2; i++) {
				result[i] = result[i - 1] + (map[i] ? 0 : 1);
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken()); //범위 시작
				int E = Integer.parseInt(st.nextToken()); //범위 종료

				int count = result[E] - result[S-1];
				sb.append(count).append("\n");
			}

			System.out.println(sb);
		}
	}
}
