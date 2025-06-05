package week6.김상진.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * PackageName : week6.김상진.programmers
 * FileName    : 석유_시추
 * Author      : sangxxjin
 * Date        : 2025. 6. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 6.     sangxxjin               Initial creation
 */
public class 석유_시추 {
	import java.util.*;

	class Solution {
		int n, m;
		int[][] oilMap;
		boolean[][] visited;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};

		public int solution(int[][] land) {
			n = land.length;
			m = land[0].length;
			oilMap = new int[n][m];
			visited = new boolean[n][m];

			List<Integer> oilSizes = new ArrayList<>();
			oilSizes.add(0);

			int idx = 1;

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (land[y][x] == 1 && !visited[y][x]) {
						int size = bfs(y, x, idx, land);
						oilSizes.add(size);
						idx++;
					}
				}
			}

			int maxOil = 0;

			for (int x = 0; x < m; x++) {
				Set<Integer> visitedBlocks = new HashSet<>();
				int total = 0;
				for (int y = 0; y < n; y++) {
					int block = oilMap[y][x];
					if (block > 0 && !visitedBlocks.contains(block)) {
						total += oilSizes.get(block);
						visitedBlocks.add(block);
					}
				}
				maxOil = Math.max(maxOil, total);
			}

			return maxOil;
		}

		private int bfs(int sy, int sx, int idx, int[][] land) {
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[]{sy, sx});
			visited[sy][sx] = true;
			oilMap[sy][sx] = idx;

			int count = 1;

			while (!q.isEmpty()) {
				int[] now = q.poll();
				int y = now[0];
				int x = now[1];

				for (int dir = 0; dir < 4; dir++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
					if (visited[ny][nx] || land[ny][nx] == 0) continue;

					visited[ny][nx] = true;
					oilMap[ny][nx] = idx;
					q.offer(new int[]{ny, nx});
					count++;
				}
			}

			return count;
		}
	}

}
