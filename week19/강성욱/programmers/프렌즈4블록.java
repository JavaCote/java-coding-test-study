package week19.강성욱.programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * PackageName : week19.강성욱.programmers
 * FileName    : 프렌즈4블록
 * Author      : Baekgwa
 * Date        : 2025-09-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-09-05     Baekgwa               Initial creation
 */
public class 프렌즈4블록 {
	// 좌표 기준으로 우측, 아래, 우측아래 가 동일한지 검사
	// 만약 같으면, 파괴 대기. (이거 겹치는 부분이 있을 수 있기 때문에, Set 으로 하고, class 로 하고, hashcode & equals 생성해두기)
	// 이걸 전체 nxm 만큼 반복
	// 그리고, 그걸 당겨줘야 겠네. 아래로.

	class Solution {
		public int solution(int m, int n, String[] board) {
			// 1) 가변 보드로 변환 (빈칸은 '.')
			char[][] map = new char[m][n];
			for (int y = 0; y < m; y++) map[y] = board[y].toCharArray();

			int result = 0;

			while (true) {
				Set<Point> set = new HashSet<>();

				for (int y=0; y<m-1; y++) { // 마지막 줄은 검사할 필요 없음.
					for (int x=0; x<n-1; x++) {
						char c = map[y][x];
						if (c == ' ') continue;
						if (c == map[y][x+1] &&
							c == map[y+1][x] &&
							c == map[y+1][x+1]) {
							set.add(new Point(x, y));
							set.add(new Point(x+1, y));
							set.add(new Point(x, y+1));
							set.add(new Point(x+1, y+1));
						}
					}
				}

				if (set.isEmpty()) break;

				result += set.size();
				for (Point p : set) {
					map[p.y][p.x] = ' ';
				}

				for (int x = 0; x < n; x++) {
					int write = m - 1;
					for (int y = m - 1; y >= 0; y--) {
						if (map[y][x] != ' ') {
							char ch = map[y][x];
							map[y][x] = ' ';
							map[write][x] = ch;
							write--;
						}
					}
				}
			}

			return result;
		}


		private static class Point {
			private int x;
			private int y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Point point = (Point) o;
				return x == point.x && y == point.y;
			}

			@Override
			public int hashCode() {
				return Objects.hash(x, y);
			}
		}
	}
}
