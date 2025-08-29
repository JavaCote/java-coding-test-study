package week18_a.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PackageName : week18_a.강성욱.baekjoon
 * FileName    : 전쟁_전투
 * Author      : Baekgwa
 * Date        : 2025-08-29
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-29     Baekgwa               Initial creation
 */
public class 전쟁_전투 {
	public class Main {

		public static final int[] dx = {-1, 0, 1, 0};
		public static final int[] dy = {0, -1, 0, 1};
		public static int mx, my;

		public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] size = br.readLine().split(" ");
			mx = Integer.parseInt(size[0]);
			my = Integer.parseInt(size[1]);
			char[][] map = new char[my][mx];
			boolean[][] visited = new boolean[my][mx];

			for(int y=0; y<my; y++) {
				char[] nowArray = br.readLine().toCharArray();
				for(int x=0; x<mx; x++) {
					map[y][x] = nowArray[x];
				}
			}

			int[] result = new int[]{0, 0};
			//bfs
			for(int y=0; y<my; y++) {
				for(int x=0; x<mx; x++) {
					if(visited[y][x]) continue;
					char nowChar = map[y][x];
					int nowCount = dfs(x, y, map, visited, nowChar);

					if(nowChar == 'W') result[0] += nowCount * nowCount;
					else result[1] += nowCount * nowCount;
				}
			}

			System.out.print(result[0] + " " + result[1]);
		}

		private static int dfs(int x, int y, char[][] map, boolean[][] visited, char target) {
			int result = 1;
			visited[y][x] = true;

			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if(nx < 0 || ny < 0 || nx >= mx || ny >= my) continue;
				if(visited[ny][nx]) continue;
				if(map[ny][nx] != target) continue;

				result += dfs(nx, ny, map, visited, target);
			}

			return result;
		}
	}
}
