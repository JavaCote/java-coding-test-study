package week25.강성욱.programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week25.강성욱.programers
 * FileName    : 순위_검색
 * Author      : Baekgwa
 * Date        : 2025-10-23
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-10-23     Baekgwa               Initial creation
 */
public class 순위_검색 {
	// 이거 각 조합을 string 으로 이어서 그냥 map 에다가 list로 점수 저장해두며 ㄴ안되나?
	// 아 - 처리가 애매하려나?
	// 그건 상관없구나, 잘만하면 되게넹
	//---
	// 미리 - 를 포함한걸 만들어 두면 되겠네.
	// 이진탐색 안하면 효율성에서 터짐
	class Solution {

		public static final Map<String, List<Integer>> map = new HashMap<>();

		public int[] solution(String[] info, String[] query) {

			for(String inf : info) {
				String[] infoArray = inf.split(" ");
				dfs(infoArray, 0, ""); // map 에다가 - 혹은 "java" 를 붙여가면서 케이스 찾아두기
			}

			for(List<Integer> list : map.values()) {
				Collections.sort(list);
			}

			// 쪼개서 토큰화
			int[] result = new int[query.length];
			int i=0;
			for(String qur : query) {
				String[] queryArray = qur.split(" and | ");
				String key = queryArray[0] + queryArray[1] + queryArray[2] + queryArray[3];
				int score = Integer.parseInt(queryArray[4]);

				result[i++] = findCount(key, score);
			}

			return result;
		}

		public void dfs(String[] info, int depth, String key) {
			if(depth == 4) {
				int score = Integer.parseInt(info[4]);
				map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
				return;
			}

			String nowKey = info[depth];
			dfs(info, depth + 1, key + nowKey);
			dfs(info, depth + 1, key + "-");
		}

		// targetValue 이상인걸 찾아야함
		// 이진탐색으로 처리
		public int findCount(String targetKey, int targetValue) {
			if(!map.containsKey(targetKey)) {
				return 0;
			}

			// // 정렬
			List<Integer> valueList = map.get(targetKey);
			// Collections.sort(valueList);

			// 이진탐색
			int left = 0;
			int right = valueList.size();

			while(left < right) {
				int mid = (left + right) / 2;

				if(valueList.get(mid) >= targetValue) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			return valueList.size() - left;
		}
	}
}
