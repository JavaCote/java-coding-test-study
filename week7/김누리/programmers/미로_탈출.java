package week7.김누리.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : 미로_탈출
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 10.     김누리(NRKim)               Initial creation
 */

/*
1.  S > L로 이동 가능한가?
[
    "SOOOL",
    "XXXXO",
    "OOOOO",
    "OXXXX",
    "OOOOE"
]

의 경우 S > O 이동 가능 (오른쪽으로 가면 됨 ㅇㅇ)

[
    "LOOXS",
    "OOOOX",
    "OOOOO",
    "OOOOO",
    "EOOOO"
]

의 경우 시작점에서 레버 위치 까지 이동할 수 없으므로 -1 리턴

[
    "LOOOS",
    "OOOOO",
    "OOOOO",
    "XOOOO",
    "EXOOO"
]

의 경우에는 E로 이동이 불가능하니 -1

[
    "LXOOS",
    "XOOOO",
    "OOOOO",
    "OOOOO",
    "EOOOO"
]

의 경우에는 레버에 가서 문을 열지 못하기 때문에 -1

bfs를 채용.
체크 포인트
1.  S에서 못나가는가
2.  L,E 포인트에 접근을 못하는가
3.  1,2 제약조건에 해당하지 않으면 이동한 거리만큼 return
*/

public class 미로_탈출 {
	int n;
	int m;

	public int solution(String[] maps) {
		int answer = 0;
		String[][] mapsArr = new String[maps.length][];
		int idx = 0;

		//  mapsArr 초기화
		for(String s : maps) {
			String[] sArr = s.split("");
			mapsArr[idx++] = sArr;
		}
		int n = mapsArr.length;
		int m = mapsArr[0].length;
		int startX = 0; //  시작 X 값
		int startY = 0; //  시작 Y 값
		int lX = 0; //  레버의 X
		int lY = 0; //  레버의 Y

		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mapsArr[i][j].equals("S")) {
					startX = j;
					startY = i;
				} else if (mapsArr[i][j].equals("L")) {
					lX = j;
					lY = i;
				}
			}
		}

		int lvCnt= bfs(startX, startY, n, m, mapsArr, "L"); //  S >> L 까지 이동 횟수
		if ( lvCnt == -1) return -1;

		int eCnt = bfs(lX, lY, n, m, mapsArr, "E"); //  L >> E 까지 이동 횟수
		if (eCnt == -1) return -1;

		answer = lvCnt + eCnt;

		return answer;
	}

	public int bfs(int startX, int startY, int n, int m, String[][] maps, String target) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {startX,startY,0}); //  시작점의 X, Y 그리고 이동거리 큐에 적재
		visited[startY][startX] = true; // S든, L이든 시작 포인트는 방문상태로

		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0]; // 현재 x 위치
			int y = now[1]; // 현재 y 위치
			int mvCnt = now[2]; // 현재 이동 수

			//  타겟 (예 : S > L // L > E 등)에 도착한 경우
			if (maps[y][x].equals(target)) {
				return mvCnt;
			}

			for(int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];

				//  지도 범위 벗어난 경우
				if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

				//  벽(X) or 방문 지역
				if(maps[ny][nx].equals("X") || visited[ny][nx]) continue;

				visited[ny][nx] = true; // 다음 좌표는 일단 방문 상태로
				q.offer(new int[] {nx,ny,mvCnt + 1});
			}
		}

		return -1;
	}
}
