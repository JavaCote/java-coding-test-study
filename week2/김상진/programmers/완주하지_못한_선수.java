package week2.김상진.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week2.김상진.programmers
 * FileName    : 완주하지_못한_선수
 * Author      : sangxxjin
 * Date        : 2025. 5. 6.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 6.     sangxxjin               Initial creation
 */
public class 완주하지_못한_선수 {
	class Solution {
		public String solution(String[] participant, String[] completion) {
			Map<String, Integer> map = new HashMap<>();
			for(String name : completion){
				map.put(name, map.getOrDefault(name,0)+1);
			}
			for(String name : participant){
				if(!map.containsKey(name)||map.get(name)==0)return name;
				map.put(name,map.get(name)-1);
			}
			return "";
		}
	}
}
