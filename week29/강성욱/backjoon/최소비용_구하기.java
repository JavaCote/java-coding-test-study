package week29.강성욱.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PackageName : week29.강성욱.backjoon
 * FileName    : 최소비용_구하기
 * Author      : Baekgwa
 * Date        : 25. 11. 21.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 21.     Baekgwa               Initial creation
 */
public class 최소비용_구하기 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int cityCount = Integer.parseInt(br.readLine());

			// 연결 그래프 초기화
			ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
			for (int i = 0; i <= cityCount; i++) {
				graph.add(new ArrayList<>());
			}

			// 연결 그래프 추가
			int count = Integer.parseInt(br.readLine());
			for (int i = 0; i < count; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.get(from).add(new Edge(to, cost));
			}

			// 시작/도착 지점 확인
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());

			// 다익스트라 처리
			int[] dist = new int[cityCount + 1]; //시작정점에서의 최소 거리를 저장할 dist 테이블
			Arrays.fill(dist, Integer.MAX_VALUE); // 초기값은, 모두 확인안된것을 의미하도록 MAX_VALUE 로 초기화
			dist[startNode] = 0; //시작정점은 시작과 동시에 도착 판정
			PriorityQueue<Edge> pq = new PriorityQueue<>(
				(a, b) -> a.getCost() - b.getCost()); // 이동 비용 기준으로 오름차순. (작은 것 부터)
			pq.offer(new Edge(startNode, 0)); //시작을 startNode 부터 진행

			while (!pq.isEmpty()) {
				Edge now = pq.poll();
				int nowNode = now.getNode(); // 현재 노드
				int nowCost = now.getCost(); // 시작지점 부터, 현재 노드까지 사용한 비용

				if (dist[nowNode] < nowCost)
					continue; // 다른 우선순위로 인해 해당 정점까지의 최소비용이 변경되어 더 작은 경우로 가지가 뻗어진 경우, 해당 Edge 는 관리하지 않음.

				// 현재 위치에서 갈 수 있는 경로들 모두 탐색
				for (Edge edge : graph.get(nowNode)) {
					int to = edge.getNode();
					int nextCost = edge.getCost() + nowCost;

					// 현재 가는곳이 더 작은 비용을 내고 갈 수 있다면, 추가
					if (dist[to] > nextCost) {
						dist[to] = nextCost;
						pq.offer(new Edge(to, nextCost));
					}
				}
			}

			System.out.println(dist[endNode]);
		}

		private static class Edge {
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
