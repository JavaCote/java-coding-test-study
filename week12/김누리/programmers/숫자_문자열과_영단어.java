package week12.김누리.programmers;

/**
 * PackageName : week12.김누리.programmers
 * FileName    : 숫자_문자열과_영단어
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-14
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 14.     김누리(NRKim)               Initial creation
 */

/*

숫자를 쪼갠다.

쪼갠 숫자다 ? 그냥 ㄱㄱ

문자다? 문자를 만들어 숫자로 치환

*/

public class 숫자_문자열과_영단어 {
	public int solution(String s) {
		int answer = 0;
		char[] cArr = s.toCharArray();
		String sTmp = "";
		String tmp = "";

		for(char c : cArr) {
			if(c >= 97 && c <= 122) {;
				tmp += String.valueOf(c);

				switch(tmp) {
					case "zero" :
						sTmp += "0";
						tmp = "";
						break;

					case "one" :
						sTmp += "1";
						tmp = "";
						break;

					case "two" :
						sTmp += "2";
						tmp = "";
						break;

					case "three" :
						sTmp += "3";
						tmp = "";
						break;

					case "four" :
						sTmp += "4";
						tmp = "";
						break;

					case "five" :
						sTmp += "5";
						tmp = "";
						break;

					case "six" :
						sTmp += "6";
						tmp = "";
						break;

					case "seven" :
						sTmp += "7";
						tmp = "";
						break;

					case "eight" :
						sTmp += "8";
						tmp = "";
						break;

					case "nine" :
						sTmp += "9";
						tmp = "";
						break;
				}
			} else {
				sTmp += String.valueOf(c);

			}
		}

		answer = Integer.parseInt(sTmp);

		return answer;
	}
}
