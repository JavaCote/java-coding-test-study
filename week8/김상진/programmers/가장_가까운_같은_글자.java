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
	//map에 데이터를 넣으면서 index를 저
	import java.util.*;
	class Solution {
		public int[] solution(String s) {
			Map<Character,Integer> map = new HashMap<>();
			int[] answer = new int[s.length()];
			for(int i=0; i<s.length(); i++){
				char c = s.charAt(i);
				if(!map.containsKey(c)){
					map.put(c,i);
					answer[i]=-1;
				}
				else {
					answer[i]=i-map.get(c);
					map.put(c,i);

				}
			}
			return answer;
		}
	}
}
