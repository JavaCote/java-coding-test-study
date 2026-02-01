package week39.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PackageName : week39.강성욱.baekjoon
 * FileName    : 구두_수선공
 * Author      : Baekgwa
 * Date        : 26. 2. 2.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 2. 2.     Baekgwa               Initial creation
 */
public class 구두_수선공 {
	public class Main {
		// 음 생각을 해보자.
		// 지연이 될 수록 더 손해인걸 먼저 골라야겠네.
		// (index) T S
		// (1) 3 4		= 3/4 = 0.75
		// (2) 1 1000	= 1/1000 = 0.001
		// (3) 2 2		= 2/2 = 1
		// (4) 5 5		= 5/5 = 1
		// 작을 수록 급하다고 보면될듯?
		// 2, 1, (3, 4) 인데, 34는 오름차순 정렬로 가져가기.

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine()); //작업 개수

			PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
				int compare = Double.compare(a.getPriority(), b.getPriority());

				// 둘이 같으면 인덱스 기준
				if (compare == 0) {
					return Integer.compare(a.getIndex(), b.getIndex());
				}

				return compare;
			});

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());

				pq.offer(new Job(i, T, S));
			}

			StringBuilder sb = new StringBuilder();
			while (!pq.isEmpty()) {
				Job job = pq.poll();
				sb.append(job.index).append(" ");
			}

			System.out.println(sb);
		}

		private static class Job {
			private final int index;
			private final double priority;

			public Job(int index, int T, int S) {
				this.index = index;
				this.priority = (double)T / S;
			}

			public double getPriority() {
				return priority;
			}

			public int getIndex() {
				return index;
			}
		}
	}
}
