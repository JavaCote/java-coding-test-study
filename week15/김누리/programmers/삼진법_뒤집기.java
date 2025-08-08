package week15.김누리.programmers;

/**
 * PackageName : week15.김누리.programmers
 * FileName    : 삼진법_뒤집기
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-02
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 02.     김누리(NRKim)               Initial creation
 */

/*
풀이 방법은 2가지.

1.  n을 3으로 나눈 나머지를 순차적으로 이어붙이면 리버스 3진수화
2.  n을 Integer.toString(n,3); 해서 3진수 String으로 만들고 역정렬

간단하긴 1번이 간단해 보여서 1번 채용.

*/

public class 삼진법_뒤집기 {
	public int solution(int n) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();

		while(n > 0) {
			sb.append(n%3);
			n /= 3;
		}

		answer = Integer.parseInt(sb.toString(),3);

		return answer;
	}
}
