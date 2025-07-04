package week8_a.강성욱.programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * PackageName : week8_a.강성욱.programmers
 * FileName    : 롤케이크_자르기
 * Author      : Baekgwa
 * Date        : 2025-06-23
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-23     Baekgwa               Initial creation
 */
public class 롤케이크_자르기 {
	//일정 문자열에서 어느 지점을 잘랐을때, 그 지점 기준으로 토핑의 종류가 같으면 공평한 것.
	// 공평하지 못할 수도 있음.
	// 최대 1,000,000 길이의 토핑 종류가 들어옴...
	// 공평하게 자르는 방법의 수를 모두 체크해야됨. (거의 완탐)
	// set 두개를 사용해서 넣고 빼고 사이즈 비교? 하면 되긴함.
	// 마지막까지 다 잘라봐야지 모두 체크가 가능할듯
	// 아 이거 set 쓰면 안된다. map 으로 해야된다.

	class Solution {
		public int solution(int[] topping) {
			Map<Integer, Integer> mapLeft = new HashMap<>();
			Map<Integer, Integer> mapRight = new HashMap<>();
			int result = 0;

			//전부 다 right 에 다 박아두기. 자르기 전이라는 가정
			for(int i=0; i<topping.length; i++) {
				mapRight.put(topping[i], mapRight.getOrDefault(topping[i], 0) + 1);
			}

			//굳이 명시적으로 두개로 나눌 필요는 없네 조건분기 하면될듯?
			//leftEnd = 잘랐을때 왼쪽의 마지막 인덱스 번호
			for(int leftEnd=0; leftEnd<topping.length; leftEnd++) {
				mapLeft.put(topping[leftEnd], mapLeft.getOrDefault(topping[leftEnd], 0) + 1);
				if(mapRight.get(topping[leftEnd]) <= 1) mapRight.remove(topping[leftEnd]);
				else mapRight.replace(topping[leftEnd], mapRight.get(topping[leftEnd]) - 1);

				if(mapLeft.keySet().size() == mapRight.keySet().size()) {
					result++;
				}
			}

			return result;
		}
	}
}
