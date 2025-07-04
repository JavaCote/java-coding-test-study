package week10.강성욱.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 지게차와_크레인
 * Author      : Baekgwa
 * Date        : 2025-06-30
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-30     Baekgwa               Initial creation
 */
public class 지게차와_크레인 {
	// 세로 n, 가로 m
	// 꺼내는 조건이 2개 존재
	// 1. 지게차로 외부에 노출 된 친구들만 처리가 가능한거
	// 2. 크레인으로 해당하는거 모두 꺼낼 수 있는거.
	// 남은 컨테이너 수를 return 해야됨.
	// 1번 지게차로 외부에 노출된 컨테이너만 꺼내는걸 어떻게 구현해야될까?
	// 만약 반복문으로, 4방 확인하여 있는지 없는지 검사를 한다면?
	// 50x50*4 이니깐, 10,000 개 확인
	// 근데 이렇게 검사하면, 중간에 비어있는 경우 검사 등등, 너무 조건이 빡세다. 다른방법.
	//----
	// 초기에는 외부에 있는 모든 데이터의 [x, y] 좌표를 모두 저장
	// 다음부터는, (외부와 노출되고 && 비어있는 곳) 에서 dfs 나 bfs 를 하면서 좌표 추가?
	// 매번 할 필요는 없고, 지게차로 빼는 명령어가 들어오면 실시하면 될듯.
	// 와 1시간 반 걸림; 뭐가 이리도 복잡하냐

	class Solution {

		public static final char NOT_EXIST = '.';
		public static final int dx[] = {0, 1, 0, -1};
		public static final int dy[] = {1, 0, -1, 0};
		public static int maxX = Integer.MIN_VALUE;
		public static int maxY = Integer.MIN_VALUE;

		public int solution(String[] storage, String[] requests) {
			maxX = storage[0].length();
			maxY = storage.length;

			char[][] map = new char[maxY][maxX];

			//2차원 map 으로 변환
			for(int y=0; y<maxY; y++) {
				map[y] = storage[y].toCharArray();
			}

			// request 정리
			for(String request : requests) {
				char target = request.charAt(0);
				if(request.length() == 1) {
					map = removeCanMove(map, target);
				} else {
					map = removeAll(map, target);
				}
			}

			// map에 있는 남아이있는 container 검사
			int result = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] != NOT_EXIST) result++;
				}
			}

			return result;
		}

		private char[][] removeAll(char[][] map, char target) {
			for (int y = 0; y < maxY; y++) {
				for( int x=0; x< maxX; x++) {
					if(map[y][x] == target) map[y][x] = NOT_EXIST;
				}
			}

			return map;
		}

		private char[][] removeCanMove(char[][] map, char target) {
			boolean[][] visited = new boolean[maxY][maxX];
			Queue<Point> q = new LinkedList<>();
			List<Point> removeTargetList = new ArrayList<>(); //제거해야될 포인트. 이때 제거는 NOT_EXIST로 만드는 것

			//먼저 removeTargetList 에는, 외부 값들은 모두 들어가면됨.
			//단, 메모리 활용을 위해, target과 매칭되는 것만 넣기
			for(int x=0; x<maxX; x++) {
				//0번 y
				if(map[0][x] == target) {
					visited[0][x] = true;
					removeTargetList.add(new Point(x, 0));
				}
				//maxY-1번 y
				if(map[maxY-1][x] == target){
					visited[maxY-1][x] = true;
					removeTargetList.add(new Point(x, maxY-1));
				}

				//Queue에 비어있는 곳이 있다면, 그곳에서 시작하게 queue에 미리 넣기
				if(map[0][x] == NOT_EXIST) {
					q.add(new Point(x, 0));
					visited[0][x] = true;
				}
				if(map[maxY-1][x] == NOT_EXIST) {
					q.add(new Point(x, maxY-1));
					visited[maxY-1][x] = true;
				}
			}

			for(int y=0; y<maxY; y++) {
				if(map[y][0] == target) {
					visited[y][0] = true;
					removeTargetList.add(new Point(0, y));
				}
				if(map[y][maxX-1] == target){
					visited[y][maxX-1] = true;
					removeTargetList.add(new Point(maxX-1, y));
				}
				if(map[y][0] == NOT_EXIST) {
					q.add(new Point(0, y));
					visited[y][0] = true;
				}
				if(map[y][maxX-1] == NOT_EXIST) {
					q.add(new Point(maxX-1, y));
					visited[y][maxX-1] = true;
				}
			}


			//BFS로, 비어잇는곳 시작해서 이동 가능한 곳을 탐색하며, removeTargetList에 추가할 것 찾기
			while(!q.isEmpty()) {
				Point p = q.poll();
				for(int d=0; d<4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];

					if(nx < 0 || nx >= maxX || ny < 0 || ny >= maxY) continue;
					if(visited[ny][nx]) continue;

					if(map[ny][nx] == NOT_EXIST) {
						q.add(new Point(nx, ny));
						visited[ny][nx] = true;
					} else if(map[ny][nx] == target) {
						removeTargetList.add(new Point(nx, ny));
						visited[ny][nx] = true;
					}
				}
			}

			// removeTargetList 기반으로 map 다시 재구성해서 반환
			for(Point pt : removeTargetList) {
				map[pt.getY()][pt.getX()] = NOT_EXIST;
			}

			return map;
		}


		private static class Point {
			private final int x;
			private final int y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			public int getX() { return this.x; }
			public int getY() { return this.y; }
		}
	}
}
