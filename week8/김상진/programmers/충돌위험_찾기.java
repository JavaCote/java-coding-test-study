package week8.김상진.programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 충돌위험_찾기
 * Author      : sangxxjin
 * Date        : 2025. 6. 18.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 18.     sangxxjin               Initial creation
 */
public class 충돌위험_찾기 {
	//구현문제인데 어려웠음.
	import java.util.*;

	public class Solution {
		public int solution(int[][] points, int[][] routes) {
			int n = routes.length;

			// 각 로봇의 이동 경로를 저장할 배열
			// paths[i] = i번째 로봇이 시간 순서대로 방문하는 좌표 (큐 구조)
			Deque<int[]>[] paths = new ArrayDeque[n];
			for (int i = 0; i < n; i++) paths[i] = new ArrayDeque<>();

			// 각 로봇마다 이동 경로를 계산하여 큐에 저장
			for (int i = 0; i < n; i++) {
				int r = points[routes[i][0] - 1][0];  // 시작 좌표 r
				int c = points[routes[i][0] - 1][1];  // 시작 좌표 c
				paths[i].addLast(new int[]{r, c});    // 출발 위치를 먼저 큐에 저장

				for (int j = 1; j < routes[i].length; j++) {
					int tr = points[routes[i][j] - 1][0]; // 목표 좌표 r
					int tc = points[routes[i][j] - 1][1]; // 목표 좌표 c

					// r(행) 먼저 이동
					while (r != tr) {
						r += (tr > r) ? 1 : -1;
						paths[i].addLast(new int[]{r, c}); // 이동한 좌표 저장
					}

					// c(열) 이동
					while (c != tc) {
						c += (tc > c) ? 1 : -1;
						paths[i].addLast(new int[]{r, c});
					}
				}
			}

			int answer = 0;
			int finished = 0;

			// 모든 로봇이 도착할 때까지 시뮬레이션
			while (finished < n) {
				int[][] map = new int[101][101]; // 해당 시점의 좌표별 로봇 수
				finished = 0;

				// 각 로봇이 1칸씩 이동 (or 도착한 경우 finished++)
				for (Deque<int[]> path : paths) {
					if (path.isEmpty()) {
						finished++;
						continue;
					}
					int[] pos = path.pollFirst(); // 시간순으로 위치 꺼냄
					map[pos[0]][pos[1]]++;        // 해당 좌표에 로봇 1대 도착
				}

				// 충돌 감지: 동시에 2대 이상 도착한 좌표 수만큼 +1
				for (int[] row : map) {
					for (int count : row) {
						if (count > 1) answer++;
					}
				}
			}

			return answer;
		}
	}


}
