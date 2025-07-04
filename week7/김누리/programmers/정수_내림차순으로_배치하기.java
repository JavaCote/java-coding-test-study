package week7.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : 정수_내림차순으로_배치하기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-09
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 09.     김누리(NRKim)               Initial creation
 */

/*
*
* 간단한 흐름 정리
* 1.  long n을 String 타입으로 변환
* 2.  1의 결과값을 각 자리별로 분해
* 3.  정렬
* 4.  String 타입 >> Long 타입으로
*
*/

public class 정수_내림차순으로_배치하기 {
	public long solution(long n) {
		long answer = 0;
		String v = Long.toString(n);
		String[] vArr = v.split("");
		StringBuilder sb = new StringBuilder();

		Arrays.sort(vArr);

		for(int i = vArr.length-1; i >= 0; i--) {
			sb.append(vArr[i]);
		}

		String tmp = sb.toString();

		answer = Long.parseLong(tmp);

		return answer;
	}
}
