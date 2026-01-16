package week37.강성욱.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * PackageName : week37.강성욱.baekjoon
 * FileName    : 줄_세우기
 * Author      : Baekgwa
 * Date        : 26. 1. 12.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 1. 12.     Baekgwa               Initial creation
 */
public class 줄_세우기 {
	public class Main {
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 학생 수
			int M = Integer.parseInt(st.nextToken()); // 비교 횟수

			List<List<Integer>> effectList = new ArrayList<>(); //각 정점이 어떤 정점들에게 영향을 끼쳤는지 확인하기 위한 리스트
			for (int i = 0; i <= N; i++) {
				effectList.add(new ArrayList<>());
			}

			int[] ingress = new int[N + 1]; //각 정점이 result 에 저장되기 전에, 먼저 처리되어야 하는 정점의 개수

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// 학생 A가 B 앞에 있어야함.
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				ingress[B]++; // B 정점은, 누군진 몰라도, 앞에 정점 하나가 먼저 처리되어야 등장이 가능
				effectList.get(A).add(B); // A 정점은, B 정점에게 영향을 끼쳤다.
			}

			// ingress[Node] 의 값이 0인 친구들을 넣을 곳
			// 즉, q에는 현재 언제 나와도 상관없는 정점들의 큐
			Queue<Integer> q = new LinkedList<>();
			insertZeroIngressNode(ingress, q);

			StringBuilder sb= new StringBuilder();

			while(!q.isEmpty()) {
				Integer nowNode = q.poll();
				sb.append(nowNode).append(" ");

				for (int effectedNode : effectList.get(nowNode)) {
					ingress[effectedNode]--;

					if(ingress[effectedNode] == 0) {
						q.add(effectedNode);
					}
				}
			}

			System.out.println(sb.toString());
		}

		private static void insertZeroIngressNode(int[] ingress, Queue<Integer> q) {
			for(int i=1; i<ingress.length; i++){
				if(ingress[i] == 0) {
					q.add(i);
					ingress[i]--;
				}
			}
		}
	}
}
