package week9.강성욱.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week9.강성욱.programmers
 * FileName    : 나누어_떨어지는_숫자_배열
 * Author      : Baekgwa
 * Date        : 2025-06-25
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-25     Baekgwa               Initial creation
 */
public class 나누어_떨어지는_숫자_배열 {
	// 범위가 딱히 나와있진않음.
	// 딱히 생각나는 알고리즘도 없음. 반복문으로 해결하자 그냥

	class Solution {
		public int[] solution(int[] arr, int divisor) {
			List<Integer> result = new ArrayList<>();

			for(int val : arr) {
				if(val % divisor == 0) result.add(val);
			}

			if(result.isEmpty()) return new int[]{-1};

			Collections.sort(result);
			return result.stream().mapToInt(Integer::intValue).toArray();
		}
	}
}
