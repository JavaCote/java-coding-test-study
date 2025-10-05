package week23.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week23.강성욱.baekjoon
 * FileName    : 좌표_정렬하기
 * Author      : Baekgwa
 * Date        : 2025-10-03
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-03     Baekgwa               Initial creation
 */
public class 좌표_정렬하기 {
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			int N = Integer.parseInt(br.readLine());

			List<Point> pointList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				pointList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			pointList.sort((a, b) -> {
				if (a.x == b.x) {
					return a.y - b.y;
				}
				return a.x - b.x;
			});

			for (Point p : pointList) {
				sb.append(p.x).append(" ").append(p.y).append("\n");
			}

			System.out.print(sb);
		}

		public static class Point {
			private int x;
			private int y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
	}
}
