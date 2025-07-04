package week7.김상진.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PackageName : week7.김상진.programmers
 * FileName    : 정수_내림차순으로_배치하기
 * Author      : sangxxjin
 * Date        : 2025. 6. 8.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 6. 8.     sangxxjin               Initial creation
 */
public class 정수_내림차순으로_배치하기 {
	// 숫자를 list에 넣고 정렬 후 계산.
	import java.util.*;
	class Solution {
		public long solution(long n) {
			List<Integer> arr = new ArrayList<>();
			while (n > 0) {
				arr.add((int)(n % 10));
				n /= 10;
			}

			arr.sort(Collections.reverseOrder());

			long answer = 0;
			for (int num : arr) {
				answer = answer * 10 + num;
			}
			return answer;
		}
	}

}
