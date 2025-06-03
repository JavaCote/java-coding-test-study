package week6.김상진.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 전력망을_둘로_나누기
 * Author      : sangxxjin
 * Date        : 2025. 6. 3.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 3.     sangxxjin               Initial creation
 */
public class 전력망을_둘로_나누기 {
	// 어떻게 풀어야할지 감이 안잡혔음.
	// 이후에 풀 수 있는지 주기적으로 체크해야할 문제
	import java.util.*;
	class Solution {
		public int solution(int n, int[][] wires) {
			int answer = Integer.MAX_VALUE;
			// 인접리스트 생성
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

			// 그래프 구성
			for (int[] wire : wires) {
				graph.get(wire[0]).add(wire[1]);
				graph.get(wire[1]).add(wire[0]);
			}

			// 하나씩 끊어가면서 차이 계산
			for (int[] wire : wires) {
				boolean[] visited = new boolean[n + 1];

				// 해당 간선 제거 (임시)
				int a = wire[0], b = wire[1];
				graph.get(a).remove(Integer.valueOf(b));
				graph.get(b).remove(Integer.valueOf(a));

				// 하나의 노드에서 DFS로 연결된 송전탑 수 계산
				int count = dfs(a, visited, graph);

				// |count - (n - count)| = |n - 2*count|
				int diff = Math.abs(n - count - count);
				answer = Math.min(answer, diff);

				// 복원
				graph.get(a).add(b);
				graph.get(b).add(a);
			}

			return answer;
		}

		private int dfs(int node, boolean[] visited, List<List<Integer>> graph) {
			visited[node] = true;
			int count = 1;

			for (int next : graph.get(node)) {
				if (!visited[next]) {
					count += dfs(next, visited, graph);
				}
			}

			return count;
		}
	}

}
