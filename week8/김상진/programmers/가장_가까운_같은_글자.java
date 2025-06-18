package week8.김상진.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week8.김상진.programmers
 * FileName    : 가장_가까운_같은_글자
 * Author      : sangxxjin
 * Date        : 2025. 6. 13.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 13.     sangxxjin               Initial creation
 */
public class 가장_가까운_같은_글자 {
	import java.util.*;
	class Solution {
		public int[] solution(String s) {
			Map<Character,Integer> map = new HashMap<>();
			int[] answer = new int[s.length()];
			for(int i=0; i<s.length(); i++){
				char c = s.charAt(i);
				//해당 문자가 앞에 나오지 않았으면 map에 문자와 index를 넣으면서 -1저장
				if(!map.containsKey(c)){
					map.put(c,i);
					answer[i]=-1;
				}
				//앞에 나왔던 문자면 해당 index에 차이 넣고 값 갯ㅇ신
				else {
					answer[i]=i-map.get(c);
					map.put(c,i);

				}
			}
			return answer;
		}
	}
}
