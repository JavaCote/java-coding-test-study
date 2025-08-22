package week17.김누리.programmers;

import java.util.Arrays;

/**
 * PackageName : week17.김누리.programmers
 * FileName    : 전화번호_목록
 * Author      : 김누리(NRKim)
 * Date        : 2025-08-17
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 08. 17.     김누리(NRKim)               Initial creation
 */

/*

흠... phone_book의 각 요소들을 순회하면서 다음 단어의 시작인지 판단

*/

public class 전화번호_목록 {
	public boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);

		for(int i = 0; i < phone_book.length - 1; i++) {
			String now = phone_book[i];

			if(phone_book[i+1].startsWith(now)) answer = false;

		}

		return answer;
	}
}
