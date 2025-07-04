package week7.김누리.programmers;

/**
 * PackageName : week7.김누리.programmers
 * FileName    : 음양_더하기
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
* 간단한 흐름
* 1.  signs 배열 만큼 반복
* 2.  signs[i]의 값이 true다 ? + 기능을, false다 ? - 기능을 하면 됨
*
*/
public class 음양_더하기 {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for(int i = 0; i < signs.length; i++) {
			if(signs[i]) {
				answer += absolutes[i];
			} else if (!signs[i]) {
				answer -= absolutes[i];
			}
		}
		return answer;
	}
}
