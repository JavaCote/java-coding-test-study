package week10.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week10.김누리.programmers
 * FileName    : h_index
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 02.     김누리(NRKim)               Initial creation
 */

/*

citations.length = 발표한 논문 n 편

citations 정렬

h = 논문 수(배열의 길이) - 현재 인덱스(i)

{0 1 3 5 6}

idx == 0 > h = 5 - 0(5), citations[0](0) >> false ;
idx == 1 > h = 5 - 1(4), citations[1](1) >> false ;
idx == 2 > h = 5 - 2(3), citations[2](3) >> true (answer = 3) ;
idx == 3 > h = 5 - 3(2), citations[3](5) >> true (answer = 3) ;
idx == 4 > h = 5 - 4(1), citations[4](6) >> true (answer = 3) ;


*/

public class h_index {
	public int solution(int[] citations) {
		int answer = 0;
		int n = citations.length; //  총 논문 수

		//  asec
		Arrays.sort(citations);

		for(int i = 0; i < n; i++) {

			//  h = 논문 수(배열의 길이) - 현재 인덱스(i)
			int h = n - i;

			//  정답 계산
			answer = citations[i] >= h ? Math.max(answer, h) : answer;
		}

		return answer;
	}
}
