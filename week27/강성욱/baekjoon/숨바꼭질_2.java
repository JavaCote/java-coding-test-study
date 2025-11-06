package week27.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week27.강성욱.baekjoon
 * FileName    : 숨바꼭질_2
 * Author      : Baekgwa
 * Date        : 25. 11. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 6.     Baekgwa               Initial creation
 */
public class 숨바꼭질_2 {
	public class Main {

		private static final int MAX = 200_000;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			if (start == end) {
				System.out.println(0);
				System.out.println(1);
				return;
			}

			boolean[] visited = new boolean[MAX + 1];

			// bfs
			int minDis = Integer.MAX_VALUE;
			int minDisCount = 0; // 최소 이동 횟수로 몇번 가능한지
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(start, 0));
			visited[start] = true;

			while (!queue.isEmpty()) {
				Point point = queue.poll();
				if (point.getDepth() > minDis) {
					continue;
				}

				visited[point.getPos()] = true;

				if (point.getPos() == end) {
					if (minDis > point.getDepth()) {
						minDis = point.getDepth();
						minDisCount = 1; // 1로 초기화
					} else if (minDis == point.getDepth()) {
						minDisCount++;
					}
					continue;
				}

				int backPos = point.getPos() - 1;
				int frontPos = point.getPos() + 1;
				int telPos = point.getPos() * 2;

				if (backPos >= 0 && backPos <= MAX)
					queue.add(new Point(backPos, point.getDepth() + 1));
				if (frontPos >= 0 && frontPos <= MAX)
					queue.add(new Point(frontPos, point.getDepth() + 1));
				if (telPos >= 0 && telPos <= MAX)
					queue.add(new Point(telPos, point.getDepth() + 1));
			}

			System.out.println(minDis);
			System.out.println(minDisCount);
		}

		private static class Point {
			private int pos;
			private int depth;

			public int getPos() {
				return pos;
			}

			public int getDepth() {
				return depth;
			}

			public Point(int pos, int depth) {
				this.pos = pos;
				this.depth = depth;
			}
		}
	}
}
