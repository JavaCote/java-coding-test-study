package week34.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week34.강성욱.baekjoon
 * FileName    : 회전_초밥
 * Author      : Baekgwa
 * Date        : 25. 12. 22.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 22.     Baekgwa               Initial creation
 */
public class 회전_초밥 {
	public class Main {

		// Set 을 써서, 중복되지 않게 해서 쭈욱 넣기
		// 항상 연속된걸 먹는게 이득인가?
		// 그런듯?
		// Set 에 넣어두고, 최대 사이즈를 확인하면 되지 않을까
		// 그리고, K+1 만큼 나오면 더이상 탐색 하지 않고 종료해도 될듯? 짜피 최대 K+1 개가 max 치잖아.
		// 아, Set 쓰면, (1, 3, 3, 5, 6) 이런 흐름에서, 2개씩 뽑을때, 3 두개 있을때 한번에 다 삭제해버리는 문제 있음.

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓은 접시의 수
			int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
			int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
			int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

			int[] belt = new int[N];
			for(int i=0; i<N; i++) {
				belt[i] = Integer.parseInt(br.readLine());
			}

			int max = 0;
			int left = 0;
			int right = k - 1;

			// 초기값 필요함.
			int distinct = 0;
			int[] count = new int[d+1];
			for(int i=0; i<k; i++) {
				count[belt[i]]++;

				if(count[belt[i]] >= 2) continue;
				distinct++;
			}

			// 쿠폰으로 먹는거 중복 확인
			max = distinct;
			if(count[c] == 0) {
				max++;
			}

			// 전체 확인
			while(left < N) {
				int now = belt[left]; // 이번에 뺄 스시
				count[now]--;
				if(count[now] == 0) {
					distinct--;
				}

				// 스시 더하기
				right = (left + k) % N;
				now = belt[right];
				count[now]++;
				if(count[now] == 1) {
					distinct++;
				}

				int current = distinct;
				if(count[c] == 0) {
					current++;
				}

				max = Math.max(max, current);

				left++;
			}

			System.out.println(max);
		}
	}
}
