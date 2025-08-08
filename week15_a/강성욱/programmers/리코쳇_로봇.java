package week15_a.강성욱.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week15_a.강성욱.programmers
 * FileName    : 리코쳇_로봇
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 리코쳇_로봇 {
	class Solution {

		public static final int[] dx = new int[]{0, 0, -1, 1};
		public static final int[] dy = new int[]{-1, 1, 0, 0};
		public static int maxY = 0;
		public static int maxX = 0;

		public int solution(String[] board) {
			maxY = board.length;
			maxX = board[0].length();
			int sx = 0, sy = 0;
			boolean[][] visited = new boolean[maxY][maxX];
			char[][] map = new char[maxY][maxX];

			//map 으로 변환 및 시작지점, 도착지점 저장
			for(int y = 0; y < maxY; y++) {
				char[] cArray = board[y].toCharArray();
				for(int x=0; x<maxX; x++) {
					map[y][x] = cArray[x];
					if(cArray[x] == 'R') {
						sx = x;
						sy = y;
					}
				}
			}

			//bfs 준비
			Queue<Point> q = new LinkedList<>();
			q.offer(new Point(sx, sy, 0));
			visited[sy][sx] = true;

			//bfs로 4방향 이동
			while(!q.isEmpty()) {
				Point nowPoint = q.poll();
				//도착지점 걸리면 return
				if(map[nowPoint.getY()][nowPoint.getX()] == 'G') return nowPoint.getDepth();

				//4방향 이동 시작
				//그냥 마음속으로, 상-하-좌-우 순서로 보자
				for(int dir=0; dir<4; dir++) {
					Point nextPoint = calculateNextPoint(nowPoint, dir, map);
					if(isDenied(nextPoint, visited)) continue;
					visited[nextPoint.getY()][nextPoint.getX()] = true;
					q.offer(nextPoint);
				}
			}

			//중간에 탈출 못하고 다 진행하면 목적지 도달 불가임
			return -1;
		}

		// 현재 방향(dir 상-하-좌-우 순서)로 map 최대 거리까지 가는 좌표 Point return
		private Point calculateNextPoint(Point nowPoint, int dir, char[][] map) {
			int nx = nowPoint.getX();
			int ny = nowPoint.getY();

			while(true) {
				int nextX = nx + dx[dir];
				int nextY = ny + dy[dir];

				if(nextX < 0 || nextY < 0 || nextX >= maxX || nextY >= maxY) break;
				if(map[nextY][nextX] == 'D') break;

				nx = nextX;
				ny = nextY;
			}

			return new Point(nx, ny, nowPoint.getDepth() + 1);
		}

		// 갈수 있는 곳인지, 들린곳인지 확인하는 메서드
		private boolean isDenied(Point point, boolean[][] visited) {
			return visited[point.getY()][point.getX()];
		}

		private static class Point {
			private int x;
			private int y;
			private int depth;

			public Point(int x, int y, int depth) {
				this.x = x;
				this.y = y;
				this.depth = depth;
			}

			public int getX() { return this.x; }
			public int getY() { return this.y; }
			public int getDepth() { return this.depth; }
		}
	}
}
