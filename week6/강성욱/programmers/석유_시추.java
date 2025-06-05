package week6.강성욱.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PackageName : week6.강성욱.programmers
 * FileName    : 석유_시추
 * Author      : Baekgwa
 * Date        : 2025-06-05
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-05     Baekgwa               Initial creation
 */
public class 석유_시추 {
	class Solution {
		int[][] map;
		boolean[][] visited;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		int maxX, maxY;

		public int solution(int[][] land) {
			maxY = land.length;
			maxX = land[0].length;
			map = land;
			visited = new boolean[maxY][maxX];

			List<OilCluster> clusters = new ArrayList<>();
			int[][] clusterMap = new int[maxY][maxX];

			for (int y = 0; y < maxY; y++) {
				for (int x = 0; x < maxX; x++) {
					if (map[y][x] == 1 && !visited[y][x]) {
						OilCluster cluster = new OilCluster(clusters.size() + 1);
						check(y, x, cluster, clusterMap);
						clusters.add(cluster);
					}
				}
			}

			int answer = 0;
			for (int x = 0; x < maxX; x++) {
				Set<Integer> uniqueClusters = new HashSet<>();
				int totalOil = 0;
				for (int y = 0; y < maxY; y++) {
					if (clusterMap[y][x] > 0) {
						int clusterIdx = clusterMap[y][x] - 1;
						if (!uniqueClusters.contains(clusterIdx)) {
							uniqueClusters.add(clusterIdx);
							totalOil += clusters.get(clusterIdx).size;
						}
					}
				}
				answer = Math.max(answer, totalOil);
			}

			return answer;
		}

		// 현재 좌표에서 연결된 석유 덩어리 크기를 구해서 cluster, clusterMap에 반영
		private void check(int y, int x, OilCluster cluster, int[][] clusterMap) {
			visited[y][x] = true;
			cluster.add();
			clusterMap[y][x] = cluster.getIndex();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= maxX || ny >= maxY) continue;
				if (map[ny][nx] == 1 && !visited[ny][nx]) {
					check(ny, nx, cluster, clusterMap);
				}
			}
		}

		// 석유 덩어리 정보용 class
		private static class OilCluster {
			private final int index;
			private int size;

			OilCluster(int index) {
				this.index = index;
				this.size = 0;
			}

			public int getIndex() {
				return this.index;
			}

			public void add() {
				size++;
			}
		}
	}
}
