package week4.김상진.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 포켓몬
 * Author      : sangxxjin
 * Date        : 2025. 5. 21.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 21.     sangxxjin               Initial creation
 */
public class 포켓몬 {
	// 처음에 문제의 이해를 잘못했었음.
	// 최대한 많이 고르는 종류의 수가 아니라 최대한 많이 골랐을때 몇 종류인지를 구하는 문제였음.
	//  Set을 사용하여 배열의 반절과 중복제거한 종류의 개수를 가지고 결과 도출 가능 파악
	import java.util.*;
	class Solution {
		public int solution(int[] nums) {
			HashSet<Integer> types = new HashSet<>();
			for (int n : nums) types.add(n);
			return Math.min(types.size(), nums.length / 2);
		}
	}


}
