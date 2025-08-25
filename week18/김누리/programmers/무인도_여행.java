package week18.김누리.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PackageName : week18.김누리.programmers
 * FileName    : 무인도_여행
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 25.     김누리(NRKim)               Initial creation
 */

/*

이거는 bfs 방식 채용하면 될 듯


maps 를 2차원 배열로 해서 맵으로 만들고 진행하면 될듯

*/

public class 무인도_여행 {
	int[] dx = {1,-1,0,0}; // x축 좌표
	int[] dy = {0,0,1,-1}; // y축 좌표
	int n;
	int m;
	boolean[][] visited;

	public int[] solution(String[] maps) {
		String[][] map = new String[maps.length][];

		//  String[] 배열로 들어온 maps를 좀 더 직관적으로 보기 위해
		//  2차원 배열화
		int idx = 0;

		for(String m : maps) {
			String[] tmp = m.split("");

			map[idx++] = tmp;

		}

		n = map.length; //  x축 범위
		m = map[0].length; // y축 범위

		List<Integer> list = new ArrayList<>();
		visited = new boolean[n][m];

		for(int i = 0; i < n; i++) {

			for(int j = 0; j < m; j++) {
				//  현재 값이 X가 아닌 것만 bfs 진행
				if(!visited[i][j] && !map[i][j].equals("X")) {
					list.add(bfs(i,j,map));
				}
			}
		}

		if(list.size() == 0) return new int[] {-1};
		return list.stream().sorted().mapToInt(Integer::intValue).toArray();
	}

	private int bfs(int x, int y, String[][] map) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		int sum = 0;

		while(!q.isEmpty()) {
			int[] now = q.poll();
			int cx = now[0];
			int cy = now[1];
			sum += Integer.parseInt(map[cx][cy]);

			for(int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(visited[nx][ny]) continue;

				//  인접한 좌표는 "X" 값일수도 있음
				if(map[nx][ny].equals("X")) continue;

				visited[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
		}

		return sum;
	}
}
