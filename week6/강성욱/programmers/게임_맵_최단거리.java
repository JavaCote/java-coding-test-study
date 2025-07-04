package week6.강성욱.programmers;

/**
 * PackageName : week6.강성욱.programmers
 * FileName    : 게임_맵_최단거리
 * Author      : Baekgwa
 * Date        : 2025-06-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-05     Baekgwa               Initial creation
 */
import java.util.*;
public class 게임_맵_최단거리 {
	//가장 최단거리 찾기
	//경로가 막힌 경우도 있음. 이때는 -1 return
	//결론적으로, 가장 빠르게 가는 횟수를 return 해주면됨.
	// 1은 갈 수 있는 곳.
	// 0은 갈 수 없는 곳. (벽)
	// 맵 밖으로 나갈 수 없음.
	// Queue + BFS 로

	class Solution {
		private final int[] dx = {-1, 0, 1, 0};
		private final int[] dy = {0, -1, 0, 1};

		public int solution(int[][] maps) {
			//map 사이즈 확인
			int maxY = maps.length;
			int maxX = maps[0].length;
			int result = -1;

			boolean[][] visited = new boolean[maxY][maxX];
			Queue<Point> q = new LinkedList<>();
			//방문한 곳 처리는 중복되어도 됨. 즉, 방문한곳 다시 가면 안됨.

			visited[0][0] = true;
			q.offer(new Point(0, 0, 1));

			while(q.size() > 0) {
				Point nowPoint = q.poll();
				int nowX = nowPoint.getX();
				int nowY = nowPoint.getY();
				int nowDepth = nowPoint.getDepth();

				//종료 조건
				if(nowX == maxX-1 && nowY == maxY-1) {
					result = nowDepth;
					break;
				}

				for(int i=0; i<4; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];

					if(nextX < 0 || nextY < 0 || nextX >= maxX || nextY >= maxY) continue; //under, over index 확인
					if(maps[nextY][nextX] == 0) continue; //벽에 막힘
					if(visited[nextY][nextX] == true) continue; //이미 간곳이면 다시 갈 필요 없음.

					visited[nextY][nextX] = true;
					q.offer(new Point(nextX, nextY, nowDepth + 1));
				}
			}

			return result;
		}

		public static class Point {
			private int x;
			private int y;
			private int depth;

			public int getX() { return this.x; }
			public int getY() { return this.y; }
			public int getDepth() { return this.depth; }

			public Point(int x, int y, int depth) {
				this.x = x;
				this.y = y;
				this.depth = depth;
			}
		}
	}
}
