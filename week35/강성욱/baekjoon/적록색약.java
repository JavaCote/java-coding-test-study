package week35.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * PackageName : week35.강성욱.baekjoon
 * FileName    : 적록색약
 * Author      : Baekgwa
 * Date        : 25. 12. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 30.     Baekgwa               Initial creation
 */
public class 적록색약 {
	public class Main {

		private static int N;
		private static char[][] map;
		private static int[] dx = {-1, 0, 1, 0};
		private static int[] dy = {0, -1, 0, 1};

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for(int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			int normalCount = bfs(true);
			int abnormalCount = bfs(false);

			System.out.println(normalCount + " " + abnormalCount);
		}

		public static int bfs(boolean isNormal) {
			int count = 0;
			boolean[][] visited = new boolean[N][N];

			// x, y 모두 돌면서 최대한 다 확인하기
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					char nowChar = map[y][x];
					Queue<int[]> q = new LinkedList<>();

					// 이미 방문한 곳이면 pass (다른 구역에 포함되면)
					if(visited[y][x]) continue;
					q.offer(new int[]{y, x});
					visited[y][x] = true;

					while(!q.isEmpty()) {
						int[] nowPos = q.poll();
						int nowY = nowPos[0];
						int nowX = nowPos[1];

						for(int i=0; i<4; i++) {
							int ny = nowY + dy[i];
							int nx = nowX + dx[i];

							if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
							if(visited[ny][nx]) continue;
							if(isNormal && map[ny][nx] != nowChar) continue;
							if(!isNormal) {
								if(nowChar == 'B' && map[ny][nx] != 'B') continue;
								if(nowChar != 'B' && map[ny][nx] == 'B') continue;
							}
							q.offer(new int[]{ny, nx});
							visited[ny][nx] = true;
						}
					}

					count++;
				}
			}

			return count;
		}
	}
}
