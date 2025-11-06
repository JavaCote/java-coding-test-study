package week27.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week27.강성욱.baekjoon
 * FileName    : AtoB
 * Author      : Baekgwa
 * Date        : 25. 11. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 6.     Baekgwa               Initial creation
 */
public class AtoB {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken());
			long target = Long.parseLong(st.nextToken());

			//bfs
			int result = 0;
			Queue<Num> queue = new LinkedList<>();
			queue.add(new Num(start, 1));

			while (!queue.isEmpty()) {
				Num nowNum = queue.poll();
				// 종료조건
				if (nowNum.getNumber() == target) {
					result = nowNum.getDepth();
					break;
				}

				// *2 연산
				long multiNum = nowNum.getNumber() * 2;
				if (multiNum <= target)
					queue.add(new Num(multiNum, nowNum.getDepth() + 1));

				// 가장 오른쪽 1 추가
				long addOneNum = addOneLast(nowNum.getNumber());
				if (addOneNum <= target)
					queue.add(new Num(addOneNum, nowNum.getDepth() + 1));
			}

			if (result == 0)
				System.out.println(-1);
			else
				System.out.println(result);
		}

		// num 에다가 오른쪽 끝에 1 추가해서 return
		private static long addOneLast(long num) {
			return num * 10 + 1;
		}

		private static class Num {
			private long number;
			private int depth;

			public Num(long now, int depth) {
				this.number = now;
				this.depth = depth;
			}

			public long getNumber() {
				return number;
			}

			public int getDepth() {
				return depth;
			}
		}
	}
}
