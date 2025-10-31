package week26.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * PackageName : week26.강성욱.baekjoon
 * FileName    : 연결_요소의_개수
 * Author      : Baekgwa
 * Date        : 25. 10. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 10. 30.     Baekgwa               Initial creation
 */
public class 연결_요소의_개수 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[N+1];

			Map<Integer, List<Integer>> graph = new HashMap<>();

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				graph.computeIfAbsent(A, k -> new ArrayList<>()).add(B);
				graph.computeIfAbsent(B, k -> new ArrayList<>()).add(A);
			}

			// 정점들 하나씩 돌면서 확인
			int result = 0;
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;

				result++;
				dfs(i, graph, visited);
			}

			System.out.println(result);
		}

		private static void dfs(Integer node, Map<Integer, List<Integer>> graph, boolean[] visited) {
			visited[node] = true;

			if(!graph.containsKey(node)) return;

			for(Integer neighbor : graph.get(node)) {
				if(visited[neighbor]) continue;
				dfs(neighbor, graph, visited);
			}
		}
	}
}
