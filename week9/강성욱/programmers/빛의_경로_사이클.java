package week9.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * PackageName : week9.강성욱.programmers
 * FileName    : 빛의_경로_사이클
 * Author      : Baekgwa
 * Date        : 2025-06-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-25     Baekgwa               Initial creation
 */
public class 빛의_경로_사이클 {

	class Solution {
		private final int[] dy = {-1, 0, 1, 0};
		private final int[] dx = {0, 1, 0, -1};

		public int[] solution(String[] grid) {
			int h = grid.length;
			int w = grid[0].length();
			Set<Light> visited = new HashSet<>();
			List<Integer> result = new ArrayList<>();

			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					for (int dir = 0; dir < 4; dir++) {
						Light start = new Light(y, x, dir);
						if (visited.contains(start)) continue;

						int cnt = 0;
						int nowY = y;
						int nowX = x;
						int nowDir = dir;

						while (true) {
							Light current = new Light(nowY, nowX, nowDir);
							if (visited.contains(current)) break;

							visited.add(current);
							cnt++;

							// 다음 위치 계산
							int nextY = nowY + dy[nowDir];
							int nextX = nowX + dx[nowDir];

							// 위쪽으로 나가면 맨 아래로
							if (nextY < 0) {
								nextY = h - 1;
							}
							// 아래쪽으로 나가면 맨 위로
							else if (nextY >= h) {
								nextY = 0;
							}

							// 왼쪽으로 나가면 맨 오른쪽으로
							if (nextX < 0) {
								nextX = w - 1;
							}
							// 오른쪽으로 나가면 맨 왼쪽으로
							else if (nextX >= w) {
								nextX = 0;
							}

							// 이동 적용
							nowY = nextY;
							nowX = nextX;

							char command = grid[nowY].charAt(nowX);
							if (command == 'L') {
								nowDir = (nowDir + 3) % 4;
							} else if (command == 'R') {
								nowDir = (nowDir + 1) % 4;
							}

							if (nowY == y && nowX == x && nowDir == dir) break;
						}

						if (cnt > 0) result.add(cnt);
					}
				}
			}

			return result.stream().sorted().mapToInt(Integer::intValue).toArray();
		}

		private static class Light {
			private final int y;
			private final int x;
			private final int dir;

			Light(int y, int x, int dir) {
				this.y = y;
				this.x = x;
				this.dir = dir;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (!(o instanceof Light)) return false;
				Light light = (Light) o;
				return y == light.y && x == light.x && dir == light.dir;
			}


			@Override
			public int hashCode() {
				return Objects.hash(y, x, dir);
			}
		}
	}
}
