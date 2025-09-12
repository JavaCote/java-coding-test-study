package week20.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week20.강성욱.baekjoon
 * FileName    : 홀짝트리
 * Author      : Baekgwa
 * Date        : 2025-09-11
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-11     Baekgwa               Initial creation
 */
public class 홀짝트리 {
	class Solution {
		public int[] solution(int[] nodes, int[][] edges) {
			Map<Integer, List<Integer>> nodeMap = new HashMap<>(); //key : node, value : 연결된 Node들 List
			Set<Integer> visited = new HashSet<>(); //key : node, value : 방문 여부. true => 방문

			// 미리 정해진 node 만큼 Map value 에 ArrayList 만들어두기
			for(int node : nodes) {
				nodeMap.put(node, new ArrayList<>());
			}

			// 간선 정리 및 저장
			for(int[] edge : edges) {
				int a = edge[0];
				int b = edge[1];

				nodeMap.get(a).add(b);
				nodeMap.get(b).add(a);
			}

			int treeCount = 0;
			int reverseTreeCount = 0;

			for (int node : nodes) {
				if (!visited.contains(node)) {
					List<Integer> treeList = new ArrayList<>();

					// DFS를 호출하여 연결된 모든 노드를 리스트에 담는다
					dfs(node, nodeMap, visited, treeList);

					if (isNormalTree(treeList, nodeMap)) {
						treeCount++;
					}
					if (isReverseTree(treeList, nodeMap)) {
						reverseTreeCount++;
					}
				}
			}

			return new int[]{treeCount, reverseTreeCount};
		}

		private void dfs(int currentNode, Map<Integer, List<Integer>> nodeMap, Set<Integer> visited, List<Integer> treeList) {
			visited.add(currentNode);
			treeList.add(currentNode);

			for (int neighbor : nodeMap.get(currentNode)) {
				if (!visited.contains(neighbor)) {
					dfs(neighbor, nodeMap, visited, treeList);
				}
			}
		}

		private boolean isNormalTree(List<Integer> treeList, Map<Integer, List<Integer>> nodeMap) {
			int rootCount = 0;
			for (int node : treeList) {
				int childeCount = nodeMap.get(node).size();

				// "루트가 아닐 때"의 조건: P(번호) == P(degree - 1)
				// 이 조건을 만족하지 않는 노드를 카운트한다.
				// (a % 2)는 a의 홀짝성을 나타낸다. (0: 짝수, 1: 홀수)
				if ((node % 2) != ((childeCount - 1) % 2)) {
					rootCount++;
				}
			}
			if(rootCount == 1) return true;
			return false;
		}

		private boolean isReverseTree(List<Integer> treeList, Map<Integer, List<Integer>> nodeMap) {
			int rootCount = 0;
			for (int node : treeList) {
				int childCount = nodeMap.get(node).size();

				// "루트가 아닐 때"의 조건: P(번호) != P(degree - 1)
				// 이 조건을 만족하지 않는 노드, 즉 P(번호) == P(degree - 1)인 노드를 카운트한다.
				if ((node % 2) == ((childCount - 1) % 2)) {
					rootCount++;
				}
			}
			if(rootCount == 1) return true;
			return false;
		}
	}
}
