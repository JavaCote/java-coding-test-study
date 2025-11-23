package week30.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PackageName : week30.강성욱.baekjoon
 * FileName    : 최소비용_구하기2
 * Author      : Baekgwa
 * Date        : 25. 11. 24.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 24.     Baekgwa               Initial creation
 */
public class 최소비용_구하기2 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine()); // 도시의 개수
			int m = Integer.parseInt(br.readLine()); // 버스의 개수

			// 그래프 초기화
			List<List<Edge>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}

			// 그래프 (간선) 추가
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				graph.get(from).add(new Edge(to, cost));
			}

			// 시작 / 출발 노드 확인
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			// PQ 선언 및 최소거리 테이블 초기화
			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[start] = 0;

			// 경로 추적을 위한 테이블
			int[] preCity = new int[n + 1];

			PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.getCost() - b.getCost());
			pq.offer(new Edge(start, 0));

			// 다익스트라 시작
			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				int from = now.getNode();
				int nowCost = now.getCost(); // 해당 노드까지 도달하기 위해 사용한 비용

				if (dist[from] < nowCost)
					continue;

				for (Edge nextEdge : graph.get(from)) {
					int to = nextEdge.getNode();
					int nextCost = nextEdge.getCost() + nowCost;

					// 이동할 곳이 현재 노드를 거쳐서 진행하는 것보다 더 이득인 경우에는, 여기 가지는 뻗지않고 종료
					if (dist[to] <= nextCost)
						continue;

					// 이동하여, 최소 거리 테이블 업데이트 및 pq 추가, + 경로 추적
					dist[to] = nextCost;
					pq.offer(new Edge(to, nextCost));
					preCity[to] = from;
				}
			}

			// 최소 비용 출력
			System.out.println(dist[end]);

			// 도시의 개수 및 경로 출력
			StringBuilder sb = new StringBuilder();
			List<Integer> visited = new ArrayList<>();
			int now = end;
			while (now != 0) {
				visited.add(now);
				if(now == start) break;
				now = preCity[now];
			}
			// visited = visited.reversed();
			Collections.reverse(visited);
			for (Integer i : visited) {
				sb.append(i).append(" ");
			}

			System.out.println(visited.size());
			System.out.println(sb);
		}

		public static class Edge {
			private int node;
			private int cost;

			public Edge(int node, int cost) {
				this.node = node;
				this.cost = cost;
			}

			public int getNode() {
				return node;
			}

			public int getCost() {
				return cost;
			}
		}
	}
}
