package week7_a.김상진.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week7_a.김상진.programmers
 * FileName    : 방문_길이
 * Author      : sangxxjin
 * Date        : 2025. 6. 13.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 13.     sangxxjin               Initial creation
 */
public class 방문_길이 {
	import java.util.*;
	class Solution {
		// 방문한 좌표에 visited처리. answer 증가는 방문하지 않은 좌표 방문 시에만
		// 변수발생 좌표가 같더라도 어디서 오는지에 따라 다를 수 있음.
		// 그러면 단순 visited가 아닌 출발->도착의 길을 기억해야함.
		// list<list>? contains로 ?
		// List<int[]> -> 이러면 배열이기떄문에 직접비교를 해야함 equals
		// 중복방지 -> set  -> 양방향을 넣어줘야함.
		// U 위, D 아래, R 오른쪽, L 왼쪽
		Set<String> visited = new HashSet<>();
		public int solution(String dirs) {

			int answer=0,x=0,y=0;
			for(int i=0; i<dirs.length(); i++){
				char dir = dirs.charAt(i);
				int dx = x;
				int dy = y;

				if(dir=='U'&&dy<5){
					dy++;
				}
				else if(dir=='D'&&dy>-5){
					dy--;
				}
				else if(dir=='R'&&dx<5){
					dx++;
				}
				else if(dir=='L'&&dx>-5){
					dx--;
				}
				else continue;
				String path1 = x+""+y+"->"+dx+""+dy;
				String path2 = dx+""+dy+"->"+x+""+y;
				if(!visited.contains(path1) && !visited.contains(path2)){
					answer++;
					visited.add(path1);
					visited.add(path2);
				}
				x=dx;
				y=dy;

			}
			return answer;
		}
	}
}
