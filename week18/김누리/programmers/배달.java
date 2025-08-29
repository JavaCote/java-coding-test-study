package week18.김누리.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PackageName : week18.김누리.programmers
 * FileName    : 배달
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-27
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 27.     김누리(NRKim)               Initial creation
 */

/*

N은 마을의 총 갯수 , K는 제한시간. 이 시간 넘어가면 배달 안받음

[
    [1,2,1], >> 1 - 2 연결, 걸리는 시간 1
    [2,3,3], >> 2 - 3 연결, 걸리는 시간 3
    [5,2,2], >> 5 - 2 연결, 걸리는 시간 2
    [1,4,2], >> 1 - 4 연결, 걸리는 시간 2
    [5,3,1], >> 5 - 3 연결, 걸리는 시간 1
    [5,4,2], >> 5 - 4 연결, 걸리는 시간 2
]

1번에 있는 음식점에서 각 2 3 4 5로 배달 할 때 배달이 가능한 음식점의 갯수는?

1 -> 1 : 즈그 동네이니까 가능
1 -> 2 : 1시간 >> K(3) 이하이므로 가능.
1 -> 3 :
         1 > 2 > 3으로 가면 4시간이므로 K 범위를 초과하므로 불가능
         1 > 2 > 5 > 3 으로 가도 4시간 NG
         1 > 4 > 5 > 3 으로 가면 5시간 NG
1 -> 4 : 2시간 가능
1 -> 5 :
         1 > 2 > 5 >> 딱 3시간 >> OK
         1 > 4 > 5 >> 4시간이기 때문에 불가능

결과적으로는 1,2,4,5 마을에 배달이 가능하다.....

딱 하고 떠오르는 선택지는 bfs, 그리고 자신없는 dp 뿐인거 같은데...

bfs가 좀 더 맞는거 같은 느낌인데...?


*/

public class 배달 {
	//  노드간 이어져있는 상황
	public static class Edge {
		int to, w;

		Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	//  이어진 노드 별로 걸리는 이동 시간
	public static class State {
		int node, cost; // 노드, 노드간 걸리는 시간

		State(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}

	public int solution(int N, int[][] road, int K) {
		final int INF = Integer.MAX_VALUE;

		//  연결 된 노드들 정리하기 위한 리스트
		List<List<Edge>> list = new ArrayList<>();

		//  리스트 초기화
		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<>());

		for (int[] r : road) {
			int a = r[0], b = r[1], w = r[2];
			list.get(a).add(new Edge(b, w));
			list.get(b).add(new Edge(a, w));
		}

		//  최단시간 값이 저장 될 배열
		//  실제 마을의 시작값은 1부터이고, 1부터 체킹하기 위해
		//  배열을 N+1사이즈로 잡고 0번 인덱스는 0으로 지정
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		Queue<State> q = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost));
		q.offer(new State(1, 0));

		while (!q.isEmpty()) {
			State now = q.poll();

			if (now.cost > dist[now.node])
				continue; // 더 먼 거리로 판명되면 skip

			for (Edge e : list.get(now.node)) {
				int nd = now.cost + e.w;

				if (nd < dist[e.to]) {
					dist[e.to] = nd;
					q.offer(new State(e.to, nd));
				}
			}
		}

		//  K 이하의 마을 카운트
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			if (dist[i] <= K)
				answer++;
		}

		return answer;
	}
}
