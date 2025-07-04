package week9.김누리.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week9.김누리.programmers
 * FileName    : 나누어_떨어지는_숫자_배열
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-24
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 24.     김누리(NRKim)               Initial creation
 */

public class 나누어_떨어지는_숫자_배열 {
	public int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();

		for(int i : arr) {
			if ( i % divisor == 0 ) {
				list.add(i);
			}
		}

		int[] answer = new int[list.size()];

		if (list.size() == 0) return new int[] {-1};

		Collections.sort(list);

		int idx = 0;
		for(int i : list) answer[idx++] = i;

		return answer;
	}
}
