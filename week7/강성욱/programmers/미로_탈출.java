package week7.강성욱.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week7.강성욱.programmers
 * FileName    : 미로_탈출
 * Author      : Baekgwa
 * Date        : 2025-06-11
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-11     Baekgwa               Initial creation
 */
public class 미로_탈출 {
	//가장 빠른 길찾기 인데, 중간에 무조건 들러야 되는 경유지가 있다.
	//그럼 경유지까지 가장 빠르게 들리는게 항상 이득인가?
	//맞음. 단, 경유지 (레버)가 여러개라면? 조금 다를수도? => 한개만 존재 한다고 한다.
	//그럼 bfs 로 레버까지 찾아서 min 계산하고.
	//레버 위치에서, 시작지점으로 가는 bfs 계산
	//이때, visited 배열은 bfs 마다 초기화해서 사용해야됨. [S O E O L] 이럴때, 끝가지 왔다가 다시 가운데로 가야됨.

	public class Solution {
		private static final char START = 'S';
		private static final char LABER = 'L';
		private static final char GOAL = 'E';
		private static final char WALL = 'X';

		private int maxY, maxX;
		private final int[] dy = {-1, 1, 0, 0};
		private final int[] dx = {0, 0, -1, 1};

		public int solution(String[] maps) {
			maxY = maps.length;
			maxX = maps[0].length();

			char[][] map = new char[maxY][maxX];
			int sy = 0;
			int sx = 0;
			int ly = 0;
			int lx = 0;

			for (int y = 0; y < maxY; y++) {
				for (int x = 0; x < maxX; x++) {
					map[y][x] = maps[y].charAt(x);
					if (map[y][x] == START) {
						sy = y;
						sx = x;
					}
					if (map[y][x] == LABER) {
						ly = y;
						lx = x;
					}
				}
			}

			int findLaberCount = findCount(map, sy, sx, LABER);
			if (findLaberCount == -1) return -1;
			int findGoalCount = findCount(map, ly, lx, GOAL);
			if (findGoalCount == -1) return -1;

			return findLaberCount + findGoalCount;
		}

		private int findCount(char[][] map, int sy, int sx, char target) {
			boolean[][] visited = new boolean[maxY][maxX];
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(sy, sx, 0));
			visited[sy][sx] = true;

			while (!q.isEmpty()) {
				Point p = q.poll();
				if (map[p.getY()][p.getX()] == target)
					return p.getDepth();
				for (int d = 0; d < 4; d++) {
					int ny = p.getY() + dy[d];
					int nx = p.getX() + dx[d];
					if (ny < 0 || nx < 0 || ny >= maxY || nx >= maxX) continue;
					if (map[ny][nx] == WALL || visited[ny][nx]) continue;
					visited[ny][nx] = true;
					q.add(new Point(ny, nx, p.getDepth() + 1));
				}
			}
			return -1;
		}

		private static class Point {
			private final int y;
			private final int x;
			private final int depth;

			Point(int y, int x, int dist) {
				this.y = y;
				this.x = x;
				this.depth = dist;
			}

			public int getY() {
				return y;
			}

			public int getX() {
				return x;
			}

			public int getDepth() {
				return depth;
			}
		}
	}
}
