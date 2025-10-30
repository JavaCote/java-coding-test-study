package week26.강성욱.programers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week26.강성욱.programers
 * FileName    : 뉴스_클러스터링
 * Author      : Baekgwa
 * Date        : 25. 10. 30.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 10. 30.     Baekgwa               Initial creation
 */
public class 뉴스_클러스터링 {
	// map 으로 정리해보자.
	// key : value(개수)
	// 1 : 2
	// 2 : 2
	// 3 : 1
	// 다음 입력으로, {1, 2, 2, 4, 5}
	// 1 찾고, 있으면 -1
	// 2 찾고, 있으면 -1 [여기서 1은 삭제]
	// 2 찾고, 있으면 -1 [여기서, 2는 삭제]
	// 4, 찾고 없어서 아무것도
	// 5 찾고 없어서 아무것도
	// 이렇게 하면 교집합 찾을 수 있음.

	// 2번째도 map 으로 정리
	// key : value(개수)
	// 1 : 1
	// 2 : 2
	// 4 : 1
	// 5 : 1

	// 이거 두개 기반으로, key 당 max 치의 숫자를 구하면 합집합?
	// 그럼, 1번map, 2번map 둘다 iter key 돌면서 확인하면 될듯?

	class Solution {

		public static final String regex = "[A-Z]{2}";

		public int solution(String str1, String str2) {
			Map<String, Integer> map1 = new HashMap<>();
			Map<String, Integer> map2 = new HashMap<>();

			for(int i=0; i<str1.length()-1; i++) {
				String token = str1.substring(i, i+2).toUpperCase();
				if(!token.matches(regex)) continue;
				map1.compute(token, (k, v) -> v == null ? 1 : v + 1);
			}

			for(int i=0; i<str2.length()-1; i++) {
				String token = str2.substring(i, i+2).toUpperCase();
				if(!token.matches(regex)) continue;
				map2.compute(token, (k, v) -> v == null ? 1 : v + 1);
			}

			Set<String> keySet = new HashSet<>();
			keySet.addAll(map1.keySet());
			keySet.addAll(map2.keySet());

			double innerSum = 0;
			double outerSum = 0;
			for(String key : keySet) {
				innerSum += Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
				outerSum += Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
			}

			if(outerSum == 0) return 65536;

			return (int)(innerSum / outerSum * 65536);
		}
	}
}
