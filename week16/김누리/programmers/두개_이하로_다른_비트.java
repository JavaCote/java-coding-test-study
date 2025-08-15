package week16.김누리.programmers;

/**
 * PackageName : week16.김누리.programmers
 * FileName    : 두개_이하로_다른_비트
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 10.     김누리(NRKim)               Initial creation
 */

/*

1.  number[i]를 2진 변환
2.  number[i]를 + 1 후 2진 변환
3.  1에서 변환한 값과, 2에서 변환한 값을 비교해서 다른 갯수 비교
4.  2번이랑 3번 비교 했을 때, 다른 값이 2개 이하인가? >> answer[i]에 추가
5.  아니면 2~4 반복


예)
case 1 : [2,7]
1. number[0] = 2     >> 0010
2. number[0] + 1 = 3 >> 0011

결과 : 1개만 다름


위 방식대로 가면?? timeout 발생
*/


public class 두개_이하로_다른_비트 {
	//  타임아웃 소스
	// public long[] solution(long[] numbers) {
	// 	long[] answer = new long[numbers.length];
	//
	// 	for(int t = 0; t < numbers.length; t++) {
	// 		long n = numbers[t];
	// 		long a = n + 1;
	//
	// 		while (true) {
	// 			String s1 = Long.toBinaryString(n);
	// 			String s2 = Long.toBinaryString(a);
	//
	// 			int l = Math.max(s1.length(),s2.length());
	// 			s1 = String.format("%" + l + "s",s1).replace(' ','0');
	// 			s2 = String.format("%" + l + "s",s2).replace(' ','0');
	//
	// 			int diff = 0;
	//
	// 			for(int i = 0; i < l; i++) {
	// 				if(s1.charAt(i) != s2.charAt(i)) {
	// 					diff++;
	// 					if (diff > 2) break;
	// 				}
	// 			}
	//
	// 			if (diff <= 2) {
	// 				answer[t] = a;
	// 				break;
	// 			}
	//
	// 			a++;
	//
	// 		}
	// 	}
	// 	return answer;
	//
	// }

	//  비트 연산을 이용한 방법
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for(int i = 0; i < numbers.length; i++) {
			long n = numbers[i]; //  변환 대상 값

			//  짝수인 경우
			if((n & 1L) == 0) {
				//  짝수인 경우 이진수로 표현하면마지막 비트가 0으로 끝남.
				//  그래서 1을 더하게 되면 이진수로 변환 시, 맨 마지막 비트가 1로 바뀜
				//  그 결과, n+1이 n보다 크면서 가장 가까운 수이기 때문에 1L을 더해야 함
				answer[i] = n +1L;
			} else {
				//  이진수 화 했을 떄 마지막이 0인 비트를 탐색
				long z = (~n) & (n + 1L);

				//  비트 우측이동
				answer[i] = n + (z >> 1);
			}
		}

		return answer;
	}
}
