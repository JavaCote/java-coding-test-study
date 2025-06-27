package week9.강성욱.programmers;

/**
 * PackageName : week9.강성욱.programmers
 * FileName    : 공원_산책
 * Author      : Baekgwa
 * Date        : 2025-06-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-25     Baekgwa               Initial creation
 */
public class 공원_산책 {
	//dfs나 그런게 필요한건 아님.
	//단순이 순서대로 들어오는 route 가 이동이 가능한지? 확인
	//1. 가는 길이 막혀있는지
	//2. 맵을 벗어나는지?
	// 그럼 일딴 맵을 만들어야딤.

	class Solution {
		public int[] solution(String[] park, String[] routes) {
			int h = park.length;
			int w = park[0].length();
			char[][] map = new char[h][w];
			int[] now = new int[2];

			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					map[y][x] = park[y].charAt(x);
					if (map[y][x] == 'S') {
						now[0] = y;
						now[1] = x;
					}
				}
			}

			for (String route : routes) {
				String[] split = route.split(" ");
				char dir = split[0].charAt(0);
				int count = Integer.parseInt(split[1]);

				int dy = 0, dx = 0;
				switch (dir) {
					case 'N' -> dy = -1;
					case 'S' -> dy = 1;
					case 'W' -> dx = -1;
					case 'E' -> dx = 1;
				}

				int nextY = now[0];
				int nextX = now[1];
				boolean canMove = true;

				for (int i = 0; i < count; i++) {
					nextY += dy;
					nextX += dx;

					if (nextY < 0 || nextY >= h || nextX < 0 || nextX >= w || map[nextY][nextX] == 'X') {
						canMove = false;
						break;
					}
				}

				if (canMove) {
					now[0] = nextY;
					now[1] = nextX;
				}
			}

			return now;
		}
	}
}
