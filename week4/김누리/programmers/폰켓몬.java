package week4.김누리.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 폰켓몬
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-20
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 20.     김누리(NRKim)               Initial creation
 */

/*
*
* nums 배열의 절반만 획득 가능
* 그리고 가능한 중복없이 골라야함. >> HashSet 이용
* 이후 Hash의 사이즈가 선택 가능한 수 보다 크면 ? >> 선택 가능한 수만 반환
* 아니면 그냥 선택한 수 그대로 반환
*
*/

public class 폰켓몬 {
	public int solution(int[] nums) {
		int answer = 0;
		int get = nums.length/2; //  선택 가능한 수
		Set<Integer> set = new HashSet<>();

		for (int i : nums) {
			set.add(i);
		}

		if (set.size() > get) answer = get;
		if (set.size() <= get) answer = set.size();


		return answer;
	}
}
