package week12.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week12.김누리.programmers
 * FileName    : 수레_움직이기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-18
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 18.     김누리(NRKim)               Initial creation
 */

/*
재풀이 필요

bfs 통해 풀이를 해야하는건 이해함.

그러나, 풀이 중 체크 내용에서 동시 이동 및 수레 고정 내용 등

구현 하면서 AI를 많이 이용함.

*/

public class 수레_움직이기 {
	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	int n, m;

	public int solution(int[][] maze) {
		n = maze.length;
		m = maze[0].length;

		boolean[][][][] visited = new boolean[n][m][n][m];

		int rx = 0, ry = 0, bx = 0, by = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maze[i][j] == 1) { rx = i; ry = j; }
				if (maze[i][j] == 2) { bx = i; by = j; }
			}
		}

		Queue<Object[]> q = new LinkedList<>();
		boolean[][] redInit = new boolean[n][m];
		boolean[][] blueInit = new boolean[n][m];
		redInit[rx][ry] = true;
		blueInit[bx][by] = true;

		visited[rx][ry][bx][by] = true;
		q.offer(new Object[]{rx, ry, bx, by, 0, redInit, blueInit});

		while (!q.isEmpty()) {
			Object[] cur = q.poll();
			int drx = (int) cur[0], dry = (int) cur[1];
			int dbx = (int) cur[2], dby = (int) cur[3];
			int turn = (int) cur[4];
			boolean[][] rVisited = (boolean[][]) cur[5];
			boolean[][] bVisited = (boolean[][]) cur[6];

			if (maze[drx][dry] == 3 && maze[dbx][dby] == 4) {
				return turn;
			}

			for (int d1 = 0; d1 < 4; d1++) {
				for (int d2 = 0; d2 < 4; d2++) {
					int nrx = drx + dx[d1];
					int nry = dry + dy[d1];
					int nbx = dbx + dx[d2];
					int nby = dby + dy[d2];

					if (maze[drx][dry] == 3) { nrx = drx; nry = dry; }
					if (maze[dbx][dby] == 4) { nbx = dbx; nby = dby; }

					if (!isValid(nrx, nry, maze) || !isValid(nbx, nby, maze)) continue;

					// 수레가 겹치거나, 서로 위치를 교환하는 경우
					if ((nrx == nbx && nry == nby) ||
						(nrx == dbx && nry == dby && nbx == drx && nby == dry)) {
						continue;
					}

					// 도착 칸이 아닌데 이미 방문한 경우
					if ((rVisited[nrx][nry] && maze[nrx][nry] != 3) ||
						(bVisited[nbx][nby] && maze[nbx][nby] != 4)) {
						continue;
					}

					if (visited[nrx][nry][nbx][nby]) continue;

					visited[nrx][nry][nbx][nby] = true;

					boolean[][] newR = copy(rVisited);
					boolean[][] newB = copy(bVisited);
					newR[nrx][nry] = true;
					newB[nbx][nby] = true;

					q.offer(new Object[]{nrx, nry, nbx, nby, turn + 1, newR, newB});
				}
			}
		}

		return 0;
	}

	public boolean isValid(int x, int y, int[][] maze) {
		return x >= 0 && x < n && y >= 0 && y < m && maze[x][y] != 5;
	}

	public boolean[][] copy(boolean[][] src) {
		boolean[][] result = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			result[i] = src[i].clone();
		}
		return result;
	}
}
