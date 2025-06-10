package week6.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 게임_맵_최단거리
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-05
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 05.     김누리(NRKim)               Initial creation
 */

/*
계속해서 위치를 갱신해 가며, 방문 했는지? 안했는지? ==> dfs or bfs.

근데 상하 좌우 이동 할 때 마다 dfs로 재귀 방식으로 하면 메모리 issue 나올것 같으므로 bfs 채용

길인지 판단하며 이동 진행
*/

public class 게임_맵_최단거리 {
	int n; // maps의 가로
	int m; // maps의 세로
	int[] dx = {-1,1,0,0}; //  x축 이동
	int[] dy = {0,0,-1,1}; //  y축 이동

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;
		boolean[][] visited = new boolean[n][m]; // 좌표별 방문 위치
		Queue<int[]> q = new LinkedList<>(); //  이동한 x,y의 위치 저장용
		q.offer(new int[] {0,0,1}); // x,y,이동 거리
		visited[0][0] = true; // 초기 시작 위치는 방문 된 상태니, true

		while(!q.isEmpty()) {
			int[] now = q.poll(); //  이동한 위치를 queue에 저장
			int x = now[0], y = now[1], dist = now[2];

			if (x == n-1 && y == m-1) return dist; // 마지막 위치에 도달하면, 이동한 거리 반환

			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i]; // 새로 이동한 x 좌표
				int ny = y + dy[i]; // 새로 이동한 y 좌표

				if(!checkRange(nx,ny)) continue;

				if(maps[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[]{nx,ny,dist+1});
				}
			}
		}
		return -1; // 마지막 위치로 가지 못하는 경우 -1 반환
	}


	//  이동한 x,y 좌표의 범위가 map 내부에 있는가
	public boolean checkRange(int x,int y) {
		if(x < 0 || x >= n || y < 0 || y >= m ) {
			return false;
		}

		return true;
	}
}
