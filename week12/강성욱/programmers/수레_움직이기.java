package week12.강성욱.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PackageName : week12.강성욱.programmers
 * FileName    : 수레_움직이기
 * Author      : Baekgwa
 * Date        : 2025-07-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-21     Baekgwa               Initial creation
 */
public class 수레_움직이기 {
	//bfs 로 찾으면 될듯?
	class Solution {
		private static final int[] dx = {-1, 0, 1, 0};
		private static final int[] dy = {0, -1, 0, 1};

		public int solution(int[][] maze) {
			int maxY = maze.length;
			int maxX = maze[0].length;
			//x, y 저장
			int redStartX = 0, redStartY = 0;
			int redEndX = 0, redEndY = 0;
			int blueStartX = 0, blueStartY = 0;
			int blueEndX = 0, blueEndY = 0;

			// 색상별 시작/도착 지점 확인
			for(int y=0; y<maxY; y++) {
				for(int x=0; x<maxX; x++) {
					if(maze[y][x] == 1) {
						redStartX = x;
						redStartY = y;
					} else if(maze[y][x] == 2) {
						blueStartX = x;
						blueStartY = y;
					} else if(maze[y][x] == 3) {
						redEndX = x;
						redEndY = y;
					} else if(maze[y][x] == 4) {
						blueEndX = x;
						blueEndY = y;
					}
				}
			}

			Queue<State> q = new LinkedList<>();
			boolean[][] redVisited = new boolean[maxY][maxX];
			boolean[][] blueVisited = new boolean[maxY][maxX];
			redVisited[redStartY][redStartX] = true;
			blueVisited[blueStartY][blueStartX] = true;
			q.offer(new State(redStartX, redStartY, blueStartX, blueStartY, redVisited, blueVisited, 0));

			//bfs 를 진행하는데, 한 스텝에 두개의 아이템을 움직여야함.
			//현재 state 에서 움직일 수 있는 모든곳 확인해서 넣기.
			//2중 배열로, red 가 움직일수 있는 한곳 * blue가 움직일 수 있는 곳 으로 여러개 생성
			//중간에, 만약 도착 위치에 있다면, 움직이지 않기
			while(!q.isEmpty()) {
				State now = q.poll();

				if(now.nowRedPosX == redEndX && now.nowRedPosY == redEndY &&
					now.nowBluePosX == blueEndX && now.nowBluePosY == blueEndY) {
					return now.depth;
				}

				for (int r = 0; r < 4; r++) {
					int redNextX = now.nowRedPosX, redNextY = now.nowRedPosY;
					boolean redMoved = false;

					if (!(now.nowRedPosX == redEndX && now.nowRedPosY == redEndY)) {
						redNextX += dx[r];
						redNextY += dy[r];
						// 범위/벽/방문 칸 체크
						if (!isValidMove(redNextX, redNextY, maxX, maxY, maze) || now.redVisited[redNextY][redNextX]) continue;
						redMoved = true;
					}
					for (int b = 0; b < 4; b++) {
						int blueNextX = now.nowBluePosX, blueNextY = now.nowBluePosY;
						boolean blueMoved = false;

						if (!(now.nowBluePosX == blueEndX && now.nowBluePosY == blueEndY)) {
							blueNextX += dx[b];
							blueNextY += dy[b];
							// 범위/벽/방문 칸 체크
							if (!isValidMove(blueNextX, blueNextY, maxX, maxY, maze) || now.blueVisited[blueNextY][blueNextX]) continue;
							blueMoved = true;
						}
						if (redNextX == blueNextX && redNextY == blueNextY) continue;
						if (redNextX == now.nowBluePosX && redNextY == now.nowBluePosY &&
							blueNextX == now.nowRedPosX && blueNextY == now.nowRedPosY) continue;

						boolean[][] newRedVisited = deepCopy(now.redVisited);
						boolean[][] newBlueVisited = deepCopy(now.blueVisited);

						if (redMoved && !(redNextX == redEndX && redNextY == redEndY)) {
							newRedVisited[redNextY][redNextX] = true;
						}
						if (blueMoved && !(blueNextX == blueEndX && blueNextY == blueEndY)) {
							newBlueVisited[blueNextY][blueNextX] = true;
						}

						State nextState = new State(redNextX, redNextY, blueNextX, blueNextY, newRedVisited, newBlueVisited, now.depth + 1);
						q.offer(nextState);
					}
				}
			}

			return 0;
		}

		private boolean isValidMove(int x, int y, int maxX, int maxY, int[][] maze) {
			return x >= 0 && x < maxX && y >= 0 && y < maxY && maze[y][x] != 5;
		}

		private boolean[][] deepCopy(boolean[][] original) {
			boolean[][] copy = new boolean[original.length][];
			for(int i = 0; i < original.length; i++) {
				copy[i] = original[i].clone();
			}
			return copy;
		}

		private static class State {
			private int nowRedPosX, nowRedPosY;
			private int nowBluePosX, nowBluePosY;
			private boolean[][] redVisited;
			private boolean[][] blueVisited;
			private int depth;

			public State(int nowRedPosX, int nowRedPosY, int nowBluePosX, int nowBluePosY, boolean[][] redVisited, boolean[][] blueVisited, int depth) {
				this.nowRedPosX = nowRedPosX;
				this.nowRedPosY = nowRedPosY;
				this.nowBluePosX = nowBluePosX;
				this.nowBluePosY = nowBluePosY;
				this.redVisited = redVisited;
				this.blueVisited = blueVisited;
				this.depth = depth;
			}
		}
	}
}
