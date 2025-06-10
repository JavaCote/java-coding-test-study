package week6.김누리.programmers;

/**
 * PackageName : week6.김누리.programmers
 * FileName    : 삼총사
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 02.     김누리(NRKim)               Initial creation
 */

/*

number 배열을 반복하며 숫자 3개를 더했을 때, 0이 되면 삼총사.

-2 + 3 + 0 = 1 > NG
-2 + 3 + 2 = 3 > NG
-2 + 3 + (-5) = -4 > NG

-2 + 0 + 2 = 0 > ++
-2 + 0 + (-5) = -7 > NG
-2 + 2 + (-5) = -5 > NG

3 + 0 + 2 = 5 > NG
3 + 0 + (-5) = -2 > NG
3 + 2 + (-5) = 0 > ++
0 + 2 + (-5) = -3 > NG

이런식으로 완전 쌩노가다 진행해야함.

그러면? 어차피? 숫자는 최대 13개만 준다며? >> 3중 for문 해도 될듯

*/

public class 삼총사 {
	public int solution(int[] number) {
		int answer = 0;

		for (int i = 0; i < number.length -2; i++) {
			int sum = 0; // 3중 for문 돌아가며 들어갈 변수

			for (int j = i+1; j < number.length -1; j++) {
				for(int k = j+1; k < number.length; k++) {
					sum = number[i] + number[j] + number[k]; //  숫자 3개 합

					if (sum == 0) {
						answer++; //  3개를 더하고도 0이라면? 카운트 증가
					}
				}
			}
		}

		return answer;
	}
}
