package week4.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week4.김누리.programmers
 * FileName    : 가장_큰_수
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-19
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 19.     김누리(NRKim)               Initial creation
 */

public class 가장_큰_수 {
	public String solution(int[] numbers) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		String[] arr = new String[numbers.length];

		//  numbers 테이블을 복사하여 String 배열화
		for(int i = 0; i < numbers.length; i++) {
			arr[i] = String.valueOf(numbers[i]);
		}

		//  배열을 커스텀 하며 정렬
		Arrays.sort(arr,(s1,s2) -> (s2+s1).compareTo(s1+s2));

		//  정렬된 배열순번대로 문자열 조합
		for(String s : arr) {
			sb.append(s);
		}

		//  조합한 문자열이 00 혹은 000등 0으로만 조합된 경우는 0 리턴
		if(sb.charAt(0) == '0') {
			answer = "0";
		} else {
			answer = sb.toString();
		}

		return answer;
	}
}
