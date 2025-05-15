package week3.김상진.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week3.김상진.programmers
 * FileName    : 달리기_경주
 * Author      : sangxxjin
 * Date        : 2025. 5. 13.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 13.     sangxxjin               Initial creation
 */
public class 달리기_경주 {
	//문제에 대하여 고민을 많이함.
	// 배열을 계속 만들면서 순서를 이동시킬까 하다가 map이 생각남
	import java.util.*;
	class Solution {
		public String[] solution(String[] players, String[] callings) {
			// 이름과 순위 저장용 map 생성 후 데이터 삽입
			Map<String, Integer> map = new HashMap<>();
			for(int i=0; i<players.length; i++){
				map.put(players[i],i);
			}
			//callings 즉 부를때마다 아래의 작업
			//앞 사람의 이름을 저장하고 players의 배열 순서 변경 및 map의 데이터 최신화
			for(String name : callings){
				int idx = map.get(name);
				String frontName = players[idx-1];
				players[idx-1]=name;
				players[idx]=frontName;

				map.put(name,idx-1);
				map.put(frontName,idx);

			}
			return players;
		}
	}
}
