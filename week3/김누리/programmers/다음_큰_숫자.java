package week3.김누리.programmers;

/**
 * PackageName : week3.김누리.programmers
 * FileName    : 다음_큰_숫자
 * Author      : 김누리(NRKim)
 * Date        : 2025-05-10
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 05. 10.     김누리(NRKim)               Initial creation
 */

/*
case 1 :
78 (1001110) => 1*2^6 + 0*2^5 + 0*2^4 + 1*2^3 + 1*2^2 + 1 * 2
             => 64 + 8 + 4 + 2
             => 72 + 6
             => 8
79 (1001111)
80 (1010000)
81 (1010001)
82 (1010010)
83 (1010011)
그래서 정답은 83
*/

public class 다음_큰_숫자 {
	public int solution(int n) {
		int answer = 0;
		int bin = Integer.bitCount(n); //  n을 이진변환 완료한 타겟 값

		//  n을 이진변환 했을 때 1의 수 == bin 값일 때 까지
		while (Integer.bitCount(++n) != bin);

		// 변환 완료한 n값 answer로
		answer = n;

		return answer;
	}
}
