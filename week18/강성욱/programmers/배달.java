package week18.강성욱.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * PackageName : week18.강성욱.programmers
 * FileName    : 배달
 * Author      : Baekgwa
 * Date        : 2025-08-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-29     Baekgwa               Initial creation
 */
public class 배달 {

	class Solution {
		public int solution(int N, int[][] road, int K) {
			int[][] map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(map[i], Integer.MAX_VALUE);
				map[i][i] = 0;
			}
			for (int[] r : road) {
				int from = r[0];
				int to = r[1];
				int value = r[2];
				if (value < map[from][to]) {
					// 양방향 간선
					map[from][to] = value;
					map[to][from] = value;
				}
			}

			int[] dist = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[1] = 0;

			PriorityQueue<State> pq = new PriorityQueue<>();
			pq.offer(new State(1, 0));

			while (!pq.isEmpty()) {
				State cur = pq.poll();
				int nowNode = cur.node;
				int nowDist = cur.dist;
				if (nowDist > dist[nowNode]) continue;
				for (int nextNode = 1; nextNode <= N; nextNode++) {
					if (map[nowNode][nextNode] == Integer.MAX_VALUE) continue;
					int nextDist = nowDist + map[nowNode][nextNode];
					if (nextDist < dist[nextNode]) {
						dist[nextNode] = nextDist;
						pq.offer(new State(nextNode, nextDist));
					}
				}
			}

			int result = 0;
			for (int i = 1; i <= N; i++) {
				if (dist[i] <= K) {
					result++;
				}
			}
			return result;
		}

		private static class State implements Comparable<State> {
			private final int node;
			private final int dist;

			public State(int node, int dist) {
				this.node = node;
				this.dist = dist;
			}

			@Override
			public int compareTo(State o) {
				int c = Integer.compare(this.dist, o.dist);
				return (c != 0) ? c : Integer.compare(this.node, o.node);
			}
		}
	}

}
