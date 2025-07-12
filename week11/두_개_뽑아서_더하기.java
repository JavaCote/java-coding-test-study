package week11;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week11
 * FileName    : 두_개_뽑아서_더하기
 * Author      : Baekgwa
 * Date        : 2025-07-07
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-07     Baekgwa               Initial creation
 */
public class 두_개_뽑아서_더하기 {
	// 반복?
	// (인덱스) 0, 0+1, 0+1+2 .... => 100번 반복
	// 그게 총 100번 반복 (크게 잡아서)
	// 그럼, 100^2
	// 할만하네
	// 중복은 Set으로 해결

	class Solution {
		public int[] solution(int[] numbers) {

			Set<Integer> resultSet = new HashSet<>();

			for(int i=0; i<numbers.length; i++) {
				for(int j=i+1; j<numbers.length; j++) {
					//두 수 더하기
					resultSet.add(numbers[i] + numbers[j]);
				}
			}

			return resultSet.stream().sorted().mapToInt(m -> m).toArray();
		}
	}
}
