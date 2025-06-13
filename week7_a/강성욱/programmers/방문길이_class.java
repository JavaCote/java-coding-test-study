package week7_a.강성욱.programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * PackageName : week7_a.강성욱.programmers
 * FileName    : 방문길이_class
 * Author      : Baekgwa
 * Date        : 2025-06-13
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-13     Baekgwa               Initial creation
 */
public class 방문길이_class {
	//좌표 평면계, 이동 문제
	//본인 위치를 계속 기억하고 있어야됨.
	//동시에, 이번 길이 이동한 길인지 처음인지 확인해야됨.
	//자료구조를 뭐쓸까
	//point -> point 니깐.. 음
	//ArrayList 이중으로 쓸까? 생각이 안나네
	//그냥 4차원으로 쓰면 공간 얼마나 먹지?
	//visited[fromX][fromY][toX][toY] = 10*10*10*10 = 10000; 이게 제일 간단하네ㅋㅋ

	class Solution {
		public int solution(String dirs) {
			int nowX = 5, nowY = 5;
			int result = 0;
			Set<Visited> visited = new HashSet<>();

			for(char dir : dirs.toCharArray()) {
				int nextX = nowX, nextY = nowY;
				if(dir == 'U') nextY++;
				else if(dir == 'D') nextY--;
				else if(dir == 'L') nextX--;
				else if(dir == 'R') nextX++;

				if(nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10) continue;

				Point p1 = new Point(nowX, nowY);
				Point p2 = new Point(nextX, nextY);
				Visited path = new Visited(p1, p2);

				if (!visited.contains(path)) result++;
				visited.add(path);

				nowX = nextX;
				nowY = nextY;
			}
			return result;
		}

		private static class Visited {
			private final Point p1, p2;
			public Visited(Point p1, Point p2) {
				if (p1.compareTo(p2) <= 0) {
					this.p1 = p1;
					this.p2 = p2;
				} else {
					this.p1 = p2;
					this.p2 = p1;
				}
			}
			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (!(o instanceof Visited)) return false;
				Visited v = (Visited) o;
				return p1.equals(v.p1) && p2.equals(v.p2);
			}
			@Override
			public int hashCode() {
				return Objects.hash(p1, p2);
			}
		}

		private static class Point implements Comparable<Point> {
			private final int x, y;
			public Point(int x, int y) {
				this.x = x; this.y = y;
			}
			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (!(o instanceof Point)) return false;
				Point p = (Point) o;
				return x == p.x && y == p.y;
			}
			@Override
			public int hashCode() {
				return Objects.hash(x, y);
			}
			@Override
			public int compareTo(Point p) {
				if (x != p.x) return Integer.compare(x, p.x);
				return Integer.compare(y, p.y);
			}
		}
	}
}
