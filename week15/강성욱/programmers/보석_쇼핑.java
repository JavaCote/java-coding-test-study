package week15.강성욱.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PackageName : week15.강성욱.programmers
 * FileName    : 보석_쇼핑
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 보석_쇼핑 {
	//0~끝 인덱스까지 다사면 무조건 다 살 수 있다.
	//끝 인덱스부터 하나씩 없애면서 확인해보기.
	//그렇게 빼다가 더 이상 뺄 수 없으면, 그게 오른쪽 인덱스의 끝 지점.
	//0번 인덱스부터 1, 2, 3... 까지 확인
	//그렇게 빼다가 더 뺄수 없으면 왼쪽 끝지점.

	//근데, 중간에 뺄때마다 다 계산하는건 너무 비효율 적임. 메모리제이션 해야됨.

	class Solution {
		//     public int[] solution(String[] gems) {
		//         int[] result = new int[2];
		//         int left = 0;
		//         int right = gems.length-1;

		//         Set<String> set = new HashSet<>(); //총 몇종류 있는지 확인하는 set
		//         Map<String, Integer> map = new HashMap<>(); // left ~ right 까지 얼마나 있는지 확인
		//         for(String gem : gems) {
		//             set.add(gem);
		//             map.put(gem, map.getOrDefault(gem, 0) + 1);
		//         }

		//         //right 최적화 하기
		//         while(right > 0) {
		//             String nowGem = gems[right]; //이번에 빼야될 숫자.
		//             int count = map.getOrDefault(nowGem, 0);

		//             if(count > 1) {
		//                 map.put(nowGem, count -1);
		//                 right--;
		//             } else {
		//                 break;
		//             }
		//         }
		//         result[1] = right - 1; //인덱스라 +1 해줘야함

		//         //left 최적화 하기
		//         while(left < right) {
		//             String nowGem = gems[left]; //이번에 빼야될 숫자.
		//             int count = map.getOrDefault(nowGem, 0);

		//             if(count > 1) {
		//                 map.put(nowGem, count -1);
		//                 left++;
		//             } else {
		//                 break;
		//             }
		//         }
		//         result[0] = left + 1; //인덱스라 +1 해줘야함

		//         return result;
		//     }

		//left right, 번갈아가면서 처리해야될듯?
		public int[] solution(String[] gems) {
			int[] result = new int[2];
			int left = 0;
			int right = 0;
			int minLen = Integer.MAX_VALUE;

			Map<String, Integer> map = new HashMap<>();
			Set<String> set = new HashSet<>(); // 보석 종류 확인용 set
			for(String gem : gems) {
				set.add(gem);
			}

			while(true) {
				//왼쪽을 늘릴지, 오른쪽을 늘릴지 어떻게 판단? set 종류와 현재 map 에 들어있는걸 비교하면 될듯?
				//모든 종류의 보석이 다 담겨있음 현재 map에. 그럼 left ++ 해서 줄여봐야함
				if (map.size() == set.size()) {
					if (right - left < minLen) {
						minLen = right - left;
						result[0] = left + 1;  // 1-based
						result[1] = right;     // 1-based
					}
					// 왼쪽 빼기
					String nowGem = gems[left];
					map.put(nowGem, map.get(nowGem) - 1);
					if (map.get(nowGem) == 0) map.remove(nowGem);
					left++;
				}
				// 모든 종류가 아직 안 들어왔으면 right++
				else {
					if (right == gems.length) break; // 오른쪽 끝 도달 시 종료
					String nowGem = gems[right];
					map.put(nowGem, map.getOrDefault(nowGem, 0) + 1);
					right++;
				}
			}

			return result;
		}
	}
}
