package week40.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week40.강성욱.baekjoon
 * FileName    : 숫자고르기
 * Author      : Baekgwa
 * Date        : 26. 2. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 2. 6.     Baekgwa               Initial creation
 */
public class 숫자고르기 {
	public class Main {
		// 1번줄의 집합에 순서대로 들어가있음.
		// 즉, 중복된 숫자를 가지는 집합인 답을 절때로 없음.
		// 이거 2번에 나오는걸 map 으로 가지고 있기?
		// 그럼 일딴 위에꺼 무시하고, 아래꺼 기준으로 뽑을 수는 있는데.
		// 그거 중에서 매칭 안되는걸 (1번 집합이랑 매칭해봤을때) 어케 필터링 해야하지?
		private static int N;
		private static int[] arr;
		private static boolean[] visited;
		private static boolean[] finished;
		private static final List<Integer> result = new ArrayList<>();
		private static final List<Integer> path = new ArrayList<>();

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			visited = new boolean[N + 1];
			finished = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			Collections.sort(result);

			System.out.println(result.size());
			for (int num : result) {
				System.out.println(num);
			}
		}

		private static void dfs(int current) {
			visited[current] = true;
			path.add(current);
			int next = arr[current];

			if (!visited[next]) {
				dfs(next);
			} else {
				if (!finished[next]) {
					int idx = path.indexOf(next);
					for (int i = idx; i < path.size(); i++) {
						result.add(path.get(i));
					}

				}
			}

			finished[current] = true;
			path.remove(path.size() - 1);
		}
	}
}
