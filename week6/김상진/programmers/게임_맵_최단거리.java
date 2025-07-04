package week6.김상진.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 게임_맵_최단거리
 * Author      : sangxxjin
 * Date        : 2025. 6. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 6.     sangxxjin               Initial creation
 */
public class 게임_맵_최단거리 {
	import java.util.*;

	class Solution {
		public int solution(int[][] maps) {
			int n = maps.length;
			int m = maps[0].length;

			boolean[][] visited = new boolean[n][m];
			int[][] dist = new int[n][m];

			int[] dx = {0, 1, 0, -1};
			int[] dy = {-1, 0, 1, 0};

			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[]{0, 0});
			visited[0][0] = true;
			dist[0][0] = 1;

			while (!q.isEmpty()) {
				int[] now = q.poll();
				int y = now[0], x = now[1];

				for (int dir = 0; dir < 4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
					if (visited[ny][nx]) continue;
					if (maps[ny][nx] == 0) continue;

					visited[ny][nx] = true;
					dist[ny][nx] = dist[y][x] + 1;
					q.offer(new int[]{ny, nx});
				}
			}

			return dist[n - 1][m - 1] == 0 ? -1 : dist[n - 1][m - 1];
		}
	}

}
