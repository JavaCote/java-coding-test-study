package week12.강성욱.programmers;

/**
 * PackageName : week12.강성욱.programmers
 * FileName    : 숫자_문자열과_영단어
 * Author      : Baekgwa
 * Date        : 2025-07-21
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-07-21     Baekgwa               Initial creation
 */
public class 숫자_문자열과_영단어 {
	class Solution {
		public int solution(String s) {
			int answer = 0;
			String temp;
			String[] english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

			for(int i=0; i<10; i++){
				s = s.replace(english[i], Integer.toString(i));
			}
			answer = Integer.parseInt(s);

			return answer;
		}
	}
}
