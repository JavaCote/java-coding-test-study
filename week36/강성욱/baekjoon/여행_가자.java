package week36.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * PackageName : week36.강성욱.baekjoon
 * FileName    : 여행_가자
 * Author      : Baekgwa
 * Date        : 26. 1. 7.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 7.     Baekgwa               Initial creation
 */
public class 여행_가자 {
	public class Main {

		// 1. 유니온 파인드 적용
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine()); // 도시 수
			int M = Integer.parseInt(br.readLine()); // 여행할 도시 수

			int[] parent = new int[N+1];
			Arrays.fill(parent, -1);

			// 도시 연결
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int isConnect = Integer.parseInt(st.nextToken());
					if (isConnect == 1) {
						union(parent, i, j);
					}
				}
			}

			StringTokenizer st=  new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			for(int i=1; i<M; i++) {
				int next = Integer.parseInt(st.nextToken());
				if(!isSameUnion(parent, first, next)) {
					System.out.println("NO");
					return;
				}
			}

			System.out.println("YES");
		}

		// a와 b의 최상위 루트 노드를 결합.
		// a 의 루트 노드 위에 b를 추가
		// 즉 b -> a 로 결합
		private static void union(int[] parent, int a, int b) {

			int rootNodeA = find(parent, a);
			int rootNodeB = find(parent, b);

			if(rootNodeA == rootNodeB) return;

			parent[rootNodeA] = rootNodeB;
		}

		// x의 최상위 루트 노드를 찾는 메서드
		private static int find(int[] parent, int x) {

			if(parent[x] == -1) {
				return x;
			}

			return find(parent, parent[x]);
		}

		private static boolean isSameUnion(int[] parent, int a, int b) {
			return find(parent, a) == find(parent, b);
		}
	}
}
