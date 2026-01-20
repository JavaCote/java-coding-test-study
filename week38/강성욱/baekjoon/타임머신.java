package week38.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week38.강성욱.baekjoon
 * FileName    : 타임머신
 * Author      : Baekgwa
 * Date        : 26. 1. 20.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 20.     Baekgwa               Initial creation
 */
public class 타임머신 {
	public class Main {
		// 무조건 1번 도시에서 시작!
		// 아 음수가 있네.
		// 이러면 다익스트라 사용 불가능
		// 벨만 포드로
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			long[] dist = new long[N + 1];
			Arrays.fill(dist, Long.MAX_VALUE);
			dist[1] = 0;

			List<Edge> edgeList = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(start, end, weight));
			}

			// N-1번까지는 최단거리 갱신, N번째는 음수 사이클 확인
			for (int i = 0; i < N; i++) {
				for (Edge edge : edgeList) {
					if (dist[edge.getStart()] == Long.MAX_VALUE)
						continue;

					int start = edge.getStart();
					int end = edge.getEnd();
					int weight = edge.getWeight();

					long distance = dist[start] + weight;
					if (dist[end] > distance) {
						dist[end] = distance;
						if (i == N - 1) {
							System.out.println("-1");
							return;
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 2; i <= N; i++) {
				if (dist[i] == Long.MAX_VALUE) {
					sb.append("-1").append("\n");
				} else {
					sb.append(dist[i]).append("\n");
				}
			}
			System.out.print(sb.toString());
		}

		private static class Edge {
			private int start;
			private int end;
			private int weight;

			public Edge(int start, int end, int weight) {
				this.start = start;
				this.end = end;
				this.weight = weight;
			}

			public int getStart() {
				return start;
			}

			public int getEnd() {
				return end;
			}

			public int getWeight() {
				return weight;
			}
		}
	}
}
