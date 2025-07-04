package week8.김누리.programmers;

/**
 * PackageName : week8.김누리.programmers
 * FileName    : 이상한_문자_만들기
 * Author      : 김누리(NRKim)
 * Date        : 2025-06-15
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 06. 15.     김누리(NRKim)               Initial creation
 */


/*
" "기준으로 문자 나눔
나눈 문자 별로 홀수 인덱스는 대문자 짝수 인덱스는 소문자로 조합
*/

public class 이상한_문자_만들기 {
	public String solution(String s) {
		String answer = "";
		String[] sArr = s.split("");
		StringBuilder sb = new StringBuilder();
		int idx = 0; //  문자의 idx

		for(int i = 0; i < sArr.length; i++) {

			//  해당 idx의 값이 space 일 때
			if (sArr[i].equals(" ")) {
				sb.append(" ");
				idx = 0;
			}

			//  해당 idx가 짝수번 idx 이며, 해당 값이 space가 아닐 때
			else if (idx%2 == 0) {
				sb.append(sArr[i].toUpperCase());
				idx++;
			}

			//  해당 idx가 홀수번 idx 이며, 해당 값이 space가 아닐 일 때
			else if (idx%2 != 0) {
				sb.append(sArr[i].toLowerCase());
				idx++;
			}
		}

		answer = sb.toString();

		return answer;
	}
}
