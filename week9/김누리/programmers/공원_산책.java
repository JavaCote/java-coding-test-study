package week9.김누리.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week9.김누리.programmers
 * FileName    : 공원_산책
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-23
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 23.     김누리(NRKim)               Initial creation
 */


/*
int[] start = new int [2];
int[] goal = new int [2];

0.  좌표값 초기화
Map<String, Integer>map = new HashMap<>();

map.put("E",1);
map.put("W",-1);
map.put("N",1);
map.put("S",-1);

1.  park 배열 2차원 배열화
2.  시작점 셋팅
3.  명령어 배열화
4.  1번에서 2차원 배열화 한 배열에서 [i][j]이 O 면 이동 가능, X 면 이동 불가 판정을 내리며 진행

*/
public class 공원_산책 {
	public int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];
		String[][] parks = new String[park.length][];
		String[][] commands = new String[routes.length][];
		int[] start = new int[2]; // 시작점 y,x 순번
		Map<String, Integer> map = new HashMap<>();

		//  0.  좌표값 초기화
		map.put("E",1);
		map.put("W",-1);
		map.put("S",1);
		map.put("N",-1);


		//  1.  park 배열 2차원 배열화
		for(int i = 0; i < park.length; i++) {
			//
			String now = park[i];
			String[] tmp = now.split("");

			parks[i] = tmp;
		}

		//  2.  시작점 셋팅
		for (int i = 0; i < parks.length; i++) {
			for (int j = 0; j < parks[0].length; j++) {
				if(parks[i][j].equals("S")) {
					start[0] = i;
					start[1] = j;
				}
			}
		}

		int h = parks.length; // 높이
		int w = parks[0].length; // 너비

		//  3.  명령어 2차원 배열화
		for(int i = 0; i < routes.length; i++) {
			String now = routes[i];
			String[] tmp = now.split(" ");

			commands[i] = tmp;
		}

		//  4.  로직 구현
		for(int i = 0; i < commands.length; i++) {
			String obj = commands[i][0];
			int dist = Integer.parseInt(commands[i][1]);

			//  현재 x축 y축
			int x = 0;
			int y = 0;

			//  방향이 x 축인 경우
			if(obj.equals("E") || obj.equals("W")) {
				x = map.get(obj);
			} else {
				y = map.get(obj);
			}

			//  막혀 있는지 체크
			boolean isBlocked = false;
			int nx = start[1];
			int ny = start[0];

			//  새 x,y 좌표값 계산
			for(int j = 0; j < dist; j++) {
				ny += y;
				nx += x;

				//  이동 후 x,y값이 맵의 크기를 벗어나지 않고, 해당 위치가 X면 안가고 패스
				if(ny < 0 || ny >= h || nx < 0 || nx >= w || parks[ny][nx].equals("X")) {
					isBlocked = true;
					break;
				}
			}

			//  정상 케이스인 경우 > 신규 y,x 축을 다시 시작점으로
			if(!isBlocked) {
				start[0] = ny;
				start[1] = nx;
			}
		}

		int idx = 0;
		//  5.  start >> answer
		for(int i : start) {
			answer[idx++] = i;
		}

		return answer;
	}
}
