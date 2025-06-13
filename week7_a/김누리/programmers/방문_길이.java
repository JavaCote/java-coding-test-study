package week7_a.김누리.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week7_a.김누리.programmers
 * FileName    : 방문_길이
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-14
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 14.     김누리(NRKim)               Initial creation
 */

/*
U = 위로
D = 아래로
R = 우측
L = 좌측

시작 : 0,0

ULURRDLLU 인 경우

1.   0,1
2.  -1,1
3.  -1,2
4.   0,2
5.   1,2
6.   1,1
7.   0,1
8.  -1,1
9.  -1,2
*/

public class 방문_길이 {
	public int solution(String dirs) {
		int answer = 0;
		int x = 0;
		int y = 0; // 시작점
		Set<String> set = new HashSet<>(); //  이동 완료 현재 좌표
		Map<String,int[]> map = new HashMap<>(); //  상하좌우 맵
		map.put("U", new int[] {0,1});
		map.put("D", new int[] {0,-1});
		map.put("R", new int[] {1,0});
		map.put("L", new int[] {-1,0});

		String[] dir = dirs.split("");

		//  명령어 만큼 반복
		for(String d : dir) {
			int[] now = map.get(d);
			int nx = x + now[0];
			int ny = y + now[1];

			if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;

			String path1 = x + "," + y + ">" + nx + "," + ny; // 배열로 하면 안풀리니... String 화 : x,y >> nx,ny
			String path2 = nx + "," + ny + ">" + x + "," + y; // 배열로 하면 안풀리니... String 화 : nx,ny >> x,y

			if(!set.contains(path1) && !set.contains(path2)) {
				set.add(path1);
				set.add(path2);
				answer++;
			}

			x = nx;
			y = ny;
		}

		return answer;
	}
}
