package week18_a.김누리.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week18_a.김누리.baekjoon
 * FileName    : 전쟁_전투
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-29
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 29.     김누리(NRKim)               Initial creation
 */


/*

입력값
N_M >> 아군세력_수__적군세력_수

예 ) 5 5 > 5 : 5 상황

WBWWW > W 1 B 1 W 3^2 (N명이 뭉친경우 N^2임. 즉 W가 3이니 3^2) ==> W : 10, B : 1
WWWWW > W 5 >> 5^2 >> W 25
BBBBB > B 5 >> 5^2 >> B 25
BBBWW > B 3 W 2 >> 3^2 + 2^2 >> B 9 W 4
WWWWW  > W 5 >> 5^2 >> W 25

 그러면 W : 10 + 25 + 4 + 25 >> 64
 그러면 B : 1 + 25 + 9 >> 35

*/


public class 전쟁_전투 {
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int n, m;
	public static char[][] battleField;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(tk1.nextToken()); //  y축
		m = Integer.parseInt(tk1.nextToken()); //  x축
		battleField = new char[m][n];

		//  전장 상황 2차원 배열로 정리
		for(int i = 0; i < m; i++) {
			tk1 = new StringTokenizer(br.readLine());
			char[] tmp = tk1.nextToken().toCharArray();

			battleField[i] = tmp;
		}

		visited = new boolean[m][n];

		//  세력별 포인트
		int w = 0, b = 0;

		//  세력별 점수 계산
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					int size = bfs(i, j, battleField[i][j]);
					if(battleField[i][j] == 'W') w += size * size; // Math.pow(size,2);
					else b += size * size;
				}
			}
		}

		bw.write(String.valueOf(w) + " " + String.valueOf(b));
		bw.flush();
		bw.close();
	}

	public static int bfs (int i, int j, char team) {
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		q.offer(new int[] {i, j});
		int cnt = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0], y = now[1];

			for(int c = 0; c < 4; c++) {
				int nx = x + dx[c];
				int ny = y + dy[c];

				if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
				if (visited[nx][ny]) continue;
				if(battleField[nx][ny] != team) continue;;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
				cnt++;
			}
		}

		return cnt;
	}
}