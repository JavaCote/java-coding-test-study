package week37.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week37.강성욱.baekjoon
 * FileName    : DFS와_BFS
 * Author      : Baekgwa
 * Date        : 26. 1. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 12.     Baekgwa               Initial creation
 */
public class DFS와_BFS {
	public class Main {

		private static List<Integer> dfsResult = new ArrayList<>();
		private static boolean[] dfsVisited;

		private static List<Integer> bfsResult = new ArrayList<>();
		private static boolean[] bfsVisited;

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken()); // 시작 정점

			// List<PriorityQueue<Integer>> graph = new ArrayList<>();
			// for(int i=0; i<=N; i++) graph.add(new PriorityQueue<>()); // 방문할 곳 많으면, 작은순서로 해야해서 그냥 PQ 쓰기
			List<List<Integer>> graph = new ArrayList<>();
			for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				graph.get(A).add(B);
				graph.get(B).add(A);
			}

			for(int i=0; i<=N; i++) {
				Collections.sort(graph.get(i));
			}

			dfsVisited = new boolean[N+1];
			bfsVisited = new boolean[N+1];

			dfs(graph, V);
			bfs(graph, V);

			System.out.println(toString(dfsResult));
			System.out.println(toString(bfsResult));
		}

		private static String toString(List<Integer> list) {
			StringBuilder sb = new StringBuilder();

			for (int now : list) {
				sb.append(now).append(" ");
			}

			sb.deleteCharAt(sb.length()-1);

			return sb.toString();
		}

		private static void dfs(List<List<Integer>> graph, int now) {
			dfsResult.add(now);
			dfsVisited[now] = true;

			for (int nextNode : graph.get(now)) {
				if(dfsVisited[nextNode]) continue;
				dfs(graph, nextNode);
			}
		}

		private static void bfs(List<List<Integer>> graph, int now) {
			Queue<Integer> q = new LinkedList<>();
			bfsVisited[now] = true;
			q.offer(now);

			while (!q.isEmpty()) {
				int nowNode = q.poll();
				bfsResult.add(nowNode);

				for(int nextNode : graph.get(nowNode)) {
					if(bfsVisited[nextNode]) continue;

					bfsVisited[nextNode] = true;
					q.offer(nextNode);
				}
			}
		}
	}
}
