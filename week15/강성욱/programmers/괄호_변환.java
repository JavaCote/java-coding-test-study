package week15.강성욱.programmers;

/**
 * PackageName : week15.강성욱.programmers
 * FileName    : 괄호_변환
 * Author      : Baekgwa
 * Date        : 2025-08-08
 * Description : 
 * =====================================================================================================================
 * DATE          AUTHOR               NOTE
 * ---------------------------------------------------------------------------------------------------------------------
 * 2025-08-08     Baekgwa               Initial creation
 */
public class 괄호_변환 {
	//균형잡힌 문자열 2개로 분할하는 메소드 필요
	// u / v 로 나눌때
	// u는 균형잡힌 가장 짧은 걸로.
	// v는 나머지

	class Solution {
		public String solution(String p) {
			return dfs(p);
		}

		private String dfs(String p) {
			if (p.isEmpty()) return "";

			String[] pArray = div(p);
			String left = pArray[0];
			String right = pArray[1];

			if (isCorrect(left)) {
				return left + dfs(right);
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("(");
				sb.append(dfs(right));
				sb.append(")");
				sb.append(reverse(left.substring(1, left.length() - 1)));
				return sb.toString();
			}
		}

		private String[] div(String p) {
			int left = 0, right = 0;
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == '(') left++;
				else right++;
				if (left == right) {
					return new String[]{p.substring(0, i + 1), p.substring(i + 1)};
				}
			}
			return new String[]{p, ""};
		}

		private boolean isCorrect(String p) {
			int balance = 0;
			for (char c : p.toCharArray()) {
				if (c == '(') balance++;
				else balance--;
				if (balance < 0) return false;
			}
			return balance == 0;
		}

		private String reverse(String p) {
			StringBuilder sb = new StringBuilder();
			for (char c : p.toCharArray()) {
				sb.append(c == '(' ? ')' : '(');
			}
			return sb.toString();
		}
	}
}
