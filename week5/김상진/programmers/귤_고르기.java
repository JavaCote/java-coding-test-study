package week5.김상진.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PackageName : week5.김상진.programmers
 * FileName    : 귤_고르기
 * Author      : sangxxjin
 * Date        : 2025. 5. 26.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 26.     sangxxjin               Initial creation
 */
public class 귤_고르기 {
	// 문제를 보고 사이즈별 개수를 구하기 위해 map을 먼저 생각
	// 다른 사람들의 풀이를 보니 아래의 방법으로 푸는 경우도 많음
	// List<Integer> list = new ArrayList<>(map.keySet());
	// list.sort((o1, o2) -> map.get(o2)-map.get(o1));
	// 리스트에 map의 key값들을 넣어놓고 value를 기준으로 내림차순
	// 하지만 실전 코테에서 이렇게 푸는것은 반복 학습으로 숙달이 필요함
	import java.util.*;
	class Solution {
		public int solution(int k, int[] tangerine) {
			int answer = 0;
			Map<Integer, Integer> map = new HashMap<>();
			for(int i : tangerine){
				map.put(i, map.getOrDefault(i,0)+1);
			}
			List<Integer> arr = new ArrayList<>();
			for(int i : map.values()){
				arr.add(i);
			}
			Collections.sort(arr, Collections.reverseOrder());
			int sum =0;
			for(int i : arr){
				sum+=i;
				answer++;
				if(sum >= k)break;
			}

			return answer;
		}
	}
}
