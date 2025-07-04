package week8.김누리.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 충돌위험_찾기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-19
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 19.     김누리(NRKim)               Initial creation
 */


/*
points = [[3, 2], [6, 4], [4, 7], [1, 4]]
points = [[y, x], [y, x], [y, x], [y, x]]

routes = [[4, 2], [1, 3], [2, 4]] ==> 이거는 좌표 아님

routes[0][0] = [4,2] ==> 4번 위치 --> 2번 위치로 간다.

그러면 map을 2개 쓰자

1번 맵
map = {
 1 = {3,2},
 2 = {6,4},
 3 = {4,7},
 4 = {1,4}
}


이후 2번 맵에 시간별 로봇의 이동 경로를 카운팅 하며 충돌 위치 파악

※  초기에 map을 통해 물류 창고 설정 map 초기화는 OK 그러나 이후 경로 설정 및 충돌 로직 구현에서
   AI 도구 이용. 추후 다시 풀어봐야 함
*/



public class 충돌위험_찾기 {
	public int solution(int[][] points, int[][] routes) {
		int answer = 0;
		Map<Integer, int[]> map = new HashMap<>();

		int position = 1;
		// 물류센터 포지션 저장 맵 초기화
		for(int[] p : points) {
			map.put(position++, p);
		}

		// 각 로봇별 시간순 경로 저장 (시간 -> 위치)
		List<List<int[]>> robotPaths = new ArrayList<>();

		// 각 로봇의 전체 경로 계산
		for(int[] route : routes) {
			List<int[]> path = new ArrayList<>();

			// 시작 위치 추가
			int[] currentPos = map.get(route[0]).clone();
			path.add(currentPos.clone());

			// 각 목표점까지의 경로 계산
			for(int i = 1; i < route.length; i++) {
				int[] target = map.get(route[i]);

				// r 좌표부터 이동
				while(currentPos[0] != target[0]) {
					if(currentPos[0] < target[0]) currentPos[0]++;
					else currentPos[0]--;
					path.add(currentPos.clone());
				}

				// c 좌표 이동
				while(currentPos[1] != target[1]) {
					if(currentPos[1] < target[1]) currentPos[1]++;
					else currentPos[1]--;
					path.add(currentPos.clone());
				}
			}

			robotPaths.add(path);
		}

		// 최대 시간 찾기
		int maxTime = 0;
		for(List<int[]> path : robotPaths) {
			maxTime = Math.max(maxTime, path.size());
		}

		// 각 시간별로 충돌 검사
		for(int time = 0; time < maxTime; time++) {
			Map<String, List<Integer>> positionRobots = new HashMap<>();

			// 각 로봇의 현재 시간 위치 확인
			for(int robotId = 0; robotId < robotPaths.size(); robotId++) {
				List<int[]> path = robotPaths.get(robotId);
				if(time < path.size()) {
					int[] pos = path.get(time);
					String posKey = pos[0] + "," + pos[1];
					positionRobots.computeIfAbsent(posKey, k -> new ArrayList<>()).add(robotId);
				}
			}

			// 같은 위치에 2대 이상 있는 경우 충돌 발생
			for(List<Integer> robots : positionRobots.values()) {
				if(robots.size() > 1) {
					answer++; // 한 위치에서 충돌이 발생하면 1 증가
				}
			}
		}

		return answer;
	}
}
