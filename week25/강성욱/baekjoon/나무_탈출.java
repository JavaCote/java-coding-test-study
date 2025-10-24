package week25.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * PackageName : week25.강성욱.baekjoon
 * FileName    : 나무_탈출
 * Author      : Baekgwa
 * Date        : 2025-10-23
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-23     Baekgwa               Initial creation
 */
public class 나무_탈출 {
	/**
	 * PackageName : baekgwa
	 * FileName    : ${NAME}
	 * Author      : Baekgwa
	 * Date        : 2025-09-11
	 * Description :
	 * =====================================================================================================================
	 * DATE          AUTHOR               NOTE
	 * ---------------------------------------------------------------------------------------------------------------------
	 * 2025-09-11     Baekgwa               Initial creation
	 */

	// 리프노드에서, 루트 노드까지 각각 올라가는 개수의 합을 구해서
	// 짝수거나 홀수에 따라서 승자 패자가 결정되는 게임 아닌가?
	// 간선을 ㄴ일딴 arrayList 이중배열로 확인
	// 1번 노드는 루트노드 확정이니깐, 1부터 찾다가 자식이 없는 노드를 발견하면 그게 리프노드.
	// 그리고 그때 depth 가 리프 -> 루트 까지의 거리임
	public class Main {

		public static List<List<Integer>> tree;
		public static int totalDepthSum = 0;

		public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());

			tree = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				tree.add(new ArrayList<>());
			}

			for (int i = 0; i < N - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tree.get(a).add(b);
				tree.get(b).add(a);
			}

			dfs(1, 0, 0);

			if (totalDepthSum % 2 == 1) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

		public static void dfs(int current, int parent, int depth) {

			int childCount = 0;

			for (int neighbor : tree.get(current)) {
				if (neighbor == parent) {
					continue;
				}

				childCount++;
				dfs(neighbor, current, depth + 1);
			}

			if (childCount == 0) {
				totalDepthSum += depth;
			}
		}
	}
}
