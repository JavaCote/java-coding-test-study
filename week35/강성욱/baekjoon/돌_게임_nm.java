package week35.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week35.강성욱.baekjoon
 * FileName    : 돌_게임_nm
 * Author      : Baekgwa
 * Date        : 25. 12. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 30.     Baekgwa               Initial creation
 */
public class 돌_게임_nm {
	public class Main {

		// 음 항상 더 큰곳을 고르는게 승리에 영향이 있는건가?
		// ㄴㄴ 3x3 에서 더 큰곳을 고르면, 3줄밖에 못긋는데, 중간에 작은곳을 한번 선택하면 승패가 바뀜
		// 그럼 더 짧은곳을 고르는게 승리에 영향이 있는가?
		// 근데 이거 시뮬레이션 아닌듯? n,m 의 범위가 너무 큰데?
		// 바로 공식으로 딱 나오는거일듯
		// 결국 정사각형으로 시작하는 사람이 지는 게임

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int T = Integer.parseInt(br.readLine());

			for (int i = 0; i < T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				long n = Long.parseLong(st.nextToken());
				long m = Long.parseLong(st.nextToken());

				if (Math.min(n, m) >= 2 && (n - m) % 2 == 0) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}
	}
}
