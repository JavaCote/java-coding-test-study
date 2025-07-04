package week4.김상진.programmers;

import java.util.Arrays;

/**
 * PackageName : week4.김상진.programmers
 * FileName    : 가장_큰_수
 * Author      : sangxxjin
 * Date        : 2025. 5. 21.
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 5. 21.     sangxxjin               Initial creation
 */
public class 가장_큰_수 {
	//먼저 바로 밑에 있는 방법으로 풀었습니다.
	//정렬을 직접하면서 맨 앞의 숫자가 크면 앞으로 오면 된다고 생각해서 구현
	//하지만 시간초과가 빈번하게 일어남 이중for문때문 그래서 맨 아래의 방법으로 풀음
	import java.util.*;
	public class Solution {
		public String solution(int[] numbers) {
			for (int i = 0; i < numbers.length - 1; i++) {
				for (int j = 0; j < numbers.length - 1 - i; j++) {
					int a = numbers[j];
					int b = numbers[j + 1];

					if (compare(a, b) < 0) {
						int temp = numbers[j];
						numbers[j] = numbers[j + 1];
						numbers[j + 1] = temp;
					}
				}
			}

			if (numbers[0] == 0) return "0";

			StringBuilder sb = new StringBuilder();
			for (int n : numbers) {
				sb.append(n);
			}

			return sb.toString();
		}

		private int compare(int a, int b) {
			int ab = concat(a, b);
			int ba = concat(b, a);
			return Integer.compare(ab, ba);
		}

		private int concat(int x, int y) {
			int digits = 1;
			for (int temp = y; temp > 0; temp /= 10) {
				digits *= 10;
			}
			return x * digits + y;
		}
	}
	import java.util.*;
	public class Solution {
		public String solution(int[] numbers) {
			String[] strs = new String[numbers.length];

			for (int i = 0; i < numbers.length; i++) {
				strs[i] = String.valueOf(numbers[i]);
			}
			//Arrays.sort(strs, 정렬조건)
			// 정렬조건 = (a, b) -> (b + a).compareTo(a + b)
			// 두 수의 비교 = (b + a).compareTo(a + b) -> b+a가 크면 1 같으면 0 작으면 -1
			// 까지 이해했는데  Arrays.sort(strs, (a,b)->1)); 이런게 이해가 잘 안됌..
			Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

			if (strs[0].equals("0")) return "0";

			StringBuilder sb = new StringBuilder();
			for (String s : strs) {
				sb.append(s);
			}

			return sb.toString();
		}
	}



}
