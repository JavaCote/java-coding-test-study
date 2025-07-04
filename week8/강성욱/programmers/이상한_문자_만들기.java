package week8.강성욱.programmers;

/**
 * PackageName : week8.강성욱.programmers
 * FileName    : 이상한_문자_만들기
 * Author      : Baekgwa
 * Date        : 2025-06-16
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-06-16     Baekgwa               Initial creation
 */
public class 이상한_문자_만들기 {
	//각 단어로 쪼개야됨
	//단어별로 쪼개서, 변환하는 메서드가 있어야함

	class Solution {
		public String solution(String s) {
			String[] sToken = s.split(" ", -1);
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < sToken.length; i++) {
				sb.append(transfer(sToken[i]));
				if (i < sToken.length - 1) sb.append(" ");
			}

			return sb.toString();
		}

		private String transfer(String str) {
			if( str.isBlank() ) return str;

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				sb.append(i % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
			}
			return sb.toString();
		}
	}
}
