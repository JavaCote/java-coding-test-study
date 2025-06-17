package week8.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 충돌위험
 * Author      : Baekgwa
 * Date        : 2025-06-17
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-17     Baekgwa               Initial creation
 */
public class 충돌위험 {
	// routes가 주어졌을때, 경로를 순서대로 알고 있어야함
	// 즉, pointRoute[1] = { {x, y}, {x, y}, {x, y} ... } 등, 1번 reoutes 의 최적 경로를 모두 알고 잇어야함.

	// 쵲거의 경로는, (상하) (좌우) 움직일때, 항상 상하부터 움직이는게 답
	// 중간에 벽은 없기때문에 dfs 나 그런거 안써도될듯, 그냥 좌표보고 계산해놓으면 될듯

	// 이후, 이걸 각 배열 iter 마다, 돌면서 확인하면 될듯?
	// 이걸 Map 에 저장한 후, getOrDefault 로 ++ 하면서, count check 하면 될듯. 1개 초과면, 충돌 1건 이상 발생

	class Solution {
		public int solution(int[][] points, int[][] routes) {
			List<List<Point>> pointPathList = new ArrayList<>();

			Point[] pointMap = new Point[points.length + 1];
			for (int i = 0; i < points.length; i++) {
				pointMap[i + 1] = new Point(points[i][0], points[i][1]);
			}

			// 로봇 경로 구하기
			int maxTime = 0;
			for (int i = 0; i < routes.length; i++) {
				List<Point> path = new ArrayList<>();
				path.add(pointMap[routes[i][0]]);
				for (int j = 0; j < routes[i].length - 1; j++) {
					Point from = pointMap[routes[i][j]];
					Point to = pointMap[routes[i][j + 1]];
					path.addAll(getPath(from, to));
				}
				pointPathList.add(path);
				maxTime = Math.max(maxTime, path.size());
			}

			int result = 0;

			//충돌 확인
			for (int t = 0; t < maxTime; t++) {
				Map<Point, Integer> map = new HashMap<>();
				for (int i = 0; i < routes.length; i++) {
					List<Point> path = pointPathList.get(i);
					if (t < path.size()) {
						Point p = path.get(t);
						map.put(p, map.getOrDefault(p, 0) + 1);
					}
				}

				for (int count : map.values()) {
					if (count > 1) result++;
				}
			}

			return result;
		}

		private List<Point> getPath(Point from, Point to) {
			List<Point> path = new ArrayList<>();
			int x = from.getX();
			int y = from.getY();

			if (x < to.getX()) {
				for (int i = x + 1; i <= to.getX(); i++) {
					path.add(new Point(i, y));
				}
			} else if (x > to.getX()) {
				for (int i = x - 1; i >= to.getX(); i--) {
					path.add(new Point(i, y));
				}
			}

			if (y < to.getY()) {
				for (int i = y + 1; i <= to.getY(); i++) {
					path.add(new Point(x = to.getX(), i));
				}
			} else if (y > to.getY()) {
				for (int i = y - 1; i >= to.getY(); i--) {
					path.add(new Point(x = to.getX(), i));
				}
			}

			return path;
		}

		private static class Point {
			private final int x;
			private final int y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			public int getX() { return x; }

			public int getY() { return y; }

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (!(o instanceof Point)) return false;
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
