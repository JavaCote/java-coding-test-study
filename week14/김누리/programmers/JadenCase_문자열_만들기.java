package week14.김누리.programmers;

/**
 * PackageName : week14.김누리.programmers
 * FileName    : JadenCase_문자열_만들기
 * Author      : 김누리(NRKim)
 * Date        : 2025-07-27
 * Description :
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025. 07. 27.     김누리(NRKim)               Initial creation
 */

public class JadenCase_문자열_만들기 {
	public String solution(String s) {
		String answer = "";
		int idx = s.length();
		char []tmp = new char[idx];

		for(int i = 0 ; i < s.length(); i++) {
			char t = s.charAt(i);

			if (i == 0) {
				if(Character.isAlphabetic(t)) {
					t = Character.toUpperCase(t);
				}
			} else if (tmp[i-1] == ' ') {
				t = Character.toUpperCase(t);
			} else if (Character.isUpperCase(t)) {
				t = Character.toLowerCase(t);
			}
			tmp[i] = t;
			System.out.print(tmp[i]);
		}

		for (int i = 0; i < tmp.length; i++) {
			answer += tmp[i];
		}

		return answer;
	}
}
