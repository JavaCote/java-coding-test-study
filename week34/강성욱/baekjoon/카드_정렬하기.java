package week34.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * PackageName : week34.강성욱.baekjoon
 * FileName    : 카드_정렬하기
 * Author      : Baekgwa
 * Date        : 25. 12. 22.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 22.     Baekgwa               Initial creation
 */
public class 카드_정렬하기 {
	public class Main {

		// 가장 작은거끼리 합해나가는게 더 이득인가?
		// 50, 51, 60, 100
		// (50 + 51) + (101 + 60) + (161 + 100) = 523
		// (50 + 51) + (60 + 100) + (101 + 106) = 468
		// 한번만 정렬할게 아니고, 계속 꾸준히 정렬이 필요
		// 뭉치가 하나만 들어올 수가 있어서, 그거 처리필요.

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PriorityQueue<Integer> pq = new PriorityQueue<>();

			int N = Integer.parseInt(br.readLine()); // 카드 묶음 수

			for(int i=0; i<N; i++) {
				pq.offer(Integer.parseInt(br.readLine()));
			}

			// 하나일 경우 처리
			if(N == 1) {
				System.out.println(0);
				return;
			}

			int result = 0;
			while(!pq.isEmpty()) {
				int left = pq.poll();
				int right = pq.poll();

				int sum = left + right;
				result += sum;

				// 안에 비어있으면 더이상 pq 에 추가할 필요가 없음.
				// 즉 마지막 연산임
				if(pq.isEmpty()) continue;
				pq.offer(sum);
			}

			System.out.println(result);
		}
	}
}
