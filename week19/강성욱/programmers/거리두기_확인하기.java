package week19.강성욱.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week19.강성욱.programmers
 * FileName    : 거리두기_확인하기
 * Author      : Baekgwa
 * Date        : 2025-09-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-05     Baekgwa               Initial creation
 */
public class 거리두기_확인하기 {
	class Solution {
		private static final int[] dx = {-1, 0, 1, 0};
		private static final int[] dy = {0, -1, 0, 1};

		public int[] solution(String[][] places) {
			int[] result = new int[places.length];

			int idx = 0;
			for(String[] place : places) {
				char[][] map = new char[5][5];
				for(int y=0; y<5; y++) {
					map[y] = place[y].toCharArray();
				}

				boolean isOk = checkCovid(map);
				result[idx++] = isOk ? 1 : 0;
			}

			return result;
		}

		private boolean checkCovid(char[][] map) {
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					if (map[y][x] == 'P') {
						if (!bfs(y, x, map)) {
							return false;
						}
					}
				}
			}

			return true;
		}

		private boolean bfs(int startY, int startX, char[][] map) {
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[]{startY, startX, 0});
			boolean[][] visited = new boolean[5][5];
			visited[startY][startX] = true;

			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				int y = current[0];
				int x = current[1];
				int dist = current[2];

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];

					if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
					if (visited[ny][nx]) continue;
					if (dist + 1 > 2) continue;
					if (map[ny][nx] == 'X') continue;
					if (map[ny][nx] == 'P') {
						return false;
					}

					visited[ny][nx] = true;
					queue.add(new int[]{ny, nx, dist + 1});
				}
			}
			return true;
		}
	}
}
