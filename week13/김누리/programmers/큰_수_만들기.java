package week13.김누리.programmers;

/**
 * PackageName : week13.김누리.programmers
 * FileName    : 큰_수_만들기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-22
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 22.     김누리(NRKim)               Initial creation
 */

/*
StringBuilder 써도 될 거 같은데...

정렬 하면?

9421 >> 94 까지 걍 뒤에 2개만 빼면 됨

1231234

4332211 >> 3개 제거 해야 함 4332 >> 요구와 맞지 않음

StringBuilder의 맨 뒤와 다음 숫자 비교하며 만들어나가면 될듯

풀이 진행

*/

public class 큰_수_만들기 {
	public StringBuilder solution(String number, int k) {
		StringBuilder sb = new StringBuilder();

		for(char c : number.toCharArray()) {

			while(sb.length() > 0 && c > sb.charAt(sb.length()-1) && k > 0) {
				sb.setLength(sb.length() - 1); // StringBuilder의 길이 조절
				k--;

			}

			sb.append(c);
		}

		if(k > 0) sb.setLength(sb.length() - k);


		return sb;
	}
}
