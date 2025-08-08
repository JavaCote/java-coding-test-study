package week15_a.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week15_a.김누리.programmers
 * FileName    : 리코쳇_로봇
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-08
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 08.     김누리(NRKim)               Initial creation
 */

/*
좌표가 제공되니까... bfs로 풀이가 가능할거 같은데...

board가 String[]으로 오니 아싸리 그냥 이차원 배열로 분해 하고

n, m 값 구해서 진행 하면 될듯.

이 과정에서 R의 위치, D의 위치, G의 위치 파악하며 D면 장애물이니 못가는 걸로 생각 하면 된다.
*/

public class 리코쳇_로봇 {
	int n;
	int m;
	boolean[][] visited;
	int[] dx = {1,-1,0,0};
	int[] dy = {0,0,1,-1};

	public int solution(String[] board) {
		Queue<int[]> q = new LinkedList<>();
		String[][] boards = new String[board.length][];

		//  board 2차원 배열화
		int idx = 0;
		for(String b : board) {
			boards[idx++] = b.split("");
		}

		n = boards.length; // x축 길이
		m = boards[0].length; // y축 길이

		int[] start = {};
		int[] end = {};

		// 시작점 && 끝점 파악
		for(int i = 0; i < boards.length; i++) {
			for(int j = 0; j < boards[i].length; j++) {
				//  시작점 위치
				if (boards[i][j].equals("R")) {
					start = new int[] {i,j};
				}

				//  끝점 위치
				if (boards[i][j].equals("G")) {
					end = new int[] {i,j};
				}
			}
		}
		visited = new boolean[n][m];

		q.offer(new int[] {start[0], start[1], 0});

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int cnt = now[2];

			//  끝점(G) 도달 시 리턴
			if ( x == end[0] && y == end[1]) return cnt;

			for(int i = 0; i < 4; i++) {
				int nx = x;
				int ny = y;

				// D를 만나기 전 까지 쭈욱 이동
				while(true) {
					int tx = nx + dx[i];
					int ty = ny + dy[i];

					// 범위 밖
					if(tx < 0 || tx >= n || ty < 0 || ty >= m) break;

					// 장애물(D) 조우
					if (boards[tx][ty].equals("D")) break;

					nx = tx;
					ny = ty;
				}

				//  현재위치 스킵
				if (visited[nx][ny]) continue;

				visited[nx][ny] = true;
				q.offer(new int[] {nx,ny,cnt+1});
			}

		}

		//  도달할 수 없음
		return -1;
	}
}
