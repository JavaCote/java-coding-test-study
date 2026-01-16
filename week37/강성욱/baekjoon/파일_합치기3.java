package week37.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PackageName : week37.강성욱.baekjoon
 * FileName    : 파일_합치기3
 * Author      : Baekgwa
 * Date        : 26. 1. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 12.     Baekgwa               Initial creation
 */
public class 파일_합치기3 {
	public class Main {

		// 항상 최소한의 합과 합으로 구해나가면 되는거 아냐?
		// 1, 1, 1, 100, 200
		// 2 1 100 200 /비용:2
		// 3 100 200 / 비용 2+3
		// 103 200 / 비용 2 + 3 + 103
		// ...

		// 아 40, 45, 55, 60
		// 이런케이스에는 좀 문제가 되겠네
		// 85, 55, 60 / 비용 : 85
		// 여기서, 55랑 60 을 더하는게 낫네
		// 85, 115 / 비용 : 85 + 115
		// 200 / 비용 : 85 + 115 + 200

		// 만약 저기서, 그대로 앞에서 부터 진행했으면
		// 140, 60 / 비용 : 85 + 140
		// 200 / 비용 85 + 140 + 200
		// 아 이렇게 풀면 안되네... 순서는 정해진대로 들어가야 하구나
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int testCase = Integer.parseInt(br.readLine());

			StringBuilder result = new StringBuilder();

			while(testCase-- > 0) {
				int K = Integer.parseInt(br.readLine()); // 소설의 장 수

				PriorityQueue<Long> pq = new PriorityQueue<>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i=0; i<K; i++) {
					pq.offer(Long.parseLong(st.nextToken()));
				}

				long cost = 0;
				while(pq.size() >= 2) {
					long left = pq.poll();
					long right = pq.poll();

					long nowSum = left + right;
					cost += nowSum;
					pq.add(nowSum);
				}

				result.append(cost).append("\n");
			}

			System.out.println(result.toString());
		}
	}
}
