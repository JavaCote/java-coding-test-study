package week20.김누리.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week20.김누리.programmers
 * FileName    : 홀짝트리
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-12
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 12.     김누리(NRKim)               Initial creation
 */

/*

홀수 노드 : 노드의 번호 홀수, 자식노드 개수 홀수인 노드
짝수 노드 : 노드의 번호 짝수, 자식노드 개수 짝수인 노드

역홀수 노드 : 노드의 번호 홀수, 자식노드 개수 짝수인 노드
역짝수 노드 : 노드의 번호 짝수, 자식노드 개수 홀수인 노드

nodes = 노드 정보가 저장된 배열
edges = 노드간 연결 정보

case 1 :
nodes = {11,9,3,2,4,6}
edges = [[9,11],[2,3],[6,3],[3,4]]

그러면 그래프화 한다면? 아래와 같음

   9           3
 /           / | \
11          2  4  6

9 - 11 : 홀수 노드
11 - 9 : 역홀수 노드

    3
 /  |  \
2   4   6

홀짝트리

   6
   |
   3
 /   \
2     4

해당 ㄴㄴ



*/

public class 홀짝트리 {
	public int[] solution(int[] nodes, int[][] edges) {
		int[] answer = new int[2];

		//  노드별 인덱스로 묶기
		Map<Integer,Integer> map = new HashMap<>();

		for(int i = 0; i < nodes.length; i++) map.put(nodes[i],i);

		//  노드당 인접 차수 노드 계산용 리스트
		List<Integer>[] g = new ArrayList[nodes.length];

		for(int i = 0; i < nodes.length; i++) g[i] = new ArrayList<>();
		for(int[] e : edges) {
			int u = map.get(e[0]), v = map.get(e[1]);
			g[u].add(v); g[v].add(u);
		}

		int[] deg = new int[nodes.length];
		for(int i = 0; i < nodes.length; i++) deg[i] = g[i].size();

		boolean[] visited = new boolean[nodes.length];
		int hol = 0, rev = 0;

		//  노드를 순회하며 홀짝트리, 역홀짝 트리 계산
		for(int i = 0; i < nodes.length; i++) {
			//  방문한 공역이면 스킵
			if(visited[i]) continue;

			List<Integer>comp = new ArrayList<>();
			Deque<Integer> st = new ArrayDeque<>();
			st.push(i); visited[i] = true;

			while (!st.isEmpty()) {
				int u = st.pop();
				comp.add(u);

				for(int v : g[u]) {
					if(!visited[v]) {
						visited[v] = true;
						st.push(v);
					}
				}
			}

			int eq = 0;
			for(int v : comp) if ((nodes[v] & 1) == (deg[v] & 1)) eq++;
			int size = comp.size(),neq = size - eq;

			if(eq == 1) hol++;
			if(neq == 1) rev++;
		}



		return new int[] {hol,rev};
	}
}
