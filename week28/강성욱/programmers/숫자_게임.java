package week28.강성욱.programmers;

import java.util.TreeMap;

/**
 * PackageName : week28.강성욱.programmers
 * FileName    : 숫자_게임
 * Author      : Baekgwa
 * Date        : 25. 11. 14.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 25. 11. 14.     Baekgwa               Initial creation
 */
public class 숫자_게임 {
	// 음 가장 작은 차이로 이기는게 그냥 베스트 아닌가?
	// 5, 1, 3, 7
	// 6, 2, 8, 패배
	// 만약 패배하는 케이스에서는 가장 작은 숫자를 내버리기? ㅇㅇ 그럼 될듯?
	// 그럼 TreeSet 사용해볼까?
	// 아 같은숫자 여러개 나오네.. 그럼 Map 으로

	class Solution {
		public int solution(int[] A, int[] B) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>(); //key : 숫자, value : 등장 개수

			for (int b : B) {
				treeMap.put(b, treeMap.getOrDefault(b, 0) + 1);
			}

			int winCount = 0;

			for (int a : A) {
				Integer key = treeMap.higherKey(a);

				if (key != null) {
					winCount++;
				} else {
					key = treeMap.firstKey();
				}

				// TreeMap 에서 감소 혹은 삭제 처리
				int count = treeMap.get(key);
				if (count == 1) {
					treeMap.remove(key);
				} else {
					treeMap.put(key, count - 1);
				}
			}

			return winCount;
		}
	}
}
