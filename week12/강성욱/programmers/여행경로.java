package week12.강성욱.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : week12.강성욱.programmers
 * FileName    : 여행경로
 * Author      : Baekgwa
 * Date        : 2025-07-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-21     Baekgwa               Initial creation
 */
public class 여행경로 {
	// import java.util.*;

	// class Solution {
	//     public String[] solution(String[][] tickets) {
	//         String nowCity = "ICN";

	//         Map<String, PriorityQueue<String>> map = new HashMap<>();
	//         for(String[] ticket : tickets) {
	//             String from = ticket[0];
	//             String to = ticket[1];

	//             //만약 key 기반 value 가 없다면, 빈 PQ 를 만들어주고, 안에 add
	//             map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
	//         }

	//         String[] result = new String[tickets.length + 1];
	//         result[0] = nowCity;
	//         for(int i=1; i<tickets.length+1; i++) {
	//             nowCity = map.get(nowCity).poll();
	//             result[i] = nowCity;
	//         }

	//         return result;
	//     }
	// }

	// queue에서 항상 우선순위대로 뽑아내면, 다음 갈 곳이 없을 수도 있음...
	// import java.util.*;

	// class Solution {
	//     private List<String> answer;
	//     private int n;
	//     private boolean found = false; // 첫 경로 찾았는지 여부(사전순)

	//     public String[] solution(String[][] tickets) {
	//         n = tickets.length + 1;
	//         Map<String, PriorityQueue<String>> map = new HashMap<>();
	//         for (String[] ticket : tickets) {
	//             map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
	//         }
	//         answer = new ArrayList<>();
	//         List<String> path = new ArrayList<>();
	//         path.add("ICN");
	//         dfs("ICN", map, path);
	//         return answer.stream().toArray(String[]::new);
	//     }

	//     private void dfs(String now, Map<String, PriorityQueue<String>> map, List<String> path) {
	//         if (found) return;
	//         if (path.size() == n) {
	//             answer = new ArrayList<>(path);
	//             found = true;
	//             return;
	//         }
	//         if (!map.containsKey(now) || map.get(now) == null || map.get(now).isEmpty()) return;

	//         PriorityQueue<String> pq = map.get(now);
	//         List<String> used = new ArrayList<>();
	//         while (!pq.isEmpty()) {
	//             String next = pq.poll();
	//             used.add(next);
	//             path.add(next);
	//             dfs(next, map, path);
	//             path.remove(path.size() - 1);
	//             if (found) break; // 정답 찾았으면 나머지 경로 안 탐색
	//         }
	//         for (String to : used) pq.add(to);
	//     }
	// }

	class Solution {
		private String[] answer = null;
		private boolean found = false;

		public String[] solution(String[][] tickets) {
			boolean[] visited = new boolean[tickets.length];
			List<String> path = new ArrayList<>();
			path.add("ICN");
			dfs("ICN", tickets, visited, path, 1);
			return answer;
		}

		private void dfs(String now, String[][] tickets, boolean[] visited, List<String> path, int depth) {
			if (found) return;
			if (depth == tickets.length + 1) {
				answer = path.toArray(new String[0]);
				found = true;
				return;
			}
			// 사전순 방문을 위해 next 후보들을 먼저 모아서 정렬
			List<Integer> candidates = new ArrayList<>();
			for (int i = 0; i < tickets.length; i++) {
				if (!visited[i] && tickets[i][0].equals(now)) {
					candidates.add(i);
				}
			}
			candidates.sort((a, b) -> tickets[a][1].compareTo(tickets[b][1]));

			for (int idx : candidates) {
				visited[idx] = true;
				path.add(tickets[idx][1]);
				dfs(tickets[idx][1], tickets, visited, path, depth + 1);
				path.remove(path.size() - 1);
				visited[idx] = false;
				if (found) break;
			}
		}
	}
}
