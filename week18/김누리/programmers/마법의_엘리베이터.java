package week18.김누리.programmers;

/**
 * PackageName : week18.김누리.programmers
 * FileName    : 마법의_엘리베이터
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-25
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 25.     김누리(NRKim)               Initial creation
 */

/*

엘레베이터가 가능한 이동 거리
-100, -10, -1, 1, 10, 100 처럼 10^n 층 단위로 이동 가능


2554

   -1 : 4번 ==> 2550
  100 : 4번 ==> 2950
   10 : 5번 ==> 3000
-1000 : 3번 ==> 0 ===> goal

이거는 그리디다.

그러면? 자릿수 쪼개면서 ++ 할건지? -- 할건지 측정해가면서 돌 카운팅

*/

public class 마법의_엘리베이터 {
	public int solution(int storey) {
		int answer = 0;

		while (storey > 0) {
			int d = storey % 10; //  현재 자릿수
			int next = (storey/10) % 10;  //  다음번 자릿수

			//  현재 자릿수가 5 미만일 때
			if(d < 5) {
				answer += d;
				storey /= 10;
			}

			//  현재 자릿수가 5 초과 일 때
			else if(d > 5) {
				answer += (10 - d);
				storey = storey/ 10 + 1;
			}

			else {
				if(next >= 5) {
					answer += 5;
					storey = storey / 10 + 1;
				} else {
					answer += 5;
					storey /= 10;
				}
			}
		}


		return answer;
	}
}
