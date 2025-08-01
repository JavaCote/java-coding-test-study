package week14.강성욱.programmers;

/**
 * PackageName : week14.강성욱.programmers
 * FileName    : JadenCase_문자열_만들기
 * Author      : Baekgwa
 * Date        : 2025-07-28
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-28     Baekgwa               Initial creation
 */
public class JadenCase_문자열_만들기 {
	//범위가 좁기 떄문에, 최적화는 신경쓰지 않아도 될듯

	class Solution {
		//     public String solution(String s) {
		//         //쪼개고
		//         StringBuilder sb = new StringBuilder();
		//         String[] sArray = s.split(" ");
		//         for(String sWord : sArray) {
		//             //첫번째, upperCase 로 올리기
		//             //숫자는 무시되려나? 일딴 해보자
		//             String[] sWordArray = sWord.split("");
		//             sWordArray[0] = sWordArray[0].toUpperCase();

		//             for(String word : sWordArray) sb.append(word);
		//             sb.append(" ");
		//         }

		//         return sb.toString().trim();
		//     }

		//아 공백이 여러번 나올 수 있네...?
		public String solution(String s) {
			StringBuilder result = new StringBuilder();
			boolean isFirst = true;

			for(char sChar : s.toCharArray()) {
				if(isFirst) result.append(Character.toUpperCase(sChar));
				else result.append(Character.toLowerCase(sChar));

				if(sChar == ' ') isFirst = true;
				else isFirst = false;
			}

			return result.toString();
		}
	}
}
