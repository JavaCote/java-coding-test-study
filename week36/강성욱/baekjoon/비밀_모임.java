package week36.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * PackageName : week36.강성욱.baekjoon
 * FileName    : 비밀_모임
 * Author      : Baekgwa
 * Date        : 26. 1. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 7.     Baekgwa               Initial creation
 */
public class 비밀_모임 {
	public class Main {

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();

			while (T-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken()); // 방의 개수
				int M = Integer.parseInt(st.nextToken()); // 비밀통로의 개수

				List<List<Edge>> graph = new ArrayList<>();
				for(int i=0; i<=N; i++) {
					graph.add(new ArrayList<>());
				}

				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int cost = Integer.parseInt(st.nextToken());

					graph.get(a).add(new Edge(b, cost));
					graph.get(b).add(new Edge(a, cost));
				}

				// 시작지점 목록 조회
				int K = Integer.parseInt(br.readLine()); // 친구 수
				int[][] dist = new int[K][N+1];
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<K; i++) {
					int startNode = Integer.parseInt(st.nextToken());
					dist[i] = dijkstra(startNode, N, new ArrayList<>(graph));
				}

				// 친구들 모두가 가장 가까운 최적의 정점 확인
				int minDist = Integer.MAX_VALUE;
				int minNode = -1;

				for(int i=1; i<=N; i++) {
					int sum = 0;
					for (int[] distance : dist) {
						sum += distance[i];
					}

					if(minDist > sum) {
						minDist = sum;
						minNode = i;
					}
				}

				sb.append(minNode).append("\n");
			}

			System.out.println(sb.toString());
		}

		public static int[] dijkstra(int startNode, int N, List<List<Edge>> graph) {
			int[] dist = new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[startNode] = 0;

			PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getCost));
			pq.offer(new Edge(startNode, 0));

			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				int nowCost = e.getCost(); // 현재 위치에 도달하기 위한 비용
				int nowNode = e.getNode(); // 현재 위치

				if(nowCost > dist[nowNode]) continue; // 지금이 최소 비용이 아니면 패스, 더 볼필요 x

				// 현재 위치에서 갈 수 있는 모든 곳 넣기
				for (Edge edge : graph.get(nowNode)) {
					int next = edge.getNode();
					int nextCost = edge.getCost() + nowCost;

					if(dist[next] <= nextCost) continue;

					dist[next] = nextCost;
					pq.offer(new Edge(next, nextCost));
				}
			}

			return dist;
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
