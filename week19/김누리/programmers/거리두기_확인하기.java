package week19.김누리.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * PackageName : week19.김누리.programmers
 * FileName    : 거리두기_확인하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-09-03
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 09. 03.     김누리(NRKim)               Initial creation
 */

/*

※  맨헤튼 거리
Math.abs(places[i][j] - places[i][j+1]) + Math.abs(places[i][j] - places[i+1][j]) 이게 > 3 인경우를 찾아야 한다...

P = 응시자 / O = 빈자리 / X = 파티션

case 1  :
[
    ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
    ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
    ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
    ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
    ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]
]

이거는 bfs일거 같다.

place[0][0] = P를 기준으로 보면?
place[1][0] != P 여야 하고
place[0][1] != P 여야 하니까... 그러면

[
    "POOOP",
    "OXXOX",
    "OPXPX",
    "OOXOX",
    "POXXP"
]
P[0][0] > P[0][1] > P[0][2] > P[0][3] > P[0][4] --> POOP
P[0][0] > P[1][0] > P[2][0] > P[3][0] > P[4][0] --> POOP

P[i][j] == 'P' ? P[i][j+1] != 'P' && P[i+1][j] != 'P' && P[i+1][j+1] != 'P' 임을 체크해 가며
거리계산 > 3 인경우를 찾아야 한다...

*/

public class 거리두기_확인하기 {
	boolean[][] visited;
	int n = 5, m = 5;
	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

	public int[] solution(String[][] places) {
		int[] answer = new int[n];

		//  places[i][j]를 2차원 배열화
		//  시험장은 5*5로 사이즈 고정됨
		char[][] place = new char[n][m];
		int idx = 0;

		for(String[] p : places) {
			for(int i = 0; i < p.length; i++) place[i] = p[i].toCharArray();
			answer[idx++] = isOk(place) ? 1:0;
		}

		return answer;
	}

	public boolean isOk(char[][]place) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(place[i][j] == 'P') {
					if(!bfs(place,i,j)) return false; //  거리두기 위반
				}
			}
		}

		return true;
	}

	public boolean bfs(char[][]place, int x, int y) {
		visited = new boolean[n][m];
		//  앞 뒤 위치를 모두 체킹해야 하니 큐 말고 데크로
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[]{x,y,0});
		visited[x][y] = true;

		while(!dq.isEmpty()) {
			int[] now = dq.poll();
			int nx = now[0], ny = now[1], cnt = now[2];

			for(int[] d : dir) {
				int dx = nx + d[0], dy = ny + d[1], nc = cnt+1;

				//  x,y 범위가 5를 넘으면 스킵
				if(dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
				if(visited[dx][dy] || nc > 2) continue; // 방문했어도 스킵
				if(place[dx][dy] == 'X') continue; // 파티션은 통과 불가

				if(place[dx][dy] == 'P') return false; //  사람이면 종료

				visited[dx][dy] = true;
				dq.offer(new int[]{dx,dy,nc});
			}
		}

		return true;
	}
}
