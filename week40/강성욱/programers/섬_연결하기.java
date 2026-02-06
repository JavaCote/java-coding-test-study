package week40.강성욱.programers;

import java.util.Arrays;

/**
 * PackageName : week40.강성욱.programers
 * FileName    : 섬_연결하기
 * Author      : Baekgwa
 * Date        : 26. 2. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 26. 2. 6.     Baekgwa               Initial creation
 */
public class 섬_연결하기 {
	// 전부 다 확인하기에는 너무 많음 ㅠ
	// 그래프?
	// union-find 까지는 굳이?
	// 가장 비용이 적은 것 대로 정렬을 해서 나열을 한다면?
	// 그리고 초기에는 다리는 0 이니깐, 연결 된 대로, list 로 관리해서 그걸 넣는다면?
	// 근데 그게 과연 항상 옳은 방법?
	// 그게 맞는거 아냐?
	// N개가 있으면 다리는 최소 N개는 놔야함.
	// 쭉 반복해서 넣다가 list 에 N개만큼 차는 순간 다 연결된거 아냐?
	// 이렇게 되면, 섬이 전체 하나로 연결됬는지 유무는 확인이 불가능하네.
	// 결국 union-find 해야할듯?
	class Solution {
		public int solution(int n, int[][] costs) {
			Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

			int[] parent = new int[n];
			for(int i=0; i<n; i++) {
				parent[i] = i;
			}

			int totalCost = 0;
			int edgeCount = 0;

			for(int[] cost : costs) {
				int start = cost[0];
				int end = cost[1];
				int nowCost = cost[2];

				// 둘이 같은 집합이 아니면, 연결해버리기
				if(find(parent, start) != find(parent, end)) {
					union(parent, start, end);
					edgeCount++;
					totalCost += nowCost;
				}

				if(edgeCount == n-1) break;
			}

			return totalCost;
		}

		private int find(int[] parent, int x) {
			if(parent[x] == x) return x;
			return parent[x] = find(parent, parent[x]);
		}

		private void union(int[] parent, int start, int end) {
			int rootStart = find(parent, start);
			int rootEnd = find(parent, end);
			parent[rootEnd] = rootStart;
		}
	}

	//     public int solution(int n, int[][] costs) {
	//         PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getCost(), b.getCost()));
	//         boolean[] isConnected = new boolean[n];
	//         int connectCount = 0;
	//         int totalCost = 0;

	//         for(int[] cost : costs) {
	//             pq.offer(new Edge(cost));
	//         }

	//         while(true) {
	//             Edge nowEdge = pq.poll();
	//             int start = nowEdge.getStart();
	//             int end = nowEdge.getEnd();

	//             // 이미 두개 다 섬이 연결된 상태면 굳이 할 필요가 없음 여기는
	//             if(isConnected[start] && isConnected[end]) continue;

	//             // 이제 섬 연결하기.
	//             if(!isConnected[start]) {
	//                 connectCount++;
	//                 isConnected[start] = true;
	//             }

	//             if(!isConnected[end]) {
	//                 connectCount++;
	//                 isConnected[end] = true;
	//             }

	//             totalCost += nowEdge.getCost();

	//             if(connectCount == n) break;
	//         }

	//         return totalCost;
	//     }

	//     private class Edge {
	//         private int start;
	//         private int end;
	//         private int cost;

	//         public Edge(int[] info) {
	//             this.start = info[0];
	//             this.end = info[1];
	//             this.cost = info[2];
	//         }

	//         public int getStart() { return this.start; }
	//         public int getEnd() { return this.end; }
	//         public int getCost() { return this.cost; }
	//     }
	// }
}
