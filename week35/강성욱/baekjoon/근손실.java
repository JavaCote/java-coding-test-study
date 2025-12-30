package week35.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * PackageName : week35.강성욱.baekjoon
 * FileName    : 근손실
 * Author      : Baekgwa
 * Date        : 25. 12. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 12. 30.     Baekgwa               Initial creation
 */
public class 근손실 {
	public class Main {

		// 모든 케이스를 다 확인하면?
		// 최대 8개 운동키트 순열 8!
		// 4만
		// 한 조합당 확인해야 하는 횟수 8번
		// 32만
		// 할만한듯?

		private static int[] list;
		private static boolean[] visited;
		private static int K;
		private static int N;
		private static int count = 0;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			list = new int[N];
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 500);
			System.out.println(count);
		}

		private static void dfs(int day, int weight) {
			if(weight < 500) {
				return;
			}

			if(day == N) {
				count++;
				return;
			}

			for(int i=0; i<N; i++) {
				if(visited[i]) continue;

				visited[i] = true;
				dfs(day+1, weight + list[i] - K);
				visited[i] = false;
			}
		}
	}
}
