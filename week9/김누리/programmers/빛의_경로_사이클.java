package week9.김누리.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week9.김누리.programmers
 * FileName    : 빛의_경로_사이클
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-26
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 26.     김누리(NRKim)               Initial creation
 */

/*
dfs? bfs? >>> 단순히 반복문 ㄱㄱ

우선 그럼 grid = {"SL","LR"}; >> grids[][] = {{"S","L"},{"L","R"}}

3중 반복 문을 진행하며 사이클 로직 구현
※ grid의 길이가 500 이긴 해도, 3중 for문 진행 시

x < 500
y < 500
d < 4

로 총 100만 건 정도 반복되기 때문에, 3중 for문 써도 무방.

visited[x][y][d] >> 단순히 x,y 좌표만으로는 어느 방향에서 빛이 들어왔는지 확인 불가능 하기 때문에 3중 배열로 진행

*/

public class 빛의_경로_사이클 {
	//  상하좌우 방향
	int[] dx = {-1,0,1,0};
	int[] dy = {0,1,0,-1};

	public int[] solution(String[] grid) {
		char[][] grids = new char[grid.length][];

		//  grid 문자열 배열을 이차원 배열화
		for(int i = 0; i < grid.length; i++) {
			//
			char[] tmp = grid[i].toCharArray();

			grids[i] = tmp;
		}

		//  x, y 축 길이
		int n = grids.length;
		int m = grids[0].length;

		//  방문 체크용 배열
		// [x][y][d] ==> d가 4인 이유는 상 하 좌 우 4방향이기 때문
		boolean[][][] visited = new boolean[n][m][4];

		//  빛의 경로 저장용 리스트
		List<Integer> list = new ArrayList<>();

		//
		for(int x = 0; x < n; x++) {
			for(int y = 0; y < m; y++) {
				for(int d = 0; d < 4; d++) {
					if (!visited[x][y][d]) {
						int path = followCycle(x,y,d,visited,n,m,dx,dy,grids);
						list.add(path);
					}
				}
			}
		}

		//  오름차순화
		Collections.sort(list);


		//  list >> answer 배열에 적재
		int[] answer = new int[list.size()];
		int idx = 0;

		for(int i : list) answer[idx++] = i;

		return answer;
	}


	//  빛이 사이클을 이루며 이동한 경로 길이를 계산하는 함수
	private int followCycle(int x, int y, int d, boolean[][][] visited, int n, int m, int[] dx, int[] dy, char[][] grids) {
		// 빛의 이동수
		int cnt = 0;

		// 현재 좌표와 방향에서 이미 경로를 방문했는지 확인
		while (!visited[x][y][d]) {
			visited[x][y][d] = true;
			cnt++;

			// 현재 위치의 명령어
			char cmd = grids[x][y];
			if(cmd == 'L') {
				d = (d+3) % 4; // 좌회전
			} else if (cmd == 'R') {
				d = (d+1) % 4; // 우회전
			}

			// 다음 위치
			x = (x + dx[d] + n) % n;
			y = (y + dy[d] + m) % m;
		}

		return cnt;
	}
}
