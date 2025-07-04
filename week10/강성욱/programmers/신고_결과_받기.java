package week10.강성욱.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week10.강성욱.programmers
 * FileName    : 신고_결과_받기
 * Author      : Baekgwa
 * Date        : 2025-06-30
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-30     Baekgwa               Initial creation
 */
public class 신고_결과_받기 {

	class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			Map<String, Integer> map = new HashMap<>(); //신고 횟수 저장용
			Map<String, Set<String>> historyMap = new HashMap<>(); //신고 이력 저장용
			Set<String> banSet = new HashSet<>();

			for(String re : report) {
				String[] div = re.split(" ");
				String reporter = div[0];
				String bad = div[1];

				historyMap.computeIfAbsent(reporter, v -> new HashSet<>()).add(bad);
			}

			// historyMap 으로, map 계산(id 당 신고당한 횟수)
			for(Set<String> histroySet : historyMap.values()) {
				for(String bad : histroySet) {
					map.put(bad, map.getOrDefault(bad, 0) + 1);
				}
			}

			// 정지된 id 구하기
			for(String id : map.keySet()) {
				if(map.get(id) >= k) {
					banSet.add(id);
				}
			}

			// 메일 횟수 구하기
			int[] result = new int[id_list.length];
			for(int i = 0; i < id_list.length; i++) {
				String id = id_list[i];
				int cnt = 0;
				if(historyMap.containsKey(id)) {
					for(String bad : historyMap.get(id)) {
						if(banSet.contains(bad)) {
							cnt++;
						}
					}
				}
				result[i] = cnt;
			}
			return result;
		}
	}
}
